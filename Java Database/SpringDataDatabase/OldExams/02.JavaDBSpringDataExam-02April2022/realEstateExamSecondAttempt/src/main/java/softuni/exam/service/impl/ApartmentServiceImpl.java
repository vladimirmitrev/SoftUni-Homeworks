package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private static String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final ModelMapper modelMapper;

    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final ApartmentRepository apartmentRepository;

    private final TownRepository townRepository;

    @Autowired
    public ApartmentServiceImpl(ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, ApartmentRepository apartmentRepository, TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        ApartmentImportRootDto apartmentImportRootDto =
                xmlParser.fromFile(APARTMENTS_FILE_PATH, ApartmentImportRootDto.class);

        apartmentImportRootDto.getApartments()
                .stream()
                .filter(apartmentImportDto -> {

                    boolean isValid = validationUtil.isValid(apartmentImportDto);


                    Optional<Apartment> optionalApartment =
                            apartmentRepository.findApartmentByAreaAndTown_TownName(
                                    apartmentImportDto.getArea(), apartmentImportDto.getTown());

                    if (optionalApartment.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported apartment %s - %.2f",
                                    apartmentImportDto.getApartmentType(), apartmentImportDto.getArea())
                                    : "Invalid apartment")
                            .append(System.lineSeparator());

                    return isValid;

                })
                .map(apartmentImportDto -> {
                    Apartment apartment = modelMapper.map(apartmentImportDto, Apartment.class);

                    Optional<Town> optionalTown =
                            townRepository.findTownByTownName(apartmentImportDto.getTown());

                    apartment.setTown(optionalTown.get());

                    return apartment;
                })
                .forEach(apartmentRepository::save);

        return sb.toString();
    }
}
