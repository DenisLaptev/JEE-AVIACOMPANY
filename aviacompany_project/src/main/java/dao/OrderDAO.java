package main.java.dao;

import main.java.model.Order;

import java.util.List;

public interface OrderDAO {

    //Create
    boolean addOrder(Order order);

    //Read
    Order getOrderById(int idOrder);
    List<Order> getAllOrders();

    //Update
    Order updateOrder(int idOrder, Order newOrder);

    //Delete
    boolean deleteOrderById(int idOrder);
}