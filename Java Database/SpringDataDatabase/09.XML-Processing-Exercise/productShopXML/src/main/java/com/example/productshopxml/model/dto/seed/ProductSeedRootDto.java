package com.example.productshopxml.model.dto.seed;

import com.example.productshopxml.model.dto.ProductWithSellerDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedRootDto {


    @XmlElement(name = "product")
    private List<ProductSeedDto> products;

    public List<ProductSeedDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSeedDto> products) {
        this.products = products;
    }
}
