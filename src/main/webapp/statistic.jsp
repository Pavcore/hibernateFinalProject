<%@page import="com.javarush.korchagin.service.GameService" %>
<%@page import="com.javarush.korchagin.dbo.CharacterRepository" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Stat</title>
</head>
<body>
<h3>
    Количество игр : ${GameService.getInstance().gameQuantity()}
</h3>
<h3>
    Список персонажей : ${CharacterRepository.getAll()}
</h3>
<form action="${pageContext.request.contextPath}/gameWin.jsp" method="get">
    <input type="submit" value="Вернуться назад">
</form>
</body>
</html>
