<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<page:template>
    <jsp:attribute name="title">Books</jsp:attribute>

    <jsp:body>
        <c:if test="${!empty bookList}">
            <h2>Book List</h2>
            <table class="tg">
                <tr>
                    <th width="20">ID</th>
                    <th width="120">Title</th>
                    <th width="120">Author</th>
                    <th width="120">Description</th>
                    <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <th width="60">Edit</th>
                    <th width="60">Delete</th>
                    </security:authorize>
                </tr>

                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.id}</td>
                        <td><a href="/book/${book.id}">${book.title}</a></td>
                        <td>${book.author}</td>
                        <td>${book.description}</td>
                        <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <td><a href="/book/${book.id}/edit">Edit</a></td>
                        <td><a href="/book/${book.id}/remove">Remove</a></td>
                        </security:authorize>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <h2><a href="<c:url value="/book/new"/>">Add a Book</a></h2>

    </jsp:body>
</page:template>