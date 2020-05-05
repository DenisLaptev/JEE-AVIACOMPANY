package main.java.dao;

import main.java.model.Flight;

import java.util.List;

//CRUD
public interface FlightDAO {

    //Create
    boolean addFlight(Flight flight);

    //Read
    Flight getFlightById(int idFlight);
    Flight getFlightByName(String name);
    Flight getFlightByFrom(String from);
    Flight getFlightByTo(String to);
    Flight getFlightByDate(String date);
    List<Flight> getFlightByFromByToByDate(String from,String to,String date);
    List<Flight> getAllFlights();
	List<Flight> getFreeFlightByOrderStatus(String orderStatus);
    //Update
    Flight updateFlight(int idFlight, Flight newFlight);

    //Delete
    boolean deleteFlightById(int idFlight);

}
