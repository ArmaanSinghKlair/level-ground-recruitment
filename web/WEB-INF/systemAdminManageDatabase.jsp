<%-- 
    Document   : systemAdminHome
    Created on : Feb. 26, 2021, 1:02:22 p.m.
    Author     : kentp
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>System Administrator</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="assets/css/nav-bar.css">
        <link rel="stylesheet" href="assets/css/default.css">
        <link rel="stylesheet" href="assets/css/login.css">
        <link rel="stylesheet" href="assets/css/signup.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    </head>
    <body onload="<c:if test='${requestScope.currentTab == "signup"}'>document.getElementById('signup-tab-cta').click()</c:if>">
            <nav class="navbar navbar-light navbar-expand-lg navigation-clean-button">
                <div class="container"><a class="navbar-brand d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center" href="index.html"><img class="logo" src="assets/img/logo.png">
                        <h4 class="brand-name">Level Ground Recruitment</h4>
                    </a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navcol-1">
                        <ul class="nav navbar-nav mr-auto flex-md-shrink-0">
                            <li class="nav-item"><a class="nav-link active" data-bs-hover-animate="pulse" href="#">Home</a></li>
                            <li class="nav-item"><a class="nav-link" data-bs-hover-animate="pulse" href="#">Manage Database</a></li>
                        </ul>
                        <span class="d-md-flex flex-md-shrink-0 justify-content-md-center align-items-md-center navbar-text actions"> 
                            <div class="dropdown">
                                <button class="btn btn-primary dropdown-toggle action-button" type="button" id="dropdownMenuButton" data-bs-hover-animate="pulse" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    System Administrator
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="#">Sign Out</a>
                                </div>
                            </div>    
                        </span>
                    </div>
                </div>
            </nav>

        <c:if test="${requestScope.fail == true}">
            <div class="alert alert-warning" role="alert">
                <c:forEach var="error" items="${requestScope.errList}"><div>&#9888; ${error}</div></c:forEach>
                </div>
        </c:if>
        <c:if test="${requestScope.success == true}">
            <div class="alert alert-success" role="alert">
                <span><c:out value="${sucessMessage}" /></span>
            </div>
        </c:if>

        <div class="tabs">
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">
                    <a class="nav-link active" role="tab" data-toggle="tab" href="#tab-1" onclick="revertChanges()">Candidate List</a>
                </li>
                <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">
                    <a class="nav-link" role="tab" data-toggle="tab" data-bss-hover-animate="pulse" href="#tab-2">Job Posting List</a></li>
            </ul>
            <div class="tab-content">


                <div class="tab-pane active" role="tabpanel" id="tab-1">


                    <div class="container default-container rounded">

                        <div class="inner-container shadow p-3 mb-5 rounded">
                            <h5 class="mb-4 font-weight-bold" id="new-job-title">Candidate #${candidate.candidateID}</h5>

                            <div class="candidateProfile">
                                <label for="workExperience">Work Experience</label>

                                <ul>
                                    <c:forEach var="work" items="${candidate.workHistoryCollection}">
                                        <li>
                                            ${work.company} ${work.startDate}
                                        </li>
                                    </c:forEach>
                                </ul>

                                <label for="education">Education</label>
                                <ul>
                                    <c:forEach var="education" items="${candidate.educationCollection}">
                                        <li>
                                            ${education.institution} ${education.subject} ${education.level}
                                        </li>
                                    </c:forEach>
                                </ul>

                                <label for="keySkills">Key Skills</label>
                                <ul>
                                    <c:forEach var="skill" items="${candidate.candidateSkillCollection}">
                                        <li>
                                            ${skill.skill.description}
                                        </li>
                                    </c:forEach>
                                </ul>

                                <label for="interestedRoles">Interested Roles</label>
                                <ul>
                                    <c:forEach var="role" items="${candidate.roleCollection}">
                                        <li>
                                            ${role.description}
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>

                            <div class="center-buttons" id="editButtons${job.jobpostingID}">
                                <button class="delete-button">Delete</button>
                            </div>

                        </div>
                        <c:forEach var="candidate" items="${requestScope.candidateList}">



                        </c:forEach>
                    </div>

                    <c:choose>

                        <c:when test="${requestScope.candidateList eq null}">
                            <div class="container default-container text-center mt-5 text-white">
                                <h4 id="empty-list-title">Candidate List is Empty</h4>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="container default-container rounded">

                                <div class="inner-container shadow p-3 mb-5 rounded">
                                    <h5 class="mb-4 font-weight-bold" id="new-job-title">Candidate #${candidate.candidateID}</h5>

                                    <div class="candidateProfile">
                                        <label for="workExperience">Work Experience</label>

                                        <ul>
                                            <c:forEach var="work" items="${candidate.workHistoryCollection}">
                                                <li>
                                                    ${work.company} ${work.startDate}
                                                </li>
                                            </c:forEach>
                                        </ul>

                                        <label for="education">Education</label>
                                        <ul>
                                            <c:forEach var="education" items="${candidate.educationCollection}">
                                                <li>
                                                    ${education.institution} ${education.subject} ${education.level}
                                                </li>
                                            </c:forEach>
                                        </ul>

                                        <label for="keySkills">Key Skills</label>
                                        <ul>
                                            <c:forEach var="skill" items="${candidate.candidateSkillCollection}">
                                                <li>
                                                    ${skill.skill.description}
                                                </li>
                                            </c:forEach>
                                        </ul>

                                        <label for="interestedRoles">Interested Roles</label>
                                        <ul>
                                            <c:forEach var="role" items="${candidate.roleCollection}">
                                                <li>
                                                    ${role.description}
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>

                                    <div class="center-buttons" id="editButtons${job.jobpostingID}">
                                        <button class="default-button">Hire</button>
                                        <button class="default-button">Interview</button>
                                    </div>

                                </div>
                                <c:forEach var="candidate" items="${requestScope.candidateList}">



                                </c:forEach>
                            </div>
                        </c:otherwise>
                    </c:choose>


                </div>


                <div class="tab-pane" role="tabpanel" id="tab-2">


                    <div class="container default-container rounded">

                        <div class="inner-container shadow p-3 mb-5 rounded">
                            <h5 class="mb-4 font-weight-bold" id="new-job-title">Job Posting #${candidate.candidateID}</h5>

                            <div class="candidateProfile">
                                <label for="workExperience">Company</label>

                                <ul>
                                    <c:forEach var="work" items="${candidate.workHistoryCollection}">
                                        <li>
                                            ${work.company} ${work.startDate}
                                        </li>
                                    </c:forEach>
                                </ul>

                                <label for="education">Requirements</label>
                                <ul>
                                    <c:forEach var="education" items="${candidate.educationCollection}">
                                        <li>
                                            ${education.institution} ${education.subject} ${education.level}
                                        </li>
                                    </c:forEach>
                                </ul>

                                <label for="keySkills">Start Date</label>
                                <ul>
                                    <c:forEach var="skill" items="${candidate.candidateSkillCollection}">
                                        <li>
                                            ${skill.skill.description}
                                        </li>
                                    </c:forEach>
                                </ul>

                                <label for="interestedRoles">End Date</label>
                                <ul>
                                    <c:forEach var="role" items="${candidate.roleCollection}">
                                        <li>
                                            ${role.description}
                                        </li>
                                    </c:forEach>
                                </ul>

                                <label for="interestedRoles">Status</label>
                                <p style="margin-top: 0px;">Full Time</p>
                                <ul>
                                    
                                    <c:forEach var="role" items="${candidate.roleCollection}">
                                        <li>
                                            ${role.description}
                                        </li>
                                    </c:forEach>
                                </ul>

                                <label for="interestedRoles">Description</label>
                                <p style="overflow: auto;">
                                    asafoiasdfoihasifhsadfoihadfiofdasfsdjaifoijasdfaosidfhoiashdfasiofdhasdoifhioashdfsadfihsadofh
                                    iasjdfoiashdfohasdfoiashdfhoiasdfih
                                    ihasdoifhasdfhasodifasdifhasdfh
                                    \oihasdofhasdfhoiasdfahsidfhsdfoih
                                </p>

                                <c:forEach var="role" items="${candidate.roleCollection}">
                                    <p>${test}</p>
                                </c:forEach>
                            </div>

                            <div class="center-buttons" id="editButtons${job.jobpostingID}">
                                <button class="delete-button">Delete</button>
                            </div>

                        </div>
                        <c:forEach var="candidate" items="${requestScope.candidateList}">



                        </c:forEach>
                    </div>

                    <c:choose>

                        <c:when test="${requestScope.candidateList eq null}">
                            <div class="container default-container text-center mt-5 text-white">
                                <h4 id="empty-list-title">Candidate List is Empty</h4>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="container default-container rounded">
                                <c:forEach var="candidate" items="${requestScope.candidateList}">

                                    <div class="inner-container shadow p-3 mb-5 rounded">
                                        <h5 class="mb-4 font-weight-bold" id="new-job-title">Candidate #${candidate.candidateID}</h5>

                                        <div class="candidateProfile">
                                            <label for="workExperience">Work Experience</label>

                                            <ul>
                                                <c:forEach var="work" items="${candidate.workHistoryCollection}">
                                                    <li>
                                                        ${work.company} ${work.startDate}
                                                    </li>
                                                </c:forEach>
                                            </ul>

                                            <label for="education">Education</label>
                                            <ul>
                                                <c:forEach var="education" items="${candidate.educationCollection}">
                                                    <li>
                                                        ${education.institution} ${education.subject} ${education.level}
                                                    </li>
                                                </c:forEach>
                                            </ul>

                                            <label for="keySkills">Key Skills</label>
                                            <ul>
                                                <c:forEach var="skill" items="${candidate.candidateSkillCollection}">
                                                    <li>
                                                        ${skill.skill.description}
                                                    </li>
                                                </c:forEach>
                                            </ul>

                                            <label for="interestedRoles">Interested Roles</label>
                                            <ul>
                                                <c:forEach var="role" items="${candidate.roleCollection}">
                                                    <li>
                                                        ${role.description}
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>

                                        <div class="center-buttons" id="editButtons${job.jobpostingID}">
                                            <button class="default-button">Hire</button>
                                            <button class="default-button">Interview</button>
                                        </div>

                                    </div>

                                </c:forEach>
                            </div>
                        </c:otherwise>
                    </c:choose>


                </div>
            </div>
        </div>










        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
        <script src="assets/js/job-edit.js"></script>
    </body>
</html>
