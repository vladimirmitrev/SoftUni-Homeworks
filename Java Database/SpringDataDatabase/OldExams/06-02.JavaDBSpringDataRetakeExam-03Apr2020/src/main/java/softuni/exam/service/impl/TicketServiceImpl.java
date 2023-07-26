package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketImportRootDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private static String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;

    private final PlaneRepository planeRepository;

    private final PassengerRepository passengerRepository;

    private final TownRepository townRepository;
    private final TicketRepository ticketRepository;


    public TicketServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil,
                             XmlParser xmlParser, PlaneRepository planeRepository,
                             PassengerRepository passengerRepository,
                             TownRepository townRepository, TicketRepository ticketRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.planeRepository = planeRepository;
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.ticketRepository = ticketRepository;
    }


    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();


        TicketImportRootDto ticketImportRootDto =
                xmlParser.fromFile(TICKETS_FILE_PATH, TicketImportRootDto.class);

        ticketImportRootDto.getTickets()
                .stream()
                .filter(ticketImportDto -> {

                    boolean isValid = validationUtil.isValid(ticketImportDto);

                    Optional<Ticket> optionalTicket =
                            ticketRepository.findTicketBySerialNumber(ticketImportDto.getSerialNumber());

                    if (optionalTicket.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported Ticket %s - %s",
                                    ticketImportDto.getFromTown().getName(), ticketImportDto.getToTown().getName())
                                    : "Invalid Ticket")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(ticketImportDto -> {

                    Ticket ticket = modelMapper.map(ticketImportDto, Ticket.class);

                    Optional<Passenger> passenger =
                            passengerRepository.findPassengerByEmail(ticketImportDto.getPassenger().getEmail());

                    Optional<Town> fromTown =
                            townRepository.findTownByName(ticketImportDto.getFromTown().getName());

                    Optional<Town> toTown =
                            townRepository.findTownByName(ticketImportDto.getToTown().getName());

                    Optional<Plane> plane =
                            planeRepository.findPlaneByRegisterNumber(ticketImportDto.getPlane().getRegisterNumber());


                    ticket.setFromTown(fromTown.get());

                    ticket.setToTown(toTown.get());

                    ticket.setPassenger(passenger.get());

                    ticket.setPlane(plane.get());

                    return ticket;

                })
                .forEach(ticketRepository::save);


        return sb.toString();
    }
}
