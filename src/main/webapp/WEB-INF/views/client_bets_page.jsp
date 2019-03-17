<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 17.03.2019
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang"  var="bd" scope="application"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>My bets</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/datatables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/fullcalendar.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/bootadmin.min.css">

    <style>
        body {
            padding-top: 46px;
        }
    </style>

    <%--<style>--%>

        <%--@media (min-width: 768px) {--%>
            <%--.bd-placeholder-img-lg {--%>
                <%--font-size: 3.5rem;--%>
            <%--}--%>
        <%--}--%>
    <%--</style>--%>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.3/examples/floating-labels/" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
    <a class="navbar-brand" href="#"><fmt:message key="title.totalizator" bundle="${bd}"/></a>

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

<div class="d-flex">
    <jsp:include page="client_left.jsp"/>
    <div class="text-center mb-4">
        <div class="content p-4">
            <div class="text-center mb-4">
                <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
                <!-- Responsive -->
                <ins class="adsbygoogle"
                     style="display:block"
                     data-ad-client="ca-pub-4097235499795154"
                     data-ad-slot="5211442851"
                     data-ad-format="auto"></ins>
                <script>
                    (adsbygoogle = window.adsbygoogle || []).push({});
                </script>
            </div>
            <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="text.bets.myBets" bundle="${bd}"/></h1>
            <c:if test="${requestScope.clientBets == null}">
                <div class="text-center mb-4 p-3 alert alert-warning" role="alert">
                    <h5><fmt:message key="text.bets.noMyBets" bundle="${bd}"/> </h5>
                </div>
                <div class="card mb-4">
                    <div class="card-body">
                        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/bets?command=make_bet1" class="dropdown-item"><fmt:message key="button.makeBet" bundle="${bd}"/></a>
                    </div>
                </div>
            </c:if>
            <c:if test="${requestScope.clientBets != null}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col"><fmt:message key="text.competitions.sport" bundle="${bd}"/></th>
                    <th scope="col"><fmt:message key="text.competitions.name" bundle="${bd}"/></th>
                    <th scope="col"><fmt:message key="text.bet.event" bundle="${bd}"/></th>
                    <th scope="col"><fmt:message key="text.betevent.factor" bundle="${bd}"/></th>
                    <th scope="col"><fmt:message key="text.bet.yourAmount" bundle="${bd}"/></th>
                    <th scope="col"><fmt:message key="text.bet.expected" bundle="${bd}"/></th>
                    <th scope="col"><fmt:message key="text.bets.status" bundle="${bd}"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bet" items="${requestScope.clientBets}">
                    <tr>
                        <td><c:out value="${bet.kindOfSport}"/></td>
                        <td><c:out value="${bet.competitionName}"/></td>
                        <td><c:out value="${bet.event}"/></td>
                        <td><c:out value="${bet.factor}"/></td>
                        <td><c:out value="${bet.deposit}"/></td>
                        <td><c:out value="${bet.income}"/></td>
                        <td><c:out value="${bet.status}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
                </c:if>
            </table>
        </div>
    </div>
</div>
<!-- Footer -->
<footer class="sticky-footer bg-dark">
    <div class="container">
        <ul class="list-unstyled list-inline text-center py-2">
            <li class="list-inline-item">
                <a href="${pageContext.request.contextPath}/bets?command=to_account" class="btn btn-outline-light btn-rounded"><fmt:message key="button.toAccount" bundle="${bd}"/></a>
            </li>
        </ul>
    </div>
    <div class="footer-copyright text-center py-3" style="color: #7abaff">Created by Dima Gritsuk
    </div>
</footer>
<!-- Footer -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
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
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

<script async src="pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
        google_ad_client: "ca-pub-4097235499795154",
        enable_page_level_ads: true
    });
</script>
</body>
</html>
