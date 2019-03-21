<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang"  var="bd" scope="application"/>

<!doctype html>
<html>
<head>
    <title>Totalizator(Demo)</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Totalizator(Demo)</title>


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
    <link href="${pageContext.request.contextPath}/static/script/starter-template.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#"><fmt:message key="title.totalizator" bundle="${bd}"/> </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/bets?command=add_user"><fmt:message key="button.addUser" bundle="${bd}"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/bets?command=comp_list"><fmt:message key="button.competitions" bundle="${bd}"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/bets?command=show_sports"><fmt:message key="button.sports" bundle="${bd}"/></a>
            </li>
            <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>--%>
                <%--<div class="dropdown-menu" aria-labelledby="dropdown01">--%>
                    <%--<a class="dropdown-item" href="#">Action</a>--%>
                    <%--<a class="dropdown-item" href="#">Another action</a>--%>
                    <%--<a class="dropdown-item" href="#">Something else here</a>--%>
                <%--</div>--%>
            <%--</li>--%>
            <c:if test="${ empty sessionScope.user}">
            <li class="nav-item">
                <a class="nav-link active html-editor-align-right" href="${pageContext.request.contextPath}/bets?command=to_sign_in"><fmt:message key="button.signIn" bundle="${bd}"/></a>
            </li>
            </c:if>
            <c:if test="${ not empty sessionScope.user}">
                <li class="nav-item">
                    <a class="nav-link active html-editor-align-right" href="${pageContext.request.contextPath}/bets?command=log_out"><fmt:message key="button.logOut" bundle="${bd}"/></a>
                </li>
            </c:if>
        </ul>
        <ul class="navbar-nav ml-md-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/bets?command=change_lang&local=ru_RU"><img src="${pageContext.request.contextPath}/static/Russia.jpg" alt="Ru" width="27" height="33" class="img-fluid "></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/bets?command=change_lang&local=en_EN"><img src="${pageContext.request.contextPath}/static/Britain.png" alt="En" width="27" height="33" class="img-fluid "></a>
            </li>
        </ul>
        <%--<form class="form-inline my-2 my-lg-0">--%>
            <%--<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">--%>
            <%--<button class="btn btn-outline-success" type="submit"><fmt:message key="button.search" bundle="${bd}"/></button>--%>
        <%--</form>--%>
    </div>
</nav>

<main role="main" class="container w-75">

    <%--<div class="starter-template">--%>
        <%--<h1>Bootstrap starter template</h1>--%>
        <%--<p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>--%>
    <%--</div>--%>
        <div id="carouselCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselCaptions" data-slide-to="1"></li>
                <li data-target="#carouselCaptions" data-slide-to="2"></li>
                <li data-target="#carouselCaptions" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="${pageContext.request.contextPath}/static/frontPicture1.jpg" class="d-block w-100" height="650" width="1000">
                    <div class="carousel-caption d-none d-md-block">
                        <h2 style="color: black"><fmt:message key="text.front.picture1" bundle="${bd}"/></h2>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/static/frontPicture2.jpg" class="d-block w-100" height="650" width="1000">
                    <div class="carousel-caption d-none d-md-block">
                        <h2 style="color: rgba(68,197,23,0.74)"><fmt:message key="text.front.picture2" bundle="${bd}"/></h2>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/static/frontPicture3.jpg" class="d-block w-100" height="650" width="1000">
                    <div class="carousel-caption d-none d-md-block">
                        <h2 style="color: black"><fmt:message key="text.front.picture3" bundle="${bd}"/></h2>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/static/frontPicture4.jpg" class="d-block w-100" height="650" width="1000">
                    <div class="carousel-caption d-none d-md-block">
                        <h2 style="color: rgba(90,188,29,0.98)"><fmt:message key="text.front.picture4" bundle="${bd}"/></h2>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>


</main><!-- /.container -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

<%--http://themehunt.com/item/1527563-corlate-free-business-agency-wordpress-theme-with-page-builder/preview--%>
<%--https://bootswatch.com/cyborg/--%>
<%--https://bootadmin.net/demo/datatables--%>