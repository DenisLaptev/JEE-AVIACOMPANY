package main.java.controllers.persons;

import main.java.model.Person;
import main.java.service.PersonService;
import main.java.service.PersonServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/add-person"})
public class AddPersonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/persons/addPerson.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idPerson = -1;
		int idPersonal = Integer.parseInt(request.getParameter("idPersonal"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String profession = request.getParameter("profession");

		Person person = new Person(idPerson, idPersonal, firstName, lastName, profession);

		PersonService personService = new PersonServiceImpl();
		personService.addPerson(person);

		request.setAttribute("lastName", lastName);
		doGet(request, response);
	}
}
