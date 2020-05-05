package main.java.controllers.orders;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Order;
import main.java.service.OrderService;
import main.java.service.OrderServiceImpl;

@WebServlet(urlPatterns = {"/order-by-id"})
public class GetOrderByIdServlet extends HttpServlet  {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		OrderService orderService = new OrderServiceImpl();

		int idOrder = Integer.parseInt(request.getParameter("id"));
		Order order = orderService.getOrderById(idOrder);
		request.setAttribute("order", order);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orders/showOrder.jsp");
		requestDispatcher.forward(request, response);
	}
}
