<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 25.02.2019
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang"  var="bd" scope="application"/>
<%--<fmt:setLocale value="${sessionScope.locale}"/>--%>

<%--<html>--%>
<%--<head>--%>
    <%--<title>Sign in</title>--%>
    <%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
<%--</head>--%>

<%--<body class="w3-light-grey">--%>
<%--<div class="w3-container w3-blue-grey w3-opacity w3-left-align">--%>
    <%--<h1>Totalizator</h1>--%>
<%--</div>--%>

<%--<div class="w3-container w3-padding">--%>
    <%--<c:if test="${loginErrors}">--%>
        <%--<div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">--%>
            <%--<h5>Incorrect login or password! Try again</h5>--%>
        <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${errors}">--%>
        <%--<jsp:forward page="error_page.jsp"></jsp:forward>--%>
    <%--</c:if>--%>
    <%--<c:if test="${enter}">--%>
        <%--<jsp:forward page="main_page.jsp"></jsp:forward>--%>
    <%--</c:if>--%>
        <%--<%--%>
            <%--if(request.getAttribute("loginErrors")!=null){--%>
                <%--out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">" +--%>
                        <%--"<h5>Incorrect login or password! Try again</h5></div>");--%>
            <%--}--%>
            <%--else if(request.getAttribute("entry")!=null){--%>
                <%--request.getRequestDispatcher("/WEB-INF/views/main_page.jsp").forward(request,response);--%>
            <%--}--%>
        <%--%>--%>
    <%--<div class="w3-card-4">--%>
        <%--<div class="w3-container w3-center w3-green">--%>
            <%--<h2>Sign In</h2>--%>
        <%--</div>--%>
        <%--<form method="POST" class="w3-selection w3-light-grey w3-padding" action="${pageContext.request.contextPath}/sign_in">--%>
            <%--<label>Login:--%>
                <%--<input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                       <%--style="width: 30%" required><br/>--%>
            <%--</label>--%>
            <%--<label>Password:--%>
                <%--<input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                       <%--style="width: 30%" required>--%>
            <%--</label>--%>
            <%--<button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Log In</button>--%>
            <%--<div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">--%>
                <%--<button class="w3-btn w3-green w3-round-large" onclick="location.href='${pageContext.request.contextPath}/restore'">Forgot the password?</button>--%>
            <%--</div>--%>
        <%--</form>--%>

    <%--</div>--%>
<%--</div>--%>



<%--<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">--%>
    <%--<button class="w3-btn w3-round-large" onclick="location.href='${pageContext.request.contextPath}/'">Back to begin</button>--%>
<%--</div>--%>
<%--</body>--%>

<%--</html>--%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Sign in</title>

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
<%
    if(request.getAttribute("loginErrors")!=null){
        out.println("<div class=\"text-center mb-4 p-3 alert alert-danger\" role=\"alert\">" +
                "<h5>Incorrect login or password! Try again</h5></div>");
    }
    else if(request.getAttribute("entry")!=null){
        request.getRequestDispatcher("/WEB-INF/views/main_page.jsp").forward(request,response);
    }
%>
<main class="container w-25 p-3">
    <form method="POST" class="form-signin" action=${pageContext.request.contextPath}/bets?command=sign_in>
        <div class="text-center mb-4">
            <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="text.signIn" bundle="${bd}"/></h1>
        </div>

        <div class="form-label-group">
            <input type="text" id="login" name="login" class="form-control"
                  placeholder="Login" required>
            <br>
        </div>

        <div class="form-label-group">
            <input type="password" id="password" name="password" class="form-control"
                  placeholder="Password" required>
            <br>
        </div>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"><fmt:message key="checkBox.remember" bundle="${bd}"/>
            </label>
        </div>
        <button class="btn btn-primary btn-lg" type="submit"><fmt:message key="button.submit" bundle="${bd}"/> </button>
    </form>
    <form method="POST" class="form-signin" action=${pageContext.request.contextPath}/bets?command=to_restore>
        <button class="btn btn-primary btn-lg" type="submit"><fmt:message key="button.forgotPassword" bundle="${bd}"/></button>
    </form>
</main>
<!-- Footer -->
<footer class="sticky-footer bg-dark">
    <div class="container">
        <ul class="list-unstyled list-inline text-center py-2">
            <%--<li class="list-inline-item">--%>
            <%--<h5 class="mb-1">Register for free</h5>--%>
            <%--</li>--%>
            <li class="list-inline-item">
                <a href="${pageContext.request.contextPath}/bets?command=main" class="btn btn-outline-light btn-rounded"><fmt:message key="button.backToMain" bundle="${bd}"/></a>
            </li>
        </ul>
    </div>
    <div class="footer-copyright text-center py-3" style="color: #7abaff">Created by Dima Gritsuk
    </div>
</footer>
<!-- Footer -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

