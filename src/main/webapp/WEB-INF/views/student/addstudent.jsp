<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    First Name: <form:input path="firstName"/><br>
    Last Name: <form:input path="lastName"/><br>
    Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/><br>
    Country: <form:select path="country" items="${countries}"/><br>
    Note: <form:textarea path="notes"/><br>
    Mailing List: <form:checkbox path="mailingList"/><br>
    Programming Skills: <br>
    <form:select path="programmingSkills" items="${skills}" multiple="true"/><br>
    Hobbies: <br>
<%--    można było checkboxes użyć--%>
<%--    <c:forEach items="${hobbies}" var="item">--%>
<%--        <form:checkbox id="${item}" value="${item}" path="hobbies"/>--%>
<%--        <label for="${item}"> ${item}</label><br>--%>
<%--    </c:forEach>--%>
    <form:checkboxes path="hobbies" items="${hobbies}"/>
    <form:hidden path="id"/>
    <br>
    <input type="submit">
</form:form>
</body>
</html>
