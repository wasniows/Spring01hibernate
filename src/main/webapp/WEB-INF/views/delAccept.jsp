<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Accept</title>
</head>
<body>

<p>Czy napewno chcesz usunąć książkę</p>
<table>
    <tr>
        <td>
            <form method="get" action="/delete/${id}"">
            <button type="submit">Potwierdź</button>
            </form>
        </td>

        <td>
            <form method="get" action="/listofbooks"">
            <button type="submit">Anuluj</button>
            </form>
        </td>
    </tr>

</table>




<%--<a href="/delete/${id}">Tak </a>  <a href="/listofbooks"> Nie</a>--%>
</body>
</html>
