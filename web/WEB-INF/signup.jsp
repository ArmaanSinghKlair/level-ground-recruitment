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
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/signup.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="assets/css/index.css">
</head>

<body onload="<c:if
        test='${requestScope.currentTab != null}'>document.getElementById('${requestScope.currentTab.trim()}').click()</c:if>">
<%--Wrapper div--%>
<div class="wrapper"></div>
<%--Navigation bat--%>
<%@include file="/WEB-INF/jspf/navbar.jspf" %>
<%--Alter section--%>
<%@include file="/WEB-INF/jspf/alert.jspf" %>
<%--Tabs--%>
<div class="tabs">
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">
            <a class="nav-link active" role="tab" data-bs-toggle="tab" href="#tab-1">Log In</a>
        </li>
        <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">
            <a class="nav-link" role="tab" data-bs-toggle="tab" id="signup-tab-cta" data-bss-hover-animate="pulse" href="#tab-2">Sign Up</a>
        </li>
    </ul>
    <%--Tab content--%>
    <div class="tab-content">
        <%--        Login tab--%>
        <div class="tab-pane fade show active" role="tabpanel" id="tab-1">
            <div class="container login-clean">
                <form method="post" action="<c:url value='/login'></c:url>">
                    <div class="illustration">
                        <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"
                             fill="none" style="color: #1d3557;">
                            <path
                                    d="M15.4857 20H19.4857C20.5903 20 21.4857 19.1046 21.4857 18V6C21.4857 4.89543 20.5903 4 19.4857 4H15.4857V6H19.4857V18H15.4857V20Z"
                                    fill="currentColor"></path>
                            <path
                                    d="M10.1582 17.385L8.73801 15.9768L12.6572 12.0242L3.51428 12.0242C2.96199 12.0242 2.51428 11.5765 2.51428 11.0242C2.51429 10.4719 2.962 10.0242 3.51429 10.0242L12.6765 10.0242L8.69599 6.0774L10.1042 4.6572L16.4951 10.9941L10.1582 17.385Z"
                                    fill="currentColor"></path>
                        </svg>
                    </div>
                    <div class="form-group mb-3">
                        <label for="username-login">
                            <input id="username-login" class="form-control" type="text" name="username"
                                   placeholder="Username"
                                   value="<c:out value='${lastCandidate.canUsername}' default=''/>"/>
                        </label>
                    </div>

                    <div class="form-group mb-3">
                        <label for="pass-login">
                            <input id="pass-login" class="form-control" type="password" name="password"
                                   placeholder="Password"/>
                        </label>
                    </div>
                    <div class="justify-content-lg-center align-items-lg-center login-as form-group mb-3">
                        <h5>Login as</h5>
                        <div class="d-flex flex-column">
                            <input type="radio" class="btn-check" name="userType" id="candidate"
                                   autocomplete="off" value="candidate"
                            <c:if test="${requestScope.lastUserType eq null || requestScope.lastUserType eq 'candidate'}">
                                   checked
                            </c:if>>
                            <label class="btn btn-outline-secondary" for="candidate">Candidate</label>

                            <input type="radio" class="btn-check" name="userType" id="business"
                                   autocomplete="off" value="businessClient"
                            <c:if test="${requestScope.lastUserType eq 'businessClient'}">
                                   checked
                            </c:if>>
                            <label class="btn btn-outline-secondary" for="business">Business</label>
                            <input type="radio" class="btn-check" name="userType" id="admin"
                                   autocomplete="off" value="admin"
                            <c:if test="${requestScope.lastUserType eq 'admin'}">
                                   checked
                            </c:if>>
                            <label class="btn btn-outline-secondary" for="admin">Advisor</label>
                        </div>
                    </div>
                    <div class="form-group mb-3">
                        <button class="btn btn-primary d-block w-100" type="submit" value="Login">Log In</button>
                    </div>
                    <a class="forgot" href="#">Forgot your email or password?</a>
                </form>
            </div>
        </div>
        <%--            Signup tab--%>
        <div class="tab-pane fade" role="tabpanel" id="tab-2">
            <div class="container register-photo">
                <div class="form-container">
                    <div class="image-holder"></div>
                    <form class="signup-form" method="post" action="<c:url value='/user-registration'/>">
                        <h2 class="text-center"><strong>Create</strong> an account</h2>
                        <div class="form-group mb-3">
                            <div class="d-flex justify-content-center signup-type">
                                <input type="radio" class="btn-check" name="userType" id="candidate-reg"
                                       autocomplete="off" value="candidate" onclick="registerCandidate()"
                                ${requestScope.lastClient eq null ? 'checked' : '' } />
                                <label class="btn btn-outline-secondary"
                                       for="candidate-reg">Candidate</label>

                                <input type="radio" class="btn-check" name="userType" id="business-reg"
                                       autocomplete="off" value="businessClient"
                                       onclick="registerBusinessClient()" ${requestScope.lastClient eq null ? ''
                                        : 'checked' } />
                                <label class="btn btn-outline-secondary" for="business-reg">Business</label>
                            </div>

                            <input class="form-control" type="text" data-bs-toggle="tooltip"
                                   data-bss-tooltip="" name="username" placeholder="Username" autofocus=""
                                   required="" minlength="4" maxlength="30" title="Username"
                                   value="<c:out value='${lastCandidate.canUsername}' default=''/>"/>
                        </div>
                        <div class="form-group mb-3">
                            <input class="form-control" type="password" data-bs-toggle="tooltip"
                                   data-bss-tooltip="" name="password" placeholder="Password" required
                                   minlength="8" maxlength="30"
                                   title="Password"/>
                        </div>
                        <div class="form-group mb-3">
                            <input class="form-control" type="password" data-bs-toggle="tooltip"
                                   data-bss-tooltip="" name="password-repeat" placeholder="Password (repeat)"
                                   required="" minlength="8" maxlength="30"
                                   title="Password repeat">
                        </div>
                        <div class="form-group mb-3">
                            <input class="form-control" type="text" data-toggle="tooltip"
                                   data-bss-tooltip="" name="firstName" id="candidateFirstName"
                                   placeholder="First Name"
                                   required="" maxlength="45" title="First name"
                                   value="<c:out value='${lastCandidate.canfirstName}' default=''/>"
                                   style="${requestScope.lastClient eq null ? 'display: block;' : 'display: none;'}" ${requestScope.lastClient eq null ? '' : 'disabled'}>
                        </div>
                        <div class="form-group mb-3">
                            <input class="form-control" type="text" data-toggle="tooltip"
                                   data-bss-tooltip="" name="lastName" id="candidateLastName"
                                   placeholder="Last Name"
                                   required="" maxlength="45" title="Last name"
                                   value="<c:out value='${lastCandidate.canlastName}' default=''/>"
                                   style="${requestScope.lastClient eq null ? 'display: block;' : 'display: none;'}" ${requestScope.lastClient eq null ? '' : 'disabled'}>
                        </div>
                        <div class="form-group mb-3">
                            <input class="form-control" type="text" data-toggle="tooltip"
                                   data-bss-tooltip="" name="company" id="businessCompany"
                                   placeholder="Company"
                                   required="" maxlength="45" title="Company"
                                   value="<c:out value='${lastClient.busClientCompany}' default=''/>"
                                   style="${requestScope.lastClient eq null ? 'display: none;' : 'display: block;'}" ${requestScope.lastClient eq null ? 'disabled' : ''}>
                        </div>
                        <div class="form-group mb-3">
                            <input class="form-control" type="email" data-bs-toggle="tooltip"
                                   data-bss-tooltip="" name="email" placeholder="Email" required=""
                                   title="Email"
                                   value="<c:out value='${lastCandidate eq null ? lastClient.busClientEmail : lastCandidate.canEmail}' default=''/>"/>
                        </div>
                        <div class="form-group mb-3">
                            <input class="form-control" type="tel" data-bs-toggle="tooltip"
                                   data-bss-tooltip="" name="phoneNo" placeholder="Phone Number"
                                   title="Phone Number" maxlength="10" inputmode="tel"
                                   value="<c:out value='${lastCandidate eq null ? lastClient.busClientPhone : lastCandidate.canPhoneNo}' default=''/>"/>
                        </div>
                        <div class="form-group mb-3">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox">
                                    I agree to the license terms.
                                </label>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <button class="btn btn-primary d-block w-100"
                                    type="submit">Sign Up
                            </button>
                        </div>
                        <a class="already" href="<c:url value='/login'/>">You
                            already
                            have an account? Login here.</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jspf/footer.jspf" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
