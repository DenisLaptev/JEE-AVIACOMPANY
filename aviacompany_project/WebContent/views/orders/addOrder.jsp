<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<fmt:message key="views.loginResult_jsp.button.next" />

<html>
<head>
<title><fmt:message key="views.orders.addOrder_jsp.title.Add_new_order" /></title>
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
		<h1><fmt:message key="views.orders.addOrder_jsp.h1.Adding_New_Order" /></h1>


		<div>

			<%
				int idOrder = (int) request.getAttribute("idOrder");
				out.println("<p>idOrder=" + idOrder + "</p>");

				int idFlight = -1;
				int idPersonal = -1;

				if (request.getAttribute("idFlight") != null) {
					idFlight = (int) request.getAttribute("idFlight");
				}
				if (request.getAttribute("idPersonal") != null) {
					idPersonal = (int) request.getAttribute("idPersonal");
				}
			%>



			<div>

				<table>


					<tr>
						<td>IdFlight:</td>

						<%
							out.println("<td><input type=\"text\" name=\"idFlight\" value=\"" + idFlight + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-flight?idOrder=" + idOrder
										+ "'\">Add</button>");
							%>

						</td>
					</tr>

					<tr>
						<td>IdPersonal:</td>

						<%
							out.println("<td><input type=\"text\" name=\"idPersonal\" value=\"" + idPersonal + "\"></td>");
						%>
						<td>
							<%
								out.println("<button onclick=\"location.href='/aviacompany_project/free-personal?idOrder=" + idOrder
										+ "'\">Add</button>");
							%>

						</td>
					</tr>

				</table>
			</div>
		</div>
		<button onclick="location.href='/aviacompany_project/orders'"><fmt:message key="views.orders.addOrder_jsp.button.All_Orders_Table" /></button>
	</div>
</body>
</html>




