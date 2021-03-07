<%-- 
    Document   : candidate-job-posting
    Created on : Mar 3, 2021, 6:21:02 PM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="react-inject-scripts/css/SearchBar.css?id=12">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
        <link rel="stylesheet" href="assets/css/job-posting.css">
        <link rel="stylesheet" href="assets/css/nav-bar.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <!-- Axios -->
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <title>Candidate Job Posting</title>
    </head>
    <body>

        <%@include file="/WEB-INF/jspf/navbar.jspf"%>
        <%@include file="/WEB-INF/jspf/alert.jspf"%>

        <div class="container">
            <div class="row search-row">
                <div class="col-md-10 offset-md-1 search-column" id="searchBar">
                </div>
            </div>


        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>



        <!-- Load React. -->
        <!-- Note: when deploying, replace "development.js" with "production.min.js". -->
        <script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>

        <script src="https://unpkg.com/react@17/umd/react.development.js" crossorigin></script>
        <script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js" crossorigin></script>
        <script src="react-inject-scripts/compiled/App.js" type="module"></script>
        <noscript>Javascript must be enabled to search jobs</noscript>
    </body>
</html>