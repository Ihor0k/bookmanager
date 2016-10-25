<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<div style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <h2>Please sign in</h2>
        <input type="text" name="username" placeholder="Email address" required autofocus>
        <input type="password" name="password" placeholder="Password" required>
        <input type="checkbox" name="_spring_security_remember_me" title="Remember me">
        <button type="submit">Войти</button>
    </form>
</div>
</body>
</html>
