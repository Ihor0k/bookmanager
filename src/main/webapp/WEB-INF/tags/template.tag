<%@ tag pageEncoding="UTF-8" description="Main template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@attribute name="title" fragment="true" %>

<html>
<head>
    <title>
        <jsp:invoke fragment="title"/>
    </title>

    <spring:url value="/resources/css/style.css" var="stylesheet"/>
    <link rel="stylesheet" href="${stylesheet}">
</head>

<body>

<c:set var="currentUser" scope="session" value="anonym"/>
<c:url value="/login" var="log"/>
<c:set var="logText" scope="session" value="Log in"/>
<security:authorize access="isAuthenticated()">
    <security:authentication property="principal.username" var="currentUser"/>
    <c:url var="log" value="/j_spring_security_logout"/>
    <c:set var="logText" value="Log out"/>
</security:authorize>

<div id="header">
    <ul>
        <li id="greeting">
            Hello, ${currentUser}
        </li>
        <li id="log_text">
            <a href="${log}">${logText}</a>
        </li>
    </ul>
</div>

<div id="body">
    <jsp:doBody/>
</div>
</body>
</html>