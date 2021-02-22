<%-- 
    Document   : businessClientCandidateList
    Created on : Feb. 16, 2021, 4:40:19 p.m.
    Author     : kentp
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Business Client</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="assets/css/nav-bar.css">
        <link rel="stylesheet" href="assets/css/default.css">
        <link rel="stylesheet" href="assets/css/login.css">
        <link rel="stylesheet" href="assets/css/signup.css">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>
    <body>
        <nav class="navbar navbar-light navbar-expand-lg navigation-clean-button">
            <div class="container"><a class="navbar-brand d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center" href="index.html"><img class="logo" src="assets/img/logo.png">
                    <h4 class="brand-name">Level Ground Recruitment</h4>
                </a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav mr-auto flex-md-shrink-0">
                        <li class="nav-item"><a class="nav-link active" data-bs-hover-animate="pulse" href="index.html">Home</a></li>
                        <li class="nav-item"><a class="nav-link" data-bs-hover-animate="pulse" href="#">Candidate List</a></li>
                    </ul>
                    <span class="d-md-flex flex-md-shrink-0 justify-content-md-center align-items-md-center navbar-text actions"> 
                        <div class="dropdown">
                            <button class="btn btn-primary dropdown-toggle action-button" type="button" id="dropdownMenuButton" data-bs-hover-animate="pulse" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Business Client
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Sign Out</a>
                            </div>
                        </div>
                    </span>
                </div>
            </div>
        </nav>


        <div class="tabs">
            <ul class="nav nav-tabs" role="tablist"></ul>
        </div>

        <c:choose>

            <c:when test="${requestScope.candidateList eq null}">
                <div class="container default-container text-center mt-5 text-white">
                    <h4>Candidate List is Empty</h4>
                </div>
            </c:when>

            <c:otherwise>
                <div class="container default-container">
                    <c:forEach var="candidate" items="${requestScope.candidateList}">

                        <div class="inner-container">
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







        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
    </body>
</html>
