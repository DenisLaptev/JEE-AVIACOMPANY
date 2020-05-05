package test.java.test_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.dao.UserDAO;
import main.java.dao.UserDAOImpl;
import main.java.model.User;

class TestUserDAO {


	UserDAO userDao = new UserDAOImpl();

	private static final int ID_USER_FOR_TEST = -2;
	private static final String ID_FIRST_NAME_FOR_TEST = "TestFirst";
	private static final String ID_LAST_NAME_FOR_TEST = "TestLast";
	private static final String ID_LOGIN_FOR_TEST = "TestLogin";
	private static final String ID_PASSWORD_FOR_TEST = "TestPassword";
	private static final String ID_ROLE_FOR_TEST = "TestRole";

	@Test
	void addUserTest() {
		
		List<User>users = new ArrayList<>();
		users = userDao.getAllUsers();
		
		System.out.println("users="+users);
		
		int numberOfUsers = 0;
		if(!users.isEmpty()) {
			numberOfUsers = users.size();
		}
		
		User userToAdd = new User(ID_USER_FOR_TEST, ID_FIRST_NAME_FOR_TEST, ID_LAST_NAME_FOR_TEST,
				ID_LOGIN_FOR_TEST, ID_PASSWORD_FOR_TEST, ID_ROLE_FOR_TEST );
		userDao.addUser(userToAdd);
		
		System.out.println("userToAdd="+userToAdd);
		
		List<User>usersModified = new ArrayList<>();
		usersModified = userDao.getAllUsers();
		
		System.out.println("usersModified="+usersModified);
		
		int numberOfUsersModified = 0;
		if(!usersModified.isEmpty()) {
			numberOfUsersModified = usersModified.size();
		}
		System.out.println("numberOfUsersModified="+numberOfUsersModified);
		System.out.println("numberOfUsers="+numberOfUsers);
		
		User lastUserFromBD = usersModified.get(usersModified.size()-1);
		
		System.out.println("userToAdd="+userToAdd);
		System.out.println("lastUSerFromBD="+lastUserFromBD);
		
		
		assertEquals(numberOfUsersModified,numberOfUsers+1);
		

		assertEquals(userToAdd.getFirstName(),lastUserFromBD.getFirstName());
		assertEquals(userToAdd.getLastName(),lastUserFromBD.getLastName());
		assertEquals(userToAdd.getLogin(),lastUserFromBD.getLogin());
		assertEquals(userToAdd.getPassword(),lastUserFromBD.getPassword());
		assertEquals(userToAdd.getRole(),lastUserFromBD.getRole());
		
		
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
