package main.java.service;

import main.java.model.Flight;

import java.util.List;

public interface FlightService {

	// Create
	boolean addFlight(Flight flight);

	// Read
	List<Flight> getAllFlights();

	List<Flight> getFlightByFromByToByDate(String from, String to, String date);

	Flight getFlightById(int idFlight);

	List<Flight> sortByIdFlight(List<Flight> unsortedFlightsList);

	List<Flight> sortByName(List<Flight> unsortedFlightsList);

	List<Flight> getFreeFlightByOrderStatus(String orderStatus);

	
	// Update
	Flight updateFlight(int idFlight, Flight newFlight);

	// Delete
	boolean deleteFlightById(int idFlight);


}
