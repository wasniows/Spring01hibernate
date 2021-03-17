<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>Pe

<%--@elvariable id="person" type=""--%>
<form:form method="post" modelAttribute="person">
    <form:input path="login"/>
    <form:input path="password"/>
    <form:input path="email"/>
    <input type="submit" value="Save">
</form:form>

<%--<form method="post">--%>
<%--    <label for="login">Login: </label>--%>
<%--    <input id="login" type="text" name="login">--%>
<%--    <br>--%>
<%--    <label for="password">Password: </label>--%>
<%--    <input id="password" type="text" name="password">--%>
<%--    <br>--%>
<%--    <label for="email">Email: </label>--%>
<%--    <input id="email" type="text" name="email">--%>
<%--    <br>--%>
<%--    <input type="submit"></form>--%>
</body>
</html>
