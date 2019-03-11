<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 10.03.2019
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang" var="bd" scope="application"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/datatables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/fullcalendar.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/bootadmin.min.css">

    <style>
        body {
            padding-top: 65px;
        }
    </style>

    <title>Make bet</title>
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
    <a class="navbar-brand" href="https://bootadmin.net"><fmt:message key="title.totalizator" bundle="${bd}"/></a>

    <div class="navbar-collapse collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a href="#" id="dd_user" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${sessionScope.user.firstName} ${sessionScope.user.lastName}</a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dd_user">
                    <a href="#" class="dropdown-item">Profile</a>
                    <a href="${pageContext.request.contextPath}/bets?command=log_out" class="dropdown-item"><fmt:message key="button.logOut" bundle="${bd}"/></a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<main class="container w-75 p-3">
    <div class="card mb-4">
        <div class="card-body">
            <label for="selectCompetition"><fmt:message key="text.bet.selectCompetition" bundle="${bd}"/></label>
            <div class="list-group" id="selectCompetition">

    <c:if test="${requestScope.bets == null}">
        <div class="text-center mb-4 p-3 alert alert-warning" role="alert">
            <h5><fmt:message key="message.bet.noBets" bundle="${bd}"/></h5>
        </div>
    </c:if>
    <c:if test="${requestScope.bets != null}">
        <div class="card mb-4">
            <div class="card-body">
                <table id="example" class="table table-hover" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th><fmt:message key="text.bet.event" bundle="${bd}"/></th>
                        <th><fmt:message key="text.bet.factor" bundle="${bd}"/></th>
                        <th><fmt:message key="text.bet.minimumValue" bundle="${bd}"/></th>
                        <th class="actions"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="bet" items="${requestScope.bets}">
                        <tr>
                            <td><c:out value="${bet.event.event}"/></td>
                            <td><c:out value="${bet.event.factor}"/></td>
                            <td><c:out value="${bet.minValue}"/></td>
                            <td>
                                <form method="POST" action=${pageContext.request.contextPath}/bets?command=make_bet4&id=${bet.id}>
                                    <button class="btn btn-icon btn-pill btn-primary" data-toggle="tooltip" type="submit"><fmt:message key="button.makeBet" bundle="${bd}"/></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>

            </div>
        </div>
    </div>
</main>

<!-- Footer -->
<footer class="sticky-footer bg-dark">
    <div class="container">
        <ul class="list-unstyled list-inline text-center py-2">
            <%---------------realisation-------------%>
            <li class="list-inline-item">
                <a href="${pageContext.request.contextPath}/bets?command=to_account" class="btn btn-outline-light btn-rounded"><fmt:message key="button.toAccount" bundle="${bd}"/></a>
            </li>
        </ul>
    </div>
    <div class="footer-copyright text-center py-3" style="color: #7abaff">Created by Dima Gritsuk
    </div>
</footer>
<!-- Footer -->

<script src="${pageContext.request.contextPath}/static/script/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/script/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/static/script/js/datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/script/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/static/script/js/fullcalendar.min.js"></script>
<script src="${pageContext.request.contextPath}/static/script/js/bootadmin.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>

<script async src="https://www.googletagmanager.com/gtag/js?id=UA-118868344-1"></script>
<script>
    window.dataLayer = window.dataLayer || [];

    function gtag() {
        dataLayer.push(arguments);
    }

    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
        google_ad_client: "ca-pub-4097235499795154",
        enable_page_level_ads: true
    });
</script>

</body>
</html>
