package main.java.dao;

import main.java.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.database.DBHelper;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public boolean addPerson(Person person) {

        boolean result = true;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            int idPersonal = person.getIdPersonal();
            String firstName = person.getFirstName();
            String lastName = person.getLastName();
            String profession = person.getProfession();

            String query = "INSERT INTO aviacompany_db.persons(idPersonal, firstName, lastName, profession) VALUES (?,?,?,?)";

            ps = connection.prepareStatement(query);

            ps.setInt(1, idPersonal);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, profession);

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
    public Person getPersonById(int idPerson) {
        Person person = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM persons WHERE idPerson = ?";
            ps = connection.prepareStatement(query);

            ps.setString(1, String.valueOf(idPerson));

            rs = ps.executeQuery();

            while (rs.next()) {

                // int idFlight = rs.getInt("idFlight");
                int idPersonal = rs.getInt("idPersonal");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String profession = rs.getString("profession");

                person = new Person(idPerson, idPersonal, firstName, lastName, profession);
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
        return person;
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM persons";
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                int idPerson = rs.getInt("idPerson");
                int idPersonal = rs.getInt("idPersonal");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String profession = rs.getString("profession");

                Person person = new Person(idPerson, idPersonal, firstName, lastName, profession);
                persons.add(person);
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
        return persons;
    }

    @Override
    public List<Person> getAllPersonsByProfession(String profession) {

        List<Person> persons = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM persons WHERE idPersonal=-1 AND profession = ?";
            ps = connection.prepareStatement(query);

            ps.setString(1, profession);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idPerson = rs.getInt("idPerson");
                int idPersonal = rs.getInt("idPersonal");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                Person person = new Person(idPerson, idPersonal, firstName, lastName, profession);
                persons.add(person);
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
        return persons;
    }

    @Override
    public Person updatePerson(int idPerson, Person newPerson) {

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            int newIdPersonal = newPerson.getIdPersonal();
            String newFirstName = newPerson.getFirstName();
            String newLastName = newPerson.getLastName();
            String newProfession = newPerson.getProfession();

            String query = "UPDATE persons SET idPersonal = '" + newIdPersonal + "', firstName = '" + newFirstName
                    + "', lastName = '" + newLastName + "', profession = '" + newProfession + "' WHERE idPerson = ?";

            ps = connection.prepareStatement(query);

            ps.setInt(1, idPerson);

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

        return newPerson;
    }

    @Override
    public boolean deletePersonById(int idPerson) {
        boolean result = true;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM persons WHERE idPerson = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idPerson);

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
