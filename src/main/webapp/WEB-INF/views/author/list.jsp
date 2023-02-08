<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Book list</title>
  <style>
    table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
    }
  </style>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Rating</th>
    <th>Publisher</th>
    <th>Update link</th>
    <th>Delete link</th>
  </tr>
  </thead>
  <c:forEach items="${books}" var="book">
    <tr>
      <td>${book.id}</td>
      <td><c:out value="${book.title}"/></td>
      <td><c:out value="${book.rating}"/></td>
      <td><c:out value="${book.publisher.name}"/></td>
      <td><a href = "<c:url value = "/book/edit/${book.id}"/>">UPDATE</a></td>
      <td><a href = "<c:url value = "/book/delete/${book.id}"/>">DELETE</a></td>
    </tr>
  </c:forEach>
</table>
<a href = "<c:url value = "/book/new"/>">Add new book</a>
</body>
</html>