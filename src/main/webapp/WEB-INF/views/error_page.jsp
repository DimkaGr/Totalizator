<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 22.02.2019
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failed registration</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container">
    <div class="picture">
        <img src="errorPic.jpg" height=330px" width="500px" alt="Oops!">
    </div>
    <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
       <%--<span class="w3-button w3-margin-right w3-display-center w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey"></span>--%>
    <h5>Your input data is not valid! Try to registr again or return to menu</h5>
    </div>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/Totalizator_war/'">Back to main</button>
        <button class="w3-btn w3-round-large" onclick="location.href='/Totalizator_war/add'">Try to register again</button>
    </div>
</div>
</body>
</html>
