<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add publisher</title>
</head>
<body>

<%--@elvariable id="publisher" type="pl.coderslab.entity.Publisher"--%>
<form:form method="post" modelAttribute="publisher">
    <label for="name">Name: </label>
    <form:input path="name"/><br><br>
    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>
