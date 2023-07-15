package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketImportRootDto;
import softuni.exam.models.entity.Ticket;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final TownService townService;
    private final PassengerService passengerService;
    private final PlaneService planeService;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, TownService townService, PassengerService passengerService, PlaneService planeService) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.passengerService = passengerService;
        this.planeService = planeService;
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
                                    ticketImportDto.getFromTown(), ticketImportDto.getToTown())
                                    : "Invalid Town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(ticketImportDto -> {
                    Ticket ticket = modelMapper.map(ticketImportDto, Ticket.class);

                    ticket.setFromTown(townService.findTownByName(ticketImportDto.getFromTown().getName()));
                    ticket.setToTown(townService.findTownByName(ticketImportDto.getToTown().getName()));
                    ticket.setPassenger(passengerService.findPassengerByEmail(ticketImportDto.getPassenger().getEmail()));
                    ticket.setPlane(planeService.findPlaneByRegisterNumber(ticketImportDto.getPlane().getRegisterNumber()));

                    return ticket;
                })
                .forEach(ticketRepository::save);


        return sb.toString();
    }
}
