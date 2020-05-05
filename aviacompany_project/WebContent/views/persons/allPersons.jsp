<%@ page import="java.util.List"%>
<%@ page import="main.java.model.Person"%>
<%@ page import="main.java.model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.persons.allPersons_jsp.title.All_Persons" /></title>
<style>
body {
	background-image: url("images/air2.jpg");
}

.no-background {
	background-image: url("images/blank.jpg");
}
</style>
</head>
<body>
<fmt:setBundle basename="resources" />
	<div align="center">
		<h1>All Persons Table</h1>

		<br>
		<%
			User registeredUser = (User) session.getAttribute("registeredUser");
		if (registeredUser != null) {
			out.println("~~~~~");
			//out.println(registeredUser);
			//out.println("UserId=" + registeredUser.getIdUser() + " role= " + registeredUser.getRole());
			if (registeredUser.getRole().equals("user")) {
				out.println("You are simple user");
			} else if (registeredUser.getRole().equals("dispatcher")) {
				out.println("You are dispatcher");
			} else {
				out.println("You are admin");
			}
			out.println("~~~~~");
		} else {
			out.println("~~~~~");
			out.println("You didn't login!");
			out.println("~~~~~");
		}
		%>
		<div>
	<button onclick="location.href='/aviacompany_project/my-account'"><fmt:message key="views.persons.allPersons_jsp.button.Back_to_main_page" /></button>
			<%
				if (registeredUser != null && registeredUser.getRole().equals("admin")) {
			%>
			<button onclick="location.href='/aviacompany_project/add-person'"><fmt:message key="views.persons.allPersons_jsp.button.Add_Person" /></button>
			<%
				}
			%>

		</div>
		<br> <br>
		<div>
			<div>

				<%
					List<Person> persons = (List<Person>) request.getAttribute("allPersons");
				if (persons != null && !persons.isEmpty()) {
				%>

				<table cellspacing="2" border="1" cellpadding="5" width="600">
					<thead>
						<tr>
							<th>IdPerson</th>
							<th>idPersonal</th>
							<th>FirstName</th>
							<th>LastName</th>
							<th>Profession</th>
							<%
								if (registeredUser != null && registeredUser.getRole().equals("admin")) {
							%>
							<th>Update</th>
							<th>Delete</th>
							<%
								}
							%>
						</tr>
					</thead>
					<tbody>

						<%
							if (registeredUser != null && registeredUser.getRole().equals("admin")) {
							for (Person person : persons) {
								out.println("<tr>");
								out.println("<td><a href=\"/aviacompany_project/person-by-id?id=" + person.getIdPerson() + "\">"
								+ person.getIdPerson() + "</a></td>");
								out.println("<td>" + person.getIdPersonal() + "</td>");
								out.println("<td>" + person.getFirstName() + "</td>");
								out.println("<td>" + person.getLastName() + "</td>");
								out.println("<td>" + person.getProfession() + "</td>");

								out.println("<td><a href=\"/aviacompany_project/update-person-by-id?id=" + person.getIdPerson()
								+ "\">Update</a></td>");
								out.println("<td><a href=\"/aviacompany_project/delete-person-by-id?id=" + person.getIdPerson()
								+ "\">Delete</a></td>");
								out.println("</tr>");
							}
						} else {
							for (Person person : persons) {
								out.println("<tr>");
								out.println("<td><a href=\"/aviacompany_project/person-by-id?id=" + person.getIdPerson() + "\">"
								+ person.getIdPerson() + "</a></td>");
								out.println("<td>" + person.getIdPersonal() + "</td>");
								out.println("<td>" + person.getFirstName() + "</td>");
								out.println("<td>" + person.getLastName() + "</td>");
								out.println("<td>" + person.getProfession() + "</td>");
								out.println("</tr>");
							}
						}
						%>

					</tbody>
				</table>

				<%
					} else {
					out.println("<p>There are no persons yet!</p>");
				}
				%>

			</div>
		</div>

		<br>
		<div>
			<button onclick="location.href='/aviacompany_project/my-account'"><fmt:message key="views.persons.allPersons_jsp.button.Back_to_main_page" /></button>
			<%
				if (registeredUser != null && registeredUser.getRole().equals("admin")) {
			%>
			<button onclick="location.href='/aviacompany_project/add-person'"><fmt:message key="views.persons.allPersons_jsp.button.Add_PersonЫ" /></button>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>
