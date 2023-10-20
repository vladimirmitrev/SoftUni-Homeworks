package com.example.shoppinglistapp.service;

import com.example.shoppinglistapp.model.dto.ProductAddBindingModel;
import com.example.shoppinglistapp.model.entity.Category;
import com.example.shoppinglistapp.model.entity.Product;
import com.example.shoppinglistapp.repository.CategoryRepository;
import com.example.shoppinglistapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public void addProduct(ProductAddBindingModel productAddBindingModel) {


        Category category = categoryRepository
                .findByName(productAddBindingModel.getCategory())
                .orElse(null);

        if (category != null) {
            Product product = new Product();

            product.setName(productAddBindingModel.getName());
            product.setDescription(productAddBindingModel.getDescription());
            product.setNeededBefore(productAddBindingModel.getNeededBefore());
            product.setPrice(productAddBindingModel.getPrice());
            product.setCategory(category);

            productRepository.save(product);
        }
    }
}
