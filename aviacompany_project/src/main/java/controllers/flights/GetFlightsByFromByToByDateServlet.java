package main.java.controllers.flights;

import main.java.model.Flight;
import main.java.service.FlightService;
import main.java.service.FlightServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/flight-by-from-to-date"})
public class GetFlightsByFromByToByDateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/flights/selectFlight.jsp");
        requestDispatcher.forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        FlightService flightService = new FlightServiceImpl();

        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("date");

        List<Flight> flights = flightService.getFlightByFromByToByDate(from, to, date);
        request.setAttribute("allFlights", flights);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/flights/allFlights.jsp");
        requestDispatcher.forward(request, response);
    }
}
