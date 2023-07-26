package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerImportDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
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

    private static String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final TownRepository townRepository;

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(ModelMapper modelMapper,
                                ValidationUtil validationUtil, Gson gson,
                                TownRepository townRepository,
                                PassengerRepository passengerRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.townRepository = townRepository;
        this.passengerRepository = passengerRepository;
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

                    Optional<Passenger> optionalPassenger =
                            passengerRepository.findPassengerByEmail(passengerImportDto.getEmail());

                    if (optionalPassenger.isPresent()) {
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


                    Optional<Town> town = townRepository.findTownByName(passengerImportDto.getTown());

                    passenger.setTown(town.get());

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
                passengerRepository.getAllPassengersOrderByTicketCount();

        passengerList.forEach(passenger ->
                sb.append(String.format("Passenger %s  %s%n" +
                                        "       Email - %s%n" +
                                        "       Phone - %s%n" +
                                        "       Number of tickets - %d%n",
                                passenger.getFirstName(),
                                passenger.getLastName(),
                                passenger.getEmail(),
                                passenger.getPhoneNumber(),
                                passenger.getTickets().size()))
                        .append(System.lineSeparator()));

        return sb.toString();
    }
}
