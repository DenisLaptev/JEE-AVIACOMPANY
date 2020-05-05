package main.java.controllers.orders;

import main.java.model.Order;
import main.java.model.Personal;
import main.java.service.OrderService;
import main.java.service.OrderServiceImpl;
import main.java.service.PersonalService;
import main.java.service.PersonalServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/add-order"})
public class AddOrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		 OrderService orderService = new OrderServiceImpl();
		 Order orderForCreation = new Order(-1, -1, -1,"free");
		 orderService.addOrder(orderForCreation);

		List<Order> ordersList = orderService.getAllOrders();
		int idOrder = ordersList.get(ordersList.size() - 1).getIdOrder();
		request.setAttribute("idOrder", idOrder);


		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orders/addOrder.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idOrder = -1;
		int idFlight = Integer.parseInt(request.getParameter("idFlight"));
		int idPersonal = Integer.parseInt(request.getParameter("idPersonal"));
		String status = "free";

		Order order = new Order(idOrder, idFlight, idPersonal, status);

		OrderService orderService = new OrderServiceImpl();
		orderService.addOrder(order);

		request.setAttribute("idFlight", idFlight);
		request.setAttribute("idPersonal", idPersonal);
		doGet(request, response);
	}


}
