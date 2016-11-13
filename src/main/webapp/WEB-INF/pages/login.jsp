<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>
    <jsp:attribute name="title">New book</jsp:attribute>

    <jsp:body>
        <div style="width: 300px;">
            <h2>Please sign in</h2>
            <c:url value="/j_spring_security_check" var="loginUrl"/>
            <form action="${loginUrl}" method="post">
                <input type="text" name="username" placeholder="Username" required autofocus>
                <input type="password" name="password" placeholder="Password" required><br/>
                <button type="submit">Log in</button>
            </form>
        </div>
    </jsp:body>
</page:template>