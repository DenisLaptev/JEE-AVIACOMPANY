package main.java.dao;

import main.java.model.Person;

import java.util.List;

public interface PersonDAO {

    //Create
    boolean addPerson(Person person);

    //Read
    Person getPersonById(int idPerson);
    List<Person> getAllPersons();
    List<Person> getAllPersonsByProfession(String profession);

    //Update
    Person updatePerson(int idPerson, Person newPerson);

    //Delete
    boolean deletePersonById(int idPerson);


}
