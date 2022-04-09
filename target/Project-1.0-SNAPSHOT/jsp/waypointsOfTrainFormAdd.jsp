<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/form.css">
    <title>Форма добавления</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%--@elvariable id="waypointTrain" type="vsu.kolesnikov.сomponents.WaypointTrain"--%>
<%--@elvariable id="waypoints" type="java.util.List"--%>
<%--@elvariable id="trains" type="java.util.List"--%>
<form class="action_form" action="${"add"}" method="post">
    <h2>
        Добавить
    </h2>

    <fieldset>
        <label>
            ID точки маршрута:
        </label>
        <label>
            <input type="text" list="waypointsList"
                   value="<c:out value='${waypointTrain.ID_waypoint.station}' />"
                   name="station" required="required">
            <datalist id="waypointsList">
                <c:forEach var="waypoint" items="${waypoints}">
                    <option value="<c:out value='${waypoint.station}' />"></option>
                </c:forEach>
            </datalist>
        </label>
    </fieldset>

    <fieldset>
        <label>
            ID поезда:
        </label>
        <label>
            <input type="text" list="trainsList"
                   value="<c:out value='${waypointTrain.ID_train.name}' />"
                   name="name" required="required">
            <datalist id="trainsList">
                <c:forEach var="train" items="${trains}">
                    <option value="<c:out value='${train.name}' />"></option>
                </c:forEach>
            </datalist>
        </label>
    </fieldset>

    <fieldset>
        <label>
            Номер:
        </label>
        <label>
            <input type="number"
                   value="<c:out value='${waypointTrain.number}' />"
                   min="0"
                   name="number" required="required">
        </label>
    </fieldset>

    <div>
        <button type="submit" class="save_button">
            Сохранить
        </button>
    </div>
</form>
<form class="action_form" action="${pageContext.request.contextPath}/waypointOfTrain" method="post">
    <div>
        <input type="submit" class="save_button" value="Вернуться"/>
    </div>
</form>
</body>
</html>
