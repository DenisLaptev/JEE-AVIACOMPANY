<%@ page import="main.java.model.Personal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title><fmt:message key="views.personals.showPersonal_jsp.title.Show_personal" /></title>
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
    <h1>Showing Personal</h1>

<br>
<div>
    <%
    Personal personal = (Personal) request.getAttribute("personal");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300">
            <tr>
                <td>Id:</td>
                <td>
                    <%
                        out.println(personal.getIdPersonal());
                    %>
                </td>
            </tr>
            <tr>
                <td>IdPilot1:</td>
                <td>
                    <%
                        out.println(personal.getIdPilot1());
                    %>
                </td>
            </tr>
            <tr>
                <td>IdPilot2:</td>
                <td>
                    <%
                        out.println(personal.getIdPilot2());
                    %>
                </td>
            </tr>
            <tr>
                <td>IdShturman:</td>
                <td>
                    <%
                        out.println(personal.getIdShturman());
                    %>
                </td>
            </tr>
            <tr>
                <td>IdRadist:</td>
                <td>
                    <%
                        out.println(personal.getIdRadist());
                    %>
                </td>
            </tr>
            <tr>
                <td>IdSt1:</td>
                <td>
                    <%
                        out.println(personal.getIdSt1());
                    %>
                </td>
            </tr>
            <tr>
                <td>IdSt2:</td>
                <td>
                    <%
                        out.println(personal.getIdSt2());
                    %>
                </td>
            </tr>
            <tr>
                <td>IdSt3:</td>
                <td>
                    <%
                        out.println(personal.getIdSt3());
                    %>
                </td>
            </tr>
            <tr>
                <td>IdOrder:</td>
                <td>
                    <%
                        out.println(personal.getIdOrder());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>
<button onclick="location.href='/aviacompany_project/personals'">All Personals Table</button>
</div>
</body>
</html>
