<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<page:template>
    <jsp:attribute name="title">${user.username}</jsp:attribute>

    <jsp:body>
        <c:set var="username" value="${user.username}"/>
        <c:set var="books" value="${user.books}"/>
        <h3>${username} has uploaded ${fn:length(user.books)} books</h3>

        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Title</th>
                <th width="120">Author</th>
                <th width="120">Description</th>
                <th width="120">File</th>
            </tr>
            <c:forEach var="book" items="${user.books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.description}</td>
                    <td><a href="/file/${book.filename}">View</a></td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>
</page:template>