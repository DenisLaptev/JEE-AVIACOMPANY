package main.java.controllers.orders;

import main.java.model.Flight;
import main.java.model.Order;
import main.java.model.Person;
import main.java.model.Personal;
import main.java.service.FlightService;
import main.java.service.FlightServiceImpl;
import main.java.service.OrderService;
import main.java.service.OrderServiceImpl;
import main.java.service.PersonService;
import main.java.service.PersonServiceImpl;
import main.java.service.PersonalService;
import main.java.service.PersonalServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/add-flight-to-order" })
public class AddFlightToOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FlightService flightService = new FlightServiceImpl();
		OrderService orderService = new OrderServiceImpl();

		int idFlight = Integer.parseInt(request.getParameter("id"));
		String orderStatus = request.getParameter("orderStatus");
		int idOrder = Integer.parseInt(request.getParameter("idOrder"));

		Order orderForUpdate = orderService.getOrderById(idOrder);
		Flight flightForUpdate = flightService.getFlightById(idFlight);

		flightForUpdate.setOrderStatus("created");
		flightForUpdate.setIdOrder(idOrder);
		orderForUpdate.setIdFlight(idFlight);

		request.setAttribute("idFlight", idFlight);
		request.setAttribute("idOrder", idOrder);

		flightService.updateFlight(idFlight, flightForUpdate);
		orderService.updateOrder(idOrder, orderForUpdate);
		
		
		int idPersonal = orderForUpdate.getIdPersonal();
        request.setAttribute("idPersonal",idPersonal);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orders/addOrder.jsp");
		requestDispatcher.forward(request, response);

	}
}
