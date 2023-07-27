package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.SellerImportRootDto;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    private static String SELLERS_FILE_PATH = "src/main/resources/files/xml/sellers.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    private final XmlParser xmlParser;
    private final SellerRepository sellerRepository;


    @Autowired
    public SellerServiceImpl(ModelMapper modelMapper, ValidationUtilImpl validationUtil,
                             XmlParser xmlParser, SellerRepository sellerRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.sellerRepository = sellerRepository;
    }


    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        SellerImportRootDto sellerImportRootDto =
                xmlParser.fromFile(SELLERS_FILE_PATH, SellerImportRootDto.class);

        sellerImportRootDto.getSellers()
                .stream()
                .filter(sellerImportDto -> {

                    boolean isValid = validationUtil.isValid(sellerImportDto);

                    Optional<Seller> optionalSeller =
                            sellerRepository.findSellerByEmail(sellerImportDto.getEmail());

                    if (optionalSeller.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully import seller %s - %s",
                                    sellerImportDto.getLastName(), sellerImportDto.getEmail())
                                    : "Invalid seller")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(sellerImportDto -> modelMapper.map(sellerImportDto, Seller.class))
                .forEach(sellerRepository::save);

        return sb.toString();
    }
}
