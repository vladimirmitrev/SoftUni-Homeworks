package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferImportRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private static String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final ModelMapper modelMapper;

    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final OfferRepository offerRepository;

    private final ApartmentRepository apartmentRepository;

    private final AgentRepository agentRepository;


    @Autowired
    public OfferServiceImpl(ModelMapper modelMapper, XmlParser xmlParser,
                            ValidationUtil validationUtil, OfferRepository offerRepository,
                            ApartmentRepository apartmentRepository, AgentRepository agentRepository) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.offerRepository = offerRepository;
        this.apartmentRepository = apartmentRepository;
        this.agentRepository = agentRepository;
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

                    Optional<Agent> optionalAgent =
                            agentRepository.findAgentByFirstName(offerImportDto.getAgent().getName());

                    if (optionalAgent.isEmpty()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported offer %.2f", offerImportDto.getPrice())
                                    : "Invalid offer")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(offerImportDto -> {
                    Offer offer = modelMapper.map(offerImportDto, Offer.class);

                    Optional<Apartment> optionalApartment =
                            apartmentRepository.findById(offerImportDto.getApartment().getId());

                    Optional<Agent> optionalAgent =
                            agentRepository.findAgentByFirstName(offerImportDto.getAgent().getName());


                    offer.setApartment(optionalApartment.get());
                    offer.setAgent(optionalAgent.get());

                    return offer;
                })
                .forEach(offerRepository::save);

        return sb.toString();
    }

    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();

        List<Offer> offers = offerRepository.findOfferByApartment_ApartmentType(ApartmentType.three_rooms);

        offers.forEach(offer ->
                sb.append(String.format("Agent %s %s with offer №%d:%n" +
                "   -Apartment area: %.2f%n" +
                "   --Town: %s%n" +
                "   ---Price: %.2f%n",
                        offer.getAgent().getFirstName(),
                        offer.getAgent().getLastName(),
                        offer.getId(),
                        offer.getApartment().getArea(),
                        offer.getApartment().getTown().getTownName(),
                        offer.getPrice())));


        return sb.toString();
    }
}
