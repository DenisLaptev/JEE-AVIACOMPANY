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
import java.util.List;

@WebServlet(urlPatterns = {"/free-person"})
public class GetFreePersonByProfessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String profession = request.getParameter("profession");
        int idPersonal = Integer.parseInt(request.getParameter("idPersonal"));
        PersonService personService = new PersonServiceImpl();

        List<Person> freePersons = personService.getAllPersonsByProfession(profession);
        //List<Person> freePersons = personService.getAllPersons();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>GetFreePersonByProfessionServlet");
        System.out.println("freePersons="+freePersons);
        request.setAttribute("freePersons", freePersons);
        request.setAttribute("profession", profession);
        request.setAttribute("idPersonal", idPersonal);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/persons/selectFreePerson.jsp");
        requestDispatcher.forward(request, response);
    }
}


