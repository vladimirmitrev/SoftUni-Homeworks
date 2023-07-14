package softuni.exam.instagraphlite.service;

import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.entity.User;

import java.io.IOException;

public interface UserService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importUsers() throws IOException;
    String exportUsersWithTheirPosts();

    User findUserByUsername(String username);
}
