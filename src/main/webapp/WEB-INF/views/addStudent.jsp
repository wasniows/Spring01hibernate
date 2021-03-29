<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Student</title>
</head>
<body>

<%--@elvariable id="student" type="pl.coderslab.entity.Student"--%>
<form:form method="post" modelAttribute="student">
    <label for="firstName">Imię: </label>
    <form:input path="firstName"/><br><br>
    <label for="lastName">Nazwisko: </label>
    <form:input path="lastName"/><br><br>

    <fieldset>
        <legend>Płeć</legend>
    <form:radiobutton path="gender" value="Male"/>Mężczyzna<br>
    <form:radiobutton path="gender" value="Female"/>Kobieta
    </fieldset><br><br>

    <label>Kraj: </label>
    <form:select path="country" items="${countries}"/><br><br>
    <label>Notatki: </label>
    <form:textarea path="notes" rows="5" cols="20"/><br><br>
    <label>Lista mailingowa: </label>
    <form:checkbox path="mailingList"/><br><br>
    <label>Umiejętności: </label>
    <form:select path="programmingSkills" items="${skills}" multiple="true"/><br><br>

    <fieldset>
        <legend>Hobby</legend>
    <form:checkboxes path="hobbies" items="${hobbies}"/>
    </fieldset><br><br>
    <input type="submit" value="Wyślij">
</form:form>

</body>
</html>
