package main.java.dao;

import main.java.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.database.DBHelper;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean addUser(User user) {
        boolean result = true;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String login = user.getLogin();
            String password = user.getPassword();
            String role = user.getRole();

            String query = "INSERT INTO aviacompany_db.users(firstName, lastName, login, password, role) VALUES (?,?,?,?,?)";

            ps = connection.prepareStatement(query);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, login);
            ps.setString(4, password);
            ps.setString(5, role);

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
    public User getUserById(int idUser) {
        User user = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM users WHERE idUser = ?";
            ps = connection.prepareStatement(query);

            ps.setString(1, String.valueOf(idUser));

            rs = ps.executeQuery();

            while (rs.next()) {

                // int idFlight = rs.getInt("idFlight");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String role = rs.getString("role");

                user = new User(idUser, firstName, lastName, login, password, role);
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
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM users";
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                int idUser = rs.getInt("idUser");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String role = rs.getString("role");

                User user = new User(idUser, firstName, lastName, login, password, role);
                users.add(user);
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
        return users;
    }

    @Override
    public User updateUser(int idUser, User newUser) {

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            String newFirstName = newUser.getFirstName();
            String newLastName = newUser.getLastName();
            String newLogin = newUser.getLogin();
            String newPassword = newUser.getPassword();
            String newRole = newUser.getRole();

            String query = "UPDATE users SET firstName = '" + newFirstName + "', lastName = '" + newLastName
                    + "', login = '" + newLogin + "', password = '" + newPassword + "', role = '" + newRole
                    + "' WHERE idUser = ?";

            ps = connection.prepareStatement(query);

            ps.setInt(1, idUser);

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

        return newUser;
    }

    @Override
    public boolean deleteUserById(int idUser) {
        boolean result = true;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM users WHERE idUser = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idUser);

            // System.out.println(ps);
            ps.executeUpdate();

            // connection.close();
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
}
