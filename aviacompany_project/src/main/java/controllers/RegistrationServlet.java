package main.java.controllers;

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
import java.util.List;

@WebServlet(urlPatterns = { "/registration" })
public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/registration.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("111111111111111111111111111111111"+request.getSession().getAttribute("currentLocale"));
		System.out.println("222222222222222222222222222222222"+request.getSession().getAttribute("param.locale"));
		int idUser = -1;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String role = "user";
		
		UserService userService = new UserServiceImpl();
		
		boolean isUnique = true;
		
		List<User> allUsers = userService.getAllUsers();
		for(User user:allUsers) {
			if(user.getLogin().equals(login)) {
				isUnique = false;
				break;
			}
		}
		

		boolean isEmptyRow = (firstName.length() == 0) || (lastName.length() == 0) || (login.length() == 0)
				|| (password.length() == 0);

		if (!isEmptyRow && isUnique==true) {
			User user = new User(idUser, firstName, lastName, login, password, role);
			userService.addUser(user);
			request.setAttribute("lastName", lastName);
		}
		
		request.setAttribute("isUnique", isUnique);
		doGet(request, response);
	}

	
}
