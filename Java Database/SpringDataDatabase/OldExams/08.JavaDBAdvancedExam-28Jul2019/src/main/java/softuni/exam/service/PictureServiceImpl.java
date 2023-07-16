package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PictureImportRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PICTURES_FILE_PATH = "src/main/resources/files/xml/pictures.xml";
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        PictureImportRootDto pictureImportRootDto = xmlParser.fromFile(PICTURES_FILE_PATH, PictureImportRootDto.class);

        pictureImportRootDto.getPictures()
                .stream()
                .filter(pictureImportDto -> {
                    boolean isValid = validationUtil.isValid(pictureImportDto);

                    sb.append(isValid ? String.format("Successfully imported picture - %s",
                                    pictureImportDto.getUrl())
                                    : "Invalid picture")
                            .append(System.lineSeparator());

                    return isValid;

                })
                .map(pictureImportDto -> modelMapper.map(pictureImportDto, Picture.class))
                .forEach(pictureRepository::save);


        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public Picture findPictureByUrl(String url) {
        return pictureRepository
                .findPictureByUrl(url)
                .orElse(null);
    }

}
