package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PicturesImportDto;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtilImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    private static String PICTURES_FILE_PATH = "src/main/resources/files/json/pictures.json";

    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    private final Gson gson;
    private final CarRepository carRepository;

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(ModelMapper modelMapper, ValidationUtilImpl validationUtil,
                              Gson gson,
                              CarRepository carRepository,
                              PictureRepository pictureRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.carRepository = carRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();

        PicturesImportDto[] picturesImportDtos =
                gson.fromJson(readPicturesFromFile(), PicturesImportDto[].class);

        Arrays.stream(picturesImportDtos)
                .filter(picturesImportDto -> {


                    boolean isValid = validationUtil.isValid(picturesImportDto);

                    Optional<Picture> optionalPicture =
                            pictureRepository.findPictureByName(picturesImportDto.getName());

                    if(optionalPicture.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully import picture - %s",
                                    picturesImportDto.getName())
                                    : "Invalid picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(picturesImportDto -> {
                    Picture picture = modelMapper.map(picturesImportDto, Picture.class);

                    picture.setCar(carRepository.findById(picturesImportDto.getCar()).get());

                    return picture;
                })
                .forEach(pictureRepository::save);

        return sb.toString();
    }
}
