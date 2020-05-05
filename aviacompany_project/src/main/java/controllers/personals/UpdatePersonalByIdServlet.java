package main.java.controllers.personals;

import main.java.model.Personal;
import main.java.service.PersonalService;
import main.java.service.PersonalServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/update-personal-by-id" })
public class UpdatePersonalByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idPersonal = Integer.parseInt(request.getParameter("id"));
		PersonalService personalService = new PersonalServiceImpl();
		Personal personal =personalService.getPersonalById(idPersonal);

		request.setAttribute("personalToUpdate", personal);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/personals/updatePersonal.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int idPersonal = Integer.parseInt(request.getParameter("id"));
		int idPilot1 = Integer.parseInt(request.getParameter("idPilot1"));
		int idPilot2 = Integer.parseInt(request.getParameter("idPilot2"));
		int idShturman = Integer.parseInt(request.getParameter("idShturman"));
		int idRadist = Integer.parseInt(request.getParameter("idRadist"));
		int idSt1 = Integer.parseInt(request.getParameter("idSt1"));
		int idSt2 = Integer.parseInt(request.getParameter("idSt2"));
		int idSt3 = Integer.parseInt(request.getParameter("idSt3"));
		int idOrder = Integer.parseInt(request.getParameter("idOrder"));

		Personal updatedPersonal = new Personal(idPersonal, idPilot1, idPilot2, idShturman, idRadist, idSt1, idSt2, idSt3, idOrder);
		PersonalService personalService = new PersonalServiceImpl();

		personalService.updatePersonal(idPersonal, updatedPersonal);

		response.sendRedirect("/aviacompany_project/personals");
	}
}
