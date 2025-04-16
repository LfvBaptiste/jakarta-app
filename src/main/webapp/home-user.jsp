<%@ page import="fr.formation.jakarta.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 15/04/2025
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
User user = (User) session.getAttribute("user");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%= user %>

</body>
</html>
