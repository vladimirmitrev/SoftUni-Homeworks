package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerImportDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {


    private static final String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";
    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final TownService townService;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, TownService townService) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {

        StringBuilder sb = new StringBuilder();


        PassengerImportDto[] passengerImportDtos =
                gson.fromJson(readPassengersFileContent(), PassengerImportDto[].class);

        Arrays.stream(passengerImportDtos)
                .filter(passengerImportDto -> {
                    boolean isValid = validationUtil.isValid(passengerImportDto);


                    Optional<Passenger> optionalPassenger = passengerRepository.findPassengerByEmail(passengerImportDto.getEmail());


                    if(optionalPassenger.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Passenger %s - %s",
                                    passengerImportDto.getLastName(), passengerImportDto.getEmail())
                                    : "Invalid Passenger")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(passengerImportDto -> {
                    Passenger passenger = modelMapper.map(passengerImportDto, Passenger.class);
                    passenger.setTown(townService.findTownByName(passengerImportDto.getTown()));

                    return passenger;
                })
                .forEach(passengerRepository::save);


        return sb.toString();
    }

    @Override
    @Transactional
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

        StringBuilder sb = new StringBuilder();

        List<Passenger> passengerList =
                passengerRepository.findAllPassengerOrderByTicketCount();

        passengerList
                .forEach(passenger -> sb.append(String.format("Passenger %s  %s%n" +
                        "   Email - %s%n" +
                        "   Phone - %s%n" +
                        "   Number of tickets - %d%n",
                        passenger.getFirstName(),
                        passenger.getLastName(),
                        passenger.getEmail(),
                        passenger.getPhoneNumber(),
                        passenger.getTickets().size()))
                        .append(System.lineSeparator()));

        return sb.toString();
    }

    @Override
    public Passenger findPassengerByEmail(String email) {
        return passengerRepository
                .findPassengerByEmail(email)
                .orElse(null);
    }
}
