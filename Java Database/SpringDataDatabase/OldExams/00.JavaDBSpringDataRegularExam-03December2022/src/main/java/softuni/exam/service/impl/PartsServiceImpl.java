package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartImportDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class PartsServiceImpl implements PartsService {

    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";

    private final PartsRepository partsRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public PartsServiceImpl(PartsRepository partsRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.partsRepository = partsRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {

        StringBuilder sb = new StringBuilder();

        PartImportDto[] partImportDtos =
                gson.fromJson(readPartsFileContent(), PartImportDto[].class);

        Arrays.stream(partImportDtos)
                .filter(partImportDto -> {

                    boolean isValid = validationUtil.isValid(partImportDto);

                    Optional<Part> optionalPart = partsRepository.findPartByPartName(partImportDto.getPartName());

                    if (optionalPart.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported part %s - %s",
                                    partImportDto.getPartName(), partImportDto.getPrice())
                                    : "Invalid part")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(partImportDto -> modelMapper.map(partImportDto, Part.class))
                .forEach(partsRepository::save);


        return sb.toString();
    }

    @Override
    public Part findPartById(Long id) {
        return partsRepository.findPartById(id);
    }
}
