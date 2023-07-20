package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private static String CITIES_FILE_PATH = "src/main/resources/files/json/cities.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CityRepository cityRepository;

    private final CountryRepository countryRepository;

    @Autowired
    public CityServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, CityRepository cityRepository, CountryRepository countryRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {


        return Files.readString(Path.of(CITIES_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();

        CityImportDto[] cityImportDtos =
                gson.fromJson(readCitiesFileContent(), CityImportDto[].class);


        Arrays.stream(cityImportDtos)
                .filter(cityImportDto -> {
                    boolean isValid = validationUtil.isValid(cityImportDto);

                    Optional<City> optionalCity =
                            cityRepository.findCityByCityName(cityImportDto.getCityName());

                    if (optionalCity.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported city %s - %d",
                                    cityImportDto.getCityName(), cityImportDto.getPopulation())
                                    : "Invalid city")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(cityImportDto -> {
                    City city = modelMapper.map(cityImportDto, City.class);

                    Optional<Country> optionalCountry =
                            countryRepository.findCountryById(cityImportDto.getCountry());

                    city.setCountry(optionalCountry.get());

                    return city;

                })
                .forEach(cityRepository::save);


        return sb.toString();
    }
}
