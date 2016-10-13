<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>${book.title}</title>
    <link rel="stylesheet" href="../../resources/css/main.css">
</head>
<body>
<h1>Book Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Author</th>
        <th width="120">Description</th>
        <c:if test="${book.filename != null}">
        <th width="120">File</th>
        </c:if>
    </tr>
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.description}</td>
        <c:if test="${book.filename != null}">
            <td><a href="/file/${book.filename}">Download</a></td>
        </c:if>
    </tr>
</table>
</body>
</html>