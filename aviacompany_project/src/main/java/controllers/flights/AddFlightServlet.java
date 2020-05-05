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

@WebServlet(urlPatterns = { "/add-flight" })
public class AddFlightServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/flights/addFlight.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idFlight = -1;
		String name = request.getParameter("name");
		String flightFrom = request.getParameter("from");
		String flightTo = request.getParameter("to");
		String date = request.getParameter("date");
		String orderStatus = "free";
		int idOrder = -1;

		boolean isEmptyRow = (name.length() == 0) || (flightFrom.length() == 0) || (flightTo.length() == 0)
				|| (date.length() == 0);

		if (!isEmptyRow) {
			Flight flight = new Flight(idFlight, name, flightFrom, flightTo, date);
			FlightService flightService = new FlightServiceImpl();
			flightService.addFlight(flight);
			request.setAttribute("flightName", name);
		}
		doGet(request, response);
	}
}
