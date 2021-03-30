<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Books</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="/listofbooks" class="nav-link nav-item active">Książki</a>
            <a href="/listofpublishers" class="nav-link nav-item">Wydawcy</a>
            <a href="/listofauthors" class="nav-link nav-item">Autorzy</a>
        </div>
    </div>
</nav>

<div class=" bg-success text-white text-center">
    <div class="container">
        <h3 class="display-4">Książki</h3>
    </div>
</div>
<% int num = 1; %>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Tytuł</th>
        <th>Autorzy</th>
        <th>Wydawca</th>
        <th>Opis</th>
        <th>Ranking</th>
        <th>Liczba stron</th>
        <th>Kategoria</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${books}' var="book">
        <tr>
            <td><%=num%></td>
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
            <td>${book.category.name}</td>
            <td>
                <form action="/edit/${book.id}">
                    <button class="btn btn-outline-primary btn-sm">edytuj</button>
                </form>
            </td>
            <td>
                <form action="/delaccept/${book.id}">
                    <button class="btn btn-outline-danger btn-sm">usuń</button>
                </form>
            </td>
        </tr>
        <%num = num + 1;%>
    </c:forEach>
    </tbody>
</table>

<div class="row">
    <div class="col-3 pl-5">
        <form action="/addbookform">
            <button class="btn btn-outline-success">Dodaj książkę</button>
        </form>
    </div>
</div>

</body>
</html>
