<%@ page import="main.java.model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.users.showUser_jsp.title.Show_user" /></title>
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
		<h1><fmt:message key="views.users.showUser_jsp.h1.Showing_User" /></h1>
	
	<br>
	<div>
		<%
			User user = (User) request.getAttribute("user");
		%>
		<div>

			<table cellspacing="2" border="1" cellpadding="5" width="300">
				<tr>
					<td>Id:</td>
					<td>
						<%
							out.println(user.getIdUser());
						%>
					</td>
				</tr>
				<tr>
					<td>FirstName:</td>
					<td>
						<%
							out.println(user.getFirstName());
						%>
					</td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td>
						<%
							out.println(user.getLastName());
						%>
					</td>
				</tr>
				<tr>
					<td>Login:</td>
					<td>
						<%
							out.println(user.getLogin());
						%>
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td>
						<%
							out.println(user.getPassword());
						%>
					</td>
				</tr>
				<tr>
					<td>Role:</td>
					<td>
						<%
							out.println(user.getRole());
						%>
					</td>
				</tr>
			</table>
			
		</div>
	</div>
	<br>
	<button onclick="location.href='<%=request.getContextPath()%>/users'"><fmt:message key="views.users.showUser_jsp.button.All_Users_Table" /></button>
</div>
</body>
</html>
