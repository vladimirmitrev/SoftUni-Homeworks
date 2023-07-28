package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicImportDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class MechanicsServiceImpl implements MechanicsService {

    private static String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    private final MechanicsRepository mechanicsRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.mechanicsRepository = mechanicsRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {

        StringBuilder sb = new StringBuilder();

        MechanicImportDto[] mechanicImportDtos =
                gson.fromJson(readMechanicsFromFile(), MechanicImportDto[].class);

        Arrays.stream(mechanicImportDtos)
                .filter(mechanicImportDto -> {

                    boolean isValid = validationUtil.isValid(mechanicImportDto);


                    Optional<Mechanic> optionalMechanic =
                            mechanicsRepository.findByEmail(mechanicImportDto.getEmail());

                    if (optionalMechanic.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported mechanic %s %s",
                                    mechanicImportDto.getFirstName(), mechanicImportDto.getLastName())
                                    : "Invalid mechanic")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(mechanicImportDto -> modelMapper.map(mechanicImportDto, Mechanic.class))
                .forEach(mechanicsRepository::save);


        return sb.toString();
    }
}
