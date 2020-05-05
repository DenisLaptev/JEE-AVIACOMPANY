package main.java.application;

import main.java.dao.FlightDAO;
import main.java.dao.FlightDAOImpl;
import main.java.model.Flight;

public class Main {


    public static void main(String[] args) {
        FlightDAO flightDAO = new FlightDAOImpl();

        //addFlight
        Flight newFlight = new Flight();
        newFlight.setName("Flight22");
        newFlight.setFlightFrom("Paris");
        newFlight.setFlightTo("Kharkiv");
        newFlight.setDate("10-01-1999");
        flightDAO.addFlight(newFlight);

        //getFlightById
        Flight f1 = flightDAO.getFlightById(538);
        Flight f2 = flightDAO.getFlightById(539);
        Flight f3 = flightDAO.getFlightById(540);
        System.out.println("f1="+f1);
        System.out.println("f2="+f2);
        System.out.println("f3="+f3);

        System.out.println("-----------------------------------");

        //getFlightByName
        System.out.println(flightDAO.getFlightByName("Flight2000"));
        System.out.println(flightDAO.getFlightByName("wrong"));

        System.out.println("-----------------------------------");

        //getFlightByFrom
        System.out.println(flightDAO.getFlightByFrom("New York"));
        System.out.println(flightDAO.getFlightByFrom("Kharkov"));

        System.out.println("-----------------------------------");

        //getFlightByTo
        System.out.println(flightDAO.getFlightByTo("Bagdad"));
        System.out.println(flightDAO.getFlightByTo("Paris"));

        System.out.println("-----------------------------------");

        //getFlightByDate
        System.out.println(flightDAO.getFlightByDate("1-03-2020"));
        System.out.println(flightDAO.getFlightByDate("16-03-2020"));

        System.out.println("-----------------------------------");

        //getAllFlights
        System.out.println(flightDAO.getAllFlights());
        System.out.println("~~~~~~~~~~~~~~");
        flightDAO.updateFlight(10,new Flight(1,"UPDATE",null,null,null,null,-1));
        flightDAO.deleteFlightById(9);
        System.out.println(flightDAO.getAllFlights());
    }
}
