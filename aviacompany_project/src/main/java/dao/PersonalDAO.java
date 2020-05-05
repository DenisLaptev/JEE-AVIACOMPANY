package main.java.dao;

import main.java.model.Personal;

import java.util.List;

public interface PersonalDAO {

	// Create
	boolean addPersonal(Personal personal);

	// Read
	Personal getPersonalById(int idPersonal);

	List<Personal> getAllPersonals();

	// Update
	Personal updatePersonal(int idPersonal, Personal newPersonal);

	// Delete
	boolean deletePersonalById(int idPersonal);

    void addPersonToPersonal(int idPerson, int idPersonal);

	List<Personal> getFreePersonalByIdOrder(int idOrder);
}
