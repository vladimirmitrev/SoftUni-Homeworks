package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.OfferImportRootDto;
import softuni.exam.models.entities.Offer;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {

    private static String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    private final XmlParser xmlParser;
    private final SellerRepository sellerRepository;

    private final OfferRepository offerRepository;

    private final CarRepository carRepository;

    @Autowired
    public OfferServiceImpl(ModelMapper modelMapper, ValidationUtilImpl validationUtil,
                            XmlParser xmlParser, SellerRepository sellerRepository,
                            OfferRepository offerRepository, CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.sellerRepository = sellerRepository;
        this.offerRepository = offerRepository;
        this.carRepository = carRepository;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        OfferImportRootDto offerImportRootDto =
                xmlParser.fromFile(OFFERS_FILE_PATH, OfferImportRootDto.class);

        offerImportRootDto.getOffers()
                .stream()
                .filter(offerImportDto -> {

                    boolean isValid = validationUtil.isValid(offerImportDto);


                    sb.append(isValid ? String.format("Successfully import offer %s - %s",
                                    offerImportDto.getAddedOn(), offerImportDto.getHasGoldStatus())
                                    : "Invalid offer")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(offerImportDto -> {

                    Offer offer = modelMapper.map(offerImportDto, Offer.class);

                    offer.setCar(carRepository.findById(offerImportDto.getCar().getId()).get());

                    offer.setSeller(sellerRepository.findById(offerImportDto.getSeller().getId()).get());

                    return offer;
                })
                .forEach(offerRepository::save);

        return sb.toString();
    }
}
