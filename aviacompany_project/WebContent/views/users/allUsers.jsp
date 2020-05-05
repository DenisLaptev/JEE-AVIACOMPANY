<%@ page import="java.util.List"%>
<%@ page import="main.java.model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>All Users</title>
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
	<div align="center">
		<h1><fmt:message key="views.users.allUsers_jsp.h1.All_All_Users_Table" /></h1>

		<br>
		<%
			User registeredUser = (User) session.getAttribute("registeredUser");
		if (registeredUser != null) {
			out.println("~~~~~");
			//out.println(registeredUser);
			//out.println("UserId=" + registeredUser.getIdUser() + " role= " + registeredUser.getRole());
			if (registeredUser.getRole().equals("user")) {
				out.println("You are simple user");
			} else if (registeredUser.getRole().equals("dispatcher")) {
				out.println("You are dispatcher");
			} else {
				out.println("You are admin");
			}
			out.println("~~~~~");
		} else {
			out.println("~~~~~");
			out.println("You didn't login!");
			out.println("~~~~~");
		}
		%>
		<div>
			<button
				onclick="location.href='<%=request.getContextPath()%>/my-account'"><fmt:message key="views.users.allUsers_jsp.button.Back_to_main_page" /></button>
			<%
				if (registeredUser != null && registeredUser.getRole().equals("admin")) {
			%>
			<button onclick="location.href='/aviacompany_project/add-user'">Add
				User</button>
			<%
				}
			%>
		</div>
		<br> <br>
		<div>
			<div>

				<%
					List<User> users = (List<User>) request.getAttribute("allUsers");
				if (users != null && !users.isEmpty()) {
				%>

				<table cellspacing="2" border="1" cellpadding="5" width="600">
					<thead>
						<tr>
							<th>Id</th>
							<th>FirstName</th>
							<th>LastName</th>
							<%
								if (registeredUser != null && registeredUser.getRole().equals("admin")) {
							%>
							<th>Login</th>
							<th>Password</th>
							<%
								}
							%>
							<th>Role</th>
							<%
								if (registeredUser != null && registeredUser.getRole().equals("admin")) {
							%>
							<th>Update</th>
							<th>Delete</th>
							<%
								}
							%>
						</tr>
					</thead>
					<tbody>

						<%
							if (registeredUser != null && registeredUser.getRole().equals("admin")) {
							for (User user : users) {
								out.println("<tr>");
								out.println("<td><a href=\"/aviacompany_project/user-by-id?id=" + user.getIdUser() + "\">" + user.getIdUser()
								+ "</a></td>");
								out.println("<td>" + user.getFirstName() + "</td>");
								out.println("<td>" + user.getLastName() + "</td>");
								out.println("<td>" + user.getLogin() + "</td>");
								out.println("<td>" + user.getPassword() + "</td>");
								out.println("<td>" + user.getRole() + "</td>");

								out.println(
								"<td><a href=\"/aviacompany_project/update-user-by-id?id=" + user.getIdUser() + "\">Update</a></td>");
								out.println(
								"<td><a href=\"/aviacompany_project/delete-user-by-id?id=" + user.getIdUser() + "\">Delete</a></td>");
								out.println("</tr>");
							}
						} else {
							for (User user : users) {
								out.println("<tr>");
								out.println("<td><a href=\"/aviacompany_project/user-by-id?id=" + user.getIdUser() + "\">" + user.getIdUser()
								+ "</a></td>");
								out.println("<td>" + user.getFirstName() + "</td>");
								out.println("<td>" + user.getLastName() + "</td>");

								out.println("<td>" + user.getRole() + "</td>");
								out.println("</tr>");
							}
						}
						%>


					</tbody>
				</table>

				<%
					} else {
					out.println("<p>There are no users yet!</p>");
				}
				%>

			</div>
		</div>

		<br>

		<div>
		<button
				onclick="location.href='<%=request.getContextPath()%>/my-account'"><fmt:message key="views.users.allUsers_jsp.button.Back_to_main_page" /></button>
			<%
				if (registeredUser != null && registeredUser.getRole().equals("admin")) {
			%>
			<button onclick="location.href='/aviacompany_project/add-user'">Add
				User</button>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>
