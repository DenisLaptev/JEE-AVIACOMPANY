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
import java.util.List;

@WebServlet(urlPatterns = {"/add-personal"})
public class AddPersonalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        PersonalService personalService = new PersonalServiceImpl();
        Personal personalForCreation = new Personal(-1, -1, -1, -1, -1, -1, -1, -1);
        personalService.addPersonal(personalForCreation);

        List<Personal> personalsList = personalService.getAllPersonals();
        int idPersonal = personalsList.get(personalsList.size() - 1).getIdPersonal();
        request.setAttribute("idPersonal", idPersonal);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/personals/addPersonal.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int idPersonal = Integer.parseInt(request.getParameter("idPersonal"));
        int idPilot1 = Integer.parseInt(request.getParameter("idPilot1"));
        int idPilot2 = Integer.parseInt(request.getParameter("idPilot2"));
        int idShturman = Integer.parseInt(request.getParameter("idShturman"));
        int idRadist = Integer.parseInt(request.getParameter("idRadist"));
        int idSt1 = Integer.parseInt(request.getParameter("idSt1"));
        int idSt2 = Integer.parseInt(request.getParameter("idSt2"));
        int idSt3 = Integer.parseInt(request.getParameter("idSt3"));
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        Personal newPersonal = new Personal(idPersonal, idPilot1, idPilot2, idShturman, idRadist, idSt1, idSt2, idSt3, idOrder);
        PersonalService personalService = new PersonalServiceImpl();
        personalService.updatePersonal(idPersonal, newPersonal);

        request.setAttribute("isAdded", true);
        //doGet(request, response);

        response.sendRedirect("/aviacompany_project/personals");

    }
}
