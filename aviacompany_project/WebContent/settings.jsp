<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<style>
body {
	background-image: url("images/air2.jpg");
}

.no-background {
	background-image: url("images/blank.jpg");
}
</style>
<body>
<div align="center" style="padding-top: 15%">
	<form action="changeLocale.jsp" method="post">
		<fmt:message key="settings_jsp.label.set_locale"/>:
		<select name="locale">
			<c:forEach items="${applicationScope.locales}" var="locale">
				<c:set var="selected" value="${locale.key == currentLocale ? 'selected' : '' }"/>
				<option value="${locale.key}" ${selected}>${locale.value}</option>
			</c:forEach>
		</select>
		<input type="submit" value="<fmt:message key='settings_jsp.form.submit_save_locale'/>">
		
	</form>
	<a href="index.jsp"><fmt:message key="settings_jsp.link.back_to_main_page"></fmt:message></a>
	</div>
</body>
</html>