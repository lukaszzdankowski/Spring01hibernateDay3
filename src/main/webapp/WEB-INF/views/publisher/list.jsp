<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Publisher list</title>
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
    <th>Name</th>
    <th>Update link</th>
    <th>Delete link</th>
  </tr>
  </thead>
  <c:forEach items="${publishers}" var="publisher">
    <tr>
      <td>${publisher.id}</td>
      <td><c:out value="${publisher.name}"/></td>
      <td><a href = "<c:url value = "/publisher/edit/${publisher.id}"/>">UPDATE</a></td>
      <td><a href = "<c:url value = "/publisher/delete/${publisher.id}"/>">DELETE</a></td>
    </tr>
  </c:forEach>
</table>
<a href = "<c:url value = "/publisher/new"/>">Add new publisher</a>
</body>
</html>