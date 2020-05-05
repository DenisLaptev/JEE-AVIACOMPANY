package main.java.dao;

import main.java.database.DBHelper;
import main.java.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean addOrder(Order order) {
        boolean result = true;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            int idFlight = order.getIdFlight();
            int idPersonal = order.getIdPersonal();
            String status = order.getStatus();

            String query = "INSERT INTO aviacompany_db.orders(idFlight, idPersonal, status) VALUES (?,?,?)";

            ps = connection.prepareStatement(query);

            ps.setInt(1, idFlight);
            ps.setInt(2, idPersonal);
            ps.setString(3, status);

            // System.out.println(ps);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    @Override
    public Order getOrderById(int idOrder) {
        Order order = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM orders WHERE idOrder = ?";
            ps = connection.prepareStatement(query);

            ps.setString(1, String.valueOf(idOrder));

            rs = ps.executeQuery();

            while (rs.next()) {
                int idFlight = rs.getInt("idFlight");
                int idPersonal = rs.getInt("idPersonal");
                String status = rs.getString("status");

                order = new Order(idOrder, idFlight, idPersonal, status);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM orders";
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idOrder = rs.getInt("idOrder");
                int idFlight = rs.getInt("idFlight");
                int idPersonal = rs.getInt("idPersonal");
                String status = rs.getString("status");

                Order order = new Order(idOrder, idFlight, idPersonal, status);
                orders.add(order);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return orders;
    }

    @Override
    public Order updateOrder(int idOrder, Order newOrder) {

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            int newIdFlight = newOrder.getIdFlight();
            int newIdPersonal = newOrder.getIdPersonal();
            String newStatus = newOrder.getStatus();

            String query = "UPDATE orders SET idFlight = '" + newIdFlight + "', idPersonal = '" + newIdPersonal
                    + "', status = '" + newStatus + "' WHERE idOrder = ?";

            ps = connection.prepareStatement(query);

            ps.setInt(1, idOrder);

            // System.out.println(ps);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return newOrder;
    }

    @Override
    public boolean deleteOrderById(int idOrder) {
        boolean result = true;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM orders WHERE idOrder = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idOrder);

            // System.out.println(ps);
            ps.executeUpdate();

            // connection.close();
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
