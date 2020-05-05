<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Registration</title>
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
	<div align="center" style="padding-top: 15%">
		<h1>Registration</h1>
	</div>

	<div align="center">
		<%
			if (request.getAttribute("lastName") != null && request.getAttribute("lastName") != "") {
				out.println("<p>User '" + request.getAttribute("lastName") + "' added!</p>");
			} else {
				out.println("<p>Fill in all user parameters!</p>");
			}
		%>
		
		<%
			if (request.getAttribute("isUnique") != null && (boolean)request.getAttribute("isUnique") == false) {
				out.println("<p>User already exists!</p>");
			} 
		%>

		<div align="center" style="padding-top: 20px">
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
						<td align="right" colspan="2"><input type="submit"
							value="Submit"></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
	<div style="padding-top: 15%">
		<button onclick="location.href='/aviacompany_project'">Back</button>
	</div>
</body>
</html>