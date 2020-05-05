package main.java.controllers.users;

import main.java.model.Flight;
import main.java.model.Order;
import main.java.model.User;
import main.java.service.FlightService;
import main.java.service.FlightServiceImpl;
import main.java.service.OrderService;
import main.java.service.OrderServiceImpl;
import main.java.service.UserService;
import main.java.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/add-user" })
public class AddUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/users/addUser.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idUser = -1;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		boolean isEmptyRow = (firstName.length() == 0) && (lastName.length() == 0) && (login.length() == 0)
				&& (password.length() == 0);

		if (!isEmptyRow) {

			User user = new User(idUser, firstName, lastName, login, password, role);
			UserService userService = new UserServiceImpl();
			userService.addUser(user);
			request.setAttribute("lastName", lastName);
		}
		
		doGet(request, response);

	}
}
