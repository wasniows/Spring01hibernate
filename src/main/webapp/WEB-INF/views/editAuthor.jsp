<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add publisher</title>

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
        <h3 class="display-4">Dodaj autora</h3>
    </div>
</div>
<%--@elvariable id="author" type="Author"--%>
<div class="container pt-5">
    <form:form action="/editauthor" method="post" modelAttribute="author">
        <div class="row">
            <div class="form-group col-6">
                <label for="firstName">Imię</label>
                <form:input path="firstName" cssClass="form-control"/>
                <small><form:errors path="firstName" cssClass="alert-danger"/></small>
            </div>
            <div class="form-group col-6">
                <label for="lastName">Nazwisko</label>
                <form:input path="lastName" cssClass="form-control"/>
                <small><form:errors path="lastName" cssClass="alert-danger"/></small>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-6">
                <label for="pesel">Pesel</label>
                <form:input path="pesel" cssClass="form-control"/>
                <small><form:errors path="pesel" cssClass="alert-danger"/></small>
            </div>
            <div class="form-group col-6">
                <label for="email">Email</label>
                <form:input path="email" cssClass="form-control"/>
                <small><form:errors path="email" cssClass="alert-danger"/></small>
            </div>
        </div>
        <form:hidden path="id" />
        <button type="submit" class="btn btn-primary" >Zmień</button>
    </form:form>
</div>
</body>
</html>



