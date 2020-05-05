package main.java.service;

import main.java.dao.OrderDAO;
import main.java.dao.OrderDAOImpl;
import main.java.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getAllOrders() {
		OrderDAO orderDAO = new OrderDAOImpl();
		List<Order> allOrdersList = new ArrayList<>();
		allOrdersList = orderDAO.getAllOrders();
		return allOrdersList;

	}

	@Override
	public Order getOrderById(int idOrder) {
		OrderDAO orderDAO = new OrderDAOImpl();
		Order order = orderDAO.getOrderById(idOrder);
		return order;
	}

	@Override
	public Order updateOrder(int idOrder, Order newOrder) {
		OrderDAO orderDAO = new OrderDAOImpl();
		Order updatedOrder = orderDAO.updateOrder(idOrder, newOrder);

		System.out.println("updatedOrder=" + updatedOrder);
		return updatedOrder;
	}

	@Override
	public boolean deleteOrderById(int idOrder) {
		OrderDAO orderDAO = new OrderDAOImpl();
		boolean result = orderDAO.deleteOrderById(idOrder);

		System.out.println("deleteOrderById=" + result);
		return result;
	}

	@Override
	public boolean addOrder(Order order) {
		OrderDAO orderDAO = new OrderDAOImpl();
		boolean result = orderDAO.addOrder(order);
		return result;
	}
}
