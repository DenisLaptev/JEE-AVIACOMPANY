package test.java.test_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.dao.PersonDAO;
import main.java.dao.PersonDAOImpl;
import main.java.model.Person;

class TestPersonDAO {


	PersonDAO personDao = new PersonDAOImpl();

	private static final int ID_PERSON_FOR_TEST = -2;
	private static final int ID_PERSONAL_FOR_TEST = -2;
	private static final String ID_FIRST_NAME_FOR_TEST = "TestFirst";
	private static final String ID_LAST_NAME_FOR_TEST = "TestLast";
	private static final String ID_PROFESSION_FOR_TEST = "TestProfession";

	@Test
	void addPersonTest() {
		
		List<Person>persons = new ArrayList<>();
		persons = personDao.getAllPersons();
		
		System.out.println("persons="+persons);
		
		int numberOfPersons = 0;
		if(!persons.isEmpty()) {
			numberOfPersons = persons.size();
		}
		
		Person personToAdd = new Person(ID_PERSON_FOR_TEST, ID_PERSONAL_FOR_TEST, ID_FIRST_NAME_FOR_TEST, ID_LAST_NAME_FOR_TEST,
				ID_PROFESSION_FOR_TEST);
		personDao.addPerson(personToAdd);
		
		System.out.println("personToAdd="+personToAdd);
		
		List<Person>personsModified = new ArrayList<>();
		personsModified = personDao.getAllPersons();
		
		System.out.println("personsModified="+personsModified);
		
		int numberOfPersonsModified = 0;
		if(!personsModified.isEmpty()) {
			numberOfPersonsModified = personsModified.size();
		}
		System.out.println("numberOfPersonsModified="+numberOfPersonsModified);
		System.out.println("numberOfPersons="+numberOfPersons);
		
		Person lastPersonFromBD = personsModified.get(personsModified.size()-1);
		
		System.out.println("personToAdd="+personToAdd);
		System.out.println("lastPersonFromBD="+lastPersonFromBD);
		
		
		assertEquals(numberOfPersonsModified,numberOfPersons+1);
		
		assertEquals(personToAdd.getIdPersonal(),lastPersonFromBD.getIdPersonal());
		assertEquals(personToAdd.getFirstName(),lastPersonFromBD.getFirstName());
		assertEquals(personToAdd.getLastName(),lastPersonFromBD.getLastName());
		assertEquals(personToAdd.getProfession(),lastPersonFromBD.getProfession());
		
		
	}

//	@Test
//	Flight getFlightById(int idFlight);
//
//	@Test
//	Flight getFlightByName(String name);
//
//	@Test
//	Flight getFlightByFrom(String from);
//
//	@Test
//	Flight getFlightByTo(String to);
//
//	@Test
//	Flight getFlightByDate(String date);
//
//	@Test
//	List<Flight> getFlightByFromByToByDate(String from, String to, String date);
//
//	@Test
//	List<Flight> getAllFlights();
//
//	@Test
//	List<Flight> getFreeFlightByOrderStatus(String orderStatus);
//
//	@Test
//	Flight updateFlight(int idFlight, Flight newFlight);
//
//	@Test
//	boolean deleteFlightById(int idFlight);

}
