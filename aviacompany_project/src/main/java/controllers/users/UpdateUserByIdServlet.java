package main.java.controllers.users;

import main.java.model.User;
import main.java.service.UserService;
import main.java.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/update-user-by-id" })
public class UpdateUserByIdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idUser = Integer.parseInt(request.getParameter("id"));
		UserService userService = new UserServiceImpl();
		User user = userService.getUserById(idUser);

		request.setAttribute("userToUpdate", user);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/users/updateUser.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idUser = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		User updatedUser = new User(idUser, firstName, lastName, login, password, role);
		UserService userService = new UserServiceImpl();

		userService.updateUser(idUser, updatedUser);

		response.sendRedirect("/aviacompany_project/users");
	}
}
