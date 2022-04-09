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
<%--@elvariable id="train" type="vsu.kolesnikov.сomponents.Train"--%>
<form class="action_form" action="${"add"}" method="post">
    <h2>
        Добавить
    </h2>

    <fieldset>
        <label>
            Название поезда:
        </label>
        <label>
            <input type="text"
                   value="<c:out value='${train.name}' />"
                   name="name" required="required">
        </label>
    </fieldset>

    <fieldset>
        <label>
            Маршрут:
        </label>
        <label>
            <input type="text"
                   value="<c:out value='${train.route}' />"
                   name="route" required="required">
        </label>
    </fieldset>

    <div>
        <button type="submit" class="save_button">
            Сохранить
        </button>
    </div>
</form>
<form class="action_form" action="${pageContext.request.contextPath}/train" method="post">
    <div>
        <input type="submit" class="save_button" value="Вернуться"/>
    </div>
</form>
</body>
</html>
