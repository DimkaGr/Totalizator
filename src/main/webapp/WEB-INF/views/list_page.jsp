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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang" var="bd" scope="application"/>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/datatables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/fullcalendar.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/script/css/bootadmin.min.css">
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
<div style="background-color: rgba(13,24,46,0.38);">
    <br>
    <h1 class="h1 mr-md-auto font-weight-normal" style="color:white"><fmt:message key="title.totalizator" bundle="${bd}"/></h1>
    <br>
</div>
<main class="container w-75 p-3">
    <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="text.users.list" bundle="${bd}"/></h1>
    </div>
    <%--<%--%>
        <%--List<User> users = (List<User>) request.getAttribute("users");--%>

        <%--if (users != null && !users.isEmpty()) {--%>
            <%--String delete;--%>
            <%--if (session.getAttribute("locale") == null || session.getAttribute("locale").equals("en_EN")) {--%>
                <%--delete = "Delete";--%>
            <%--} else {--%>
                <%--delete = "Удалить";--%>
            <%--}--%>
            <%--for (User user : users) {--%>
                <%--out.println("<div class=\"card w-50\">" +--%>
                        <%--"  <div class=\"card-body\">" +--%>
                        <%--"    <h5 class=\"card-title\">" + user.getLogin() + "</h5>" +--%>
                        <%--"    <p class=\"card-text\">" + user.getFirstName() + " " + user.getLastName() + "," + user.getEmail() + "</p>" +--%>
<%--//                        "    <a href=\"${pageContext.request.contextPath}/bets?command=delete&id="+user.getId()+"\" class=\"btn btn-primary\">Delete</a>" +--%>
                        <%--"    <a href=\"#\" class=\"btn btn-primary\">" + delete + "</a>" +--%>
                        <%--"  </div>\n" +--%>
                        <%--"</div>");--%>
            <%--}--%>
        <%--} else {--%>
            <%--out.println("<div class=\"text-center mb-4 p-3 alert alert-warning\" role=\"alert\">" +--%>
                    <%--"<h5>There are no users here</h5></div>");--%>
        <%--}--%>
    <%--%>--%>
    <c:if test="${requestScope.users eq null}">
        <div class="text-center mb-4 p-3 alert alert-warning" role="alert">
            <h5><fmt:message key="message.noUsers" bundle="${bd}"/></h5>
        </div>
    </c:if>
    <c:if test="${requestScope.users != null}">
        <div class="card mb-4">
            <div class="card-body">
                <table id="example" class="table table-hover" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th><fmt:message key="text.user.firstName" bundle="${bd}"/></th>
                        <th><fmt:message key="text.user.lastName" bundle="${bd}"/></th>
                        <th><fmt:message key="text.user.login" bundle="${bd}"/></th>
                        <th><fmt:message key="text.user.email" bundle="${bd}"/></th>
                        <th><fmt:message key="text.user.status" bundle="${bd}"/></th>
                        <th class="actions"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="client" items="${requestScope.users}">
                        <tr>
                            <td><c:out value="${client.firstName}"/> </td>
                            <td><c:out value="${client.lastName}"/></td>
                            <td><c:out value="${client.login}"/></td>
                            <td><c:out value="${client.email}"/></td>
                            <c:if test="${client.status eq 'active'}">
                                <td><span class="badge badge-pill badge-success">Active</span></td>
                            </c:if>
                            <c:if test="${client.status eq 'banned'}">
                                <td><span class="badge badge-pill badge-danger">Banned</span></td>
                            </c:if>
                            <c:if test="${client.status eq 'waiting_confirmation'}">
                                <td><span class="badge badge-pill badge-warning">Waiting confirmation</span></td>
                            </c:if>
                            <td>
                                <form method="POST" action=${pageContext.request.contextPath}/bets?command=delete&id=${client.id}>
                                    <button class="btn btn-icon btn-pill btn-danger" data-toggle="tooltip" type="submit"><i class="fa fa-fw fa-trash"></i></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>

</main>
<!-- Footer -->
<footer class="sticky-footer bg-dark">
    <div class="container">
        <ul class="list-unstyled list-inline text-center py-2">
            <c:if test="${sessionScope.role == null}">
                <li class="list-inline-item">
                    <a href="${pageContext.request.contextPath}/bets?command=main" class="btn btn-outline-light btn-rounded"><fmt:message key="button.backToMain" bundle="${bd}"/></a>
                </li>
            </c:if>
            <c:if test="${sessionScope.role != null}">
                <li class="list-inline-item">
                    <a href="${pageContext.request.contextPath}/bets?command=to_account" class="btn btn-outline-light btn-rounded"><fmt:message key="button.toAccount" bundle="${bd}"/></a>
                </li>
            </c:if>
        </ul>
    </div>
    <div class="footer-copyright text-center py-3" style="color: #7abaff">Created by Dima Gritsuk
    </div>
</footer>
<!-- Footer -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/static/script/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
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

<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({
        google_ad_client: "ca-pub-4097235499795154",
        enable_page_level_ads: true
    });
</script>
</body>
</html>

