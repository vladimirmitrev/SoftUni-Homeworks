package com.example.springDataAutoMappingObjectsLab._03_Projection.repositoy;

import com.example.springDataAutoMappingObjectsLab._03_Projection.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByBirthdayBeforeOrderBySalaryDesc(LocalDate dateYear);
}
