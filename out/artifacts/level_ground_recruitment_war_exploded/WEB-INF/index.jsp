<%-- 
    Document   : index
    Created on : Feb 15, 2021, 10:58:15 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>capstone</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body onload="<c:if
        test='${requestScope.currentTab != null}'>document.getElementById('${requestScope.currentTab.trim()}').click()</c:if>">
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
                <li class="nav-item"><a class="nav-link active" data-bss-hover-animate="pulse"
                                        href="index.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" data-bss-hover-animate="pulse" href="#">Job Posting</a></li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" aria-expanded="false"
                                                 data-toggle="dropdown" data-bss-hover-animate="pulse"
                                                 href="#">Services</a>
                    <div class="dropdown-menu"><a class="dropdown-item" href="<c:url value='/candidate-profile'/>">Profile</a><a
                            class="dropdown-item" href="#">Contact us</a><a class="dropdown-item" href="#">About</a>
                    </div>
                </li>
            </ul>
            <span class="d-md-flex flex-md-shrink-0 justify-content-md-center align-items-md-center navbar-text actions"> <a
                    data-bss-hover-animate="pulse" class="login" href="<c:url value='/candidate-login' />">Log In</a><a
                    class="btn btn-primary action-button" role="button" data-bss-hover-animate="pulse"
                    href="<c:url value='/user-registration' />">Sign Up</a></span>
        </div>
    </div>
</nav>
<c:if test="${requestScope.fail == true}">
    <div class="alert alert-warning" role="alert">
        <c:forEach var="error" items="${requestScope.errList}">
            <div>&#9888; ${error}</div>
        </c:forEach>
    </div>
</c:if>
<c:if test="${requestScope.success == true}">
    <div class="alert alert-success" role="alert">
        <span><c:out value="${sucessMessage}"/></span>
    </div>
</c:if>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
</body>

</html>