<script src="assets/js/popup.js"></script>
<script src="assets/js/register.js"></script>
</body>

</html>

<%--<html>--%>

<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">--%>
<%--    <title>Level Ground Recruitment | Login | Signup</title>--%>
<%--    <link rel="stylesheet"--%>
<%--          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">--%>
<%--    <link rel="stylesheet"--%>
<%--          href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">--%>
<%--    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">--%>
<%--    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">--%>
<%--    <link rel="stylesheet" href="assets/css/login.css">--%>
<%--    <link rel="stylesheet" href="assets/css/nav-bar.css">--%>
<%--    <link rel="stylesheet" href="assets/css/signup.css">--%>
<%--    <link rel="stylesheet" href="assets/css/styles.css">--%>
<%--</head>--%>

<%--<body onload="<c:if--%>
<%--        test='${requestScope.currentTab != null}'>document.getElementById('${requestScope.currentTab.trim()}').click()</c:if>">--%>

<%--<%@include file="/WEB-INF/jspf/navbar.jspf" %>--%>
<%--<%@include file="/WEB-INF/jspf/alert.jspf" %>--%>

<%--<div class="tabs">--%>
<%--    <ul class="nav nav-tabs" role="tablist">--%>
<%--        <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">--%>
<%--            <a class="nav-link active" role="tab" data-bs-toggle="tab" href="#tab-1">Log In</a>--%>
<%--        </li>--%>
<%--        <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">--%>
<%--            <a class="nav-link" role="tab" data-bs-toggle="tab" data-bss-hover-animate="pulse"--%>
<%--               href="#tab-2">Sign Up--%>
<%--            </a>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--    <div class="tab-content">--%>
<%--        <div class="tab-pane fade show active" role="tabpanel" id="tab-1">--%>
<%--            <div class="container login-clean">--%>
<%--                <form method="post" style="background: #f1faee;" action="<c:url value='/login'></c:url>">--%>
<%--                    <div class="illustration">--%>
<%--                        <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" fill="none"--%>
<%--                             style="color: #1d3557;">--%>
<%--                            <path d="M15.4857 20H19.4857C20.5903 20 21.4857 19.1046 21.4857 18V6C21.4857 4.89543 20.5903 4 19.4857 4H15.4857V6H19.4857V18H15.4857V20Z"--%>
<%--                                  fill="currentColor"></path>--%>
<%--                            <path d="M10.1582 17.385L8.73801 15.9768L12.6572 12.0242L3.51428 12.0242C2.96199 12.0242 2.51428 11.5765 2.51428 11.0242C2.51429 10.4719 2.962 10.0242 3.51429 10.0242L12.6765 10.0242L8.69599 6.0774L10.1042 4.6572L16.4951 10.9941L10.1582 17.385Z"--%>
<%--                                  fill="currentColor"></path>--%>
<%--                        </svg>--%>
<%--                    </div>--%>
<%--                    <div class="form-group"><input class="form-control" type="text" name="username"--%>
<%--                                                   placeholder="Username"--%>
<%--                                                   value="<c:out value='${lastCandidate.canUsername}' default=''/>">--%>
<%--                    </div>--%>
<%--                    <div class="form-group"><input class="form-control" type="password" name="password"--%>
<%--                                                   placeholder="Password"></div>--%>
<%--                    <div class="form-group justify-content-lg-center align-items-lg-center login-as">--%>

