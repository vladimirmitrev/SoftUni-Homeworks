package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.BranchImportDto;
import hiberspring.domain.entities.Branch;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class BranchServiceImpl implements BranchService {

    private static final String BRANCHES_FILE_PATH = "branches.json";

    private final BranchRepository branchRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final TownService townService;


    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, TownService townService) {
        this.branchRepository = branchRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public Boolean branchesAreImported() {
        return branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + BRANCHES_FILE_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {

        StringBuilder sb = new StringBuilder();

        BranchImportDto[] branchImportDtos =
                gson.fromJson(readBranchesJsonFile(), BranchImportDto[].class);

        Arrays.stream(branchImportDtos)
                .filter(branchImportDto -> {
                    boolean isValid = validationUtil.isValid(branchImportDto);

                    sb.append(isValid ? String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, "Branch", branchImportDto.getName())
                                    : Constants.INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(branchImportDto -> {
                    Branch branch = modelMapper.map(branchImportDto, Branch.class);

                    branch.setTown(townService.findTownByName(branchImportDto.getTown()));

                    return branch;
                })
                .forEach(branchRepository::save);


        return sb.toString();
    }

    @Override
    public Branch findBranchByName(String branchName) {

        return branchRepository
                .findBranchByName(branchName)
                .orElse(null);
    }
}
