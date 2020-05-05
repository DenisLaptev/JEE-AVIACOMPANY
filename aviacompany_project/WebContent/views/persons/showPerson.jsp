<%@ page import="main.java.model.Person"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.persons.showPerson_jsp.title.Show_person" /></title>
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
	<div align="center" style="padding-top: 20%">
		<h1><fmt:message key="views.persons.showPerson_jsp.h1.Showing_Person" /></h1>

	<br>
	<div>
		<%
			Person person = (Person) request.getAttribute("person");
		%>
		<div>

			<table cellspacing="2" border="1" cellpadding="5" width="300">
				<tr>
					<td>Id:</td>
					<td>
						<%
							out.println(person.getIdPerson());
						%>
					</td>
				</tr>
				<tr>
					<td>IdPersonal:</td>
					<td>
						<%
							out.println(person.getIdPersonal());
						%>
					</td>
				</tr>
				<tr>
					<td>FirstName:</td>
					<td>
						<%
							out.println(person.getFirstName());
						%>
					</td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td>
						<%
							out.println(person.getLastName());
						%>
					</td>
				</tr>
				<tr>
					<td>Profession:</td>
					<td>
						<%
							out.println(person.getProfession());
						%>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<br>
	<button onclick="location.href='/aviacompany_project/persons'">All
		Persons Table</button>
	</div>
</body>
</html>