<%--                        <h5>Login as</h5>--%>
<%--                        <div class="form-check"><input type="radio" class="form-check-input" id="candidate"--%>
<%--                                                       name="userType" value="candidate"--%>
<%--                                                       <c:if test="${requestScope.lastUserType eq null || requestScope.lastUserType eq 'candidate'}">checked</c:if>/><label--%>
<%--                                class="form-check-label" for="candidate">Candidate</label></div>--%>
<%--                        <div class="form-check"><input type="radio" class="form-check-input" id="business"--%>
<%--                                                       name="userType" value="businessClient"--%>
<%--                                                       <c:if test="${requestScope.lastUserType eq 'businessClient'}">checked</c:if>/><label--%>
<%--                                class="form-check-label" for="business">Business Client</label></div>--%>
<%--                        <div class="form-check"><input type="radio" class="form-check-input" id="admin" name="userType"--%>
<%--                                                       value="admin"--%>
<%--                                                       <c:if test="${requestScope.lastUserType eq 'admin'}">checked</c:if>/><label--%>
<%--                                class="form-check-label" for="admin">Admin</label></div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <button class="btn btn-primary btn-block" type="submit" value="Login">Log In</button>--%>
<%--                    </div>--%>
<%--                    <a class="forgot" href="#">Forgot your email or password?</a>--%>
<%--                </form>--%>


<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="tab-pane fade" role="tabpanel" id="tab-2">--%>
<%--            <div class="container register-photo">--%>
<%--                <div class="form-container">--%>
<%--                    <div class="image-holder"></div>--%>
<%--                    <form action="<c:url value='/user-registration'></c:url>" method="post">--%>
<%--                        <h2 class="text-center"><strong>Create</strong> an account.</h2>--%>

<%--                        <div class="form-group justify-content-lg-center align-items-lg-center login-as">--%>
<%--                            <h5>Register as</h5>--%>
<%--                            <div class="form-check" style="font-size: 1rem;">--%>
<%--                                <input type="radio"--%>
<%--                                                                                    class="form-check-input"--%>
<%--                                                                                    id="candidate" name="userType"--%>
<%--                                                                                    value="candidate"--%>
<%--                                                                                    onclick="registerCandidate();" ${requestScope.lastClient eq null ? 'checked' : ''}/><label--%>
<%--                                    class="form-check-label" for="candidate">Candidate</label></div>--%>
<%--                            <div class="form-check" style="font-size: 1rem;"><input type="radio"--%>
<%--                                                                                    class="form-check-input"--%>
<%--                                                                                    id="business" name="userType"--%>
<%--                                                                                    value="businessClient"--%>
<%--                                                                                    onclick="registerBusinessClient();" ${requestScope.lastClient eq null ? '' : 'checked'}/><label--%>
<%--                                    class="form-check-label" for="business">Business Client</label></div>--%>
<%--                        </div>--%>

