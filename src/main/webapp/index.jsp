<!DOCTYPE html>
<%--<%@ page import="by.gritsuk.dima.controller.command.CommandType" %>--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Totalizator(Demo)</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Totalizator</h1>
    <div class="w3-right-align">
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='${pageContext.request.contextPath}/sign_in'">Sign In</button>
    </div>
</div>

<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='${pageContext.request.contextPath}/list'">List users</button>
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='${pageContext.request.contextPath}/comp_list'">View competitions</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='${pageContext.request.contextPath}/add'">Add user</button>
    </div>
</div>
</body>
</html>

