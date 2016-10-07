<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="../../resources/css/main.css">
</head>
<body>

<c:if test="${!empty listBooks}">
    <h1>Book List</h1>
    <table class="tg">
        <tr>
            <th width="20">ID</th>
            <th width="120">Title</th>
            <th width="120">Author</th>
            <th width="120">Description</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>

        <c:forEach var="book" items="${listBooks}">
            <tr>
                <td>${book.id}</td>
                <td><a href="/book/${book.id}">${book.title}</a></td>
                <td>${book.author}</td>
                <td>${book.description}</td>
                <td><a href="/edit/${book.id}">Edit</a></td>
                <td><a href="/remove/${book.id}">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1><a href="<c:url value="/add"/>">Add a Book</a> </h1>

</body>
</html>