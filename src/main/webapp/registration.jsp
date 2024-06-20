<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/" method="post">
    <h2>
        Come up with login : <input name="login">
        <br><br>
        Come up with password : <input name="password">
        <br><br>
        <input type="submit" value="Зарегистрироваться">
    </h2>
</form>
<form action="login.jsp" method="post">
    <input type="submit" value="Уже зарегистрирован">
</form>
</body>
</html>
