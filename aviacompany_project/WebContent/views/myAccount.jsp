<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.myAccount_jsp.title.Aviacompany" /></title>
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
		<h1><fmt:message key="views.myAccount_jsp.h1.welcome" /></h1>



		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		%>

		<p>
			<button onclick="location.href='<%=request.getContextPath()%>'"><fmt:message key="views.myAccount_jsp.button.logout" /></button>
		</p>
		<p>
			<button
				onclick="location.href='<%=request.getContextPath()%>/flights'"><fmt:message key="views.myAccount_jsp.button.showFlights" /></button>

		</p>
		<p>
			<button
				onclick="location.href='<%=request.getContextPath()%>/orders'">
				<fmt:message key="views.myAccount_jsp.button.showOrders" /></button>
		</p>
		<p>
			<button
				onclick="location.href='<%=request.getContextPath()%>/personals'"><fmt:message key="views.myAccount_jsp.button.showPersonals" /></button>
		</p>
		<p>
			<button
				onclick="location.href='<%=request.getContextPath()%>/persons '"><fmt:message key="views.myAccount_jsp.button.showPersons" /></button>
		</p>
		<p>
			<button
				onclick="location.href='<%=request.getContextPath()%>/users '">
				<fmt:message key="views.myAccount_jsp.button.showUsers" /></button>
		</p>
		
		<p>
			<button
				onclick="location.href='<%=request.getContextPath()%>/admin-page '">
				<fmt:message key="views.myAccount_jsp.button.admin" /></button>
		</p>

	</div>
</body>
</html>
