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

        <%@include file="/WEB-INF/jspf/navbar.jspf"%>
        <%@include file="/WEB-INF/jspf/alert.jspf"%>

        <!--
            ***MAIN SECTION***
          
            I'm still using the tab approach to keep the page alignment consistent but this page only has 1 tab
            
        -->
        <div class="tabs">
            <ul class="nav nav-tabs" role="tablist"></ul>
            <c:choose>

                <c:when test="${requestScope.candidateList eq null}">
                    <div class="container default-container">
                        <h4 id="empty-list-title">Candidate List is Empty</h4>
                    </div>
                </c:when>

                <c:otherwise>
                    <div class="container default-container">
                        <c:forEach var="candidate" items="${requestScope.candidateList}">

                            <div class="inner-container shadow p-3 mb-5">
                                <h5 class="container-header">Candidate #${candidate.candidateID}</h5>

                                <dl>
                                    <dt class="section-label">Work Experience</dt>
                                    <c:forEach var="work" items="${candidate.workHistoryCollection}">
                                        <dd>
                                            ${work.company} ${work.startDate}
                                        </dd>
                                    </c:forEach>

                                    <dt class="section-label">Education</dt>
                                    <c:forEach var="education" items="${candidate.educationCollection}">
                                        <dd>
                                            ${education.institution} ${education.subject} ${education.level}
                                        </dd>
                                    </c:forEach>

                                    <dt class="section-label">Key Skills</dt>
                                    <c:forEach var="skill" items="${candidate.candidateSkillCollection}">
                                        <dd>
                                            ${skill.skill.description}
                                        </dd>
                                    </c:forEach>

                                    <dt class="section-label">Interested Roles</dt>
                                    <c:forEach var="role" items="${candidate.roleCollection}">
                                        <dd>
                                            ${role.description}
                                        </dd>
                                    </c:forEach>
                                </dl>

                                <div>
                                    <button class="default-button primary-button">Hire</button>
                                    <button class="default-button primary-button">Interview</button>
                                </div>

                            </div>

                        </c:forEach>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>









        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
    </body>
</html>
