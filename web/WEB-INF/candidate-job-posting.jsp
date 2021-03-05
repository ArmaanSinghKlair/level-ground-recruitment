<%-- 
    Document   : candidate-job-posting
    Created on : Mar 3, 2021, 6:21:02 PM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
        <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
        <link rel="stylesheet" href="assets/css/job-posting.css">
        <link rel="stylesheet" href="assets/css/nav-bar.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="react-inject-scripts/css/SearchBar.css?id=123">
         <!-- Axios -->
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <title>Candidate Job Posting</title>
    </head>
    <body>
        <nav class="navbar navbar-light navbar-expand-lg navigation-clean-button">
            <div class="container-fluid"><a
                    class="navbar-brand d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center"
                    href="index.html"><img class="logo" src="assets/img/logo.png">
                    <h4 class="brand-name">Level Ground Recruitment</h4>
                </a>
                <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                        class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="navbar-nav mr-auto flex-md-shrink-0">
                        <li class="nav-item"><a class="nav-link" data-bss-hover-animate="pulse" href="index.html">Home</a></li>
                        <li class="nav-item"><a class="nav-link" data-bss-hover-animate="pulse" href="<c:url value="/candidate-job-posting"/>">Job Posting</a></li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" aria-expanded="false"
                                                         data-toggle="dropdown" data-bss-hover-animate="pulse"
                                                         href="#">Services</a>
                            <div class="dropdown-menu"><a class="dropdown-item" href="<c:url value="/candidate-profile"/>">Profile</a><a
                                    class="dropdown-item" href="#">Contact us</a><a class="dropdown-item" href="#">About</a>
                            </div>
                        </li>
                    </ul>
                    <span class="d-md-flex flex-md-shrink-0 justify-content-md-center align-items-md-center navbar-text actions"><a
                            class="login" href="">Profile</a><a class="btn btn-primary action-button" role="button"
                            href="">Logout</a></span>
                </div>
            </div>
        </nav>
        <c:if test="${requestScope.fail == true && requestScope.currentTab == null}">
            <div class="alert alert-warning" role="alert">
                <c:forEach var="error" items="${requestScope.errList}">
                    <div>&#9888; ${error}</div>
                </c:forEach>
            </div>
        </c:if>
        <c:if test="${requestScope.success == true && requestScope.currentTab == null}">
            <div class="alert alert-success" role="alert">
                <span><c:out value="${sucessMessage}"/></span>
            </div>
        </c:if>

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
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
        <script src="assets/js/popup.js"></script>
        
       
<!-- Load React. -->
         <!-- Note: when deploying, replace "development.js" with "production.min.js". -->
         <script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>

        <script src="https://unpkg.com/react@17/umd/react.development.js" crossorigin></script>
        <script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js" crossorigin></script>
        <script src="react-inject-scripts/compiled/App.js" type="module"></script>
        <noscript>Javascript must be enabled to search jobs</noscript>
    </body>

</html>
</body>
</html>
