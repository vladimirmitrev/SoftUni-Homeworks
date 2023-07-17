package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.EmployeeCardImportDto;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
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
public class EmployeeCardServiceImpl implements EmployeeCardService {


    private static final String EMPLOYEE_CARDS_FILE_PATH = "employee-cards.json";

    private final EmployeeCardRepository employeeCardRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;


    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, ModelMapper modelMapper,
                                   Gson gson, ValidationUtil validationUtil) {
        this.employeeCardRepository = employeeCardRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + EMPLOYEE_CARDS_FILE_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {

        StringBuilder sb = new StringBuilder();


        EmployeeCardImportDto[] employeeCardImportDtos =
                gson.fromJson(readEmployeeCardsJsonFile(), EmployeeCardImportDto[].class);


        Arrays.stream(employeeCardImportDtos)
                .filter(employeeCardImportDto -> {
                    boolean isValid = validationUtil.isValid(employeeCardImportDto);

                    EmployeeCard employeeCard =
                            employeeCardRepository.findEmployeeCardByNumber(employeeCardImportDto.getNumber());

                    if (employeeCard != null) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    "Employee Card", employeeCardImportDto.getNumber())
                                    : Constants.INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(employeeCardImportDto -> modelMapper.map(employeeCardImportDto, EmployeeCard.class))
                .forEach(employeeCardRepository::save);

        return sb.toString();
    }

    @Override
    public EmployeeCard findEmployeeCardByNumber(String card) {
        return employeeCardRepository
                .findEmployeeCardByNumber(card);
    }
}
