package com.example.productshopxml.model.dto.seed._4dto;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductCountDto {

    @XmlAttribute(name = "count")
    private Integer count;
//    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<ProductWithNameAndPriceDto> product;


    public ProductCountDto(List<ProductWithNameAndPriceDto> product) {
        this.product = product;
    }

    public ProductCountDto() {
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductWithNameAndPriceDto> getProduct() {
        return product;
    }

    public void setProduct(List<ProductWithNameAndPriceDto> product) {
        this.product = product;
    }
}
