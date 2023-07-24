package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PostImportDto;
import softuni.exam.instagraphlite.models.dtos.PostImportRootDto;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.Post;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private static String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final PictureRepository pictureRepository;

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    public PostServiceImpl(ModelMapper modelMapper, XmlParser xmlParser,
                           ValidationUtil validationUtil,
                           PictureRepository pictureRepository,
                           UserRepository userRepository, PostRepository postRepository) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
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

        PostImportRootDto postImportRootDto =
                xmlParser.fromFile(POSTS_FILE_PATH, PostImportRootDto.class);


        List<PostImportDto> posts = postImportRootDto.getPosts();

        posts.stream()
                .filter(postImportDto -> {

                    boolean isValid = validationUtil.isValid(postImportDto);

                    Optional<User> optionalUser =
                            userRepository.findUserByUsername(postImportDto.getUser().getUsername());

                    Optional<Picture> optionalPicture =
                            pictureRepository.findPictureByPath(postImportDto.getPicture().getPath());

                    if (optionalUser.isEmpty() || optionalPicture.isEmpty()) {
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

                    Optional<User> user =
                            userRepository.findUserByUsername(postImportDto.getUser().getUsername());

                    Optional<Picture> picture =
                            pictureRepository.findPictureByPath(postImportDto.getPicture().getPath());

                    post.setUser(user.get());
                    post.setPicture(picture.get());

                    return post;
                })
                .forEach(postRepository::save);


        return sb.toString();
    }
}
