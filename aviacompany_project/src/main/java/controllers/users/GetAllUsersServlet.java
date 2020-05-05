package main.java.controllers.users;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.model.User;
import main.java.service.UserService;
import main.java.service.UserServiceImpl;


@WebServlet(urlPatterns = {"/users"})
public class GetAllUsersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		UserService userService = new UserServiceImpl();

		List<User> allUsers = userService.getAllUsers();
		request.setAttribute("allUsers", allUsers);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/users/allUsers.jsp");
		requestDispatcher.forward(request, response);
	}
}
