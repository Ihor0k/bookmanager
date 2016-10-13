<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<html>
<head>
    <title>New Book</title>
    <link rel="stylesheet" href="../../resources/css/main.css">
</head>
<body>
<form:form method="POST" enctype="multipart/form-data">
    <table class="tg">
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" size="50"/></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input type="text" name="author" size="50"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><textarea name="description" cols="50" rows="10"></textarea></td>
        </tr>
        <tr>
            <td>File</td>
            <td><input type="file" accept="application/pdf" name="file" size="50"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
