<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 26.02.2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Restore your password</title>--%>
    <%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>

<%--</head>--%>

<%--<body class="w3-light-grey">--%>

<%--<div class="w3-container w3-blue-grey w3-opacity w3-left-align">--%>
    <%--<h1>Totalizator</h1>--%>
<%--</div>--%>

<%--<div class="w3-container w3-padding">--%>
    <%--<%--%>
        <%--if(request.getAttribute("errors")!=null){--%>
            <%--out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">" +--%>
                    <%--"<h5>Incorrect login or email! Try again</h5></div>");--%>
        <%--}--%>
    <%--%>--%>
    <%--<div class="w3-card-4">--%>
        <%--<form method="POST" class="w3-selection w3-light-grey w3-padding" action="${pageContext.request.contextPath}/restore">--%>
            <%--<label>Enter your login:--%>
                <%--<input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                       <%--style="width: 30%" required><br/>--%>
            <%--</label>--%>
            <%--<label>Enter your email:--%>
                <%--<input type="text" name="email" class="w3-input w3-animate-input w3-border w3-round-large"--%>
                        <%--style="width: 30%" required><br/>--%>
            <%--</label>--%>
            <%--<button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Send message</button>--%>
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
    <title>Restore your password</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >


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
    <h1 class="h1 mr-md-auto font-weight-normal" style="color:white">Totalizator</h1>
    <br>
</div>

<main class="container w-25 p-3">
    <%
        if(request.getAttribute("errors")!=null){
            out.println("<div class=\"text-center mb-4 p-3 alert alert-danger\" role=\"alert\"> " +
                    "<h5>Incorrect login or email! Try again</h5></div");
        }
    %>
    <form method="POST" class="form-signin" action=${pageContext.request.contextPath}/bets?command=restore>
        <div class="text-center mb-4">
            <h1 class="h3 mb-3 font-weight-normal">Enter your login and email to get message</h1>
        </div>

        <div class="form-label-group">
            <input type="text" id="login" name="login" class="form-control"
                   placeholder="Login" required>
            <br>
        </div>

        <div class="form-label-group">
            <input type="email" id="email" name="email" class="form-control"
                   placeholder="Email" required>
            <br>
        </div>

        <button class="btn btn-primary btn-lg" type="submit">Send message</button>
    </form>
</main>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
