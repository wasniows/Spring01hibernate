
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of errors</title>

        <style>
        table {
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid grey;
        }

        th, td {
            text-align: center;
            padding: 6px;
        }

        tr {
            background-color: #F2F2F2;
        }
        h2 {
            color: #1c7430;
        }
    </style>
</head>
<body>

<c:choose>
    <c:when test="${empty errors}">
        <h2>validated</h2>
    </c:when>
    <c:otherwise>
        <table class="my-5 table">
            <caption>List of errors</caption>
            <thead>
            <tr>
                <th>Property path</th>
                <th>Message</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items='${errors}' var="error">
                <tr>
                    <td>${error.getPropertyPath()}</td>
                    <td>${error.getMessage()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>
