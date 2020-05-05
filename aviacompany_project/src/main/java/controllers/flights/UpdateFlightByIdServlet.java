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

@WebServlet(urlPatterns = { "/update-flight-by-id" })
public class UpdateFlightByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idFlight = Integer.parseInt(request.getParameter("id"));

		FlightService flightService = new FlightServiceImpl();
		Flight flight = flightService.getFlightById(idFlight);
		request.setAttribute("flightToUpdate", flight);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/flights/updateFlight.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idFlight = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String flightFrom = request.getParameter("from");
		String flightTo = request.getParameter("to");
		String date = request.getParameter("date");
		String orderStatus = request.getParameter("orderStatus");
		int idOrder = Integer.parseInt(request.getParameter("idOrder"));

		Flight updatedFlight = new Flight(idFlight, name, flightFrom, flightTo, date, orderStatus, idOrder);
		FlightService flightService = new FlightServiceImpl();
		flightService.updateFlight(idFlight, updatedFlight);
		// request.setAttribute("flightName", name);

		response.sendRedirect("/aviacompany_project/flights");
	}
}
