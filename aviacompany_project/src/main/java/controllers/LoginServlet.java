package main.java.controllers;

import main.java.model.User;
import main.java.service.UserService;
import main.java.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");

        UserService userService = new UserServiceImpl();
        User registeredUser = userService.isRegistered(userLogin, userPassword);

        HttpSession session = request.getSession();
        session.setAttribute("registeredUser", registeredUser);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/loginResult.jsp");
        requestDispatcher.forward(request, response);

    }
}
