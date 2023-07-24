package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PictureImportDto;
import softuni.exam.instagraphlite.models.entities.Picture;
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

    private static String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(ModelMapper modelMapper, Gson gson,
                              ValidationUtil validationUtil,
                              PictureRepository pictureRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.pictureRepository = pictureRepository;
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

        PictureImportDto[] pictureImportDtos =
                gson.fromJson(readFromFileContent(), PictureImportDto[].class);


        Arrays.stream(pictureImportDtos)
                .filter(pictureImportDto -> {

                    boolean isValid = validationUtil.isValid(pictureImportDto);

                    Optional<Picture> optionalPicture =
                            pictureRepository.findPictureByPath(pictureImportDto.getPath());

                    if(optionalPicture.isPresent()) {
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

        double picSize = 30000;

        List<Picture> pictureList = pictureRepository.findPictureBySizeGreaterThanOrderBySizeAsc(picSize);

        pictureList.forEach(picture ->
                sb.append(String.format("%.2f – %s%n",
                        picture.getSize(), picture.getPath())));

        return sb.toString();
    }
}
