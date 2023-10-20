package com.example.shoppinglistapp.service;

import com.example.shoppinglistapp.model.dto.ProductAddBindingModel;
import com.example.shoppinglistapp.model.dto.ProductViewBindingModel;
import com.example.shoppinglistapp.model.entity.Category;
import com.example.shoppinglistapp.model.entity.Product;
import com.example.shoppinglistapp.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglistapp.repository.CategoryRepository;
import com.example.shoppinglistapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductViewBindingModel> getAllFoods(CategoryNameEnum food) {

        return productRepository
                .findProductsByCategoryName(food)
                .stream()
                .map(this::mapProductDTO)
                .collect(Collectors.toList());
    }
    public List<ProductViewBindingModel> getAllDrinks(CategoryNameEnum drink) {

        return productRepository
                .findProductsByCategoryName(drink)
                .stream()
                .map(this::mapProductDTO)
                .collect(Collectors.toList());
    }
    public List<ProductViewBindingModel> getAllHouseholds(CategoryNameEnum household) {

        return productRepository
                .findProductsByCategoryName(household)
                .stream()
                .map(this::mapProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductViewBindingModel> getAllOthers(CategoryNameEnum household) {

        return productRepository
                .findProductsByCategoryName(household)
                .stream()
                .map(this::mapProductDTO)
                .collect(Collectors.toList());
    }


    private ProductViewBindingModel mapProductDTO(Product product) {
        ProductViewBindingModel productViewBindingModel = new ProductViewBindingModel();
        productViewBindingModel.setId(product.getId());
        productViewBindingModel.setName(product.getName());
        productViewBindingModel.setPrice(product.getPrice());
        productViewBindingModel.setCategory(product.getCategory());

        return productViewBindingModel;
    }

    public List<ProductViewBindingModel> getAllProducts() {
                return productRepository.findAll()
                        .stream()
                        .map(this::mapProductDTO)
                        .collect(Collectors.toList());
    }

    public void removeProductById(Long id) {

        productRepository.deleteById(id);
    }

    public void removeAllProducts() {

        productRepository.deleteAll();
    }
}
