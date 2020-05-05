package main.java.controllers.orders;

import main.java.service.FlightService;
import main.java.service.FlightServiceImpl;
import main.java.service.OrderService;
import main.java.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/delete-order-by-id"})
public class DeleteOrderByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int idOrder = Integer.parseInt(request.getParameter("id"));

        OrderService orderService = new OrderServiceImpl();
        orderService.deleteOrderById(idOrder);

        response.sendRedirect("/aviacompany_project/orders");
    }
}
