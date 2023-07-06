package com.example.productshopxml.model.dto;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryViewRootDto {

   @XmlElement(name = "category")
   private List<CategoryWithInfoDto> categories;

   public List<CategoryWithInfoDto> getCategories() {
      return categories;
   }

   public void setCategories(List<CategoryWithInfoDto> categories) {
      this.categories = categories;
   }
}
