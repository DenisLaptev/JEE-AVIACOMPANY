package main.java.controllers.users;

import main.java.service.UserService;
import main.java.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/delete-user-by-id"})
public class DeleteUserByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int idUser = Integer.parseInt(request.getParameter("id"));

        UserService userService = new UserServiceImpl();
        userService.deleteUserById(idUser);

        response.sendRedirect("/aviacompany_project/users");
    }
}
