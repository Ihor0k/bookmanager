<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form modelAttribute="user" method="post">
    <table>
        <tr>
            <td><label>Username</label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><label>Password</label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr><td><button type="submit">Register</button></td></tr>
    </table>
</form:form>
</body>
</html>
