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
            <a href="/listofbooks" class="nav-link nav-item">Książki</a>
            <a href="/listofpublishers" class="nav-link nav-item">Wydawcy</a>
            <a href="/listofauthors" class="nav-link nav-item active">Autorzy</a>
        </div>
    </div>
</nav>

<div class=" bg-success text-white text-center">
    <div class="container">
        <h3 class="display-4">Autorzy</h3>
    </div>
</div>
<% int num = 1; %>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Autor</th>
        <th>Email</th>
        <th>Pesel</th>
        <th>Książki</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${authors}' var="author">
        <tr>
            <td><%=num%></td>
            <td>${author.firstName} ${author.lastName}</td>
            <td>${author.email}</td>
            <td>${author.pesel}</td>
            <td>
                <c:forEach items="${author.books}" var="item">
                    ${item.title}<br>
                </c:forEach>
            </td>
            <td>
                <form action="/editauthor/${author.id}">
                    <button class="btn btn-outline-primary btn-sm">edytuj</button>
                </form>
            </td>
            <td>
                <form action="/deleteauthor/${author.id}">
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
        <form action="/addauthor">
            <button class="btn btn-outline-success">Dodaj autora</button>
        </form>
    </div>
</div>

</body>
</html>
