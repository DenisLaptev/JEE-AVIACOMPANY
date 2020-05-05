package main.java.controllers.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.User;
import main.java.service.UserService;
import main.java.service.UserServiceImpl;


@WebServlet(urlPatterns = {"/user-by-id"})
public class GetUserByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		UserService userService = new UserServiceImpl();

		int idUser = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(idUser);
		request.setAttribute("user", user);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/users/showUser.jsp");
		requestDispatcher.forward(request, response);
	}

}
