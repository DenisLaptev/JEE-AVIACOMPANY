<%@ page import="main.java.model.Order"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<fmt:message key="views.loginResult_jsp.button.next" />

<html>
<head>
<title><fmt:message key="views.orders.updateOrder_jsp.title.Update_order" /></title>
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
		<h1><fmt:message key="views.orders.updateOrder_jsp.h1.Updating_Order" /></h1>


		<div>
			<%
				Order orderToUpdate = (Order) request.getAttribute("orderToUpdate");
			%>
			<div>

				<form method="post">
					<table>
						<tr>
							<td>IdFlight:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idFlight\" value=\"" + orderToUpdate.getIdFlight() + "\">");
								%>
							</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"id\" value=\"" + orderToUpdate.getIdOrder() + "\" hidden>");
								%>
							</td>
						</tr>
						<tr>
							<td>IdPersonal:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idPersonal\" value=\"" + orderToUpdate.getIdPersonal() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>Status:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"status\" value=\"" + orderToUpdate.getStatus() + "\">");
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
		<button onclick="location.href='/aviacompany_project/orders'"><fmt:message key="views.orders.updateOrder_jsp.button.All_Orders_Table" /></button>
	</div>
</body>
</html>
