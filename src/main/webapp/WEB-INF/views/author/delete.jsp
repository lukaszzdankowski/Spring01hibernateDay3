<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Author to delete:<br>
Name: ${author.firstName} ${author.lastName}<br>
<form:form method="post" action="/author/delete/${author.id}">
    <input type="submit" value="DELETE">
</form:form>
<form:form method="get" action="/author/list">
    <input type="submit" value="CANCEL">
</form:form>

</body>
</html>
