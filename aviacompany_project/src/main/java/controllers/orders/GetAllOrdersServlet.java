package main.java.controllers.orders;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.model.Order;
import main.java.service.OrderService;
import main.java.service.OrderServiceImpl;

@WebServlet(urlPatterns = {"/orders"})
public class GetAllOrdersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		OrderService orderService = new OrderServiceImpl();

		List<Order> allOrders = orderService.getAllOrders();
		request.setAttribute("allOrders", allOrders);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orders/allOrders.jsp");
		requestDispatcher.forward(request, response);
	}
}
