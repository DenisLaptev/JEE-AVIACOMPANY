package main.java.controllers.flights;

import main.java.service.FlightService;
import main.java.service.FlightServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/delete-flight-by-id"})
public class DeleteFlightByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int idFlight = Integer.parseInt(request.getParameter("id"));

        FlightService flightService = new FlightServiceImpl();
        flightService.deleteFlightById(idFlight);

        response.sendRedirect("/aviacompany_project/flights");
    }
}
