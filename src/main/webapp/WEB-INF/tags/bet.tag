<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:directive.attribute name="message" required="true" description="localized message"/>

<c:if test="${message != null}">
    <div class="text-center mb-4 p-3 alert alert-warning" role="alert">
        <fmt:message key="${message}" bundle="${bd}"/>
    </div>
</c:if>
