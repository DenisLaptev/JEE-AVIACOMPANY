package main.java.service;

import main.java.model.Order;

import java.util.List;

public interface OrderService {

	//Create
	boolean addOrder(Order order);

	//Read
	List<Order> getAllOrders();
	Order getOrderById(int idOrder);

	//Update
	Order updateOrder(int idOrder, Order newOrder);

	//Delete
	boolean deleteOrderById(int idOrder);
}
