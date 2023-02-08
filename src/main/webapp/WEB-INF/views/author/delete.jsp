<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Book to delete:<br>
Title: ${book.title}<br>
Rating: ${book.rating}<br>
Description: ${book.description}<br>
<form:form method="post" action="/book/delete/${book.id}">
    <input type="submit" value="DELETE">
</form:form>
<form:form method="get" action="/book/list">
    <input type="submit" value="CANCEL">
</form:form>

</body>
</html>
