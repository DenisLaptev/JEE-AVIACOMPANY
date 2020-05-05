<%@ page import="java.util.List" %>
<%@ page import="main.java.model.Flight" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title><fmt:message key="views.flights.selectFreeFlight_jsp.title.Free_Flights" /></title>
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
        String orderStatus = (String) request.getAttribute("orderStatus");
        int idOrder = (int) request.getAttribute("idOrder");
    %>
    
    <%
        out.println("<h1>All Free Flights</h1>");
    %>

<br>


<div>
    <button onclick="location.href='/aviacompany_project/my-account'"><fmt:message key="views.flights.selectFreeFlight_jsp.button.Back_to_main_page" />
    </button>

</div>
<br>
<br>
<div>
    <div>


        <%
            List<Flight> flights = (List<Flight>) request.getAttribute("freeFlights");
            if (flights != null && !flights.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600">
            <thead>
            <tr>
                <th>IdFlight</th>
                <th>Name</th>
                <th>FlightFrom</th>
                <th>FlightTo</th>
                <th>Date</th>
                <th>OrderStatus</th>
                <th>IdOrder</th>
              
                <th>ADD TO ORDER</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Flight flight : flights) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/aviacompany_project/flight-by-id?id=" + flight.getIdFlight() + "\">"
                            + flight.getIdFlight() + "</a></td>");
                    out.println("<td>" + flight.getName() + "</td>");
                    out.println("<td>" + flight.getFlightFrom() + "</td>");
                    out.println("<td>" + flight.getFlightTo() + "</td>");
                    out.println("<td>" + flight.getDate() + "</td>");
                    out.println("<td>" + flight.getOrderStatus() + "</td>");
                    out.println("<td>" + flight.getIdOrder() + "</td>");

               
                    out.println("<td><a href=\"/aviacompany_project/add-flight-to-order?id=" + flight.getIdFlight() + "&orderStatus=" + orderStatus+ "&idOrder=" + idOrder
                            + "\">ADD TO ORDER</a></td>");
                    
                  
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no flights yet!</p>");
            }
        %>

    </div>
</div>

<br>

<div>
    <button onclick="location.href='/aviacompany_project/my-account'">Back to main
        page
    </button>
</div>
</div>
</body>
</html>
