<%@page import="com.javarush.korchagin.service.GameDataService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Stat</title>
</head>
<body>
<h3>
    Количество игр : ${GameDataService.getInstance().gameQuantity()}
</h3>
<h3>
    Список персонажей : ${GameDataService.getInstance().getAll()}
</h3>
<form action="${pageContext.request.contextPath}/gameWin.jsp" method="get">
    <input type="submit" value="Вернуться назад">
</form>
</body>
</html>
