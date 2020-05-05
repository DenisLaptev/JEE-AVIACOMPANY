<%@ page import="java.util.List"%>
<%@ page import="main.java.model.Personal"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.personals.selectFreePersonal_jsp.title.Free_Personal" /></title>
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


		<%
			//String orderStatus = (String) request.getAttribute("orderStatus");
			int idOrder = (int) request.getAttribute("idOrder");
		%>

		<%
			out.println("<h1>All Free Flights</h1>");
		%>


		<br>


		<div>
			<button onclick="location.href='/aviacompany_project/my-account'">
				<fmt:message key="views.personals.selectFreePersonal_jsp.button.Back_to_main_page" /></button>

		</div>
		<br> <br>
		<div>
			<div>

				<%
					List<Personal> personals = (List<Personal>) request.getAttribute("freePersonals");
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

							<th>ADD TO ORDER</th>
						</tr>
					</thead>
					<tbody>

						<%
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

									out.println("<td><a href=\"/aviacompany_project/add-personal-to-order?id="
											+ personal.getIdPersonal() + "&idOrder=" + idOrder + "\">ADD TO ORDER</a></td>");

									out.println("</tr>");
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
			<button onclick="location.href='/aviacompany_project/my-account'">Back
				to main page</button>
		</div>
	</div>
</body>
</html>
