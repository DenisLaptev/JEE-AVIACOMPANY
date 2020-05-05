<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.users.addUser_jsp.title.Add_new_user" /></title>
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
		<h1><fmt:message key="views.users.addUser_jsp.h1.Adding_New_User" /></h1>
	

	<div>
		<%
			if (request.getAttribute("lastName") != null && request.getAttribute("lastName") != "") {
			out.println("<p>User '" + request.getAttribute("lastName") + "' added!</p>");
		}
		%>
		<div>

			<form method="post">
				<table>
					<tr>
						<td>FirstName:</td>
						<td><input type="text" name="firstName"></td>
					</tr>
					<tr>
						<td>LastName:</td>
						<td><input type="text" name="lastName"></td>
					</tr>
					<tr>
						<td>Login:</td>
						<td><input type="text" name="login"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="text" name="password"></td>
					</tr>
					<tr>
						<td>Role:</td>
						<td><input type="text" name="role"></td>
					</tr>
					<tr>
						<td align="right" colspan="2"><input type="submit"
							value="Submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<button onclick="location.href='/aviacompany_project/users'"><fmt:message key="views.users.addUser_jsp.button.All_Users_Table" /></button>
		</div>
</html>