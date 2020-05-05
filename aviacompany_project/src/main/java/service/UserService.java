package main.java.service;

import java.util.List;
import main.java.model.User;

public interface UserService {

	//Create
	boolean addUser(User user);

	//Read
	List<User> getAllUsers();
	User getUserById(int idUser);

	//Update
	User updateUser(int idUser, User newUser);

	//Delete
	boolean deleteUserById(int idUser);

	User isRegistered(String userLogin,String userPassword);

}
