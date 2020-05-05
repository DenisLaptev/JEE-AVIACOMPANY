package main.java.service;

import java.util.List;

import main.java.model.Personal;

public interface PersonalService {

	//Create
	boolean addPersonal(Personal personal);

	//Read
	List<Personal> getAllPersonals();
	Personal getPersonalById(int idPersonal);

	//Update
	Personal updatePersonal(int idPersonal, Personal newPersonal);

	//Delete
	boolean deletePersonalById(int idPersonal);

	void addPersonToPersonal(int idPerson, int idPersonal);

	List<Personal> getFreePersonalByIdOrder(int idOrder);
}
