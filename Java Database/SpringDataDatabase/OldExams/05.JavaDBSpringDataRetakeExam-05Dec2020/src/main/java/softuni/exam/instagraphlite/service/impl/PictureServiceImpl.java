package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureImportDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    private final ValidationUtil validationUtil;


    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();

        PictureImportDto[] pictureImportDtos = gson.fromJson(readFromFileContent(), PictureImportDto[].class);

        Arrays.stream(pictureImportDtos)
                .filter(pictureImportDto -> {
                    boolean isValid = validationUtil.isValid(pictureImportDto);


                    Optional<Picture> optionalPicture = pictureRepository.findPictureByPath(pictureImportDto.getPath());

                    if (optionalPicture.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Picture, with size %.2f",
                                    pictureImportDto.getSize())
                                    : "Invalid Picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(pictureImportDto -> modelMapper.map(pictureImportDto, Picture.class))
                .forEach(pictureRepository::save);


        return sb.toString();
    }

    @Override
    public String exportPictures() {

        StringBuilder sb = new StringBuilder();

        List<Picture> pictureList = pictureRepository.findAllPicturesOrderBySize();


//        List<Picture> picturesList = pictureRepository.findAllPictureGreaterThanOrderBySize(30000D);


        pictureList.forEach(picture -> sb.append(String.format("%.2f – %s",
                        picture.getSize(), picture.getPath()))
                .append(System.lineSeparator()));


        return sb.toString();
    }

    @Override
    public Picture findPictureByPath(String profilePicture) {

        return pictureRepository
                .findPictureByPath(profilePicture)
                .orElse(null);
    }
}
