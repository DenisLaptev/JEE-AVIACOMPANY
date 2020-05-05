<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>


<html>
<head>
<title>Login page</title>
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
		<!-- <h1>Aviacompany</h1> -->
		<h1><fmt:message key="index_jsp.h1.Aviacompany" /></h1>

		<p>
			<a href="settings.jsp"><fmt:message key="index_jsp.link.settings" /></a>
		</p>

		<h2>
			<fmt:message key="index_jsp.label.welcome" />
		</h2>
		
		<form action="/aviacompany_project/login" method="POST">
			<p>
				<input type="text" name="userLogin" placeholder=<fmt:message key="index_jsp.p.login" />>
			</p>
			<p>
				<input type="password" name="userPassword" placeholder=<fmt:message key="index_jsp.p.password" />>
			</p>
			<p>
				<input type="submit" value=<fmt:message key="index_jsp.button.send" />></input>
			</p>
		</form>
		<!--<button onclick="location.href='/aviacompany_project/registration'">Registration</button>-->
		<button onclick="location.href='/aviacompany_project/registration'"><fmt:message key="index_jsp.button.registration" /></button>
	</div>
</body>
</html>
