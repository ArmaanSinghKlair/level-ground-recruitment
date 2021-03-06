<%-- 
    Document   : signup
    Created on : Feb 19, 2021, 10:42:11 AM
    Author     : AmirS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/signup.css">
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
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-2"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-2">
            <ul class="navbar-nav mr-auto flex-md-shrink-0">
                <li class="nav-item"><a class="nav-link" data-bss-hover-animate="pulse" href="index.html">Home</a></li>
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
<div class="tabs">
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item" role="presentation" data-bss-hover-animate="pulse"><a class="nav-link active" role="tab"
                                                                                   data-toggle="tab" href="#tab-1">Log
            In</a></li>
        <li class="nav-item" role="presentation" data-bss-hover-animate="pulse"><a class='nav-link' role="tab"
                                                                                   data-toggle="tab" id="signup-tab-cta"
                                                                                   data-bss-hover-animate="pulse"
                                                                                   href="#tab-2" onLoad>Sign Up</a></li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane fade show active" role="tabpanel" id="tab-1">
            <div class="container login-clean">
                <form method="post" style="background: #f1faee;" action="<c:url value='/candidate-login'></c:url>">
                    <div class="illustration">
                        <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" fill="none"
                             style="color: #1d3557;">
                            <path d="M15.4857 20H19.4857C20.5903 20 21.4857 19.1046 21.4857 18V6C21.4857 4.89543 20.5903 4 19.4857 4H15.4857V6H19.4857V18H15.4857V20Z"
                                  fill="currentColor"></path>
                            <path d="M10.1582 17.385L8.73801 15.9768L12.6572 12.0242L3.51428 12.0242C2.96199 12.0242 2.51428 11.5765 2.51428 11.0242C2.51429 10.4719 2.962 10.0242 3.51429 10.0242L12.6765 10.0242L8.69599 6.0774L10.1042 4.6572L16.4951 10.9941L10.1582 17.385Z"
                                  fill="currentColor"></path>
                        </svg>
                    </div>
                    <div class="form-group"><input class="form-control" type="text" name="username"
                                                   placeholder="Username"
                                                   value="<c:out value='${lastCandidate.canUsername}' default=''/>">
                    </div>
                    <div class="form-group"><input class="form-control" type="password" name="password"
                                                   placeholder="Password"></div>
                    <div class="form-group justify-content-lg-center align-items-lg-center login-as">
                        <h5>Login as</h5>
                        <div class="form-check"><input type="radio" class="form-check-input" id="candidate" name="userType" value="candidate" checked /><label class="form-check-label" for="candidate">Candidate</label></div>
                        <div class="form-check"><input type="radio" class="form-check-input" id="business" name="userType" value="businessClient" /><label class="form-check-label" for="business">Business Client</label></div>
                        <div class="form-check"><input type="radio" class="form-check-input" id="admin" name="userType" value="admin" /><label class="form-check-label" for="admin">Admin</label></div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-block" type="submit" value="Login">Log In</button>
                    </div>
                    <a class="forgot" href="#">Forgot your email or password?</a>
                </form>


            </div>
        </div>
        <div class="tab-pane fade" role="tabpanel" id="tab-2">
            <div class="container register-photo">
                <div class="form-container">
                    <div class="image-holder"></div>
                    <form action="<c:url value='/user-registration'></c:url>" method="post">
                        <h2 class="text-center"><strong>Create</strong> an account.</h2>
                        <div class="form-group"><input class="form-control" type="text" data-toggle="tooltip"
                                                       data-bss-tooltip="" name="username" placeholder="Username"
                                                       autofocus="" required="" minlength="4" maxlength="30"
                                                       title="Username"
                                                       value="<c:out value='${lastCandidate.canUsername}' default=''/>">
                        </div>
                        <div class="form-group"><input class="form-control" type="password" data-toggle="tooltip"
                                                       data-bss-tooltip="" name="password" placeholder="Password"
                                                       required="" minlength="8" maxlength="30"
                                                       title="Password"></div>
                        <div class="form-group"><input class="form-control" type="password" data-toggle="tooltip"
                                                       data-bss-tooltip="" name="password-repeat"
                                                       placeholder="Confirm password" required="" minlength="8"
                                                       maxlength="30"
                                                       title="Password repeat"></div>
                        <div class="form-group"><input class="form-control" type="text" data-toggle="tooltip"
                                                       data-bss-tooltip="" name="firstName" placeholder="First Name"
                                                       required="" maxlength="45" title="First name"
                                                       value="<c:out value='${lastCandidate.canfirstName}' default=''/>">
                        </div>
                        <div class="form-group"><input class="form-control" type="text" data-toggle="tooltip"
                                                       data-bss-tooltip="" name="lastName" placeholder="Last Name"
                                                       required="" maxlength="45" title="Last name"
                                                       value="<c:out value='${lastCandidate.canlastName}' default=''/>">
                        </div>
                        <div class="form-group"><input class="form-control" type="email" data-toggle="tooltip"
                                                       data-bss-tooltip="" name="email" placeholder="Email" required=""
                                                       title="Email"
                                                       value="<c:out value='${lastCandidate.canEmail}' default=''/>">
                        </div>
                        <div class="form-group"><input class="form-control" type="tel" data-toggle="tooltip"
                                                       data-bss-tooltip="" name="phoneNo" placeholder="Phone Number"
                                                       title="Phone Number" maxlength="10" inputmode="tel"
                                                       value="<c:out value='${lastCandidate.canPhoneNo}' default=''/>">
                        </div>
                        <div class="form-group">
                            <div class="form-check"><label class="form-check-label"><input class="form-check-input"
                                                                                           type="checkbox">I agree to
                                the license terms.</label></div>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-block" type="submit">Sign Up</button>
                        </div>
                        <a class="already" href="#tab-1">You already have an account? Login here.</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
</body>

</html>