
<%@ page isELIgnored = "false"  contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>--%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        <%@ include file="/css/home.css" %>
    </style>
</head>
<body align="center">

<div class="rect">
</div>
<form id="logout" action="/index">
    <p>click here for <a href="index">logout</a></p>
</form>

<form id="home" method="get" action="" autocomplete="off">
    <h1>Books</h1>

    <jstl:if test="${role eq 'ADMIN'}">
        <button class="plus" type="submit">&#xf067;</button>
        <button class="minus" type="submit">&#xf068;</button>
    </jstl:if>

<jstl:forEach var="book" items="${books}">
    <div class="book">
        <h2>${book.getTitle()}</h2>
        <h3>${book.getAuthorFirstName()} ${book.getAuthorLastName()}</h3>
    </div>
</jstl:forEach>

</form>


</body>
</html>
