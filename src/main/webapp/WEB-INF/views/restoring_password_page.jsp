<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 26.02.2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restore your password</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>

<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Totalizator</h1>
</div>

<div class="w3-container w3-padding">
    <%
        if(request.getAttribute("errors")!=null){
            out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">" +
                    "<h5>Incorrect login or email! Try again</h5></div>");
        }
    %>
    <div class="w3-card-4">
        <form method="POST" class="w3-selection w3-light-grey w3-padding" action="${pageContext.request.contextPath}/restore">
            <label>Enter your login:
                <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%" required><br/>
            </label>
            <label>Enter your email:
                <input type="text" name="email" class="w3-input w3-animate-input w3-border w3-round-large"
                        style="width: 30%" required><br/>
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Send message</button>
        </form>
    </div>
</div>



<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='${pageContext.request.contextPath}/'">Back to begin</button>
</div>
</body>
</html>
