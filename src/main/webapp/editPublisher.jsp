<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit publisher</title>
</head>
<body>

<%--@elvariable id="publisher" type="pl.coderslab.entity.Publisher"--%>
<form:form action="/editpublisher" method="post" modelAttribute="publisher">
    <label for="name">Name: </label>
    <form:input path="name"/><br><br>
    <form:hidden path="id" />
    <input type="submit" value="Zmień">
</form:form>

</body>
</html>
