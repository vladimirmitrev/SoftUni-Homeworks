package hiberspring.domain.dtos;

import javax.validation.constraints.NotNull;

public class BranchImportDto {

    @NotNull
    private String name;

    @NotNull
    private String town;

    public BranchImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
