package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private static String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, CountryRepository countryRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        CountryImportDto[] countryImportDtos =
                gson.fromJson(readCountriesFromFile(), CountryImportDto[].class);

        Arrays.stream(countryImportDtos)
                .filter(countryImportDto -> {
                    boolean isValid = validationUtil.isValid(countryImportDto);

                    Optional<Country> optionalCountry =
                            countryRepository.findCountryByCountryName(countryImportDto.getCountryName());

                    if (optionalCountry.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported country %s - %s",
                                    countryImportDto.getCountryName(), countryImportDto.getCurrency())
                                    : "Invalid country")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(countryImportDto -> modelMapper.map(countryImportDto, Country.class))
                .forEach(countryRepository::save);


        return sb.toString();
    }
}
