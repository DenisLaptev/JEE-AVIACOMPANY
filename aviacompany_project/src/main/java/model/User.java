package main.java.model;

import java.util.Objects;

public class User {

	private int idUser;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String role;

	public User() {
	}

	public User(int idUser, String firstName, String lastName, String login, String password, String role) {
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return Objects.equals(idUser, user.idUser) && Objects.equals(firstName, user.firstName)
				&& Objects.equals(lastName, user.lastName) && Objects.equals(login, user.login)
				&& Objects.equals(password, user.password) && Objects.equals(role, user.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUser, firstName, lastName, login, password, role);
	}

	@Override
	public String toString() {
		return "User{" + "idUser='" + idUser + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", login='" + login + '\'' + ", password='" + password + '\'' + ", role='" + role + '\'' + '}';
	}
}
