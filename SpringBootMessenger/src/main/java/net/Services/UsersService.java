package net.Services;

import net.entities.User;

import java.util.List;

public interface UsersService {
    List<User> listUsers();
    User findUserById(long id);
    boolean addUser(User user);
    boolean existsUser(long id);
    boolean deleteUserById(long id);
}
