<%@ page import="main.java.model.Person"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.persons.updatePerson_jsp.title.Update_person" /></title>
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
		<h1><fmt:message key="views.persons.updatePerson_jsp.h1.Updating_Person" /></h1>


	<div>
		<%
			Person personToUpdate = (Person) request.getAttribute("personToUpdate");
		%>
		<div>

			<form method="post">
				<table>
					<tr>
						<td>IdPersonal:</td>
						<td>
							<%
								out.println("<input type=\"text\" name=\"idPersonal\" value=\"" + personToUpdate.getIdPersonal() + "\">");
							%>
						</td>
						<td>
							<%
								out.println("<input type=\"text\" name=\"id\" value=\"" + personToUpdate.getIdPerson() + "\" hidden>");
							%>
						</td>
					</tr>
					<tr>
						<td>FirstName:</td>
						<td>
							<%
								out.println("<input type=\"text\" name=\"firstName\" value=\"" + personToUpdate.getFirstName() + "\">");
							%>
						</td>
					</tr>
					<tr>
						<td>LastName:</td>
						<td>
							<%
								out.println("<input type=\"text\" name=\"lastName\" value=\"" + personToUpdate.getLastName() + "\">");
							%>
						</td>
					</tr>
					<tr>
						<td>Profession:</td>
						<td>
							<%
								out.println("<input type=\"text\" name=\"profession\" value=\"" + personToUpdate.getProfession() + "\">");
							%>
						</td>
					</tr>
					<tr>
						<td align="right" colspan="2"><input type="submit"
							value="Submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<button onclick="location.href='/aviacompany_project/persons'">All
		Persons Table</button>
	</div>
</body>
</html>
