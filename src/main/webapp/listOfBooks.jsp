<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of books</title>
</head>
<body>

<table>
    <caption>List of books</caption>
    <thead>
    <tr>
            <th>Title</th>
<%--            <th>Authors</th>--%>
            <th>Publisher</th>
            <th>Description</th>
            <th>Rating</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items='${books}' var="book">
        <tr>
            <td>${book.title}</td>
<%--            <td>${book.authorList}</td>--%>
            <td>${book.publisher}</td>
            <td>${book.descripion}</td>
            <td>${book.rating}</td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
