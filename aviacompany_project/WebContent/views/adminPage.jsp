<%@ page import="main.java.model.Flight"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Show flight</title>
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
		<h1>Admin page</h1>

		<h2>Your opportunities:</h2>
		<p>1. Add flights</p>
		<p>2. Add persons</p>
		<p>3. Add users</p>
		<p>4. Delete and update flights</p>
		<p>5. Delete and update orders</p>
		<p>6. Delete and update persons</p>
		<p>7. Delete and update personals</p>
		<p>8. Delete and update users</p>

		<button
			onclick="location.href='<%=request.getContextPath()%>/my-account'">Back
			to main page</button>
	</div>
</body>
</html>
