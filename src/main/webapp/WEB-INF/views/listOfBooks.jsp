<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of books</title>

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
    <caption>List of books</caption>
    <thead>
    <tr>
        <th>Title</th>
        <th>Authors</th>
        <th>Publisher</th>
        <th>Description</th>
        <th>Rating</th>
        <th>Pages</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${books}' var="book">
        <tr>
            <td>${book.title}</td>

            <td>
                <c:forEach items="${book.authorList}" var="item">
                    ${item.firstName}  ${item.lastName}<br>
                </c:forEach>

            </td>

            <td>${book.publisher.name}</td>
            <td>${book.description}</td>
            <td>${book.rating}</td>
            <td>${book.pages}</td>
            <td><a href="/edit/${book.id}">Edytuj</a> <br><br> <a href="/delaccept/${book.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

<br> <a href="/addbook">Dodaj nową książkę</a>
<br> <a href="/listofauthors">Lista autorów</a>
<br> <a href="/listofpublishers">Lista wydawców</a>

</body>
</html>
