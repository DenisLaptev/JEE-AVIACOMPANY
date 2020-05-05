package main.java.dao;

import main.java.database.DBHelper;
import main.java.model.Flight;
import main.java.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

	@Override
	public boolean addFlight(Flight flight) {
		boolean result = true;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		try {

			String name = flight.getName();
			String flightFrom = flight.getFlightFrom();
			String flightTo = flight.getFlightTo();
			String date = flight.getDate();
			String orderStatus = "free";
			int idOrder = -1;

			String query = "INSERT INTO aviacompany_db.flights(name, flightFrom, flightTo, date,orderStatus, idOrder) VALUES (?,?,?,?,?,?)";

			ps = connection.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, flightFrom);
			ps.setString(3, flightTo);
			ps.setString(4, date);
			ps.setString(5, orderStatus);
			ps.setInt(6, idOrder);

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
	public Flight getFlightById(int idFlight) {
		Flight flight = null;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "SELECT * FROM flights WHERE idFlight = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, String.valueOf(idFlight));

			rs = ps.executeQuery();

			while (rs.next()) {
				// int idFlight = rs.getInt("idFlight");
				String name = rs.getString("name");
				String flightFrom = rs.getString("flightFrom");
				String flightTo = rs.getString("flightTo");
				String date = rs.getString("date");
				String orderStatus = rs.getString("orderStatus");
				int idOrder = rs.getInt("idOrder");

				flight = new Flight(idFlight, name, flightFrom, flightTo, date, orderStatus,idOrder);
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
		return flight;
	}

	@Override
	public Flight getFlightByName(String name) {
		Flight flight = null;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "SELECT * FROM flights WHERE name = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, name);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idFlight = rs.getInt("idFlight");
				// String name = rs.getString("name");
				String flightFrom = rs.getString("flightFrom");
				String flightTo = rs.getString("flightTo");
				String date = rs.getString("date");
				String orderStatus = rs.getString("orderStatus");
				int idOrder = rs.getInt("idOrder");

				flight = new Flight(idFlight, name, flightFrom, flightTo, date, orderStatus,idOrder);
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
		return flight;
	}

	@Override
	public Flight getFlightByFrom(String from) {
		Flight flight = null;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "SELECT * FROM flights WHERE flightFrom = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, from);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idFlight = rs.getInt("idFlight");
				String name = rs.getString("name");
				// String flightFrom = rs.getString("flightFrom");
				String flightTo = rs.getString("flightTo");
				String date = rs.getString("date");
				String orderStatus = rs.getString("orderStatus");
				int idOrder = rs.getInt("idOrder");

				flight = new Flight(idFlight, name, from, flightTo, date, orderStatus,idOrder);
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
		return flight;
	}

	@Override
	public Flight getFlightByTo(String to) {
		Flight flight = null;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "SELECT * FROM flights WHERE flightTo = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, to);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idFlight = rs.getInt("idFlight");
				String name = rs.getString("name");
				String flightFrom = rs.getString("flightFrom");
				// String flightTo = rs.getString("flightTo");
				String date = rs.getString("date");
				String orderStatus = rs.getString("orderStatus");
				int idOrder = rs.getInt("idOrder");

				flight = new Flight(idFlight, name, flightFrom, to, date, orderStatus,idOrder);
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
		return flight;
	}

	@Override
	public Flight getFlightByDate(String date) {
		Flight flight = null;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "SELECT * FROM flights WHERE date = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, date);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idFlight = rs.getInt("idFlight");
				String name = rs.getString("name");
				String flightFrom = rs.getString("flightFrom");
				String flightTo = rs.getString("flightTo");
				// String date = rs.getString("date");
				String orderStatus = rs.getString("orderStatus");
				int idOrder = rs.getInt("idOrder");

				flight = new Flight(idFlight, name, flightFrom, flightTo, date, orderStatus,idOrder);
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
		return flight;
	}

	/*
	 * 000 001 010 100 011 101 110 111
	 */
	@Override
	public List<Flight> getFlightByFromByToByDate(String from, String to, String date) {
		List<Flight> flights = new ArrayList<>();

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM flights WHERE flightFrom = ? AND flightTo = ? AND date = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, from);
			ps.setString(2, to);
			ps.setString(3, date);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idFlight = rs.getInt("idFlight");
				String name = rs.getString("name");
				String orderStatus = rs.getString("orderStatus");
				int idOrder = rs.getInt("idOrder");

				Flight flight = new Flight(idFlight, name, from, to, date, orderStatus,idOrder);
				flights.add(flight);
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
		return flights;
	}

	@Override
	public List<Flight> getAllFlights() {
		List<Flight> flights = new ArrayList<>();

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "SELECT * FROM flights";
			ps = connection.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idFlight = rs.getInt("idFlight");
				String name = rs.getString("name");
				String flightFrom = rs.getString("flightFrom");
				String flightTo = rs.getString("flightTo");
				String date = rs.getString("date");
				String orderStatus = rs.getString("orderStatus");
				int idOrder = rs.getInt("idOrder");

				Flight flight = new Flight(idFlight, name, flightFrom, flightTo, date, orderStatus,idOrder);
				flights.add(flight);
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
		return flights;
	}

	@Override
	public Flight updateFlight(int idFlight, Flight newFlight) {

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		try {

			String newName = newFlight.getName();
			String newFlightFrom = newFlight.getFlightFrom();
			String newFlightTo = newFlight.getFlightTo();
			String newDate = newFlight.getDate();
			String newOrderStatus = newFlight.getOrderStatus();
			int newIdOrder = newFlight.getIdOrder();

			String query = "UPDATE flights SET name = '" + newName + "', flightFrom = '" + newFlightFrom
					+ "', flightTo = '" + newFlightTo + "', date = '" + newDate + "', orderStatus = '" + newOrderStatus + "', idOrder = '" + newIdOrder
					+ "' WHERE idFlight = ?";

			ps = connection.prepareStatement(query);

			ps.setInt(1, idFlight);

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
		return newFlight;
	}

	@Override
	public boolean deleteFlightById(int idFlight) {
		boolean result = false;
		int changedRowsNumber = 0;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		try {
			String query = "DELETE FROM flights WHERE idFlight = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, idFlight);

			// System.out.println(ps);
			changedRowsNumber = ps.executeUpdate();
			System.out.println("changedRowsNumber=" + changedRowsNumber);
			if (changedRowsNumber > 0) {
				result = true;
			}

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
	public List<Flight> getFreeFlightByOrderStatus(String orderStatus) {
		List<Flight> flights = new ArrayList<>();

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM flights WHERE orderStatus = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, orderStatus);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idFlight = rs.getInt("idFlight");
				String name = rs.getString("name");
				String flightFrom = rs.getString("flightFrom");
				String flightTo = rs.getString("flightTo");
				String date = rs.getString("date");
				int idOrder = rs.getInt("idOrder");

				Flight flight = new Flight(idFlight, name, flightFrom, flightTo, date, orderStatus,idOrder);
				flights.add(flight);
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
		return flights;
	}
}
