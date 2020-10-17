<%-- 
    Document   : register.jsp
    Created on : Oct 17, 2020, 1:02:11 PM
    Author     : 839645
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Regsiter</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="<c:url value='/shoppingList'/>" method="post">
            Register: 
            <input type="text" name="username" value="${username}"/>
            <input type="hidden" name="action" value="register"/>
            <input type="submit" value="Register"/>          
        </form>
        <c:if test="${message != null}">
            <p style="color:red">
                <c:out value="${message}"/>
            </p>
        </c:if>
    </body>
</html>
