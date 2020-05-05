<%@ page import="main.java.model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Title</title>
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

		<%
			User registeredUser = (User) session.getAttribute("registeredUser");
		if (registeredUser != null) {
			%>
			<h1><fmt:message key="views.loginResult_jsp.h1.welcome" /></h1>
			
<%
			User user = (User) request.getAttribute("user");
			out.println(registeredUser.getFirstName());
			out.println(registeredUser.getLastName());
			
			out.println("your role is " + registeredUser.getRole());
		%>
		<button onclick="location.href='<%=request.getContextPath()%>/'"><fmt:message key="views.loginResult_jsp.button.logout" /></button>
		<button
			onclick="location.href='<%=request.getContextPath()%>/my-account'"><fmt:message key="views.loginResult_jsp.button.next" /></button>
		<%
			}

		else {
			
			out.println("<p> This user is not registered. Please check your login and password.</p>");
		
		%>
		<button onclick="location.href='<%=request.getContextPath()%>/'">Back
			to main page</button>
		<%
			}
		%>
	</div>

</body>
</html>
