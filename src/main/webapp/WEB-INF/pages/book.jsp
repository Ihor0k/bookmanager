<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>
    <jsp:attribute name="title">${book.title}}</jsp:attribute>

    <jsp:body>
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
    </jsp:body>
</page:template>