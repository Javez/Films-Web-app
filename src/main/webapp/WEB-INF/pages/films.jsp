<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>FILMS</title>
</head>
<body>

<h2>Films</h2>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>watched</th>
        <th>action</th>
    </tr>
    <c:forEach var="films" items="${filmsList}">
        <tr>
            <td>${films.id}</td>
            <td>${films.title}</td>
            <td>${films.year}</td>
            <td>${films.genre}</td>
            <td>${films.watched}</td>
            <td>
                <a href="/edit/${films.id}">edit</a>
                <a href="/delete/${films.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new films</a>
</body>
</html>