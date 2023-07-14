package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureDto;
import softuni.exam.instagraphlite.models.dto.PostImportRootDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {


    private static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    private final XmlParser xmlParser;


    private final ValidationUtil validationUtil;

    private final PictureService pictureService;

    private final UserService userService;


    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, PictureService pictureService, UserService userService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
        this.userService = userService;
    }


    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();


        PostImportRootDto postImportRootDto = xmlParser.fromFile(POSTS_FILE_PATH, PostImportRootDto.class);

        postImportRootDto.getPosts()
                .stream()
                .filter(postImportDto -> {
                    boolean isValid = validationUtil.isValid(postImportDto);

                    Picture picture = pictureService.findPictureByPath(postImportDto.getPicture().getPath());

                    if (picture == null) {
                        isValid = false;
                    }

                    User user = userService.findUserByUsername(postImportDto.getUser().getUsername());

                    if (user == null) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported Post, made by %s",
                                    postImportDto.getUser().getUsername())
                                    : "Invalid Post")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(postImportDto -> {
                    Post post = modelMapper.map(postImportDto, Post.class);

                    post.setUser(userService.findUserByUsername(postImportDto.getUser().getUsername()));
                    post.setPicture(pictureService.findPictureByPath(postImportDto.getPicture().getPath()));

                    return post;
                })
                .forEach(postRepository::save);


        return sb.toString();
    }
}
