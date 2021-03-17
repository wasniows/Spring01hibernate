<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Book</title>
</head>
<body>

<%--@elvariable id="book" type="Book"--%>
<form:form method="post" modelAttribute="book">
    <label for="rating">Rating: </label>
    <form:input path="rating"/><br><br>
    <label for="title">Title: </label>
    <form:input path="title"/><br><br>
    <label>Description: </label>
    <form:textarea path="description" /><br><br>
    <label>Publisher: </label>
    <form:select path="publisher.id" items="${publishers}" itemValue="id" itemLabel="name"/><br><br>
    <input type="submit" value="Wyślij">
</form:form>


</body>
</html>
