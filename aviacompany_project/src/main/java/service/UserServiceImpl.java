package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.dao.UserDAO;
import main.java.dao.UserDAOImpl;
import main.java.model.User;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() {
        UserDAO userDAO = new UserDAOImpl();
        List<User> allUsersList = new ArrayList<>();
        allUsersList = userDAO.getAllUsers();
        return allUsersList;
    }

    @Override
    public User getUserById(int idUser) {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserById(idUser);
        return user;
    }

    @Override
    public User updateUser(int idUser, User newUser) {
        UserDAO userDAO = new UserDAOImpl();
        User updatedUser = userDAO.updateUser(idUser, newUser);

        System.out.println("updatedUser=" + updatedUser);
        return updatedUser;
    }

    @Override
    public boolean deleteUserById(int idUser) {
        UserDAO userDAO = new UserDAOImpl();
        boolean result = userDAO.deleteUserById(idUser);

        System.out.println("deleteUserById=" + result);
        return result;
    }

    @Override
    public User isRegistered(String login, String password) {
        User registeredUser = null;

        UserDAO userDAO = new UserDAOImpl();
        List<User> allUsersList = new ArrayList<>();
        allUsersList = userDAO.getAllUsers();

        for (User user : allUsersList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                registeredUser = user;
                break;
            }
        }
        return registeredUser;
    }

    @Override
    public boolean addUser(User user) {
        UserDAO userDAO = new UserDAOImpl();
        boolean result = userDAO.addUser(user);
        return result;
    }
}
