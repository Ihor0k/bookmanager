<%@ page import="ihor0k.model.User" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="true" %>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="../../resources/css/main.css">
</head>
<body>
<h5>Hello,
    <% Object o = SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getPrincipal();

        out.print(o instanceof String ? "anonymous" : ((User) o).getUsername());
    %>
</h5>

<security:authorize access="isAnonymous()">
<a href="/login">Log in</a>
</security:authorize>

<security:authorize access="isAuthenticated()">
<a href="/j_spring_security_logout">Log out</a><br/>
</security:authorize>

<c:if test="${!empty listBooks}">
    <h2>Book List</h2>
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
                <td><a href="/book/${book.id}/edit">Edit</a></td>
                <td><a href="/book/${book.id}/remove">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1><a href="<c:url value="/book/new"/>">Add a Book</a></h1>

</body>
</html>