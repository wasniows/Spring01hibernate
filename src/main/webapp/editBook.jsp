<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>

<%--@elvariable id="book" type="Book"--%>
<form:form action="/editbook" method="get" modelAttribute="book">
    <label for="rating">Rating: </label>
    <form:input path="rating"/><br><br>
    <label for="title">Title: </label>
    <form:input path="title"/><br><br>
    <label>Description: </label>
    <form:textarea path="description" /><br><br>
    <label>Publisher: </label>
    <form:select path="publisher.id" items="${publishers}" itemValue="id" itemLabel="name"/><br><br>
    <label>Authors: </label>
    <form:select path="authorList" items="${authors}" itemValue="id" itemLabel="lastName"/><br><br>
    <form:hidden path="id" />
    <input type="submit" value="Zmień">
</form:form>

</body>
</html>
