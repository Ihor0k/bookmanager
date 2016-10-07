<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<html>
<head>
    <title>${book.id == 0? "New Book" : book.title}</title>
    <link rel="stylesheet" href="../../resources/css/main.css">
</head>
<body>
<form:form method="POST" commandName="book" action="/add">
    <table class="tg">
        <c:set var="bookId" value="${book.id}"/>
        <c:if test="${bookId!=0}">
            <tr>
                <td><form:label path="id">id</form:label></td>
                <td><form:input path="id"/></td>
            </tr>
        </c:if>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title" size="50"/></td>
        </tr>
        <tr>
            <td><form:label path="author">Author</form:label></td>
            <td><form:input path="author" size="50"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:textarea path="description" cols="50" rows="10"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="file" name="file" size="50"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
