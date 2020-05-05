package main.java.controllers.orders;

import main.java.model.Order;
import main.java.service.OrderService;
import main.java.service.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/update-order-by-id" })
public class UpdateOrderByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idOrder = Integer.parseInt(request.getParameter("id"));
		OrderService orderService = new OrderServiceImpl();
		Order order = orderService.getOrderById(idOrder);

		request.setAttribute("orderToUpdate", order);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orders/updateOrder.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idOrder = Integer.parseInt(request.getParameter("id"));
		int idFlight = Integer.parseInt(request.getParameter("idFlight"));
		int idPersonal = Integer.parseInt(request.getParameter("idPersonal"));
		String status = request.getParameter("status");

		Order updatedOrder = new Order(idOrder, idFlight, idPersonal, status);
		OrderService orderService = new OrderServiceImpl();

		orderService.updateOrder(idOrder, updatedOrder);

		response.sendRedirect("/aviacompany_project/orders");
	}
}
