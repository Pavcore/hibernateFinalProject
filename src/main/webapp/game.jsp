<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Game</title>
</head>
<body>
<h2>
    ${stage}
    <form action="${pageContext.request.contextPath}/game" method="post">
        <input type="radio" name="nextStage" value="next"> ${firstAnswer}
        <br>
        <input type="radio" name="nextStage" value="lose"> ${secondAnswer}
        <br>
        <input type="submit">
    </form>
</h2>
</body>
</html>