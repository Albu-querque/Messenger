package net.services;

import net.entities.User;
import net.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<User> listUsers() {
        return (List)usersRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public boolean addUser(User user) {
        return usersRepository.save(user) != null;
    }

    @Override
    public boolean existsUser(long id) {
        return usersRepository.existsById(id);
    }

    @Override
    public boolean deleteUserById(long id) {
        if(existsUser(id)) {
            usersRepository.deleteById(id);
            return true;
        }
        else return false;
    }
}
