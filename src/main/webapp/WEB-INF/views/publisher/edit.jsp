<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/publisher/update" modelAttribute="publisher">
    <p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
    </p>
    <form:hidden path="id" />
    <p>
        <input type="submit">
    </p>
</form:form>
</body>
</html>
