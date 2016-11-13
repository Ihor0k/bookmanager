<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div style="width: 300px;">
    <h2>Please sign in</h2>
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <input type="text" name="username" placeholder="Username" required autofocus>
        <input type="password" name="password" placeholder="Password" required><br/>
        Remember me
        <input type="checkbox" name="_spring_security_remember_me" value="true"><br/>
        <button type="submit">Log in</button>
    </form>
</div>
</body>
</html>
