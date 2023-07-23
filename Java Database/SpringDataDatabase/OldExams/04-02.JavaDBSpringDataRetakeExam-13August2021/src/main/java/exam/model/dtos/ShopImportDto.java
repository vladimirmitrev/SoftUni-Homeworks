package exam.model.dtos;

import exam.model.entities.Town;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShopImportDto {

    @NotNull
    @Size(min = 4)
    private String name;

    @NotNull
    @Min(20000)
    private BigDecimal income;

    @NotNull
    @Size(min = 4)
    private String address;


    @NotNull
    @Min(1)
    @Max(50)
    @XmlElement(name = "employee-count")
    private Integer employeeCount;

    @NotNull
    @Min(150)
    @XmlElement(name = "shop-area")
    private Integer shopArea;

    @NotNull
    @XmlElement(name = "town")
    private TownDto town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Integer getShopArea() {
        return shopArea;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }

    public TownDto getTown() {
        return town;
    }

    public void setTown(TownDto town) {
        this.town = town;
    }
}
