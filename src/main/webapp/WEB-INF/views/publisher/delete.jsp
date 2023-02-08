<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Publisher to delete:<br>
Name: ${publisher.name} <br>
<form:form method="post" action="/publisher/delete/${publisher.id}">
    <input type="submit" value="DELETE">
</form:form>
<form:form method="get" action="/publisher/list">
    <input type="submit" value="CANCEL">
</form:form>

</body>
</html>
