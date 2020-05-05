<%@ page import="main.java.model.User"%>
<%@ page import="main.java.model.Personal"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.personals.addPersonal_jsp.title.Add_new_personal" /></title>
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
		<h1><fmt:message key="views.personals.addPersonal_jsp.h1.Adding_New_Personal" /></h1>


		<%
			User registeredUser = (User) session.getAttribute("registeredUser");
		%>
		<br>
		<div>
			<%
				if (request.getAttribute("isAdded") != null) {
				out.println("<p>Personal was added!</p>");
			}
			%>

			<%
				int idPersonal = (int) request.getAttribute("idPersonal");
			out.println("<p>idPersonal=" + idPersonal + "</p>");

			int idPilot1 = -1;
			int idPilot2 = -1;
			int idShturman = -1;
			int idRadist = -1;
			int idSt1 = -1;
			int idSt2 = -1;
			int idSt3 = -1;
			int idOrder = -1;

			if (request.getAttribute("idPilot1") != null) {
				idPilot1 = (int) request.getAttribute("idPilot1");
			}
			if (request.getAttribute("idPilot2") != null) {
				idPilot2 = (int) request.getAttribute("idPilot2");
			}
			if (request.getAttribute("idShturman") != null) {
				idShturman = (int) request.getAttribute("idShturman");
			}
			if (request.getAttribute("idRadist") != null) {
				idRadist = (int) request.getAttribute("idRadist");
			}
			if (request.getAttribute("idSt1") != null) {
				idSt1 = (int) request.getAttribute("idSt1");
			}
			if (request.getAttribute("idSt2") != null) {
				idSt2 = (int) request.getAttribute("idSt2");
			}
			if (request.getAttribute("idSt3") != null) {
				idSt3 = (int) request.getAttribute("idSt3");
			}
			if (request.getAttribute("idOrder") != null) {
				idOrder = (int) request.getAttribute("idOrder");
			}
			%>


			<div>
				<%--<form method="post">--%>
				<table>
					<tr>
						<td>IdPilot1:</td>

						<%
							out.println("<td><input type=\"text\" name=\"idPilot1\" value=\"" + idPilot1 + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-person?profession=Pilot1&idPersonal="
									+ idPersonal + "'\">Add</button>");
							%>

						</td>
					
					</tr>
					<tr>
						<td>IdPilot2:</td>
						<%
							out.println("<td><input type=\"text\" name=\"idPilot2\" value=\"" + idPilot2 + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-person?profession=Pilot2&idPersonal="
									+ idPersonal + "'\">Add</button>");
							%>
						</td>
					</tr>
					<tr>
						<td>IdShturman:</td>
						<%
							out.println("<td><input type=\"text\" name=\"idShturman\" value=\"" + idShturman + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-person?profession=Shturman&idPersonal="
									+ idPersonal + "'\">Add</button>");
							%>
						</td>
					</tr>
					<tr>
						<td>IdRadist:</td>
						<%
							out.println("<td><input type=\"text\" name=\"idRadist\" value=\"" + idRadist + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-person?profession=Radist&idPersonal="
									+ idPersonal + "'\">Add</button>");
							%>
						</td>
					</tr>
					<tr>
						<td>IdSt1:</td>
						<%
							out.println("<td><input type=\"text\" name=\"idSt1\" value=\"" + idSt1 + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-person?profession=Stuardes1&idPersonal="
									+ idPersonal + "'\">Add</button>");
							%>
						</td>
					</tr>
					<tr>
						<td>IdSt2:</td>
						<%
							out.println("<td><input type=\"text\" name=\"idSt2\" value=\"" + idSt2 + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-person?profession=Stuardes2&idPersonal="
									+ idPersonal + "'\">Add</button>");
							%>
						</td>
					</tr>
					<tr>
						<td>IdSt3:</td>
						<%
							out.println("<td><input type=\"text\" name=\"idSt3\" value=\"" + idSt3 + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-person?profession=Stuardes3&idPersonal="
									+ idPersonal + "'\">Add</button>");
							%>
						</td>
					</tr>
					
					<td>
						<%
							out.println("<input type=\"text\" name=\"idOrder\" value=\"" + idOrder + "\" hidden>");
						%>
					</td>	
					
					<td>
						<%
							out.println("<input type=\"text\" name=\"idPersonal\" value=\"" + idPersonal + "\" hidden>");
						%>
					</td>
				
				</table>
			
			</div>
		</div>
		<button onclick="location.href='/aviacompany_project/personals'"><fmt:message key="views.personals.addPersonal_jsp.button.All_Personals_Table" /></button>
	</div>
</body>
</html>