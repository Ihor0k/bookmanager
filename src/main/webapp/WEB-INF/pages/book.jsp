<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false" %>

<html>
<head>
    <title>${book.title}</title>
    <meta charset="UTF-8"/>
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
        <th width="120">File</th>
    </tr>
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.description}</td>
        <td><a href="/file/${book.filename}">View</a></td>
    </tr>
</table>
</body>
</html>