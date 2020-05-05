package main.java.service;

import main.java.dao.FlightDAO;
import main.java.dao.FlightDAOImpl;
import main.java.model.Flight;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FlightServiceImpl implements FlightService {

	@Override
	public List<Flight> getAllFlights() {
		FlightDAO flightDAO = new FlightDAOImpl();
		List<Flight> allFlightsList = new ArrayList<>();
		allFlightsList = flightDAO.getAllFlights();
		return allFlightsList;
	}

	@Override
	public List<Flight> getFlightByFromByToByDate(String from, String to, String date) {
		FlightDAO flightDAO = new FlightDAOImpl();
		List<Flight> flightsList = new ArrayList<>();
		flightsList = flightDAO.getFlightByFromByToByDate(from, to, date);
		return flightsList;
	}

	@Override
	public List<Flight> getFreeFlightByOrderStatus(String orderStatus) {

		FlightDAO flightDAO = new FlightDAOImpl();
		List<Flight> flightList = new ArrayList<>();
		flightList = flightDAO.getFreeFlightByOrderStatus(orderStatus);
		return flightList;
	}

	@Override
	public List<Flight> sortByIdFlight(List<Flight> flightsList) {

		Collections.sort(flightsList, new Comparator<Flight>() {
			@Override
			public int compare(Flight flight1, Flight flight2) {
				int idFlight1 = flight1.getIdFlight();
				int idFlight2 = flight2.getIdFlight();
				return idFlight1 - idFlight2;
			}
		});
		System.out.println(flightsList);
		return flightsList;
	}

	@Override
	public List<Flight> sortByName(List<Flight> flightsList) {

		Collections.sort(flightsList, new Comparator<Flight>() {
			@Override
			public int compare(Flight flight1, Flight flight2) {
				String name1 = flight1.getName();
				String name2 = flight2.getName();

				return name1.compareTo(name2);
			}
		});
		return flightsList;
	}

	@Override
	public Flight getFlightById(int idFlight) {
		FlightDAO flightDAO = new FlightDAOImpl();
		Flight flight = flightDAO.getFlightById(idFlight);
		return flight;
	}

	@Override
	public Flight updateFlight(int idFlight, Flight newFlight) {
		FlightDAO flightDAO = new FlightDAOImpl();
		Flight updatedFlight = flightDAO.updateFlight(idFlight, newFlight);

		System.out.println("updatedFlight=" + updatedFlight);
		return updatedFlight;
	}

	@Override
	public boolean deleteFlightById(int idFlight) {
		FlightDAO flightDAO = new FlightDAOImpl();
		boolean result = flightDAO.deleteFlightById(idFlight);

		System.out.println("deleteFlightById=" + result);
		return result;
	}

	@Override
	public boolean addFlight(Flight flight) {
		FlightDAO flightDAO = new FlightDAOImpl();
		boolean result = flightDAO.addFlight(flight);
		return result;
	}
}
