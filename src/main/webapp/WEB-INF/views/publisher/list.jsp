<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Author list</title>
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
    <th>First Name</th>
    <th>Last Name</th>
    <th>Update link</th>
    <th>Delete link</th>
  </tr>
  </thead>
  <c:forEach items="${authors}" var="author">
    <tr>
      <td>${author.id}</td>
      <td><c:out value="${author.firstName}"/></td>
      <td><c:out value="${author.lastName}"/></td>
      <td><a href = "<c:url value = "/author/edit/${author.id}"/>">UPDATE</a></td>
      <td><a href = "<c:url value = "/author/delete/${author.id}"/>">DELETE</a></td>
    </tr>
  </c:forEach>
</table>
<a href = "<c:url value = "/author/new"/>">Add new author</a>
</body>
</html>