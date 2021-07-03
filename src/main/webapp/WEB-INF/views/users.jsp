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
                UŻYTKOWNIKI<br/>
            </h1>
            <ul class="help--slides-items">
                <li>
                    <div class="col">
                        <div class="title">Name:</div>
                    </div>
                    <div class="col">
                        <div class="title">Username</div>
                    </div>
                    <div class="col">
                        <div class="title">Enabled: ${user.enabled}</div>
                    </div>
                    <div class="col">
                        <div class=title"><a href="/admin/users/update/${user.id}"></a></div>
                    </div>
                </li>
                <c:forEach var="user" items="${users}">
                    <li>
                        <div class="col">
                            <div class="title">${user.name}</div>
                        </div>
                        <div class="col">
                            <div class="subtitle">${user.username}</div>
                        </div>
                        <div class="col">
                            <div class="title">${user.enabled}</div>
                        </div>
                        <div class="col">
                            <div class="title"><a href="/admin/users/update/${user.id}">Update</a></div>
                        </div>
                    </li>
                </c:forEach>

            </ul>
        </div>
    </div>
</header>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
<%@include file="footer.jsp" %>