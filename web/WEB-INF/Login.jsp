<%-- 
    Document   : Login
    Created on : Feb 10, 2021, 9:45:15 AM
    Author     : 756887
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test Login Page</h1>
        <form action="<c:url value='/candidate-login'></c:url>" method="POST">
            <input type="text" name="username" placeholder="Username"><br/>
            <input type="password" name="password" placeholder="Password"><br/>
            <input type="submit" value="Login">
        </form>
        <!-- LOOPING THROUGH ERRORS here, you can REUSE this line to LOOP-->
            <div style="color:red">
                <c:if test="${requestScope.errList != null}">
                    <c:forEach var="error" items="${requestScope.errList}">
                        <p><c:out value="${error}"></c:out></p>
                    </c:forEach>
                </c:if>
            </div><br/>
    </body>
</html>
