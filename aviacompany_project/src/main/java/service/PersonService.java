package main.java.service;

import java.util.List;

import main.java.model.Person;

public interface PersonService {

	//Create
	boolean addPerson(Person person);

	//Read
	List<Person> getAllPersons();
	List<Person> getAllPersonsByProfession(String profession);
	Person getPersonById(int idPersonal);

	//Update
	Person updatePerson(int idPerson, Person newPerson);

	//Delete
	boolean deletePersonById(int idPerson);

}
