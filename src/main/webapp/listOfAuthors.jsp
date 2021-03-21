
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of authors</title>
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
    <caption>List of authors</caption>
    <thead>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Books</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${authors}' var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <c:forEach items="${author.books}" var="item">
                    ${item.title}<br>
                </c:forEach>

            </td>
            <td><a href="/editauthor/${author.id}">Edytuj</a> <br><br> <a href="/deleteauthor/${author.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

<br> <a href="/addauthor">Dodaj nowego autora</a>

</body>
</html>
