package test.java.test_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.dao.PersonalDAO;
import main.java.dao.PersonalDAOImpl;
import main.java.model.Personal;

class TestPersonalDAO {


	PersonalDAO personalDao = new PersonalDAOImpl();

	private static final int ID_PERSONAL_FOR_TEST = -2;
	private static final int ID_PILOT1_FOR_TEST = -2;
	private static final int ID_PILOT2_FOR_TEST = -2;
	private static final int ID_SHTURMAN_FOR_TEST = -2;
	private static final int ID_RADIST_FOR_TEST = -2;
	private static final int ID_ST1_FOR_TEST = -2;
	private static final int ID_ST2_FOR_TEST = -2;
	private static final int ID_ST3_FOR_TEST = -2;
	private static final int ID_ORDER_FOR_TEST = -2;
	@Test
	void addPersonalTest() {
		
		List<Personal>personals = new ArrayList<>();
		personals = personalDao.getAllPersonals();
		
		System.out.println("personals="+personals);
		
		int numberOfPersonals = 0;
		if(!personals.isEmpty()) {
			numberOfPersonals = personals.size();
		}
		
		Personal personalToAdd = new Personal(ID_PERSONAL_FOR_TEST, ID_PILOT1_FOR_TEST, ID_PILOT2_FOR_TEST, ID_SHTURMAN_FOR_TEST,
				ID_RADIST_FOR_TEST, ID_ST1_FOR_TEST, ID_ST2_FOR_TEST, ID_ST3_FOR_TEST, ID_ORDER_FOR_TEST);
		personalDao.addPersonal(personalToAdd);
		
		System.out.println("personalToAdd="+personalToAdd);
		
		List<Personal>personalsModified = new ArrayList<>();
		personalsModified = personalDao.getAllPersonals();
		
		System.out.println("personalsModified="+personalsModified);
		
		int numberOfPersonalsModified = 0;
		if(!personalsModified.isEmpty()) {
			numberOfPersonalsModified = personalsModified.size();
		}
		System.out.println("numberOfPersonalsModified="+numberOfPersonalsModified);
		System.out.println("numberOfPersonals="+numberOfPersonals);
		
		Personal lastPersonalFromBD = personalsModified.get(personalsModified.size()-1);
		
		System.out.println("personalToAdd="+personalToAdd);
		System.out.println("lastPersonalFromBD="+lastPersonalFromBD);
		
		
		assertEquals(numberOfPersonalsModified,numberOfPersonals+1);
		
		assertEquals(personalToAdd.getIdPilot1(),lastPersonalFromBD.getIdPilot1());
		assertEquals(personalToAdd.getIdPilot2(),lastPersonalFromBD.getIdPilot2());
		assertEquals(personalToAdd.getIdShturman(),lastPersonalFromBD.getIdShturman());
		assertEquals(personalToAdd.getIdRadist(),lastPersonalFromBD.getIdRadist());
		assertEquals(personalToAdd.getIdSt1(),lastPersonalFromBD.getIdSt1());
		assertEquals(personalToAdd.getIdSt2(),lastPersonalFromBD.getIdSt2());
		assertEquals(personalToAdd.getIdSt3(),lastPersonalFromBD.getIdSt3());
		
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
