package hiberspring.service.impl;

import hiberspring.common.Constants;
import hiberspring.domain.dtos.EmployeeImportRootDto;
import hiberspring.domain.entities.Employee;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String EMPLOYEES_FILE_PATH = "employees.xml";

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final BranchService branchService;

    private final EmployeeCardService employeeCardService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper,
                               XmlParser xmlParser, ValidationUtil validationUtil,
                               BranchService branchService, EmployeeCardService employeeCardService) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
    }

    @Override
    public Boolean employeesAreImported() {
        return employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        EmployeeImportRootDto employeeImportRootDto =
                xmlParser.fromFile(Constants.PATH_TO_FILES + EMPLOYEES_FILE_PATH, EmployeeImportRootDto.class);

        employeeImportRootDto.getEmployees()
                .stream()
                .filter(employeeImportDto -> {
                    boolean isValid = validationUtil.isValid(employeeImportDto);


                    sb.append(isValid ? String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    "Employee", employeeImportDto.getFirstName() + " " + employeeImportDto.getLastName())
                                    : Constants.INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(employeeImportDto -> {
                    Employee employee = modelMapper.map(employeeImportDto, Employee.class);

                    employee.setBranch(branchService.findBranchByName(employeeImportDto.getBranch()));
                    employee.setCard(employeeCardService.findEmployeeCardByNumber(employeeImportDto.getCard()));

                    return employee;
                })
                .forEach(employeeRepository::save);

        return sb.toString();
    }

    @Override
    public String exportProductiveEmployees() {

        StringBuilder sb = new StringBuilder();
        List<Employee> employeeList = employeeRepository
                .findAllEmployeesWithBranchAndProduct();
//                .findAllEmployeeWithProduct();



        employeeList.forEach(employee ->
                sb.append(String.format("Name: %s %s%n" +
                        "Position: %s%n" +
                        "Card Number: %s%n" +
                        "-------------------------%n",
                        employee.getFirstName(), employee.getLastName(),
                        employee.getPosition(),
                        employee.getCard().getNumber())));


        return sb.toString();
    }
}
