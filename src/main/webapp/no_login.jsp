<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>No login</title>
</head>
<body>
<h2>
    <form action="${pageContext.request.contextPath}/" method="get">
            Неверный логин или пароль.
            <br>
            <input type="submit" value="Попробовать снова">
    </form>
</h2>
</body>
</html>
