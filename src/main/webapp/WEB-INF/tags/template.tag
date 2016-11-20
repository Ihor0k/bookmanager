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

    <spring:url value="/resources/css/main.css" var="stylesheet"/>
    <link rel="stylesheet" href="${stylesheet}">
</head>

<body>

<c:set var="currentUser" scope="session" value="anonym"/>
<security:authorize access="isAuthenticated()" var="isAuthenticated">
    <security:authentication property="principal.username" var="currentUser"/>
</security:authorize>

<h5>Hello, ${currentUser}</h5>

<c:url value="/j_spring_security_logout" var="logout"/>
<c:url value="/login" var="login"/>
<c:if test="${isAuthenticated}"><a href="${logout}">Log out</a></c:if>
<c:if test="${!isAuthenticated}"><a href="${login}">Log in</a></c:if>

<jsp:doBody/>
</body>
</html>