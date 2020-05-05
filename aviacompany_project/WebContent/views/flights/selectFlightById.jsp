<%@ page import="main.java.model.Flight"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.flights.selectFlightById_jsp.title.Select_flight" /></title>
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
		<h1><fmt:message key="views.flights.selectFlightById_jsp.h1.Selecting_Flight_by_Id" /></h1>


		<div>
			<div>
				<form method="post">
					<table>
						<tr>
							<td>Flight Id:</td>
							<td><input type="text" name="id"></td>
						</tr>

						<tr>
							<td align="right" colspan="2"><input type="submit"
								value="Find Flights"></td>
						</tr>
					</table>

				</form>
			</div>
		</div>
		<button onclick="location.href='/aviacompany_project/flights'"><fmt:message key="views.flights.selectFlightById_jsp.button.All_Flights_Table" /></button>
	</div>
</body>
</html>
