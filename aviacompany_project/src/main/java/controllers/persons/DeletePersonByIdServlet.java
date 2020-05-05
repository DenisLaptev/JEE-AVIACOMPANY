package main.java.controllers.persons;

import main.java.service.PersonService;
import main.java.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/delete-person-by-id"})
public class DeletePersonByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		doDelete(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idPerson = Integer.parseInt(request.getParameter("id"));

		PersonService personService = new PersonServiceImpl();
		personService.deletePersonById(idPerson);

		response.sendRedirect("/aviacompany_project/persons");
	}
}
