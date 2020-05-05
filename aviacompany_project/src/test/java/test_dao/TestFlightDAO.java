package test.java.test_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.dao.FlightDAO;
import main.java.dao.FlightDAOImpl;
import main.java.model.Flight;

class TestFlightDAO {


	FlightDAO flightDao = new FlightDAOImpl();

	private static final int ID_FLIGHT_FOR_TEST = -2;
	private static final String NAME_FOR_TEST = "TestFlight";
	private static final String FLIGHT_FROM_FOR_TEST = "TestCityFrom";
	private static final String FLIGHT_TO_FOR_TEST = "TestCityTo";
	private static final String DATE_FOR_TEST = "1970";
	private static final String ORDER_STATUS_FOR_TEST = "TestOrder";
	private static final int ID_ORDER_FOR_TEST = -3;

	@Test
	void addFlightTest() {
		
		List<Flight>flights = new ArrayList<>();
		flights = flightDao.getAllFlights();
		
		System.out.println("flights="+flights);
		
		int numberOfFlights = 0;
		if(!flights.isEmpty()) {
			numberOfFlights = flights.size();
		}
		
		Flight flightToAdd = new Flight(ID_FLIGHT_FOR_TEST, NAME_FOR_TEST, FLIGHT_FROM_FOR_TEST, FLIGHT_TO_FOR_TEST,
				DATE_FOR_TEST, ORDER_STATUS_FOR_TEST, ID_ORDER_FOR_TEST);
		flightDao.addFlight(flightToAdd);
		
		System.out.println("flightToAdd="+flightToAdd);
		
		List<Flight>flightsModified = new ArrayList<>();
		flightsModified = flightDao.getAllFlights();
		
		System.out.println("flightsModified="+flightsModified);
		
		int numberOfFlightsModified = 0;
		if(!flightsModified.isEmpty()) {
			numberOfFlightsModified = flightsModified.size();
		}
		System.out.println("numberOfFlightsModified="+numberOfFlightsModified);
		System.out.println("numberOfFlights="+numberOfFlights);
		
		Flight lastFlightFromBD = flightsModified.get(flightsModified.size()-1);
		
		System.out.println("flightToAdd="+flightToAdd);
		System.out.println("lastFlightFromBD="+lastFlightFromBD);
		
		
		assertEquals(numberOfFlightsModified,numberOfFlights+1);
		
		assertEquals(flightToAdd.getName(),lastFlightFromBD.getName());
		assertEquals(flightToAdd.getFlightFrom(),lastFlightFromBD.getFlightFrom());
		assertEquals(flightToAdd.getFlightTo(),lastFlightFromBD.getFlightTo());
		assertEquals(flightToAdd.getDate(),lastFlightFromBD.getDate());
		
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
