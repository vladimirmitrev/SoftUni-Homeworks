package exam.service.impl;

import exam.model.dto.ShopImportRootDto;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {


    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final TownService townService;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownService townService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.shopRepository = shopRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;


    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        ShopImportRootDto shopImportRootDto = xmlParser.fromFile(SHOPS_FILE_PATH, ShopImportRootDto.class);

        shopImportRootDto.getShops()
                .stream()
                .filter(shopImportDto -> {
                    boolean isValid = validationUtil.isValid(shopImportDto);

                    Optional<Shop> optionalShop = shopRepository.findShopByName(shopImportDto.getName());

                    if (optionalShop.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Shop %s - %.0f",
                                    shopImportDto.getName(), shopImportDto.getIncome())
                                    : "Invalid shop")
                            .append(System.lineSeparator());


                    return isValid;

                })
                .map(shopImportDto -> {
                    Shop shop = modelMapper.map(shopImportDto, Shop.class);
                    shop.setTown(townService.findTownByName(shopImportDto.getTown().getName()));

                    return shop;
                })
                .forEach(shopRepository::save);


        return sb.toString();
    }

    @Override
    public Shop findShopByName(String shopName) {

        return shopRepository
                .findShopByName(shopName)
                .orElse(null);
    }
}
