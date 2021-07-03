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
                FUNDACJE<br/>
            </h1>
            <ul class="help--slides-items">
                <c:forEach var="institution" items="${institutions}">
                    <li>
                        <div class="col">
                            <div class="title">${institution.name}</div>
                        </div>
                        <div class="col">
                            <div class="subtitle">${institution.description}</div>
                        </div>
                        <div class="col">
                            <div class="title"><a href="/foundation/update/${institution.id}">Update</a></div>
                        </div>
                    </li>
                </c:forEach>

                <form method="post" action="/foundation/add">
                    <li>
                        <div class="col">
                            <div class="title">
                                <input type="text" name="name" placeholder="Institution name">
                            </div>
                        </div>
                        <div class="col">
                            <div class="title">
                                <input type="text" name="description" placeholder="Description">
                            </div>
                        </div>
                        <div class="col">
                            <button class="btn" type="submit">Add</button>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </li>
                </form>
            </ul>
        </div>
    </div>
</header>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
<%@include file="footer.jsp" %>