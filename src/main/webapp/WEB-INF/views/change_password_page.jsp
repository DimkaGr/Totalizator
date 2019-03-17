<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 15.03.2019
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang"  var="bd" scope="application"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Change password</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/bootstrap.min.css" >
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >--%>


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.3/examples/floating-labels/" rel="stylesheet">
</head>
<body style="background-color: #eee;">
<div style="background-color: rgba(13,24,46,0.38);" >
    <br>
    <h1 class="h1 mr-md-auto font-weight-normal" style="color:white"><fmt:message key="title.totalizator" bundle="${bd}"/></h1>
    <br>
</div>

<c:if test="${requestScope.passwordError != null}">
    <div class="text-center mb-4 p-3 alert alert-danger" role="alert">
        <h5><fmt:message key="message.changePassword" bundle="${bd}"/> </h5>
    </div>
</c:if>

<main class="container w-25 p-3">
    <form method="POST" class="form-signin" action=${pageContext.request.contextPath}/bets?command=change_password>
        <div class="text-center mb-4">
            <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="text.password.change" bundle="${bd}"/></h1>
        </div>

        <div class="form-label-group">
            <input type="password" id="password" name="password" class="form-control"
                   pattern="^[\w]+$" placeholder="New password" required>
            <br>
            <small class="text-muted">
                <fmt:message key="text.password.restriction" bundle="${bd}"/>
            </small>
        </div>

        <div class="form-label-group">
            <input type="password" id="passwordRep" name="passwordRep" class="form-control"
                   pattern="^[\w]+$" placeholder="Repeat password" required>
            <br>
        </div>

        <button class="btn btn-primary btn-lg" type="submit"><fmt:message key="button.submit" bundle="${bd}"/> </button>
    </form>
</main>
<!-- Footer -->
<footer class="sticky-footer bg-dark">
    <div class="footer-copyright text-center py-3" style="color: #7abaff">Created by Dima Gritsuk
    </div>
</footer>
<!-- Footer -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
