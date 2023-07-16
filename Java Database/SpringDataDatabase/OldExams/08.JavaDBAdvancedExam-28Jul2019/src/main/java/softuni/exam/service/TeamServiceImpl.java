package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.TeamImportRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {


    private static final String TEAMS_FILE_PATH = "src/main/resources/files/xml/teams.xml";
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final PictureRepository pictureRepository;
    private final PictureService pictureService;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, PictureRepository pictureRepository, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.pictureRepository = pictureRepository;
        this.pictureService = pictureService;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TeamImportRootDto teamImportRootDto =
                xmlParser.fromFile(TEAMS_FILE_PATH, TeamImportRootDto.class);

        teamImportRootDto.getTeams()
                .stream()
                .filter(teamImportDto -> {

                    boolean isValid = validationUtil.isValid(teamImportDto);


                    Picture optionalPicture =
                            pictureService.findPictureByUrl(teamImportDto.getPicture().getUrl());

                    if (optionalPicture == null) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported - %s",
                                    teamImportDto.getName())
                                    : "Invalid team")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(teamImportDto -> {
                    Team team = modelMapper.map(teamImportDto, Team.class);

                    team.setPicture(pictureService.findPictureByUrl(teamImportDto.getPicture().getUrl()));

                    return team;
                })
                .forEach(teamRepository::save);


        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public Team findTeamByName(String teamName) {
        return teamRepository
                .findTeamByName(teamName)
                .orElse(null);
    }
}
