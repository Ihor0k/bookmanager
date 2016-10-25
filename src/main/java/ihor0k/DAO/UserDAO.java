package ihor0k.DAO;

import ihor0k.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(String username);

    User getUser(String username);

    List<User> getAllUsers();
}
