<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New author form</title>
</head>
<body>
<form:form method="post" action="/author/save" modelAttribute="author">
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:input path="lastName"/>
    </p>
    <p>
        <input type="submit">
    </p>
</form:form>
</body>
</html>
