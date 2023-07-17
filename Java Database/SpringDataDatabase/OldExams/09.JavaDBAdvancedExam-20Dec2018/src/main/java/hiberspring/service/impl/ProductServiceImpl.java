package hiberspring.service.impl;

import hiberspring.common.Constants;
import hiberspring.domain.dtos.ProductsImportRootDto;
import hiberspring.domain.entities.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_PATH = "products.xml";

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final BranchService branchService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, BranchService branchService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.branchService = branchService;
    }


    @Override
    public Boolean productsAreImported() {
        return productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + PRODUCTS_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        ProductsImportRootDto productsImportRootDto =
                xmlParser.fromFile(Constants.PATH_TO_FILES + PRODUCTS_FILE_PATH, ProductsImportRootDto.class);

        productsImportRootDto.getProducts()
                .stream()
                .filter(productImportDto -> {
                    boolean isValid = validationUtil.isValid(productImportDto);

                    sb.append(isValid ? String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    "Product", productImportDto.getName())
                                    : Constants.INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(productImportDto -> {
                    Product product = modelMapper.map(productImportDto, Product.class);

                    product.setBranch(branchService.findBranchByName(productImportDto.getBranch()));

                    return product;
                })
                .forEach(productRepository::save);


        return sb.toString();
    }
}
