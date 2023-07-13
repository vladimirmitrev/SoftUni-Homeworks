package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopImportDto;
import exam.model.entity.Laptop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ShopService shopService;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();


        LaptopImportDto[] laptopImportDtos = gson.fromJson(readLaptopsFileContent(), LaptopImportDto[].class);

        Arrays.stream(laptopImportDtos)
                .filter(laptopImportDto -> {
                    boolean isValid = validationUtil.isValid(laptopImportDto);

                    Optional<Laptop> optionalLaptop = laptopRepository.findLaptopByMacAddress(laptopImportDto.getMacAddress());

                    if (optionalLaptop.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                                    laptopImportDto.getMacAddress(), laptopImportDto.getCpuSpeed(),
                                    laptopImportDto.getRam(), laptopImportDto.getStorage())
                                    : "Invalid Laptop")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(laptopImportDto -> {
                    Laptop laptop = modelMapper.map(laptopImportDto, Laptop.class);

                    laptop.setShop(shopService.findShopByName(laptopImportDto.getShop().getName()));

                    return laptop;
                })
                .forEach(laptopRepository::save);


        return sb.toString();
    }

    @Override
    public String exportBestLaptops() {

        StringBuilder sb = new StringBuilder();

        List<Laptop> laptopList =  laptopRepository.getAllLaptopsOrderByBestFirst();

        laptopList
                .forEach(laptop -> sb.append(String.format("Laptop - %s%n" +
                        "*Cpu speed - %.2f%n" +
                        "**Ram - %d%n" +
                        "***Storage - %d%n" +
                        "****Price - %.2f%n" +
                        "#Shop name - %s%n" +
                        "##Town - %s%n",
                        laptop.getMacAddress(),
                        laptop.getCpuSpeed(),
                        laptop.getRam(),
                        laptop.getStorage(),
                        laptop.getPrice(),
                        laptop.getShop().getName(),
                        laptop.getShop().getTown().getName()))
                        .append(System.lineSeparator()));


        return sb.toString();
    }
}
