package com.example.springDataAutoMappingObjectsLab._02_AdvancedMapping.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ManagerDTO {
    private String firstName;
    private String lastName;

    private Set<EmployeeDTO> workers;

    public ManagerDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workers = new HashSet<>();
    }

    public ManagerDTO() {
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

    public Set<EmployeeDTO> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<EmployeeDTO> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        String employees =  this.workers
                .stream()
                .map(EmployeeDTO::toString)
                .map(s -> "   - " + s)
                .collect(Collectors.joining("\n"));

        return String.format("%s %s | Employees: %d%n%s%n",
                this.getFirstName(), this.getLastName(), this.workers.size(), employees);
    }
}
