package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dtos.CustomerImportDto;
import exam.model.entities.Customer;
import exam.model.entities.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
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


    private static String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, Gson gson,
                               ValidationUtil validationUtil,
                               CustomerRepository customerRepository,
                               TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
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

        CustomerImportDto[] customerImportDtos =
                gson.fromJson(readCustomersFileContent(), CustomerImportDto[].class);

        Arrays.stream(customerImportDtos)
                .filter(customerImportDto -> {

                    boolean isValid = validationUtil.isValid(customerImportDto);

                    Optional<Customer> optionalCustomer =
                            customerRepository.findCustomerByEmail(customerImportDto.getEmail());

                    if (optionalCustomer.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Customer %s %s - %s",
                                    customerImportDto.getFirstName(), customerImportDto.getLastName(), customerImportDto.getEmail())
                                    : "Invalid customer")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(customerImportDto -> {

                    Customer customer = modelMapper.map(customerImportDto, Customer.class);

                    Optional<Town> town = townRepository.findTownByName(customerImportDto.getTown().getName());

                    customer.setTown(town.get());

                    return customer;
                })
                .forEach(customerRepository::save);


        return sb.toString();
    }
}
