<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Book</title>

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
            <a href="/listofauthors" class="nav-link nav-item">Autorzy</a>
        </div>
    </div>
</nav>
<div class=" bg-success text-white text-center">
    <div class="container">
        <h3 class="display-4">Nowa książka</h3>
    </div>
</div>
<%--@elvariable id="book" type="Book"--%>
<%--@elvariable id="author" type="pl.coderslab.entity.Author"--%>

<div class="container pt-5">
    <form:form method="post" modelAttribute="book" action="/addbook">
        <div class="row">
            <div class="form-group col-6">
                <label for="title">Tytuł</label>
                <form:input path="title" cssClass="form-control"/>
                <small><form:errors path="title" cssClass="alert-danger"/></small>
            </div>
            <div class="form-group col-6">
                <label for="description">Opis</label>
                <form:textarea path="description" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-6">
                <label for="authorList">Autorzy</label>
                <form:select path="authorList" items="${authors}" itemValue="id" itemLabel="name" cssClass="form-control"/>
                <small><form:errors path="authorList" cssClass="alert-danger"/></small>
            </div>
            <div class="form-group col-6">
                <label for="publisher.id">Wydawca</label>
                <form:select path="publisher.id" items="${publishers}" itemValue="id" itemLabel="name" cssClass="form-control"/>
                <small><form:errors path="publisher.id" cssClass="alert-danger"/></small>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-6">
                <label for="category.id">Kategoria</label>
                <form:select path="category.id" items="${categories}" itemValue="id" itemLabel="name" cssClass="form-control"/>
                <small><form:errors path="category.id" cssClass="alert-danger"/></small>
            </div>
            <div class="form-group col-6">
                <label for="pages">Liczba stron</label>
                <form:input path="pages" type="number" min="1" value="256" cssClass="form-control"/>
                <small><form:errors path="pages" cssClass="alert-danger"/></small>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-6">
                <label for="rating">Ranking</label>
                <form:input path="rating" type="number" min="1" max="10" value="1" cssClass="form-control"/>
                <small><form:errors path="rating" cssClass="alert-danger"/></small>
            </div>
        </div>

        <button type="submit" class="btn btn-primary" >Dodaj</button>
    </form:form>
</div>
</body>
</html>
