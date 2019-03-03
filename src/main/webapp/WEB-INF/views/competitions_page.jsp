<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 27.02.2019
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="by.gritsuk.dima.domain.Competition" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Competitions</title>--%>
    <%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>

<%--</head>--%>

<%--<body class="w3-light-grey">--%>

<%--<div class="w3-container w3-blue-grey w3-opacity w3-left-align">--%>
    <%--<h1>Totalizator</h1>--%>
<%--</div>--%>

<%--<div class="w3-container w3-padding">--%>
    <%--<h2>The list of future competitions</h2>--%>
    <%--<table class="w3-table w3-striped w3-border">--%>
        <%--<tr>--%>
            <%--<th>Kind of sport</th>--%>
            <%--<th>Participant 1</th>--%>
            <%--<th>Participant 2</th>--%>
            <%--<th>Date</th>--%>
            <%--<th>Result</th>--%>
        <%--</tr>--%>
        <%--<%--%>

            <%--List<Competition> competitions = (List<Competition>) request.getAttribute("competitions");--%>
            <%--if (competitions != null && !competitions.isEmpty()) {--%>
                <%--for (Competition s : competitions) {--%>
                    <%--out.println("<tr>" +--%>
                            <%--"<td>"+s.getKindOfSport()+"</td>" +--%>
                            <%--"<td>"+s.getParticipant1()+"</td>" +--%>
                            <%--"<td>"+s.getParticipant2()+"</td>" +--%>
                            <%--"<td>"+s.getDate()+"</td>" +--%>
                            <%--"<td>"+s.getResult()+"</td></tr>");--%>
                <%--}--%>

            <%--}      %>--%>
    <%--</table>--%>
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
    <title>Competitions</title>

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
        <h1 class="h3 mb-3 font-weight-normal">List of sport competitions</h1>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Kind of sport</th>
            <th scope="col">Participant 1</th>
            <th scope="col">Participant 2</th>
            <th scope="col">Date</th>
            <th scope="col">Result</th>
        </tr>
        </thead>
    <%
    List<Competition> competitions = (List<Competition>) request.getAttribute("competitions");

        if (competitions != null && !competitions.isEmpty()) {
            out.println("<tbody>");
            for (Competition s : competitions) {
                out.println("<tr>" +
                        "<th scope=\"row\">" + s.getId() + "</th>" +
                        "<td>" + s.getKindOfSport() + "</td>" +
                        "<td>" + s.getParticipant1() + "</td>" +
                        "<td>" + s.getParticipant2() + "</td>" +
                        "<td>" + s.getDate() + "</td>" +
                        "<td>" + s.getResult() + "</td></tr>");
            }
            out.println("</tbody>");
        }else {
            out.println("<div class=\"text-center mb-4 p-3 alert alert-warning\" role=\"alert\">" +
                    "<h5>There are no competitions</h5></div>");
        }
    %>
    </table>
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
