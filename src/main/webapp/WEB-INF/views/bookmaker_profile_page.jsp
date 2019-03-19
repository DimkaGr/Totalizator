<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 19.03.2019
  Time: 19:50
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

    <link href="https://fonts.googleapis.com/css?family=Bitter|Margarine" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Cabin" rel="stylesheet">

    <style>
        body {
            padding-top: 46px;
        }
        .header-font{
            font-family: 'Bitter', serif;
        }
        .table-font{
            font-family: 'Cabin', sans-serif;
        }
    </style>

    <title>My profile</title>
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
    <a class="navbar-brand" href="#"><fmt:message key="title.totalizator" bundle="${bd}"/></a>

    <div class="navbar-collapse collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a href="#" id="dd_user" class="nav-link dropdown-toggle" data-toggle="dropdown"><i
                        class="fa fa-user"></i>${sessionScope.user.firstName} ${sessionScope.user.lastName}</a>
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
        <div class="container emp-profile">
            <div class="row">
                <div class="col-md-3 offset-md-3">
                    <div class="profile-head header-font">
                        <h1 ><fmt:message key="button.prodile" bundle="${bd}"/></h1>
                    </div>
                </div>
            </div>
            <br>
            <hr>
            <br>
            <div class="row table-font">
                <div class="col-md-6 offset-md-2">
                    <div class="tab-content profile-tab" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="row">
                                <div class="col-md-3">
                                    <h3><fmt:message key="text.user.firstName" bundle="${bd}"/></h3>
                                </div>
                                <div class="col-md-6">
                                    <h3><c:out value="${sessionScope.user.firstName}"/></h3>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <h3><fmt:message key="text.user.lastName" bundle="${bd}"/></h3>
                                </div>
                                <div class="col-md-6">
                                    <h3><c:out value="${sessionScope.user.lastName}"/></h3>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <h3><fmt:message key="text.user.email" bundle="${bd}"/></h3>
                                </div>
                                <div class="col-md-6">
                                    <h3><c:out value="${sessionScope.user.email}"/></h3>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <h3><fmt:message key="text.user.login" bundle="${bd}"/></h3>
                                </div>
                                <div class="col-md-6">
                                    <h3><c:out value="${sessionScope.user.login}"/></h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <hr>
        <br>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/bets?command=to_change_password" class="dropdown-item"><fmt:message key="button.changePassword" bundle="${bd}"/></a>
    </div>
    <div id="editor-js" class="playground-editor" style="height:500px;" itemprop="sampleType"></div>
</div>

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

<script async src="pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
        google_ad_client: "ca-pub-4097235499795154",
        enable_page_level_ads: true
    });
</script>

</body>
</html>