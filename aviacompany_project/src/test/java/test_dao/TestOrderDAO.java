package test.java.test_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.dao.OrderDAO;
import main.java.dao.OrderDAOImpl;
import main.java.model.Order;

class TestOrderDAO {


	OrderDAO orderDao = new OrderDAOImpl();
  
	private static final int ID_ORDER_FOR_TEST = -2;
	    private static final int ID_FLIGHT_FOR_TEST = -2;
	    private static final int ID_PERSONAL_FOR_TEST = -2;
	    private static final String STATUS_FOR_TEST = "TestStatus";
	@Test
	void addOrderTest() {
		
		List<Order>orders = new ArrayList<>();
		orders = orderDao.getAllOrders();
		
		System.out.println("orders="+orders);
		
		int numberOfOrders = 0;
		if(!orders.isEmpty()) {
			numberOfOrders = orders.size();
		}
		
		Order orderToAdd = new Order(ID_ORDER_FOR_TEST, ID_FLIGHT_FOR_TEST, ID_PERSONAL_FOR_TEST, STATUS_FOR_TEST);
		orderDao.addOrder(orderToAdd);
		
		System.out.println("orderToAdd="+orderToAdd);
		
		List<Order>ordersModified = new ArrayList<>();
		ordersModified = orderDao.getAllOrders();
		
		System.out.println("ordersModified="+ordersModified);
		
		int numberOfOrdersModified = 0;
		if(!ordersModified.isEmpty()) {
			numberOfOrdersModified = ordersModified.size();
		}
		System.out.println("numberOfOrdersModified="+numberOfOrdersModified);
		System.out.println("numberOfOrders="+numberOfOrders);
		
		Order lastOrderFromBD = ordersModified.get(ordersModified.size()-1);
		
		System.out.println("orderToAdd="+orderToAdd);
		System.out.println("lastOrderFromBD="+lastOrderFromBD);
		
		
		assertEquals(numberOfOrdersModified,numberOfOrders+1);
		//assertEquals(flightToAdd.getIdFlight(),lastFlightFromBD.getIdFlight());
		assertEquals(orderToAdd.getIdFlight(),lastOrderFromBD.getIdFlight());
		assertEquals(orderToAdd.getIdPersonal(),lastOrderFromBD.getIdPersonal());
		
	}

//	@Test
//	Flight getFlightById(int idFlight);
//
//	@Test
//	Flight getFlightByName(String name);
//
//	@Test
//	Flight getFlightByFrom(String from);
//
//	@Test
//	Flight getFlightByTo(String to);
//
//	@Test
//	Flight getFlightByDate(String date);
//
//	@Test
//	List<Flight> getFlightByFromByToByDate(String from, String to, String date);
//
//	@Test
//	List<Flight> getAllFlights();
//
//	@Test
//	List<Flight> getFreeFlightByOrderStatus(String orderStatus);
//
//	@Test
//	Flight updateFlight(int idFlight, Flight newFlight);
//
//	@Test
//	boolean deleteFlightById(int idFlight);

}
