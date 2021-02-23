<%-- 
    Document   : candidate
    Created on : Feb 23, 2021, 9:58:01 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>capstone</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/profile.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-lg navigation-clean-button">
        <div class="container-fluid"><a class="navbar-brand d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center" href="index.html"><img class="logo" src="assets/img/logo.png">
                <h4 class="brand-name">Level Ground Recruitment</h4>
            </a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="navbar-nav mr-auto flex-md-shrink-0">
                    <li class="nav-item"><a class="nav-link" data-bss-hover-animate="pulse" href="index.html">Home</a></li>
                    <li class="nav-item"><a class="nav-link" data-bss-hover-animate="pulse" href="#">Job Posting</a></li>
                    <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" aria-expanded="false" data-toggle="dropdown" data-bss-hover-animate="pulse" href="#">Services</a>
                        <div class="dropdown-menu"><a class="dropdown-item" href="profile.html">Profile</a><a class="dropdown-item" href="#">Contact us</a><a class="dropdown-item" href="#">About</a></div>
                    </li>
                </ul><span class="d-md-flex flex-md-shrink-0 justify-content-md-center align-items-md-center navbar-text actions"> <a data-bss-hover-animate="pulse" class="login" href="login.html">Log In</a><a class="btn btn-primary action-button" role="button" data-bss-hover-animate="pulse" href="login.html">Sign Up</a></span>
            </div>
        </div>
    </nav>
    <!-- Example of how to implement the alert -->
<c:choose>
    <!-- Test condition can be string, int or any order validation method
    coming from the server. it should be in request scope-->
    <c:when test="${requestScope.success!=null}">
        <!-- span tag holds the message that you want to show to the user 
        This div represent the success message-->
        <div class="alert alert-success" role="alert"><span>${requestScope.success}</span></div>
    </c:when>
    <c:when test="${requestScope.fail!=null}">
        <!-- This div represent the unsuccessful message -->
        <div class="alert alert-warning" role="alert"><span>${requestScope.fail}</span></div>
    </c:when>
</c:choose>

    <div class="container-md">
        <div class="row text-left head-row">
            <div class="col m-auto">
                <h3>Name Here</h3>
                <p>Status</p>
            </div>
        </div>
        <div class="row head-row">
            <div class="col-12 col-md-5 sections">
                <h4>Info</h4>
                <hr>
                <form data-aos="fade-up" class="info-form">
                    <div class="form-group">
                        <p>About:</p>
                        <p>Email:</p>
                        <p>Phone Number:&nbsp;</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
            </div>
            <div class="col-12 col-md-5 offset-md-2 sections">
                <h4>Education</h4>
                <hr>
                <form data-aos="fade-up">
                    <div class="form-group">
                        <h6>Institution</h6>
                        <p>level</p>
                        <p>Subject</p>
                        <p>Start date - End date</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
                <form data-aos="fade-up">
                    <div class="form-group">
                        <h6>Institution</h6>
                        <p>level</p>
                        <p>Subject</p>
                        <p>Start date - End date</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
            </div>
        </div>
        <div class="row row-cols-2 row-cols-sm-1 head-row">
            <div class="col-12 col-md-5 sections">
                <h4>Work History</h4>
                <hr>
                <form data-aos="fade-up">
                    <div class="form-group">
                        <h6>Company</h6>
                        <p>Title:&nbsp;</p>
                        <p>Start Date:</p>
                        <p>End Date:</p>
                        <p>Reference:</p>
                    </div>
                    <div class="d-flex d-sm-flex d-xl-flex justify-content-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
                <form data-aos="fade-up">
                    <div class="form-group">
                        <h6>Company</h6>
                        <p>Title:&nbsp;</p>
                        <p>Start Date:</p>
                        <p>End Date:</p>
                        <p>Reference:</p>
                    </div>
                    <div class="d-flex d-sm-flex d-xl-flex justify-content-end justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
            </div>
            <div class="col-12 col-md-5 offset-md-2 sections">
                <h4>Skills</h4>
                <hr>
                <form class="form-inline justify-content-between" data-aos="fade-up">
                    <div class="form-group">
                        <p>Description</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
                <form class="form-inline justify-content-between" data-aos="fade-up">
                    <div class="form-group">
                        <p>Description</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
                <form class="form-inline justify-content-between" data-aos="fade-up">
                    <div class="form-group">
                        <p>Description</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
                <form class="form-inline justify-content-between" data-aos="fade-up">
                    <div class="form-group">
                        <p>Description</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
                <form class="form-inline justify-content-between" data-aos="fade-up">
                    <div class="form-group">
                        <p>Description</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group"><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="submit" title="Delete"><i class="far fa-window-close" data-bss-hover-animate="pulse"></i></button><button class="btn btn-lg" data-toggle="tooltip" data-bss-tooltip="" type="button" title="Edit"><i class="far fa-edit" data-bss-hover-animate="pulse"></i></button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
</body>

</html>
