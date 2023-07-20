package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static String FORECASTS_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;
    private final CityRepository cityRepository;

    private final ForecastRepository forecastRepository;

    public ForecastServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil,
                               XmlParser xmlParser, CityRepository cityRepository,
                               ForecastRepository forecastRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.cityRepository = cityRepository;
        this.forecastRepository = forecastRepository;
    }


    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        ForecastImportRootDto forecastImportRootDto =
                xmlParser.fromFile(FORECASTS_FILE_PATH, ForecastImportRootDto.class);

        forecastImportRootDto.getForecasts()
                .stream()
                .filter(forecastImportDto -> {

                    boolean isValid = validationUtil.isValid(forecastImportDto);

                    Optional<Forecast> optionalForecast = forecastRepository
                            .findForecastByDayOfWeekAndCityId(
                                    forecastImportDto.getDayOfWeek(), forecastImportDto.getCity());

                    if (optionalForecast.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully import forecast %S - %.2f",
                                    forecastImportDto.getDayOfWeek(), forecastImportDto.getMaxTemperature())
                                    : "Invalid forecast")
                            .append(System.lineSeparator());

                    return isValid;

                })
                .map(forecastImportDto -> {
                    Forecast forecast = modelMapper.map(forecastImportDto, Forecast.class);

                    Optional<City> optionalCity = cityRepository.findById(forecastImportDto.getCity());

                    forecast.setCity(optionalCity.get());

                    return forecast;

                })
                .forEach(forecastRepository::save);


        return sb.toString();
    }

    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();

        int population = 150000;

        List<Forecast> forecastList =
                forecastRepository.findForecastByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek.SUNDAY, population);

        forecastList.forEach(forecast ->
                sb.append(String.format("City: %s:%n" +
                                "-min temperature: %.2f%n" +
                                "--max temperature: %.2f%n" +
                                "---sunrise: %s%n" +
                                "----sunset: %s%n",
                        forecast.getCity().getCityName(),
                        forecast.getMinTemperature(),
                        forecast.getMaxTemperature(),
                        forecast.getSunrise(),
                        forecast.getSunset())));


        return sb.toString();
    }
}
