<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 27.02.2019
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="by.gritsuk.dima.domain.Competition" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Competitions</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>

<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Totalizator</h1>
</div>

<div class="w3-container w3-padding">
    <h2>The list of future competitions</h2>
    <table class="w3-table w3-striped w3-border">
        <tr>
            <th>Kind of sport</th>
            <th>Participant 1</th>
            <th>Participant 2</th>
            <th>Date</th>
            <th>Result</th>
        </tr>
        <%

            List<Competition> competitions = (List<Competition>) request.getAttribute("competitions");
            if (competitions != null && !competitions.isEmpty()) {
                for (Competition s : competitions) {
                    out.println("<tr>" +
                            "<td>"+s.getKindOfSport()+"</td>" +
                            "<td>"+s.getParticipant1()+"</td>" +
                            "<td>"+s.getParticipant2()+"</td>" +
                            "<td>"+s.getDate()+"</td>" +
                            "<td>"+s.getResult()+"</td></tr>");
//                    out.println("<td>"+s.getKindOfSport()+"</td>");
//                    out.println("<td>"+s.getParticipant1()+"</td>");
//                    out.println("<td>"+s.getParticipant2()+"</td>");
//                    out.println("<td>"+s.getDate()+"</td>");
//                    out.println("<td>"+s.getResult()+"</tв>");
//                    out.println("</tr>");
                }

            }      %>
    </table>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='${pageContext.request.contextPath}/'">Back to begin</button>
</div>
</body>
</html>
