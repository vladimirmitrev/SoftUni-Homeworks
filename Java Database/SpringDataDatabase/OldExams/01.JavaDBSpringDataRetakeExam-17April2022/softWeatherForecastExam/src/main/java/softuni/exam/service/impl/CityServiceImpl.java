package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private static final String CITIES_FILE_PATH = "src/main/resources/files/json/cities.json";


    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final CountryService countryService;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.countryService = countryService;
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

        CitySeedDto[] citySeedDtos = gson.fromJson(readCitiesFileContent(), CitySeedDto[].class);

        Arrays.stream(citySeedDtos)
                .filter(citySeedDto -> {
                    boolean isValid = validationUtil.isValid(citySeedDto);

                    Optional<City> cityByCityName = cityRepository.findCityByName(citySeedDto.getCityName());
                    if (cityByCityName.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported city %s - %s",
                            citySeedDto.getCityName(), citySeedDto.getPopulation())
                            : "Invalid city");
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(citySeedDto -> {
                    City city = modelMapper.map(citySeedDto, City.class);
                    city.setCountry(countryService.findById(citySeedDto.getCountry()));
                    return city;
                })
                .forEach(cityRepository::save);


        return sb.toString();
    }

    @Override
    public City findCityById(Long id) {
        return cityRepository
                .findById(id)
                .orElse(null);
    }
}
