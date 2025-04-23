package service;

import dao.UserDao;
import entity.User;
import exception.ResourceAlreadyExistsException;

import java.util.Optional;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void registerUser(String name, String email, String pass) {
        Optional<User> foundUser = userDao.findAll().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();

        if (foundUser.isPresent()) {
            throw new ResourceAlreadyExistsException("User already exists with this email!");
        }

        
    }
}
