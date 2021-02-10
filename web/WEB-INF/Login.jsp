<%-- 
    Document   : Login
    Created on : Feb 10, 2021, 9:45:15 AM
    Author     : 756887
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test Login Page</h1>
        <form action="CandidateLoginServlet" method="POST">
            <input type="text" name="username" placeholder="Username"><br/>
            <input type="password" name="password" placeholder="Password"><br/>
            <input type="submit" value="Login">
        </form>
        ${requestScope.message}<br/>
    </body>
</html>
