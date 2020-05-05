package main.java.controllers.persons;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Person;
import main.java.service.PersonService;
import main.java.service.PersonServiceImpl;

@WebServlet(urlPatterns = {"/persons"})
public class GetAllPersonsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PersonService personService = new PersonServiceImpl();

		List<Person> allPersons = personService.getAllPersons();
		request.setAttribute("allPersons", allPersons);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/persons/allPersons.jsp");
		requestDispatcher.forward(request, response);
	}
}
