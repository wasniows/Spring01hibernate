<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of publishers</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class=" bg-success text-white text-center">
    <div class="container">
        <h3 class="display-4">Publishers</h3>
    </div>
</div>
<% int num = 1; %>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>NIP</th>
        <th>REGON</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${publishers}' var="publisher">
        <tr>
            <td><%=num%></td>
            <td>${publisher.name}</td>
            <td>${publisher.nip}</td>
            <td>${publisher.regon}</td>
            <td>
                <form action="/editpublisher/${publisher.id}">
                    <button class="btn btn-outline-primary btn-sm">edit</button>
                </form>
            </td>
            <td>
                <form action="/deletepublisher/${publisher.id}">
                    <button class="btn btn-outline-primary btn-sm">delete</button>
                </form>
            </td>
        </tr>
        <%num = num + 1;%>
    </c:forEach>
    </tbody>
</table>

<div class="row">
    <div class="col-3 pl-5">
        <form action="/addpublisher">
            <button class="btn btn-outline-success">New publisher</button>
        </form>
    </div>
    <div class="col-3">
        <form action="/listofbooks">
            <button class="btn btn-outline-success">Books</button>
        </form>
    </div>
</div>





</body>
</html>
