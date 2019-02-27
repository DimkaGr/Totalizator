<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 25.02.2019
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Totalizator</h1>
</div>

<div class="w3-container w3-padding">
    <%--<c:if test="${loginErrors}">--%>
        <%--<div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">--%>
            <%--<h5>Incorrect login or password! Try again</h5>--%>
        <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${errors}">--%>
        <%--<jsp:forward page="error_page.jsp"></jsp:forward>--%>
    <%--</c:if>--%>
    <%--<c:if test="${enter}">--%>
        <%--<jsp:forward page="main_page.jsp"></jsp:forward>--%>
    <%--</c:if>--%>
        <%
            if(request.getAttribute("loginErrors")!=null){
                out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">" +
                        "<h5>Incorrect login or password! Try again</h5></div>");
            }
            else if(request.getAttribute("entry")!=null){
                request.getRequestDispatcher("/WEB-INF/views/main_page.jsp").forward(request,response);
            }
        %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Sign In</h2>
        </div>
        <form method="POST" class="w3-selection w3-light-grey w3-padding" action="${pageContext.request.contextPath}/sign_in">
            <label>Login:
                <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%" required><br/>
            </label>
            <label>Password:
                <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%" required>
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Log In</button>
            <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
                <button class="w3-btn w3-green w3-round-large" onclick="location.href='${pageContext.request.contextPath}/restore'">Forgot the password?</button>
            </div>
        </form>

    </div>
</div>



<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='${pageContext.request.contextPath}/'">Back to begin</button>
</div>
</body>

</html>
