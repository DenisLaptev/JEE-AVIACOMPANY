package main.java.dao;

import main.java.model.Flight;
import main.java.model.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.database.DBHelper;

public class PersonalDAOImpl implements PersonalDAO {

	@Override
	public boolean addPersonal(Personal personal) {
		boolean result = true;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		try {
			int idPilot1 = personal.getIdPilot1();
			int idPilot2 = personal.getIdPilot2();
			int idShturman = personal.getIdShturman();
			int idRadist = personal.getIdRadist();
			int idSt1 = personal.getIdSt1();
			int idSt2 = personal.getIdSt2();
			int idSt3 = personal.getIdSt3();
			int idOrder = personal.getIdOrder();

			String query = "INSERT INTO aviacompany_db.personals(idPilot1, idPilot2, idShturman, idRadist, idSt1, idSt2, idSt3, idOrder) VALUES (?,?,?,?,?,?,?,?)";

			ps = connection.prepareStatement(query);

			ps.setInt(1, idPilot1);
			ps.setInt(2, idPilot2);
			ps.setInt(3, idShturman);
			ps.setInt(4, idRadist);
			ps.setInt(5, idSt1);
			ps.setInt(6, idSt2);
			ps.setInt(7, idSt3);
			ps.setInt(8, idOrder);

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
	public Personal getPersonalById(int idPersonal) {
		Personal personal = null;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "SELECT * FROM personals WHERE idPersonal = ?";
			ps = connection.prepareStatement(query);

			ps.setString(1, String.valueOf(idPersonal));

			rs = ps.executeQuery();

			while (rs.next()) {
				// int idFlight = rs.getInt("idFlight");

				int idPilot1 = rs.getInt("idPilot1");
				int idPilot2 = rs.getInt("idPilot2");
				int idShturman = rs.getInt("idShturman");
				int idRadist = rs.getInt("idRadist");
				int idSt1 = rs.getInt("idSt1");
				int idSt2 = rs.getInt("idSt2");
				int idSt3 = rs.getInt("idSt3");
				int idOrder = rs.getInt("idOrder");

				personal = new Personal(idPersonal, idPilot1, idPilot2, idShturman, idRadist, idSt1, idSt2, idSt3, idOrder);
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
		return personal;
	}

	@Override
	public List<Personal> getAllPersonals() {
		List<Personal> personals = new ArrayList<>();

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "SELECT * FROM personals";
			ps = connection.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idPersonal = rs.getInt("idPersonal");
				int idPilot1 = rs.getInt("idPilot1");
				int idPilot2 = rs.getInt("idPilot2");
				int idShturman = rs.getInt("idShturman");
				int idRadist = rs.getInt("idRadist");
				int idSt1 = rs.getInt("idSt1");
				int idSt2 = rs.getInt("idSt2");
				int idSt3 = rs.getInt("idSt3");
				int idOrder = rs.getInt("idOrder");


				Personal personal = new Personal(idPersonal, idPilot1, idPilot2, idShturman, idRadist, idSt1, idSt2,
						idSt3, idOrder);
				personals.add(personal);
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
		return personals;
	}

	@Override
	public Personal updatePersonal(int idPersonal, Personal newPersonal) {
		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		try {

			int newIdPilot1 = newPersonal.getIdPilot1();
			int newIdPilot2 = newPersonal.getIdPilot2();
			int newIdShturman = newPersonal.getIdShturman();
			int newIdRadist = newPersonal.getIdRadist();
			int newIdSt1 = newPersonal.getIdSt1();
			int newIdSt2 = newPersonal.getIdSt2();
			int newIdSt3 = newPersonal.getIdSt3();
			int newIdOrder = newPersonal.getIdOrder();

			String query = "UPDATE personals SET idPilot1 = '" + newIdPilot1 + "', IdPilot2 = '" + newIdPilot2
					+ "', IdShturman= '" + newIdShturman + "', IdRadist = '" + newIdRadist + "', IdSt1 = '" + newIdSt1
					+ "', IdSt2 = '" + newIdSt2 + "', IdSt3 = '" + newIdSt3 + "', IdOrder = '" + newIdOrder

					+ "' WHERE idPersonal = ?";

			ps = connection.prepareStatement(query);

			ps.setInt(1, idPersonal);

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

		return newPersonal;
	}

	@Override
	public boolean deletePersonalById(int idPersonal) {
		boolean result = true;

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		try {
			String query = "DELETE FROM personals WHERE idPersonal = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, idPersonal);

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

	@Override
	public void addPersonToPersonal(int idPerson, int idPersonal) {
		System.out.println("PERSON ADDED!");
	}

	@Override
	public List<Personal> getFreePersonalByIdOrder(int idOrder) {
		List<Personal> personals = new ArrayList<>();

		DBHelper objectDBHelper = new DBHelper();
		Connection connection = objectDBHelper.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM personals WHERE idOrder = ?";
			ps = connection.prepareStatement(query);

			ps.setInt(1, idOrder);

			rs = ps.executeQuery();

			while (rs.next()) {
				int idPersonal = rs.getInt("idPersonal");
				int idPilot1 = rs.getInt("idPilot1");
				int idPilot2 = rs.getInt("idPilot2");
				int idShturman = rs.getInt("idShturman");
				int idRadist = rs.getInt("idRadist");
				int idSt1 = rs.getInt("idSt1");
				int idSt2 = rs.getInt("idSt2");
				int idSt3 = rs.getInt("idSt3");
				//int idOrder = rs.getInt("idOrder");

				Personal personal = new Personal(idPersonal, idPilot1, idPilot2, idShturman, idRadist, idSt1, idSt2,
						idSt3, idOrder);
				personals.add(personal);
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
		return personals;
	}
}
