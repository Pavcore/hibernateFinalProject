<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Greetings</title>
</head>
<body>
<h2>
    Приветствую странник. Я не сильно удивлен твоему появлению. Здесь появлялось много искателей приключений с тех пор,
    как начались неприятности.
    <br><br>
    Не сомневаюсь, тебе известно о трагедии, которая произошла в Тристраме. Говорят, что Диабло, Повелитель Ужаса, снова
    пришел в мир.
    <br><br>
    Не знаю, верить мне в это или нет, но Темный Странник прошел этим несколько недель назад. Он направился на восток к
    горам, пройдя путем, который охранялся Монастырем Бродяг.
    <br><br>
    Может это и ничего не значит, но зло оставило след там, где он прошел. Спустя небольшое время после его прохода,
    Монастырские Ворота закрылись, и странные существа начали появляться в стране.
    <br><br>
    До тех пор, пока за пределами лагеря не станет безопасней и ворота снова не откроются, я буду оставаться здесь со
    своим караваном. Я надеюсь, что доберусь до Лут Голейна прежде, чем тень из Тристрама поглотит нас всех. Если вы
    будете живы и будете здесь, я могу взять вас с собой.
    <br><br>
    Советую поговорить с Акарой. Похоже, что она руководит этим лагерем. Может, она скажет вам больше.
    <br><br>
    <form action="${pageContext.request.contextPath}/home" method="post">
        Введите имя персонажа: <input name="characterName"/>
        <br><br>
        Выберите класс персонажа:
        <select name="characterClass">
            <option>Barbarian</option>
            <option>Paladin</option>
            <option>Sorcerer</option>
            <option>Necromancer</option>
            <option>Amazon</option>
            <option>Druid</option>
            <option>Assassin</option>
        </select>
        <br>
        <input type="submit" value="Играть">
    </form>
    <br>
    <form action="${pageContext.request.contextPath}/home" method="post">
        Если вы хотите поиграть за ранее созданного персонажа, введите его имя : <input name="createCharacter"/>
        <br>
        <input type="submit" value="Играть">
    </form>
</h2>
</body>
</html>