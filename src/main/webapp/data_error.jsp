<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>No login</title>
</head>
<body>
<h2>
    ${incorrectData}
    <form action="${jspPath}" method="get">
            <br>
            <input type="submit" value="Попробовать снова">
    </form>
</h2>
</body>
</html>