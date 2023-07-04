package com.example.cardealer;

import com.example.cardealer.model.dto.*;
import com.example.cardealer.model.dto.CarWithIdDto;
import com.example.cardealer.model.dto.discountSale.CarWithPartListDto;
import com.example.cardealer.model.dto.discountSale.SaleWithDiscountDto;
import com.example.cardealer.service.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static com.example.cardealer.globalConstants.GlobalConstants.*;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final SupplierService supplierService;
    private final SeedService seedService;
    private final BufferedReader bufferedReader;
    private final CustomerService customerService;

    private final CarService carService;

    private final Gson gson;
    private final SaleService saleService;


    @Autowired
    public CommandLineRunnerImpl(SupplierService supplierService, SeedService seedService, CustomerService customerService, CarService carService, Gson gson, SaleService saleService) {
        this.supplierService = supplierService;
        this.seedService = seedService;
        this.carService = carService;
        this.saleService = saleService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.customerService = customerService;
        this.gson = gson;
    }


    @Override
    public void run(String... args) throws Exception {


        //Todo uncomment to seed entities
//        this.seedService.seedSuppliers();
//        this.seedService.seedParts();
//        this.seedService.seedCars();
//        this.seedService.seedCustomer();
//        this.seedService.seedSales();

        int exerciseNumber = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Enter the number(digits from 1 to 6) of query you want to run:");

//         Todo uncomment number of case you want to test
        switch (exerciseNumber) {
            case 1 -> q01OrderedCustomers();
            case 2 -> q02CarsFromMakeToyota();
            case 3 -> q03LocalSuppliers();
            case 4 -> q04CarsWithTheirListOfParts();
            case 5 -> q05TotalSalesByCustomer();
            case 6 -> q06SalesWithAppliedDiscount();
        }

    }

    private void q06SalesWithAppliedDiscount() throws IOException {
        List<SaleWithDiscountDto> allSalesWithDiscount =
                this.saleService.getAllSalesWithDiscount();

        String fileContent = gson.toJson(allSalesWithDiscount);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + SALES_DISCOUNTS_FILE_NAME, fileContent);
    }

    private void q05TotalSalesByCustomer() throws IOException {

        List<CustomerNameWithBoughtCarsAndMoneySpentDto> customerList =
                this.customerService.getCustomerWithBoughtCars();

        String fileContent = gson.toJson(customerList);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + CUSTOMERS_TOTAL_SALES_FILE_NAME, fileContent);

    }

    private void q04CarsWithTheirListOfParts() throws IOException {

        List<CarWithPartListDto> carList = this.carService.getAllCarWithTheirPartsList();

        String fileContent = gson.toJson(carList);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + CARS_AND_PARTS_FILE_NAME, fileContent);
    }

    private void q03LocalSuppliers() throws IOException {

        List<SupplierWithIdAndPartsCountDto> supplierList =
                this.supplierService.getAllSuppliersWithLocalParts();

            String fileContent = gson.toJson(supplierList);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + LOCAL_SUPPLIERS_FILE_NAME, fileContent);

    }

    private void q02CarsFromMakeToyota() throws IOException {

            String carMake = "Toyota";

            List<CarWithIdDto> carList =
                    this.carService.getAllCarsFrom(carMake);

            String fileContent = gson.toJson(carList);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + TOYOTA_CARS_FILE_NAME, fileContent);
    }

    private void q01OrderedCustomers() throws IOException {
        List<CustomerWithIdDto> customerList =
                this.customerService.findAllCustomersOrderByBirthday();


        String fileContent = gson.toJson(customerList);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + ORDERED_CUSTOMERS_FILE_NAME,fileContent);
    }

    private void writeToFile(String filePath, String content) throws IOException {

        Files
                .write(Path.of(filePath), Collections.singleton(content));
    }

}
