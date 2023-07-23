package exam.service.impl;

import exam.model.dtos.ShopImportRootDto;
import exam.model.entities.Shop;
import exam.model.entities.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private static String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, TownRepository townRepository, ShopRepository shopRepository) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
        this.shopRepository = shopRepository;
    }

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

        ShopImportRootDto shopImportRootDto =
                xmlParser.fromFile(SHOPS_FILE_PATH, ShopImportRootDto.class);

        shopImportRootDto.getShops()
                .stream()
                .filter(shopImportDto -> {

                    boolean isValid = validationUtil.isValid(shopImportDto);

                    Optional<Shop> optionalShop = shopRepository.findShopByName(shopImportDto.getName());

                    if (optionalShop.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported Shop %s - %s",
                                    shopImportDto.getName(), shopImportDto.getIncome())
                                    : "Invalid shop")
                            .append(System.lineSeparator());


                    return isValid;

                })
                .map(shopImportDto -> {

                    Shop shop = modelMapper.map(shopImportDto, Shop.class);

                    Optional<Town> town = townRepository.findTownByName(shopImportDto.getTown().getName());

                    shop.setTown(town.get());

                    return shop;
                })
                .forEach(shopRepository::save);


        return sb.toString();
    }
}
