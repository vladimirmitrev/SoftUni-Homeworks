package com.example.springDataAutoMappingObjectsLab._01_SimpleMapping.entities;

import java.math.BigDecimal;

public class EmployeeDto {
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee name: %s %s with salary: %.2f",
                this.getFirstName(), this.getLastName(), this.getSalary());
    }
}
