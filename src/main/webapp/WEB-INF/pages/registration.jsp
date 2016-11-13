<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>
    <jsp:attribute name="title">Registration</jsp:attribute>

    <jsp:body>
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
                <tr>
                    <td>
                        <button type="submit">Register</button>
                    </td>
                </tr>
            </table>
        </form:form>

    </jsp:body>
</page:template>
