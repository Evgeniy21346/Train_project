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
<a href=${"waypoint/add?id="}<c:out value='${0}'/>>
    <button class="add_button">
        Добавить
    </button>
</a>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Название станции</th>
        <th>Время прибытия</th>
        <th>Время отправления</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="waypoints" type="java.util.List"--%>
    <c:forEach var="waypoint" items="${waypoints}">
        <tr>
            <td>
                <c:out value="${waypoint.ID}"/>
            </td>
            <td>
                <c:out value="${waypoint.station}"/>
            </td>
            <td>
                <c:out value="${waypoint.arrivalTime}"/>
            </td>
            <td>
                <c:out value="${waypoint.departureTime}"/>
            </td>
            <td>
                <a style="color: blue" href=${"waypoint/edit?id="}<c:out value='${waypoint.ID}'/>>
                    Редактировать
                </a>
                <a style="color: blue" href=${"waypoint/remove?id="}<c:out value='${waypoint.ID}'/>>
                    Удалить
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>