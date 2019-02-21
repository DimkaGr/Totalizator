<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 20.02.2019
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Totalizator</h1>
</div>

<div class="w3-container w3-padding">
    <%--<%--%>
        <%--if(request.getAttribute("errors").equals(false))--%>
    <%--%>--%>
        <%--<form action="${pageContext.request.contextPath}/error">--%>

    <%
        if (request.getAttribute("user") != null) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>User '" + request.getAttribute("user") + "' added!</h5>\n" +
                    "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Add user</h2>
        </div>
        <form method="POST" class="w3-selection w3-light-grey w3-padding" action="${pageContext.request.contextPath}/add">
            <label>First name:
                <input type="text" name="first_name" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%" required><br/>
            </label>
            <label>Last name:
                <input type="text" name="last_name" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%" required><br/>
            </label>
            <label>Email:
                <input type="text" name="email" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%" required><br/>
            </label>
            <label>Login:
                <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%" required><br/>
            </label>
            <label>Password:
                <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%" required><br/>
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/Totalizator_war/'">Back to main</button>
</div>
</body>
</html>
