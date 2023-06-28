package com.example.springDataAutoMappingObjectsLab._02_AdvancedMapping;

import com.example.springDataAutoMappingObjectsLab._02_AdvancedMapping.dto.ManagerDTO;
import com.example.springDataAutoMappingObjectsLab._02_AdvancedMapping.entities.Address;
import com.example.springDataAutoMappingObjectsLab._02_AdvancedMapping.entities.Employee;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MapperMain {
    public static void main(String[] args) {


        ModelMapper modelMapper = new ModelMapper();

        Address address = new Address("Levski", 42, "Sofia", "Bulgaria");

       Employee manager = new Employee("Steve", "Jobbsen",
               BigDecimal.ONE, LocalDate.of(2005, 1, 1),
               true, address);

        Employee employeeOne =
                new Employee("Stephen", "Bjorn",
                        BigDecimal.TEN, LocalDate.of(2009, 1, 1),
                        false, address);

        Employee employeeTwo =
                new Employee("Kirilyc", "Lefi",
                        BigDecimal.ONE, LocalDate.of(2012, 1, 1),
                        true, address);


        manager.addEmployee(employeeOne);
        manager.addEmployee(employeeTwo);

        ManagerDTO managerDTO = modelMapper.map(manager, ManagerDTO.class);

        System.out.println(managerDTO);
    }
}
