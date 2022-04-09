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
<a href=${"train/add?id="}<c:out value='${0}'/>>
    <button class="add_button">
        Добавить
    </button>
</a>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Маршрут</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="trains" type="java.util.List"--%>
    <c:forEach var="train" items="${trains}">
        <tr>
            <td>
                <c:out value="${train.ID}"/>
            </td>
            <td>
                <c:out value="${train.name}"/>
            </td>
            <td>
                <c:out value="${train.route}"/>
            </td>
            <td>
                <a style="color: blue" href=${"train/edit?id="}<c:out value='${train.ID}'/>>
                    Редактировать
                </a>
                <a style="color: blue" href=${"train/remove?id="}<c:out value='${train.ID}'/>>
                    Удалить
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>