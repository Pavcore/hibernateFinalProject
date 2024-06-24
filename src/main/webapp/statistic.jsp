<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Stat</title>
</head>
<body>
<h3>
    Количество игр : ${gameQuantity}
</h3>
<h3>
    Список персонажей : ${characterList}
</h3>
<form action="${pageContext.request.contextPath}/gameWin.jsp" method="get">
    <input type="submit" value="Вернуться назад">
</form>
</body>
</html>
