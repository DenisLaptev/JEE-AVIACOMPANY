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

@WebServlet(urlPatterns = {"/free-flight"})
public class GetFreeFlightServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderStatus = "free";
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        FlightService flightService = new FlightServiceImpl();

        List<Flight> freeFlights = flightService.getFreeFlightByOrderStatus(orderStatus);
     
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>getFreeFlightByOrderStatus");
        System.out.println("freeFlights="+freeFlights);
        request.setAttribute("freeFlights", freeFlights);
        request.setAttribute("orderStatus", orderStatus);
        request.setAttribute("idOrder", idOrder);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/flights/selectFreeFlight.jsp");
        requestDispatcher.forward(request, response);
    }
}


