<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Salut le monde" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<h2><%= request.getAttribute("message") %></h2>
<c:set var="user" value="Joe" />
<c:out value="${user}" default="Anonyme" />

</body>
</html>