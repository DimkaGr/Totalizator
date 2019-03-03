<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 20.02.2019
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="by.gritsuk.dima.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Users list</title>--%>
    <%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
<%--</head>--%>

<%--<body class="w3-light-grey">--%>
<%--<div class="w3-container w3-blue-grey w3-opacity w3-left-align">--%>
    <%--<h1>Totalizator</h1>--%>
<%--</div>--%>

<%--<div class="w3-container w3-center w3-margin-bottom w3-padding">--%>
    <%--<div class="w3-card-4">--%>
        <%--<div class="w3-container w3-light-blue">--%>
            <%--<h2>Users</h2>--%>
        <%--</div>--%>
        <%--<%--%>
            <%--List<String> users = (List<String>) request.getAttribute("user");--%>

            <%--if (users != null && !users.isEmpty()) {--%>
                <%--out.println("<ul class=\"w3-ul\">");--%>
                <%--for (String s : users) {--%>
                    <%--out.println("<li class=\"w3-hover-sand\">" + s + "</li>");--%>
                <%--}--%>
                <%--out.println("</ul>");--%>

            <%--} else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"--%>
                    <%--+--%>
                    <%--"   <span onclick=\"this.parentElement.style.display='none'\"\n" +--%>
                    <%--"   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +--%>
                    <%--"   <h5>There are no users yet!</h5>\n" +--%>
                    <%--"</div>");--%>
        <%--%>--%>
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
    <title>User list</title>

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
<main class="container w-75 p-3">
    <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal">List of users</h1>
    </div>
    <%
        List<User> users = (List<User>) request.getAttribute("user");

        if (users != null && !users.isEmpty()) {
            for (User user : users) {
                out.println("<div class=\"card w-50\">" +
                        "  <div class=\"card-body\">" +
                        "    <h5 class=\"card-title\">"+user.getLogin()+"</h5>" +
                        "    <p class=\"card-text\">"+user.getFirstName()+" "+user.getLastName()+","+user.getEmail()+"</p>" +
                        "    <a href=\"#\" class=\"btn btn-primary\">Delete</a>" +
                        "  </div>\n" +
                        "</div>");
            }
        }else {
            out.println("<div class=\"text-center mb-4 p-3 alert alert-warning\" role=\"alert\">" +
                    "<h5>There are no users here</h5></div>");
        }
    %>
</main>
<!-- Footer -->
<footer class="sticky-footer bg-dark">
    <div class="container">
        <ul class="list-unstyled list-inline text-center py-2">
            <%--<li class="list-inline-item">--%>
            <%--<h5 class="mb-1">Register for free</h5>--%>
            <%--</li>--%>
            <li class="list-inline-item">
                <a href="${pageContext.request.contextPath}/" class="btn btn-outline-light btn-rounded">Back to start page</a>
            </li>
        </ul>
    </div>
    <div class="footer-copyright text-center py-3" style="color: #7abaff">Created by Dima Gritsuk
    </div>
</footer>
<!-- Footer -->
</body>
</html>

