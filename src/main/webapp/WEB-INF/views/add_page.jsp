<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 20.02.2019
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang"  var="bd" scope="application"/>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Add new user</title>--%>
    <%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
<%--</head>--%>

<%--<body class="w3-light-grey">--%>
<%--<div class="w3-container w3-blue-grey w3-opacity w3-left-align">--%>
    <%--<h1>Totalizator</h1>--%>
<%--</div>--%>

<%--<div class="w3-container w3-padding">--%>
    <%--&lt;%&ndash;<c:if test="${errors}">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<jsp:forward page="error_page.jsp"></jsp:forward>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
    <%--<%--%>
        <%--if (request.getAttribute("user") != null) {--%>
            <%--out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +--%>
                    <%--"   <span onclick=\"this.parentElement.style.display='none'\"\n" +--%>
                    <%--"   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +--%>
                    <%--"   <h5>User '" + request.getAttribute("user") + "' added!</h5>\n" +--%>
                    <%--"</div>");--%>
        <%--}--%>
    <%--%>--%>
    <%--<div class="w3-card-4">--%>
        <%--<div class="w3-container w3-center w3-green">--%>
            <%--<h2>Add user</h2>--%>
        <%--</div>--%>
        <%--&lt;%&ndash;<form method="POST" class="w3-selection w3-light-grey w3-padding" action="${pageContext.request.contextPath}?command=add_user">&ndash;%&gt;--%>
        <%--<form method="POST" class="w3-selection w3-light-grey w3-padding" action="${pageContext.request.contextPath}/add">--%>
            <%--<label>First name:--%>
                <%--<input type="text" name="first_name" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                       <%--pattern="^[a-zA-Z]+$" style="width: 30%" required><br/>--%>
            <%--</label>--%>
            <%--<label>Last name:--%>
                <%--<input type="text" name="last_name" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                       <%--pattern="^[a-zA-Z]+$" style="width: 30%" required><br/>--%>
            <%--</label>--%>
            <%--<label>Email:--%>
                <%--<input type="text" name="email" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                       <%--pattern="^[\w\.-]+@[_a-zA-Z]+\.[a-z]{2,3}$" style="width: 30%" required><br/>--%>
            <%--</label>--%>
            <%--<label>Login:--%>
                <%--<input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                       <%--pattern="^[\w]+$" style="width: 30%" required><br/>--%>
            <%--</label>--%>
            <%--<label>Password:--%>
                <%--<input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                       <%--pattern="^[\w]+$" style="width: 30%" required><br/>--%>
            <%--</label>--%>
            <%--<button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</div>--%>

<%--<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">--%>
    <%--<button class="w3-btn w3-round-large" onclick="location.href='${pageContext.request.contextPath}/'">Back to begin</button>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Creating new account</title>

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
<main class="container w-25 p-3">
<form method="POST" class="form-signin" action=${pageContext.request.contextPath}/bets?command=sign_up>
    <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="text.createAccount" bundle="${bd}"/></h1>
        <p><fmt:message key="text.createAccount.addition" bundle="${bd}"/></p>
    </div>

    <div class="form-label-group">
        <input type="text"  id="first_name" name="first_name" class="form-control"
               pattern="^[a-zA-Z]+$" placeholder="First Name" required autofocus>
        <br>
    </div>

    <div class="form-label-group">
        <input type="text" id="last_name" name="last_name" class="form-control"
               pattern="^[a-zA-Z]+$" placeholder="Last Name" required>
        <br>
    </div>

    <div class="form-label-group">
        <input type="text" id="login" name="login" class="form-control"
               pattern="^[\w]+$" placeholder="Login" required>
        <br>
    </div>

    <div class="form-label-group">
        <input type="email" id="email" name="email" class="form-control"
               pattern="^[\w\.-]+@[_a-zA-Z]+\.[a-z]{2,3}$" placeholder="Email address" required>
        <br>
    </div>

    <div class="form-label-group">
        <input type="password" id="password" name="password" class="form-control"
               pattern="^[\w]+$" placeholder="Password" required>
        <small class="text-muted">
            <fmt:message key="text.password.restriction" bundle="${bd}"/>
        </small>
        <br>
    </div>
    <br>
    <button class="btn btn-primary btn-lg" type="submit"><fmt:message key="button.submit" bundle="${bd}"/></button>
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
