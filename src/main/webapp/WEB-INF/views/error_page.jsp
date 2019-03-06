<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 22.02.2019
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Failed registration</title>--%>
    <%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
<%--</head>--%>
<%--<body class="w3-light-grey">--%>
<%--<div class="container">--%>
    <%--<div class="picture">--%>
        <%--<img src="../../static/errorPic.jpg" height=330px" width="500px" alt="Oops!">--%>
    <%--</div>--%>
    <%--<div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">--%>
       <%--&lt;%&ndash;<span class="w3-button w3-margin-right w3-display-center w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey"></span>&ndash;%&gt;--%>
    <%--<h5>Your input data is not valid! Try to registr again or return to menu</h5>--%>
    <%--</div>--%>
    <%--<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">--%>
        <%--<button class="w3-btn w3-round-large" onclick="location.href='${pageContext.request.contextPath}/'">Back to begin</button>--%>
        <%--<button class="w3-btn w3-round-large" onclick="location.href='${pageContext.request.contextPath}/add'">Try to register again</button>--%>
    <%--</div>--%>
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
    <title>Error</title>

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
    <h1 class="h1 mr-md-auto font-weight-normal" style="color:white">Totalizator</h1>
    <br>
</div>
<main class="container w-75 p-3">
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <h1 class="display-4 font-weight-normal">Something went wrong</h1>
        </div>

        <div>
            <div class="text-center">
                <img src="${pageContext.request.contextPath}/static/errorPic.jpg" alt="You'r welcome!" class="img-fluid ">
            </div>
        </div>

        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/bets?command=main">Back to main</a>
        </div>

        <div class="product-device box-shadow d-none d-md-block"></div>
        <div class="product-device product-device-2 box-shadow d-none d-md-block"></div>
    </div>

</main>
<!-- Footer -->
<footer class="sticky-footer bg-dark">
    <div class="container">
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
