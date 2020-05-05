<%@ page import="main.java.model.Personal"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title><fmt:message key="views.personals.updatePersonal_jsp.title.Update_personal" /></title>
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
		<h1><fmt:message key="views.personals.updatePersonal_jsp.h1.Updating_Personal" /></h1>


		<div>
			<%
				Personal personalToUpdate = (Personal) request.getAttribute("personalToUpdate");
			%>
			<div>

				<form method="post">
					<table>
						<tr>
							<td>IdPilot1:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idPilot1\" value=\"" + personalToUpdate.getIdPilot1() + "\">");
								%>
							</td>

							<td>
								<%
									out.println("<input type=\"text\" name=\"id\" value=\"" + personalToUpdate.getIdPersonal() + "\" hidden>");
								%>
							</td>

						</tr>
						<tr>
							<td>IdPilot2:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idPilot2\" value=\"" + personalToUpdate.getIdPilot2() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>IdShturman:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idShturman\" value=\"" + personalToUpdate.getIdShturman() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>IdRadist</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idRadist\" value=\"" + personalToUpdate.getIdRadist() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>IdSt1:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idSt1\" value=\"" + personalToUpdate.getIdSt1() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>IdSt2:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idSt2\" value=\"" + personalToUpdate.getIdSt2() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>IdSt3:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idSt3\" value=\"" + personalToUpdate.getIdSt3() + "\">");
								%>
							</td>
						</tr>
						<tr>
							<td>IdFlight:</td>
							<td>
								<%
									out.println("<input type=\"text\" name=\"idOrder\" value=\"" + personalToUpdate.getIdOrder() + "\">");
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
		<button onclick="location.href='/aviacompany_project/personals'"><fmt:message key="views.personals.updatePersonal_jsp.button.All_Personals_Table" /></button>
	</div>
</body>
</html>
