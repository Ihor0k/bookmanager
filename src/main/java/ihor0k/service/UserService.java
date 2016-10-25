package ihor0k.service;

import ihor0k.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(String username);

    User loadUserByUsername(String username);

    List<User> getAllUsers();
}
