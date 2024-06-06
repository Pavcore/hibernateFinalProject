<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>You lose</title>
</head>
<body>
<h2>
    ${loseAttribute}
    <br><br>
    <form action="${pageContext.request.contextPath}/home.jsp" method="get">
        <input type="submit" value="Начать сначала">
    </form>
</h2>
</body>
</html>
