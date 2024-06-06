<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>You win</title>
</head>
<body>
<h2>
    После возвращения вы видите радостные лица жителей лагеря. Все благодарят вас за помощь. Варрив предлагает отправиться на восток.
    <br>
    Вы прошли игру! Поздравляю!
    <br>
    <form action="${pageContext.request.contextPath}/home.jsp" method="get">
        <input type="submit" value="Начать сначала">
    </form>
    <form action="${pageContext.request.contextPath}/statistic.jsp" method="get">
        <input type="submit" value="Посмотреть статистику">
    </form>
</h2>
</body>
</html>
