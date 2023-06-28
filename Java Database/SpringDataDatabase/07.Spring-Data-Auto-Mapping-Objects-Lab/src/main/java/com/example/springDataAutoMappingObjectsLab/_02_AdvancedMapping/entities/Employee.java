package com.example.springDataAutoMappingObjectsLab._02_AdvancedMapping.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private String firstName;
    private String lastName;

    private BigDecimal salary;

    private LocalDate birthday;
    private Boolean onHoliday;
    private Address address;
    private Employee manager;

    private Set<Employee> workers;

    public Employee(String firstName, String lastName, BigDecimal salary, LocalDate birthday, Boolean onHoliday, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.onHoliday = onHoliday;
        this.address = address;
        this.workers = new HashSet<>();
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getOnHoliday() {
        return onHoliday;
    }

    public void setOnHoliday(Boolean onHoliday) {
        this.onHoliday = onHoliday;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Set<Employee> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Employee> workers) {
        this.workers = workers;
    }

    public void addEmployee(Employee employee) {
        this.workers.add(employee);
    }


}
