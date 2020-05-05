<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Login page</title>
</head>
<body>
<fmt:setBundle basename="resources" />
<form action="<%=request.getContextPath()%>/login" method="POST">
    <p>
        <input type="text" name="userLogin" placeholder="login"/>
    </p>
    <p>
        <input type="password" name="userPassword"
               placeholder="password"/>
    </p>
    <p>
        <input type="submit" value="Send"/>
    </p>
</form>

<button onclick="location.href='<%=request.getContextPath()%>'">Back to main page</button>

</body>
</html>
