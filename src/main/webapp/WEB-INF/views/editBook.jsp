<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
    <style>
        .error{
            color: #856404;
        }
    </style>
</head>
<body>

<%--@elvariable id="book" type="Book"--%>
<form:form action="/editbook" method="get" modelAttribute="book">
    <label for="rating">Rating: </label>
    <form:input path="rating" type="number" min="1" max="10" value="1"/><br>
    <form:errors path="rating" cssClass="error"/> <br><br>
    <label for="title">Title: </label>
    <form:input path="title"/><br>
    <form:errors path="title" cssClass="error"/> <br><br>
    <label>Description: </label>
    <form:textarea path="description" /><br><br>
    <label>Publisher: </label>
    <form:select path="publisher.id" items="${publishers}" itemValue="id" itemLabel="name"/><br><br>
    <label>Authors: </label>
    <form:select path="authorList" items="${authors}" itemValue="id" itemLabel="lastName"/><br>
    <form:errors path="authorList" cssClass="error"/> <br><br>
    <label>Pages: </label>
    <form:input path="pages" type="number" min="1"/><br>
    <form:errors path="pages" cssClass="error"/> <br><br>
    <form:hidden path="id" />
    <input type="submit" value="Zmień">
</form:form>

</body>
</html>
