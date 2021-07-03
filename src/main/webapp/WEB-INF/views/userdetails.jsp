<%@include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Stuff4U</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--form-page">

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                UŻYTKOWNIK<br/>
            </h1>
            <form method="post">
                <div class="form-group">
                    <input type="text" name="name" placeholder="${user.name}" value="${user.name}">
                </div>
                <div class="form-group">
                    <input type="text" name="username" placeholder="${user.username}" value="${user.username}">
                </div>
                <input type="hidden" name="id" value="${user.id}"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group form-group--buttons">
                    <button class="btn" type="submit">Update</button>
                    <a href="/admin/users/disable/${user.id}" class="btn btn--without-border">Toggle Account</a>
                    <a href="/admin/users/delete/${user.id}" class="btn btn--without-border">Delete</a>
                </div>
            </form>
        </div>
    </div>
</header>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
<%@include file="footer.jsp" %>