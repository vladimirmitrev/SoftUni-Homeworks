package com.example.springDataAutoMappingObjectsLab._03_Projection.services;

import com.example.springDataAutoMappingObjectsLab._03_Projection.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> findOneById(int id);

    void save(Employee employee);

    List<Employee> findEmployeesBornBefore(int year);
}
