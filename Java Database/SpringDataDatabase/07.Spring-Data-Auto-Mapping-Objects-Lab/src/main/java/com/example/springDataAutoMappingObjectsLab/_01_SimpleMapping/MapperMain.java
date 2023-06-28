package com.example.springDataAutoMappingObjectsLab._01_SimpleMapping;

import com.example.springDataAutoMappingObjectsLab._01_SimpleMapping.entities.Address;
import com.example.springDataAutoMappingObjectsLab._01_SimpleMapping.entities.Employee;
import com.example.springDataAutoMappingObjectsLab._01_SimpleMapping.entities.EmployeeDto;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MapperMain {
    public static void main(String[] args) {

        ModelMapper modelMapper = new ModelMapper();

        Address address = new Address("Levski", 42, "Sofia", "Bulgaria");

        Employee employee = new Employee("Ivan", "Ivanov", BigDecimal.ONE, LocalDate.of(2005, 1, 1), address);

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        System.out.println(employeeDto);
    }


}
