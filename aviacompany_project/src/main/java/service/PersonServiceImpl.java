package main.java.service;

import java.util.ArrayList;
import java.util.List;
import main.java.dao.PersonDAO;
import main.java.dao.PersonDAOImpl;
import main.java.model.Person;

public class PersonServiceImpl implements PersonService {

	@Override
	public List<Person> getAllPersons() {
		PersonDAO personDAO = new PersonDAOImpl();
		List<Person> allPersonsList = new ArrayList<>();
		allPersonsList = personDAO.getAllPersons();
		return allPersonsList;
	}

	@Override
	public List<Person> getAllPersonsByProfession(String profession) {

		String realProfession=getRealProfession(profession);

		PersonDAO personDAO = new PersonDAOImpl();
		List<Person> personsList = new ArrayList<>();
		personsList = personDAO.getAllPersonsByProfession(realProfession);
		return personsList;
	}

	@Override
	public Person getPersonById(int idPerson) {
		PersonDAO personDAO = new PersonDAOImpl();
		Person person = personDAO.getPersonById(idPerson);
		return person;
	}

	@Override
	public Person updatePerson(int idPerson, Person newPerson) {
		PersonDAO personDAO = new PersonDAOImpl();
		Person updatedPerson = personDAO.updatePerson(idPerson, newPerson);

		System.out.println("updatedPerson=" + updatedPerson);
		return updatedPerson;
	}

	@Override
	public boolean addPerson(Person person) {
		PersonDAO personDAO = new PersonDAOImpl();
		boolean result = personDAO.addPerson(person);
		return result;
	}

	@Override
	public boolean deletePersonById(int idPerson) {
		PersonDAO personDAO = new PersonDAOImpl();
		boolean result = personDAO.deletePersonById(idPerson);

		System.out.println("deletePersonById=" + result);
		return result;
	}

	public String getRealProfession(String profession){

		String realProfession="Profession";

		if(profession.contains("Pilot")){
			realProfession="Pilot";
		}else if(profession.contains("Shturman")){
			realProfession="Shturman";
		}else if(profession.contains("Radist")){
			realProfession="Radist";
		}else if(profession.contains("Stuardes")){
			realProfession="Stuardes";
		}
		return realProfession;
	}
}