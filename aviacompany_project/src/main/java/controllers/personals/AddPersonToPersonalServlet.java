package main.java.controllers.personals;

import main.java.model.Person;
import main.java.model.Personal;
import main.java.service.PersonService;
import main.java.service.PersonServiceImpl;
import main.java.service.PersonalService;
import main.java.service.PersonalServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/add-to-personal"})
public class AddPersonToPersonalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PersonalService personalService = new PersonalServiceImpl();
        PersonService personService = new PersonServiceImpl();

        int personId = Integer.parseInt(request.getParameter("id"));
        String profession = request.getParameter("profession");
        int idPersonal = Integer.parseInt(request.getParameter("idPersonal"));

        Personal personalForUpdate = personalService.getPersonalById(idPersonal);
        Person personForUpdate = personService.getPersonById(personId);
        personForUpdate.setIdPersonal(idPersonal);




        switch(profession){
            case "Pilot1":
            {
               request.setAttribute("idPilot1",personId);
                personalForUpdate.setIdPilot1(personId);
            }
            break;
            case "Pilot2":
            {
                request.setAttribute("idPilot2",personId);
                personalForUpdate.setIdPilot2(personId);
            }
            break;
            case "Shturman":
            {
                request.setAttribute("idShturman",personId);
                personalForUpdate.setIdShturman(personId);
            }
            break;
            case "Radist":
            {
                request.setAttribute("idRadist",personId);
                personalForUpdate.setIdRadist(personId);
            }
            break;
            case "Stuardes1":
            {
                request.setAttribute("idSt1",personId);
                personalForUpdate.setIdSt1(personId);
            }
            break;
            case "Stuardes2":
            {
                request.setAttribute("idSt2",personId);
                personalForUpdate.setIdSt2(personId);
            }
            break;
            case "Stuardes3":
            {
                request.setAttribute("idSt3",personId);
                personalForUpdate.setIdSt3(personId);
            }
            break;

        }


        personalService.updatePersonal(idPersonal, personalForUpdate);
        personService.updatePerson(personId,personForUpdate);

        int idPilot1 = personalForUpdate.getIdPilot1();
        int idPilot2 = personalForUpdate.getIdPilot2();
        int idShturman = personalForUpdate.getIdShturman();
        int idRadist = personalForUpdate.getIdRadist();
        int idSt1 = personalForUpdate.getIdSt1();
        int idSt2 = personalForUpdate.getIdSt2();
        int idSt3 = personalForUpdate.getIdSt3();
        int idOrder = personalForUpdate.getIdOrder();

        request.setAttribute("idPersonal",idPersonal);
        request.setAttribute("idPilot1",idPilot1);
        request.setAttribute("idPilot2",idPilot2);
        request.setAttribute("idShturman",idShturman);
        request.setAttribute("idRadist",idRadist);
        request.setAttribute("idSt1",idSt1);
        request.setAttribute("idSt2",idSt2);
        request.setAttribute("idSt3",idSt3);
        request.setAttribute("idOrder",idOrder);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/personals/addPersonal.jsp");
        requestDispatcher.forward(request, response);

        //response.sendRedirect("/add-personal");
    }
}
