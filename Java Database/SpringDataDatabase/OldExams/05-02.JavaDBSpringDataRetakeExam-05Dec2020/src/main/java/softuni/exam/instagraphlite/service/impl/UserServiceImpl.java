package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.UserImportDto;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.Post;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final PictureRepository pictureRepository;

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    public UserServiceImpl(ModelMapper modelMapper, Gson gson,
                           ValidationUtil validationUtil,
                           PictureRepository pictureRepository,
                           UserRepository userRepository, PostRepository postRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {

        StringBuilder sb = new StringBuilder();

        UserImportDto[] userImportDtos =
                gson.fromJson(readFromFileContent(), UserImportDto[].class);

        Arrays.stream(userImportDtos)
                .filter(userImportDto -> {

                    boolean isValid = validationUtil.isValid(userImportDto);


                    Optional<User> optionalUser =
                            userRepository.findUserByUsername(userImportDto.getUsername());

                    if (optionalUser.isPresent()) {
                        isValid = false;
                    }

                    Optional<Picture> optionalPicture =
                            pictureRepository.findPictureByPath(userImportDto.getProfilePicture());

                    if (optionalPicture.isEmpty()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported User: %s",
                                    userImportDto.getUsername())
                                    : "Invalid User")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(userImportDto -> {
                    User user = modelMapper.map(userImportDto, User.class);

                    Optional<Picture> picture =
                            pictureRepository.findPictureByPath(userImportDto.getProfilePicture());

                    user.setPicture(picture.get());

                    return user;
                })
                .forEach(userRepository::save);

        return sb.toString();
    }

    @Override
    @Transactional
    public String exportUsersWithTheirPosts() {

        StringBuilder sb = new StringBuilder();

        List<User> userList = userRepository.findUserOrderByPostCount();

        userList.forEach(user -> {
            sb.append(String.format("User: %s%n" +
                            "Post count: %d%n",
                    user.getUsername(),
                    user.getPosts().size()));


            List<Post> postList = postRepository.findAllOrderByPictureSize(user.getId());

            postList.forEach(post ->
                    sb.append(String.format("==Post Details:%n" +
                                    "----Caption: %s%n" +
                                    "----Picture Size: %.2f%n",
                            post.getCaption(),
                            post.getPicture().getSize())));


            //Unordered by picture size
//            user.getPosts()
//                    .forEach(post -> {
//                        sb.append(String.format("==Post Details:%n" +
//                                        "----Caption: %s%n" +
//                                        "----Picture Size: %.2f%n",
//                                post.getCaption(),
//                                post.getPicture().getSize()));
//                    });

        });


        return sb.toString();
    }
}
