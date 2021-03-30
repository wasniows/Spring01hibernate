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
        <h3 class="display-4">Dodaj wydawcę</h3>
    </div>
</div>
<%--@elvariable id="publisher" type="pl.coderslab.entity.Publisher"--%>
<div class="container pt-5">
    <form:form method="post" modelAttribute="publisher">
       <div class="row">
           <div class="form-group col-4">
               <label for="name">Name</label>
               <form:input path="name" cssClass="form-control"/>
               <small><form:errors path="name" cssClass="alert-danger"/></small>
           </div>
           <div class="form-group col-4">
               <label for="nip">NIP</label>
               <form:input path="nip" cssClass="form-control"/>
               <small><form:errors path="nip" cssClass="alert-danger"/></small>
           </div>
           <div class="form-group col-4">
               <label for="regon">REGON</label>
               <form:input path="regon" cssClass="form-control"/>
               <small><form:errors path="regon" cssClass="alert-danger"/></small>
           </div>
       </div>
        <button type="submit" class="btn btn-primary" >Dodaj</button>
    </form:form>
</div>

</body>
</html>
