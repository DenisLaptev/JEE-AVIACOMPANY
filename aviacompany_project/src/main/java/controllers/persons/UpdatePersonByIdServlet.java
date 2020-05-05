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

@WebServlet(urlPatterns = {"/update-person-by-id"})
public class UpdatePersonByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int idPerson = Integer.parseInt(request.getParameter("id"));
        PersonService personService = new PersonServiceImpl();
        Person person = personService.getPersonById(idPerson);

        request.setAttribute("personToUpdate",person);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/persons/updatePerson.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int idPerson = Integer.parseInt(request.getParameter("id"));
        int idPersonal = Integer.parseInt(request.getParameter("idPersonal"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String profession = request.getParameter("profession");

        Person updatedPerson = new Person(idPerson, idPersonal, firstName, lastName, profession);
        PersonService personService = new PersonServiceImpl();

        personService.updatePerson(idPerson, updatedPerson);

        response.sendRedirect("/aviacompany_project/persons");
    }
}
