package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastSeedRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final CityService cityService;

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    private final ValidationUtil validationUtil;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, CityService cityService, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
                StringBuilder sb = new StringBuilder();

        ForecastSeedRootDto forecastSeedRootDto = xmlParser.fromFile(FORECAST_FILE_PATH, ForecastSeedRootDto.class);

        forecastSeedRootDto.getForecasts()
                .stream()
                .filter(forecastSeedDto -> {
                    boolean isValid = validationUtil.isValid(forecastSeedDto);

                   City city = cityService.findCityById(forecastSeedDto.getCity());

                   if(city == null) {
                       isValid = false;
                   }

                    Forecast forecast = forecastRepository
                            .findAllByCityAndDayOfWeek(city, forecastSeedDto.getDayOfWeek())
                            .orElse(null);
                    if (forecast != null) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully import forecast %s - %.2f",
                            forecastSeedDto.getDayOfWeek(), forecastSeedDto.getMaxTemperature())
                            : "Invalid forecast");
                    sb.append(System.lineSeparator());


                    return isValid;
                })
                .map(forecastSeedDto -> {
                    Forecast forecast = modelMapper.map(forecastSeedDto, Forecast.class);

                    forecast.setCity(cityService.findCityById(forecastSeedDto.getCity()));

                    return forecast;
                })
                .forEach(forecastRepository::save);

        return sb.toString();
    }

    @Override
    public String exportForecasts() {

        StringBuilder sb = new StringBuilder();

        Set<Forecast> allByDayOfWeekSunday =
                forecastRepository.findAllByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek.SUNDAY, 150000);

        allByDayOfWeekSunday
                .forEach(f -> {
                    sb.append(String.format("City: %s:%n" +
                            "-min temperature: %.2f%n" +
                            "--max temperature: %.2f%n" +
                            "---sunrise: %s%n" +
                            "----sunset: %s%n",
                            f.getCity().getName(), f.getMinTemperature(), f.getMaxTemperature(),
                            f.getSunrise(), f.getSunset()));
//                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }
}
