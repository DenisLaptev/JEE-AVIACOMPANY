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

@WebServlet(urlPatterns = {"/add-personal-to-order"})
public class AddPersonalToOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	PersonalService personalService = new PersonalServiceImpl();
		OrderService orderService = new OrderServiceImpl();

		int idPersonal = Integer.parseInt(request.getParameter("id"));
		int idOrder = Integer.parseInt(request.getParameter("idOrder"));

		Order orderForUpdate = orderService.getOrderById(idOrder);
		Personal personalForUpdate = personalService.getPersonalById(idPersonal);

		personalForUpdate.setIdOrder(idOrder);
		orderForUpdate.setIdPersonal(idPersonal);

		request.setAttribute("idPersonal", idPersonal);
		request.setAttribute("idOrder", idOrder);

		personalService.updatePersonal(idPersonal, personalForUpdate);
		orderService.updateOrder(idOrder, orderForUpdate);
		
		

        int idFlight = orderForUpdate.getIdFlight();
        request.setAttribute("idFlight",idFlight);
        
			

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orders/addOrder.jsp");
		requestDispatcher.forward(request, response);

    }
}
