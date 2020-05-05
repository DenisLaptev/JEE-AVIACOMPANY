<%@ page import="main.java.model.Flight"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.flights.updateFlight_jsp.title.Update_flight" /></title>
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

		<h1><fmt:message key="views.flights.updateFlight_jsp.button.All_Flights_Table" /></h1>


		<div>
			<%
				Flight flightToUpdate = (Flight) request.getAttribute("flightToUpdate");
			%>
			<div>

				<form method="post">
					<table>
						<tr>
							<td>Name:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"name\" value=\"" + flightToUpdate.getName() + "\">");
								%>
							</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"id\" value=\"" + flightToUpdate.getIdFlight() + "\" hidden>");
								%>
							</td>
						</tr>
						<tr>
							<td>From:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"from\" value=\"" + flightToUpdate.getFlightFrom() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>To:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"to\" value=\"" + flightToUpdate.getFlightTo() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>Date:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"date\" value=\"" + flightToUpdate.getDate() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>Order Status:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"orderStatus\" value=\"" + flightToUpdate.getOrderStatus() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>Order Id:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idOrder\" value=\"" + flightToUpdate.getIdOrder() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td align="right" colspan="2"><input type="submit"
								value="Submit"></td>
						</tr>
					</table>
					<%--
                            <label>Name:
                                <input type="text" name="name"><br/>
                            </label>
                            <label>From:
                                <input type="text" name="from"><br/>
                            </label>
                            <label>To:
                                <input type="text" name="to"><br/>
                            </label>
                            <label>Date:
                                <input type="text" name="date"><br/>
                            </label>
                            <button type="submit">Submit</button>
            --%>
				</form>
			</div>
		</div>
	
	<button onclick="location.href='/aviacompany_project/flights'">All
		Flights Table</button>
</div>
</body>
</html>
