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

@WebServlet(urlPatterns = {"/free-personal"})
public class GetFreePersonalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        PersonalService personalService = new PersonalServiceImpl();

        List<Personal> freePersonals = personalService.getFreePersonalByIdOrder(-1);
     
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>getFreePersonalByIdOrder");
        System.out.println("freePersonals="+freePersonals);
        request.setAttribute("freePersonals", freePersonals);
        request.setAttribute("idOrder", idOrder);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/personals/selectFreePersonal.jsp");
        requestDispatcher.forward(request, response);
    }
}


