package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerImportDto;
import exam.model.entity.Customer;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final TownService townService;


    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, TownService townService) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.townService = townService;
    }


    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {

        StringBuilder sb = new StringBuilder();

        CustomerImportDto[] customerImportDtos = gson.fromJson(readCustomersFileContent(), CustomerImportDto[].class);

        Arrays.stream(customerImportDtos)
                .filter(customerImportDto -> {
                    boolean isValid = validationUtil.isValid(customerImportDto);

                    Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(customerImportDto.getEmail());

                    if (optionalCustomer.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Customer %s %s - %s",
                                    customerImportDto.getFirstName(), customerImportDto.getLastName(), customerImportDto.getEmail())
                                    : "Invalid Customer")
                            .append(System.lineSeparator());


                    return isValid;

                })
                .map(customerImportDto -> {
                    Customer customer = modelMapper.map(customerImportDto, Customer.class);
                    customer.setTown(townService.findTownByName(customerImportDto.getTown().getName()));

                    return customer;
                })
                .forEach(customerRepository::save);

        return sb.toString();
    }
}
