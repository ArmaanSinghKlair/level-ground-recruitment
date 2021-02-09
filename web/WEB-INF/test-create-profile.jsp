<%-- 
    Document   : loginPage
    Created on : Feb. 6, 2021, 1:52:19 p.m.
    Author     : kentp
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
        <h1>Create profile Reference Page</h1>
       

        <h2>Register User:</h2><br/>
            <form action="<c:url value='/create-profile'></c:url>" method="POST">

                <input type="text" name="username" placeholder="Username"><br/>
                <input type="password" name="password" placeholder="Password"><br/>
                <input type="text" name="firstName" placeholder="Firstname"><br/>
                <input type="text" name="lastName" placeholder="Lastname"><br/>
                <input type="email" name="email" placeholder="Email"><br/>
                <input type="text" name="phoneNo" placeholder="Phone"><br/>

                <input type="submit" value="Create profile">
                
            </form>
            
            <c:if test="${finalMsg}">
                <c:out value="${finalMsg}"/>
            </c:if>
            
            <!-- LOOPING THROUGH ERRORS here, you can REUSE this line to LOOP-->
            <div style="color:red">
                <c:if test="${errMap != null}">
                    <c:forEach var="key" items="${errMap.keySet()}">
                        <p>${errMap.get(key)}</p>
                    </c:forEach>
                </c:if>
            </div>
   </body>
</html>
