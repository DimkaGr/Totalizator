<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 19.03.2019
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<c:if test="${sessionScope.role == 1}">
    <jsp:forward page="admin_profile_page.jsp"/>
</c:if>
<c:if test="${sessionScope.role == 2}">
    <jsp:forward page="client_profile_page.jsp"/>
</c:if>
<c:if test="${sessionScope.role == 3}">
    <jsp:forward page="bookmaker_profile_page.jsp"/>
</c:if>
</body>
</html>
