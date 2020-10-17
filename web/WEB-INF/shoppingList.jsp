<%-- 
    Document   : shoppingList
    Created on : Oct 17, 2020, 1:02:27 PM
    Author     : 839645
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello <c:out value="${sessionScope.username}"/> ! <a href="<c:url value='/shoppingList?action=logout'/>">Logout</a></p>
        
        <h2>List</h2>
        <form action="<c:url value='/shoppingList'/>" method="post">
            <input type="hidden" name="action" value="add"/>
            Add Item: <input type="text" name="itemToAdd" /> 
            <input type="submit" value="Add"/>
        </form>
            
        <c:if test="${message != null}">
            <p style="color:red">
                <c:out value="${message}"/>
            </p>
        </c:if>
            
            
        <c:if test="${sessionScope.shoppingListItems.size() > 0}">
            <form action="<c:url value='/shoppingList'/>" method="post">
                <c:forEach var='item' items="${sessionScope.shoppingListItems}">
                    ${item} <input type="radio" name="itemToDelete" value="${item}"/><br/>
                </c:forEach>
                    <input type="submit" value="Delete"/>
                    <input type="hidden" name="action" value="delete"/>
            </form>
        </c:if>
    </body>
</html>
