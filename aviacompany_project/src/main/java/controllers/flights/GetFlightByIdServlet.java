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

@WebServlet(urlPatterns = { "/flight-by-id" })
public class GetFlightByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		if (request.getParameter("id") == null) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/flights/selectFlightById.jsp");
			requestDispatcher.forward(request, response);

		} else {
			doPost(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		FlightService flightService = new FlightServiceImpl();

		int idFlight = Integer.parseInt(request.getParameter("id"));
		Flight flight = flightService.getFlightById(idFlight);
		request.setAttribute("flight", flight);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/flights/showFlight.jsp");
		requestDispatcher.forward(request, response);
	}

}
