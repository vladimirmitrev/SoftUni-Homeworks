package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserImportDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
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


    private static final String USERS_FILE_PATH = "src/main/resources/files/users.json";
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    private final ValidationUtil validationUtil;

    private final PictureService pictureService;
    private final PostRepository postRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, PictureService pictureService, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
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

        UserImportDto[] userImportDtos = gson.fromJson(readFromFileContent(), UserImportDto[].class);


        Arrays.stream(userImportDtos)
                .filter(userImportDto -> {
                    boolean isValid = validationUtil.isValid(userImportDto);


                    Optional<User> optionalUser = userRepository.findUserByUsername(userImportDto.getUsername());

                    if (optionalUser.isPresent()) {
                        isValid = false;
                    }

                    Picture picture = pictureService.findPictureByPath(userImportDto.getProfilePicture());

                    if (picture == null) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported User: %s", userImportDto.getUsername())
                                    : "Invalid User")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(userImportDto -> {
                    User user = modelMapper.map(userImportDto, User.class);

                    user.setProfilePicture(pictureService.findPictureByPath(userImportDto.getProfilePicture()));

                    return user;
                })
                .forEach(userRepository::save);


        return sb.toString();
    }

    @Override
    @Transactional
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        List<User> userList = userRepository.getAllUsers();
//        List<User> usersList = userRepository.findAllByPostsAndUser();

        userList.forEach(user -> {
            List<Post> postList = postRepository.getAllPosts(user.getId());
            sb.append(String.format("User: %s%n" +
                            "Post count: %d%n",
                    user.getUsername(),
                    user.getPosts().size()));

//            user.getPosts().forEach();

            postList.forEach(post -> sb.append(String.format("==Post Details:%n" +
                                    "----Caption: %s%n" +
                                    "----Picture Size: %.2f%n",
                            post.getCaption(), post.getPicture().getSize())));
        });

        return sb.toString();
    }

    @Override
    public User findUserByUsername(String username) {

        return userRepository
                .findUserByUsername(username)
                .orElse(null);
    }
}
