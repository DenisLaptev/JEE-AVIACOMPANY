<%@ page import="main.java.model.Flight"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.flights.showFlight_jsp.title.Show_flight" /></title>
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
		<h1><fmt:message key="views.flights.showFlight_jsp.h1.Showing_Flight" /></h1>

		<br>
		<div>

			<%
				Flight flight = new Flight(-1, "no data", "no data", "no data", "no data", "no data", -1);

				if (request.getAttribute("flight") != null) {
					flight = (Flight) request.getAttribute("flight");
				} else {

				}
			%>

			<div>

				<table cellspacing="2" border="1" cellpadding="5" width="300">
					<tr>
						<td>Id:</td>
						<td>
							<%
								out.println(flight.getIdFlight());
							%>
						</td>
					</tr>
					<tr>
						<td>Name:</td>
						<td>
							<%
								out.println(flight.getName());
							%>
						</td>
					</tr>
					<tr>
						<td>From:</td>
						<td>
							<%
								out.println(flight.getFlightFrom());
							%>
						</td>
					</tr>
					<tr>
						<td>To:</td>
						<td>
							<%
								out.println(flight.getFlightTo());
							%>
						</td>
					</tr>
					<tr>
						<td>Date:</td>
						<td>
							<%
								out.println(flight.getDate());
							%>
						</td>
					</tr>
					<tr>
						<td>Order Status:</td>
						<td>
							<%
								out.println(flight.getOrderStatus());
							%>
						</td>
					</tr>
					<tr>
						<td>Order Id:</td>
						<td>
							<%
								out.println(flight.getIdOrder());
							%>
						</td>
					</tr>
				</table>

			</div>
		</div>
		<br>
		<button onclick="location.href='/aviacompany_project/flights'"><fmt:message key="views.flights.showFlight_jsp.button.All_Flights_Table" /></button>
	</div>
</body>
</html>
