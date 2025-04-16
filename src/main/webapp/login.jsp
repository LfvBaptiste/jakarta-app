<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 15/04/2025
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head>
    <title>login</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
    >
</head>
<body>

    <form method="post">
        <div>
            <input type="text" name="name" placeholder="Votre nom">
        </div>
        <div>
            <input type="email" name="email" placeholder="Votre email">
        </div>

        <button type="submit">Valider</button>
    </form>

    <ul>


        <c:forEach var="fruit" items="${fruits}">
            <li>
                <c:out value="${fruit}" />
            </li>
        </c:forEach>
    </ul>

    <fmt:setLocale value="es_ES" />
    <fmt:formatDate value="${now}" pattern="EEEE, d MMMM yyyy" />

</body>
</html>
