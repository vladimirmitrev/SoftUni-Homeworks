package com.example.springDataAutoMappingObjectsLab._03_Projection.entities;

import java.math.BigDecimal;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String managerLastName;

    public EmployeeDTO(String firstName, String lastName, BigDecimal salary, String managerLastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerLastName = managerLastName;
    }

    public EmployeeDTO() {
    }

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

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    @Override
    public String toString() {
        return firstName + " " +
                lastName + " " +
                "-" + " " +
                "Manager:" + " " +
                (managerLastName == null
                ? "[no manger]" : managerLastName);
    }
}
