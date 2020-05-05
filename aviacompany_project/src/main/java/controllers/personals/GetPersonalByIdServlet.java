package main.java.controllers.personals;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.model.Personal;
import main.java.service.PersonalService;
import main.java.service.PersonalServiceImpl;

@WebServlet(urlPatterns = {"/personal-by-id"})
public class GetPersonalByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PersonalService personalService = new PersonalServiceImpl();

		int idPersonal = Integer.parseInt(request.getParameter("id"));
		Personal personal = personalService.getPersonalById(idPersonal);
		request.setAttribute("personal", personal);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/personals/showPersonal.jsp");
		requestDispatcher.forward(request, response);
	}
}
