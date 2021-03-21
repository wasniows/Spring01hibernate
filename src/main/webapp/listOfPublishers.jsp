<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of publishers</title>
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
    </style>
</head>
<body>

<table>
    <caption>List of publishers</caption>
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${publishers}' var="publisher">
        <tr>
            <td>${publisher.name}</td>
            <td><a href="/editpublisher/${publisher.id}">Edytuj</a> <br><br> <a href="/deletepublisher/${publisher.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

<br> <a href="/addpublisher">Dodaj nowego wydawcę</a>

</body>
</html>
