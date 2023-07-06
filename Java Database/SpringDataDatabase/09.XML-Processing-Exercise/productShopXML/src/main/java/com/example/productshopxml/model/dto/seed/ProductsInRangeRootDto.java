package com.example.productshopxml.model.dto.seed;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRangeRootDto {

    @XmlElement(name = "product")
    private List<ProductsWithSellerDto> products;

    public List<ProductsWithSellerDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsWithSellerDto> products) {
        this.products = products;
    }
}
