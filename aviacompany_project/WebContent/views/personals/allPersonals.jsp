<%@ page import="java.util.List"%>
<%@ page import="main.java.model.Personal"%>
<%@ page import="main.java.model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.personals.allPersonals_jsp.title.All_Personals" /></title>
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
		<h1><fmt:message key="views.personals.allPersonals_jsp.h1.All_All_Personals_Table" /></h1>

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
			<%
				if (registeredUser != null && registeredUser.getRole().equals("dispatcher")) {
			%>
			<button onclick="location.href='/aviacompany_project/add-personal'"><fmt:message key="views.personals.allPersonals_jsp.button.Add_Personal" /></button>
			<%
				}
			%>
			<button onclick="location.href='/aviacompany_project/my-account'"><fmt:message key="views.personals.allPersonals_jsp.button.Back_to_main_page" /></button>
		</div>
		<br> <br>
		<div>
			<div>

				<%
					List<Personal> personals = (List<Personal>) request.getAttribute("allPersonals");
					if (personals != null && !personals.isEmpty()) {
				%>

				<table cellspacing="2" border="1" cellpadding="5" width="600">
					<thead>
						<tr>
							<th>Id</th>
							<th>IdPilot1</th>
							<th>IdPilot2</th>
							<th>IdShturman</th>
							<th>IdRadist</th>
							<th>IdSt1</th>
							<th>IdSt2</th>
							<th>IdSt3</th>
							<th>IdOrder</th>
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
									for (Personal personal : personals) {
										out.println("<tr>");
										out.println("<td><a href=\"/aviacompany_project/personal-by-id?id=" + personal.getIdPersonal()
												+ "\">" + personal.getIdPersonal() + "</a></td>");
										out.println("<td>" + personal.getIdPilot1() + "</td>");
										out.println("<td>" + personal.getIdPilot2() + "</td>");
										out.println("<td>" + personal.getIdShturman() + "</td>");
										out.println("<td>" + personal.getIdRadist() + "</td>");
										out.println("<td>" + personal.getIdSt1() + "</td>");
										out.println("<td>" + personal.getIdSt2() + "</td>");
										out.println("<td>" + personal.getIdSt3() + "</td>");
										out.println("<td>" + personal.getIdOrder() + "</td>");
										out.println("<td><a href=\"/aviacompany_project/update-personal-by-id?id="
												+ personal.getIdPersonal() + "\">Update</a></td>");
										out.println("<td><a href=\"/aviacompany_project/delete-personal-by-id?id="
												+ personal.getIdPersonal() + "\">Delete</a></td>");
										out.println("</tr>");
									}
								} else {
									for (Personal personal : personals) {
										out.println("<tr>");
										out.println("<td><a href=\"/aviacompany_project/personal-by-id?id=" + personal.getIdPersonal()
												+ "\">" + personal.getIdPersonal() + "</a></td>");
										out.println("<td>" + personal.getIdPilot1() + "</td>");
										out.println("<td>" + personal.getIdPilot2() + "</td>");
										out.println("<td>" + personal.getIdShturman() + "</td>");
										out.println("<td>" + personal.getIdRadist() + "</td>");
										out.println("<td>" + personal.getIdSt1() + "</td>");
										out.println("<td>" + personal.getIdSt2() + "</td>");
										out.println("<td>" + personal.getIdSt3() + "</td>");
										out.println("<td>" + personal.getIdOrder() + "</td>");
										out.println("</tr>");
									}
								}
						%>

					</tbody>
				</table>

				<%
					} else {
						out.println("<p>There are no personals yet!</p>");
					}
				%>

			</div>
		</div>

		<br>

		<div>
			<%
				if (registeredUser != null && registeredUser.getRole().equals("dispatcher")) {
			%>
			<button onclick="location.href='/aviacompany_project/add-personal'">Add
				Personal</button>
			<%
				}
			%>
		
			
			<button onclick="location.href='/aviacompany_project/my-account'"><fmt:message key="views.personals.allPersonals_jsp.button.Back_to_main_page" /></button>
		</div>
	</div>
</body>
</html>