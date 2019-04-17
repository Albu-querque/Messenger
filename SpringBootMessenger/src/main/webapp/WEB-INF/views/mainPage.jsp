<%--
  Created by IntelliJ IDEA.
  User: albuquerque
  Date: 17.04.19
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main page</title>
</head>
<body>
        <form:form method="post" action="/users/addUser" modelAttribute="emptyUserForAdded">
            <form:label path="name" for="name">Введите имя:</form:label>
            <form:input type="text" path="name" id="name"/>
            <br>
            <form:label path="password" for="password">Введите пароль:</form:label>
            <form:input type="password" path="password" id="password"/>
            <br>
            <form:label path="email" for="email">Введите email:</form:label>
            <form:input type="email" path="email" id="email"/>
            <br>
            <form:button type="submit" id="AddUser">Отправить</form:button>
        </form:form>
    <br>
    <br>
        <c:forEach items="${listUsers}" var="i">
            <b><p>${i.name}</p></b>
            <b><p>${i.password}</p></b>
            <b><p>${i.email}</p></b>
            <br>
        </c:forEach>
</body>
</html>
