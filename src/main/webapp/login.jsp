<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/" method="post">
    <h2>
        Enter login : <label>
        <input name="login">
    </label>
        <br><br>
        Enter password : <label>
        <input name="password">
    </label>
        <br><br>
        <input type="submit" value="Авторизоваться">
    </h2>
</form>
<form action="registration.jsp" method="post">
    <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>
