<%-- 
    Document   : candidate
    Created on : Feb 23, 2021, 9:58:01 AM
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
    <link rel="stylesheet" href="assets/css/profile.css">
    <link rel="stylesheet" href="assets/css/styles.css">
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
                <li class="nav-item"><a class="nav-link" data-bss-hover-animate="pulse" href="#">Job Posting</a></li>
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
                            
                            
<div class="container-md">
    <div class="row text-left head-row">
        <div class="col m-auto">
            <h3><c:out value="${candidate.canfirstName} ${candidate.canlastName}"/></h3>
            <p>Status: ${candidate.placed ? 'Placed' : "Not placed yet"}</p>
        </div>
    </div>
    <div class="row head-row">
        <div class="col-12 col-md-5 sections">
            <div class="d-flex flex-row justify-content-between align-items-baseline">
                <h4>Info</h4>
                <form class="ignore">
                    <div class="form-group">
                        <button class="btn btn-outline-success" type="submit"><i class="fas fa-plus-circle"
                                                                                 value="addInfo"></i></button>
                    </div>
                </form>
            </div>
            <hr>
            <form data-aos="fade-up" class="info-form">
                <div class="form-group">
                    <p>About:</p>
                    <p>Email: <c:out value="${candidate.canEmail}"/></p>
                    <p>Phone Number: <c:out value="${candidate.canPhoneNo}"/></p>
                </div>
                <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                    <div class="btn-group" role="group">
                        <button class="btn" data-toggle="tooltip" type="submit" title="Edit"><i class="far fa-edit"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-12 col-md-5 offset-md-2 sections">
            <div class="d-flex flex-row justify-content-between align-items-baseline">
                <h4>Education</h4>
                <form class="ignore">
                    <div class="form-group">
                        <button class="btn btn-outline-success" type="submit"><i class="fas fa-plus-circle"
                                                                                 value="addEducation"></i></button>
                    </div>
                </form>
            </div>
            <hr>
            <c:forEach var="education" items="${candidate.educationCollection}">
                <form data-aos="fade-up" action="<c:url value='/candidate-profile'/>" method="post">
                    <input type="hidden" name="form_name" value="education"/>
                    <input type="hidden" name="id" value="${education.educationID}"/>
                    <input type="hidden" name="action" value="profilePageAction" />
                    <div class="form-group">
                        <h6>${education.institution}</h6>
                        <p>${education.level}</p>
                        <p>${education.subject}</p>
                        <p>${education.startDate} - ${education.endDate}</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group">
                            <button class="btn" data-toggle="tooltip" type="submit" name="submit" value="delete" title="Delete"><i
                                    class="far fa-window-close"></i></button>
                            <button class="btn" data-toggle="tooltip" type="submit" name="submit" value="edit"  title="Edit"><i
                                    class="far fa-edit"></i></button>
                        </div>
                    </div>
                </form>
            </c:forEach>
        </div>
    </div>
    <div class="row row-cols-2 row-cols-sm-1 head-row">
        <div class="col-12 col-md-5 sections">
            <div class="d-flex flex-row justify-content-between align-items-baseline">
                <h4>Work History</h4>
                <form class="ignore">
                    <div class="form-group">
                        <button class="btn btn-outline-success" type="submit" value="addWork"><i
                                class="fas fa-plus-circle"></i></button>
                    </div>
                </form>
            </div>
            <hr>
            <c:forEach var="workHistory" items="${candidate.workHistoryCollection}">
                <form data-aos="fade-up" action="<c:url value='/candidate-profile'/>" method="POST">
                    <input type="hidden" name="form_name" value="workHistory"/>
                    <input type="hidden" name="id" value="${workHistory.workHistoryId}"/>
                    <input type="hidden" name="action" value="profilePageAction" />
                    <div class="form-group">
                        <h6>${workHistory.company}</h6>
                        <p>${workHistory.title}</p>
                        <p>${workHistory.startDate}</p>
                        <p>${workHistory.endDate}</p>
                        <p>${workHistory.reference}</p>
                    </div>
                    <div class="d-flex d-sm-flex d-xl-flex justify-content-end modify-btns">
                        <div class="btn-group" role="group">
                            <button class="btn" data-toggle="tooltip" type="submit" name="submit" value="delete" title="Delete"><i
                                    class="far fa-window-close"></i></button>
                            <button class="btn" data-toggle="tooltip" type="submit" title="Edit"><i
                                    class="far fa-edit"></i></button>
                        </div>
                    </div>
                </form>
            </c:forEach>

        </div>
        <div class="col-12 col-md-5 offset-md-2 sections">
            <div class="d-flex flex-row justify-content-between align-items-baseline">
                <h4>Skills</h4>
                <form class="ignore">
                    <div class="form-group">
                        <button class="btn btn-outline-success" type="submit"><i class="fas fa-plus-circle"
                                                                                 value="addSkill"></i></button>
                    </div>
                </form>
            </div>
            <hr>
            <c:forEach var="candidateSkill" items="${candidate.candidateSkillCollection}">
                <form class="form-inline justify-content-between" data-aos="fade-up" action="<c:url value='/candidate-profile'/>" method="POST">
                    <input type="hidden" name="form_name" value="skills"/>
                    <input type="hidden" name="id" value=""/>
                    <input type="hidden" name="action" value="profilePageAction" />
                    <div class="form-group" style="width:100%">
                        <p>${candidateSkill.skill.description}</p>
                    </div>
                    <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                        <div class="btn-group" role="group">
                            <button class="btn" data-toggle="tooltip" type="submit" name="submit" value="delete" title="Delete"><i
                                    class="far fa-window-close"></i></button>
                            <button class="btn" data-toggle="tooltip" type="submit" title="Edit"><i
                                    class="far fa-edit"></i></button>
                        </div>
                    </div>
                </form>
            </c:forEach>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
</body>

</html>
