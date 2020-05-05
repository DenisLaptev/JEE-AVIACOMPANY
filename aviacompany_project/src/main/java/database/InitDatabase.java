package main.java.database;

import main.java.dao.*;
import main.java.model.Flight;
import main.java.model.Person;
import main.java.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitDatabase {

	public static final int NUMBER_OF_ROWS = 100;

	// -----------------------------flights
	public static final String[] FLIGHT_NAMES = new String[] { "AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH",
			"III", "JJJ" };

	public static final String[] FLIGHT_FROM = new String[] { "Kiev", "Kharkiv", "Los Angeles", "New York", "Paris",
			"London", "Lviv", "Prague", "Madrid", "Tokio" };

	public static final String[] FLIGHT_TO = new String[] { "Vinniza", "Berlin", "Rome", "Monaco", "Liverpool", "Milan",
			"Toronto", "Sidney", "Voronezh", "Wroclaw" };

	public static final String[] FLIGHT_DATES = new String[] { "1-03-2020", "2-03-2020", "3-03-2020", "4-03-2020",
			"5-03-2020", "6-03-2020", "7-03-2020", "8-03-2020", "9-03-2020", "10-03-2020" };

	// ---------------------------------persons
	public static final String[] PERSON_FIRST_NAMES = new String[] { "Alexey", "Boris", "Chen", "Dima", "Evgen", "Foma",
			"Gena", "Henry", "Ihor", "Jim" };

	public static final String[] PERSON_LAST_NAMES = new String[] { "Ivanov", "Petrov", "Chen", "Dmitriev", "Smith",
			"Fomin", "Green", "Hibs", "Sidorov", "James" };

	public static final String[] PERSON_PROFESSIONS = { "Pilot", "Shturman", "Radist", "Stuardes" };

	// ---------------------------------users
	public static final String[] USER_FIRST_NAMES = new String[] { "Alexey", "Boris", "Chen", "Dima", "Evgen", "Foma",
			"Gena", "Henry", "Ihor", "Jim" };

	public static final String[] USER_LAST_NAMES = new String[] { "Ivanov", "Petrov", "Chen", "Dmitriev", "Smith",
			"Fomin", "Green", "Hibs", "Sidorov", "James" };

	public static final String[] USER_LOGINS = generateLoginsArray(NUMBER_OF_ROWS);

	public static final String[] USER_PASSWORDS = generatePasswordsArray(NUMBER_OF_ROWS);

	public static final String[] USER_ROLES = new String[] { "user", "dispatcher", "admin" };

	public static String[] generateLoginsArray(int numberOfElements) {
		String[] loginsArray = new String[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			loginsArray[i] = "login" + i;
		}
		return loginsArray;
	}

	public static String[] generatePasswordsArray(int numberOfElements) {
		String[] passwordsArray = new String[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			passwordsArray[i] = "password" + i;
		}
		return passwordsArray;
	}

	public static List<Flight> generateFlightsList() {
		Random random = new Random();
		List<Flight> flightList = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			int idFlight = i + 1;
			String name = FLIGHT_NAMES[random.nextInt(10)];
			String flightFrom = FLIGHT_FROM[random.nextInt(10)];
			String flightTo = FLIGHT_TO[random.nextInt(10)];
			String date = FLIGHT_DATES[random.nextInt(10)];

			Flight flight = new Flight(idFlight, name, flightFrom, flightTo, date, "free", -1);
			flightList.add(flight);
		}
		return flightList;
	}

	public static List<Person> generatePersonsList() {
		Random random = new Random();
		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			int idPerson = i + 1;
			int idPersonal = -1;
			String firstName = PERSON_FIRST_NAMES[random.nextInt(10)];
			String lastName = PERSON_LAST_NAMES[random.nextInt(10)];
			String profession = PERSON_PROFESSIONS[random.nextInt(4)];

			Person person = new Person(idPerson, idPersonal, firstName, lastName, profession);
			personList.add(person);
		}
		return personList;
	}

	public static List<User> generateUsersList() {
		Random random = new Random();
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			int idUser = i + 1;
			String firstName = USER_FIRST_NAMES[random.nextInt(10)];
			String lastName = USER_LAST_NAMES[random.nextInt(10)];
			String login = USER_LOGINS[i];
			String password = USER_PASSWORDS[i];
			String role = USER_ROLES[random.nextInt(3)];

			User user = new User(idUser, firstName, lastName, login, password, role);
			userList.add(user);
		}
		return userList;
	}

	public static void addFlightsListToDB(List<Flight> flightList) {
		FlightDAO flightDAO = new FlightDAOImpl();
		for (Flight flight : flightList) {
			flightDAO.addFlight(flight);
		}
	}

	public static void addPersonsListToDB(List<Person> personList) {
		PersonDAO personDAO = new PersonDAOImpl();
		for (Person person : personList) {
			personDAO.addPerson(person);
		}
	}

	public static void addUsersListToDB(List<User> userList) {
		UserDAO userDAO = new UserDAOImpl();
		for (User user : userList) {
			userDAO.addUser(user);
		}
	}

	public static void main(String[] args) {
		List<Flight> flightList = generateFlightsList();
		addFlightsListToDB(flightList);

		List<Person> personList = generatePersonsList();
		addPersonsListToDB(personList);

		List<User> userList = generateUsersList();
		addUsersListToDB(userList);
	}
}
