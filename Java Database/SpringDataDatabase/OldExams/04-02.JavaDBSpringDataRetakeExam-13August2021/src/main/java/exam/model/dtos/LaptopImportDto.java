package exam.model.dtos;

import exam.model.entities.Shop;
import exam.model.entities.WarrantyType;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopImportDto {

    @NotNull
    @Size(min = 8)
    private String macAddress;

    @NotNull
    @Positive
    private Double cpuSpeed;

    @NotNull
    @Min(8)
    @Max(128)
    private Integer ram;

    @NotNull
    @Min(128)
    @Max(1024)
    private Integer storage;

    @NotNull
    @Size(min = 10)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private WarrantyType warrantyType;

    @NotNull
    private ShopDto shop;

    public LaptopImportDto() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public ShopDto getShop() {
        return shop;
    }

    public void setShop(ShopDto shop) {
        this.shop = shop;
    }
}
