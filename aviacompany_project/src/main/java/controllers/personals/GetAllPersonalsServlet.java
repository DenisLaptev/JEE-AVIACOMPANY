package main.java.controllers.personals;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.model.Personal;
import main.java.service.PersonalService;
import main.java.service.PersonalServiceImpl;


@WebServlet(urlPatterns = {"/personals"})
public class GetAllPersonalsServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PersonalService personalService = new PersonalServiceImpl();

		List<Personal> allPersonals = personalService.getAllPersonals();
		request.setAttribute("allPersonals", allPersonals);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/personals/allPersonals.jsp");
		requestDispatcher.forward(request, response);
	}
}
