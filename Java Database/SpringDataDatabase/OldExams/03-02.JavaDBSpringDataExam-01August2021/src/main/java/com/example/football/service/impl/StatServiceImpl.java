package com.example.football.service.impl;

import com.example.football.models.dto.StatImportRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class StatServiceImpl implements StatService {

    private static String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final StatRepository statRepository;

    @Autowired
    public StatServiceImpl(ModelMapper modelMapper, XmlParser xmlParser,
                           ValidationUtil validationUtil, StatRepository statRepository) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.statRepository = statRepository;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        StatImportRootDto statImportRootDto =
                xmlParser.fromFile(STATS_FILE_PATH, StatImportRootDto.class);

        statImportRootDto.getStats()
                .stream()
                .filter(statImportDto -> {

                    boolean isValid = validationUtil.isValid(statImportDto);

                    Optional<Stat> optionalStat =
                            statRepository.findStatByShootingAndPassingAndEndurance(
                                    statImportDto.getShooting(), statImportDto.getPassing(), statImportDto.getEndurance());

                    if (optionalStat.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                                    statImportDto.getShooting(), statImportDto.getPassing(), statImportDto.getEndurance())
                                    : "Invalid Stat")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(statImportDto -> modelMapper.map(statImportDto, Stat.class))
                .forEach(statRepository::save);

        return sb.toString();
    }
}
