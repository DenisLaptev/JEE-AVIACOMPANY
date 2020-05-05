<%@ page import="java.util.List" %>
<%@ page import="main.java.model.Person" %>
<%@ page import="main.java.model.Personal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title><fmt:message key="views.persons.selectFreePerson_jsp.title.Free_Person" /></title>
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

    <%
        String profession = (String) request.getAttribute("profession");
        int idPersonal = (int) request.getAttribute("idPersonal");
        out.println("<h1>All " + profession + " Table</h1>");
    %>



<br>


<div>
    <button onclick="location.href='/aviacompany_project/my-account'"><fmt:message key="views.persons.selectFreePerson_jsp.button.Back_to_main_page" />
    </button>
    <button onclick="location.href='/aviacompany_project/add-person'"><fmt:message key="views.persons.selectFreePerson_jsp.button.Add_Person" />
    </button>

</div>
<br>
<br>
<div>
    <div>


        <%
            List<Person> persons = (List<Person>) request.getAttribute("freePersons");
            if (persons != null && !persons.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600">
            <thead>
            <tr>
                <th>IdPerson</th>
                <th>idPersonal</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Profession</th>
              
                <th>ADD TO PERSONAL</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Person person : persons) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/aviacompany_project/person-by-id?id=" + person.getIdPerson() + "\">"
                            + person.getIdPerson() + "</a></td>");
                    out.println("<td>" + person.getIdPersonal() + "</td>");
                    out.println("<td>" + person.getFirstName() + "</td>");
                    out.println("<td>" + person.getLastName() + "</td>");
                    out.println("<td>" + person.getProfession() + "</td>");

               
                    out.println("<td><a href=\"/aviacompany_project/add-to-personal?id=" + person.getIdPerson() + "&profession=" + profession+ "&idPersonal=" + idPersonal
                            + "\">ADD TO PERSONAL</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no persons yet!</p>");
            }
        %>

    </div>
</div>

<br>

<div>
    <button onclick="location.href='/aviacompany_project/my-account'">Back to main
        page
    </button>
    <button onclick="location.href='/aviacompany_project/add-person'">Add
        Person
    </button>
</div>
</div>
</body>
</html>
