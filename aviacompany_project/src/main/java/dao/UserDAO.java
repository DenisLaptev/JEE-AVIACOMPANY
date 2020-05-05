package main.java.dao;

import main.java.model.User;

import java.util.List;

public interface UserDAO {

	// Create
	boolean addUser(User user);

	// Read
	User getUserById(int idUser);

	List<User> getAllUsers();

	// Update
	User updateUser(int idUser, User newUser);

	// Delete
	boolean deleteUserById(int idUser);

}
