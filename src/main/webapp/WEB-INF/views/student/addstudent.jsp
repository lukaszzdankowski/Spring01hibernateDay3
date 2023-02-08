<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${languages}" var="lang">
    ${lang}<br>
</c:forEach>


<form:form method="post" modelAttribute="person">
    Login <form:input path="login"/><br>
    Password <form:password path="password"/><br>
    Email <form:input path="email"/><br>
    <input type="submit">
</form:form>
</body>
</html>
