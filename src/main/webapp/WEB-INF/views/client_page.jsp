<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.03.2019
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang"  var="bd" scope="application"/>
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
            padding-top: 46px;
        }
    </style>

    <title>My account</title>
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
                    <a href="${pageContext.request.contextPath}/bets?command=to_profile" class="dropdown-item"><fmt:message key="button.prodile" bundle="${bd}"/></a>
                    <a href="${pageContext.request.contextPath}/bets?command=log_out" class="dropdown-item"><fmt:message key="button.logOut" bundle="${bd}"/></a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<div class="d-flex">
        <jsp:include page="client_left.jsp"/>

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

        <c:if test="${requestScope.notActive != null}">
            <%--<div class="text-center mb-4 p-3 alert alert-warning" role="alert">--%>
                <%--<h5><fmt:message key="message.activate" bundle="${bd}"/></h5>--%>
            <%--</div>--%>
            <my:bet message="message.activate"> </my:bet>

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
        </c:if>
        <c:if test="${requestScope.notActive == null}">
        <div class="card mb-4">
            <div class="card-body">
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/bets?command=make_bet1" class="dropdown-item"><fmt:message key="button.makeBet" bundle="${bd}"/></a>
            </div>
        </div>
        </c:if>
    </div>
</div>

<%--<script src="https://bootadmin.net/js/jquery.min.js"></script>--%>
<%--<script src="https://bootadmin.net/js/bootstrap.bundle.min.js"></script>--%>
<%--<script src="https://bootadmin.net/js/datatables.min.js"></script>--%>
<%--<script src="https://bootadmin.net/js/moment.min.js"></script>--%>
<%--<script src="https://bootadmin.net/js/fullcalendar.min.js"></script>--%>
<%--<script src="https://bootadmin.net/js/bootadmin.min.js"></script>--%>
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
