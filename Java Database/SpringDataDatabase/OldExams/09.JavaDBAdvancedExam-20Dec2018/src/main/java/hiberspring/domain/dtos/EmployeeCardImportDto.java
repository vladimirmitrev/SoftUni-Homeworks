package hiberspring.domain.dtos;

import javax.validation.constraints.NotNull;

public class EmployeeCardImportDto {

    @NotNull
    private String number;

    public EmployeeCardImportDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
