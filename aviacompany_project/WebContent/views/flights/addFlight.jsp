<%@ page import="main.java.model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message
		key="views.flights.addFlight_jsp.title.Add_new_flight" /></title>
<style>
body {
	background-image: url("images/air2.jpg");
}

.no-background {
	background-image: url("images/blank.jpg");
}
</style>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<fmt:setBundle basename="resources" />
	<div align="center" style="padding-top: 20%">
		<h1>
			<fmt:message key="views.flights.addFlight_jsp.h1.Adding_New_Flight" />
		</h1>

		<%
			User registeredUser = (User) session.getAttribute("registeredUser");
		%>

		<div>
			<%
				if (request.getAttribute("flightName") != null && request.getAttribute("flightName") != "") {
					out.println("<p>Flight '" + request.getAttribute("flightName") + "' added!</p>");
				}
			%>
			<div>

				<form method="post">
					<table>
						<tr>
							<td>Name:</td>
							<td><input type="text" name="name" class="no-background"></td>
						</tr>
						<tr>
							<td>From:</td>
							<td><input type="text" name="from" class="no-background"></td>
						</tr>
						<tr>
							<td>To:</td>
							<td><input type="text" name="to" class="no-background"></td>
						</tr>
						<tr>
							<td>Date:</td>
							<!-- <td><input type="text" name="date" class="no-background"></td> -->
							<td><div class='input-group date' id='datepicker' >
								<input type='text' name="date" class="form-control" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div></td>
						</tr>
						<tr>
							<td align="right" colspan="2"><input type="submit"
								value="Submit"></td>
						</tr>
					</table>

				</form>
			</div>
		</div>
		<button onclick="location.href='/aviacompany_project/flights'">
			<fmt:message
				key="views.flights.addFlight_jsp.button.All_Flights_Table" />
		</button>
	</div>


	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
	<script>
		$(function() {
			$('#datepicker').datepicker({
				format : "dd-mm-yyyy",
				autoclose : true,
				todayHighlight : true,
				showOtherMonths : true,
				selectOtherMonths : true,
				autoclose : true,
				changeMonth : true,
				changeYear : true,
				orientation : "button"
			});
		});
	</script>


</body>
</html>