<%--                        <div class="form-group"><input class="form-control" type="text" data-toggle="tooltip"--%>
<%--                                                       data-bss-tooltip="" name="username" placeholder="Username"--%>
<%--                                                       autofocus="" required="" minlength="4" maxlength="30"--%>
<%--                                                       title="Username"--%>
<%--                                                       value="<c:out value='${lastCandidate.canUsername}' default=''/>">--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <input class="form-control" type="password" data-toggle="tooltip"--%>
<%--                                                       data-bss-tooltip="" name="password" placeholder="Password"--%>
<%--                                                       required="" minlength="8" maxlength="30"--%>
<%--                                                       title="Password"/>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <input class="form-control" type="password" data-toggle="tooltip"--%>
<%--                                                       data-bss-tooltip="" name="password-repeat"--%>
<%--                                                       placeholder="Confirm password" required="" minlength="8"--%>
<%--                                                       maxlength="30"--%>
<%--                                                       title="Password repeat"/>--%>
<%--                        </div>--%>
<%--<div class="form-group"><input class="form-control" type="text" data-toggle="tooltip"--%>
<%--                               data-bss-tooltip="" name="firstName" id="candidateFirstName"--%>
<%--                               placeholder="First Name"--%>
<%--                               required="" maxlength="45" title="First name"--%>
<%--                               value="<c:out value='${lastCandidate.canfirstName}' default=''/>"--%>
<%--                               style="${requestScope.lastClient eq null ? 'display: block;' : 'display: none;'}" ${requestScope.lastClient eq null ? '' : 'disabled'}>--%>
<%--</div>--%>
<%--<div class="form-group"><input class="form-control" type="text" data-toggle="tooltip"--%>
<%--                               data-bss-tooltip="" name="lastName" id="candidateLastName"--%>
<%--                               placeholder="Last Name"--%>
<%--                               required="" maxlength="45" title="Last name"--%>
<%--                               value="<c:out value='${lastCandidate.canlastName}' default=''/>"--%>
<%--                               style="${requestScope.lastClient eq null ? 'display: block;' : 'display: none;'}" ${requestScope.lastClient eq null ? '' : 'disabled'}>--%>
<%--</div>--%>

<%--<div class="form-group"><input class="form-control" type="text" data-toggle="tooltip"--%>
<%--                               data-bss-tooltip="" name="company" id="businessCompany"--%>
<%--                               placeholder="Company"--%>
<%--                               required="" maxlength="45" title="Company"--%>
<%--                               value="<c:out value='${lastClient.busClientCompany}' default=''/>"--%>
<%--                               style="${requestScope.lastClient eq null ? 'display: none;' : 'display: block;'}" ${requestScope.lastClient eq null ? 'disabled' : ''}>--%>
<%--</div>--%>

<%--                        <div class="form-group"><input class="form-control" type="email" data-toggle="tooltip"--%>
<%--                                                       data-bss-tooltip="" name="email" placeholder="Email" required=""--%>
<%--                                                       title="Email"--%>
<%--                                                       value="<c:out value='${lastCandidate eq null ? lastClient.busClientEmail : lastCandidate.canEmail}' default=''/>">--%>
<%--                        </div>--%>
<%--                        <div class="form-group"><input class="form-control" type="tel" data-toggle="tooltip"--%>
<%--                                                       data-bss-tooltip="" name="phoneNo" placeholder="Phone Number"--%>
<%--                                                       title="Phone Number" maxlength="10" inputmode="tel"--%>
<%--                                                       value="<c:out value='${lastCandidate eq null ? lastClient.busClientPhone : lastCandidate.canPhoneNo}' default=''/>">--%>
<%--                        </div>--%>

<%--                        <div class="form-group">--%>
<%--                            <div class="form-check"><label class="form-check-label"><input class="form-check-input"--%>
<%--                                                                                           type="checkbox">I agree to--%>
<%--                                the license terms.</label></div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <button class="btn btn-primary btn-block" type="submit">Sign Up</button>--%>
<%--                        </div>--%>
<%--                        <a class="already" href="<c:url value='/login'/>">You already have an account? Login here.</a>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<%--<script src="assets/js/jquery.min.js"></script>--%>
<%--<script src="assets/bootstrap/js/bootstrap.min.js"></script>--%>
<%--<script src="assets/js/bs-init.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>--%>
<%--<script src="assets/js/register.js"></script>--%>
<%--</body>--%>

<%--</html>--%>