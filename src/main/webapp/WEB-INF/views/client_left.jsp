<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 17.03.2019
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en_EN'}"/>
<fmt:setBundle basename="lang"  var="bd" scope="application"/>

    <div class="sidebar sidebar-dark bg-dark">
        <ul class="list-unstyled">
            <li><a href="${pageContext.request.contextPath}/bets?command=comp_list"><i class="fa fa-fw fa-table"></i><fmt:message key="button.competitions" bundle="${bd}"/></a></li>
            <li><a href="${pageContext.request.contextPath}/bets?command=client_bets"><i class="fa fa-fw fa-table"></i><fmt:message key="button.myBets" bundle="${bd}"/></a></li>
            <li><a href="${pageContext.request.contextPath}/bets?command=show_sports"><i class="fa fa-fw fa-table"></i><fmt:message key="button.sports" bundle="${bd}"/></a></li>
        </ul>
    </div>


