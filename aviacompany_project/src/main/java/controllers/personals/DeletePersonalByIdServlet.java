package main.java.controllers.personals;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.service.PersonalService;
import main.java.service.PersonalServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/delete-personal-by-id"})
public class DeletePersonalByIdServlet extends HttpServlet {

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

		int idPersonal = Integer.parseInt(request.getParameter("id"));

		PersonalService personalService = new PersonalServiceImpl();
		personalService.deletePersonalById(idPersonal);

		response.sendRedirect("/aviacompany_project/personals");
	}

}
