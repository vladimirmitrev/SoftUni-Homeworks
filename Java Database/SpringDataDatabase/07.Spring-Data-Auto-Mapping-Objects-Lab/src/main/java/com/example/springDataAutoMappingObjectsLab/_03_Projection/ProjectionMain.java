package com.example.springDataAutoMappingObjectsLab._03_Projection;

import com.example.springDataAutoMappingObjectsLab._03_Projection.entities.Employee;
import com.example.springDataAutoMappingObjectsLab._03_Projection.entities.EmployeeDTO;
import com.example.springDataAutoMappingObjectsLab._03_Projection.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ProjectionMain implements CommandLineRunner {

    private EmployeeService employeeService;

    @Autowired

    public ProjectionMain(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public void run(String... args) throws Exception {


        persist();
        List<Employee> employeeList = this.employeeService.findEmployeesBornBefore(1990);

        ModelMapper modelMapper = new ModelMapper();
//        EmployeeDTO employeeDTO = modelMapper.map(manager, EmployeeDTO.class);

        employeeList.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .forEach(System.out::println);

//        System.out.println(employeeDTO);

    }

    private void persist() {

        Employee manager = new Employee("Steve", "Jobbsen",
                BigDecimal.valueOf(6000.20), LocalDate.of(1980, 1, 1),
                "Botev 7", null);

        Employee employeeOne = new Employee("Kirilyc", "Lefi",
                BigDecimal.valueOf(4400.00), LocalDate.of(1989, 1, 1),
                "Botev 9", manager);

//        manager = this.employeeService.findOneById(employeeOne.getManager().getId())
//                .get();

        Employee employeeTwo = new Employee("Stephen", "Bjorn",
                BigDecimal.valueOf(4300.00), LocalDate.of(1987, 1, 1),
                "Botev 11", manager);

            //Todo uncomment to save entities
//        this.employeeService.save(manager);
//        this.employeeService.save(employeeOne);
//        this.employeeService.save(employeeTwo);
    }
}
