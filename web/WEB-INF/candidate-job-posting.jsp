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
            <div class="row result-row">
                <div class="col-md-10 offset-md-1 result-column">
                    <h5 class="text-center text-muted">Found <strong>10 </strong>matches</h5>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10 offset-md-1"></div>
                <div class="col">
                    <div role="tablist" id="accordion-1">
                        <div class="card">
                            <div role="tab" class="card-header">
                                <div class="d-md-flex justify-content-md-between align-items-md-baseline job-header">
                                    <h1 class="display-4">Job Title</h1>
                                    <p class="text-muted">Posted on: 01 Jan, 2020</p>
                                </div>
                                <div class="d-md-flex justify-content-md-between align-items-md-baseline job-status">
                                    <p class="lead">Status</p>
                                    <p class="text-muted">Expires on: 01 Jan, 2020</p>
                                </div>
                                <h3 class="d-flex justify-content-end mb-0"><a data-toggle="collapse" aria-expanded="true" aria-controls="accordion-1 .item-1" href="#accordion-1 .item-1" class="more-btn"><i class="icon ion-android-more-horizontal"></i></a></h3>
                            </div>
                            <div role="tabpanel" data-parent="#accordion-1" class="collapse show item-1">
                                <div class="card-body">
                                    <div class="shadow job-post">
                                        <hr />
                                        <div>
                                            <h4>Description</h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id ornare arcu odio ut.<br /></p>
                                            <hr />
                                        </div>
                                        <div>
                                            <h4>Requirements</h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id ornare arcu odio ut.<br /></p>
                                            <hr />
                                        </div>
                                        <div class="row">
                                            <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i class="fas fa-location-arrow icons"></i>
                                                <p>Location</p>
                                            </div>
                                            <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline"><i class="far fa-money-bill-alt icons"></i>
                                                <p>$50,000 year</p>
                                            </div>
                                        </div>
                                        <form class="d-flex justify-content-end"><button class="btn apply-btn" type="submit">Apply Now</button></form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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
        
        <!-- Axios -->
        <script defer src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
