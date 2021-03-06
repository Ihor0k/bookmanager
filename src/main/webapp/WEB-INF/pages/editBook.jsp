<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>
    <jsp:attribute name="title">Edit | ${book.title}</jsp:attribute>

    <jsp:body>
        <form:form method="POST" enctype="multipart/form-data" acceptCharset="UTF-8">
            <table class="tg">
                <tr>
                    <td>Id</td>
                    <td><input type="text" disabled="true" name="id" size="30" value="${book.id}"/></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title" size="50" value="${book.title}"/></td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><input type="text" name="author" size="50" value="${book.author}"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><textarea name="description" cols="50" rows="10">${book.description}</textarea></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

    </jsp:body>
</page:template>
