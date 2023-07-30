package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class StarServiceImpl implements StarService {

    private static String STARS_FILE_PATH = "src/main/resources/files/json/stars.json";

    private final StarRepository starRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final ConstellationRepository constellationRepository;

    @Autowired
    public StarServiceImpl(StarRepository starRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, ConstellationRepository constellationRepository) {
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.constellationRepository = constellationRepository;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {

        StringBuilder sb = new StringBuilder();

        StarImportDto[] starImportDtos =
                gson.fromJson(readStarsFileContent(), StarImportDto[].class);

        Arrays.stream(starImportDtos)
                .filter(starImportDto -> {

                    boolean isValid = validationUtil.isValid(starImportDto);

                    Optional<Star> optionalStar = starRepository.findByName(starImportDto.getName());

                    if (optionalStar.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported star %s - %.2f light years",
                                    starImportDto.getName(), starImportDto.getLightYears())
                                    : "Invalid star")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(starImportDto -> {

                    Star star = modelMapper.map(starImportDto, Star.class);

                    Optional<Constellation> constellationId =
                            constellationRepository.findById(starImportDto.getConstellation());

                    star.setConstellation(constellationId.get());

                    return star;
                })
                .forEach(starRepository::save);

        return sb.toString();
    }

    @Override
    public String exportStars() {

        StringBuilder sb = new StringBuilder();

        List<Star> starList =
                starRepository.findByStarTypeAndObserversEmptyOrderByLightYears(StarType.RED_GIANT);

        starList.forEach(star ->
                sb.append(String.format("Star: %s%n" +
                                "   *Distance: %.2f light years%n" +
                                "   **Description: %s%n" +
                                "   ***Constellation: %s%n",
                        star.getName(),
                        star.getLightYears(),
                        star.getDescription(),
                        star.getConstellation().getName())));

        return sb.toString();
    }
}
