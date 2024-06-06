<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/" method="post">
    <h2>
        Enter login : <input name="login">
        <br><br>
        Enter password : <input name="password">
        <br><br>
        <input type="submit" value="Авторизоваться">
    </h2>
</form>
</body>
</html>
