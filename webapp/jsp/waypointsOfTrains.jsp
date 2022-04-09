<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/tables.css">
    <title>Записи</title>
</head>
<body>
<%@ include file="header.jsp" %>
<a href=${"waypointOfTrain/add?id="}<c:out value='${0}'/>>
    <button class="add_button">
        Добавить
    </button>
</a>
<table class="table">
    <thead>
    <tr>
        <th>Название точки маршрута</th>
        <th>Название поезда</th>
        <th>Номер</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="waypointsTrain" type="java.util.List"--%>
    <c:forEach var="wayTrain" items="${waypointsTrain}">
        <tr>
            <td>
                <c:out value="${wayTrain.getID_waypoint().getStation()}"/>
            </td>
            <td>
                <c:out value="${wayTrain.getID_train().getName()}"/>
            </td>
            <td>
                <c:out value="${wayTrain.getNumber()}"/>
            </td>
            <td>
                <a style="color: blue" href="waypointOfTrain/remove?id=${wayTrain.getID_waypoint().getID()}&id=${wayTrain.getID_train().getID()}&id=${wayTrain.getNumber()}">
                    Удалить
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>