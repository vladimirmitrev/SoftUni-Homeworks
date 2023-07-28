package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class PartImportDto {

    @NotNull
    @Size(min = 2, max = 19)
    private String partName;

    @NotNull
    @Min(10)
    @Max(2000)
    private Double price;

    @NotNull
    @Positive
    private Integer quantity;

    public PartImportDto() {
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
