package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {

    private static String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";

    private final ModelMapper modelMapper;

    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final TownRepository townRepository;

    private final AgentRepository agentRepository;


    @Autowired
    public AgentServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, AgentRepository agentRepository, TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
    }


    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder sb = new StringBuilder();

        AgentImportDto[] agentImportDtos =
                gson.fromJson(readAgentsFromFile(), AgentImportDto[].class);

        Arrays.stream(agentImportDtos)
                .filter(agentImportDto -> {

                    boolean isValid = validationUtil.isValid(agentImportDto);

                    Optional<Agent> optionalAgent =
                            agentRepository.findAgentByFirstNameOrEmail(agentImportDto.getFirstName(), agentImportDto.getEmail());

                    if (optionalAgent.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported agent - %s %s",
                                    agentImportDto.getFirstName(), agentImportDto.getLastName())
                                    : "Invalid agent")
                            .append(System.lineSeparator());


                    return isValid;

                })
                .map(agentImportDto -> {
                    Agent agent = modelMapper.map(agentImportDto, Agent.class);

                    Optional<Town> townOptional = townRepository.findTownByTownName(agentImportDto.getTown());

                    agent.setTown(townOptional.get());

                    return agent;
                })
                .forEach(agentRepository::save);


        return sb.toString();
    }
}
