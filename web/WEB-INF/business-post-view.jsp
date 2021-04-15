<%-- 
    Document   : business-post-view
    Created on : Mar 22, 2021, 9:21:52 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Level Ground Recruitment | View Job Postings</title>
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
    <link rel="stylesheet" href="assets/css/business-post.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<%--Navigation bar--%>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<%--Alter section--%>
<%@include file="/WEB-INF/jspf/alert.jspf" %>
<div class="container">
    <div class="row header-row">
        <div class="col header-row">
            <h1 class="display-4 job-title"><c:out value='${jobposting.jobTitle}' default=''/></h1>
        </div>
    </div>
    <div class="row header-row">
        <div class="shadow job-post">
            <div class="d-flex flex-column align-items-baseline flex-md-row justify-content-md-between job-header"><span
                    class="badge rounded-pill bg-secondary stat-badge"><c:out value='${jobposting.jobStatus}' default=''/></span>
                <p>Post date: <fmt:formatDate value="${jobposting.postDate}" type="date" pattern="yyyy-MM-dd"/></p>
                <button class="btn btn-success" type="button">Applicants<span class="badge bg-dark notif"><c:out value='${jobposting.applicants}' default=''/></span>
                </button>
            </div>
            <hr>
            <div>
                <h4>Description</h4>
                <p><c:out value='${jobposting.jobDescription}' default=''/><br></p>
                <hr>
            </div>
            <div>
                <h4>Requirements</h4>
                <p><c:out value='${jobposting.requirements}' default=''/><br></p>
                <hr>
            </div>
            <div class="row">
                <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-map-pin icons"></i>
                    <p><c:out value='${jobposting.location}' default=''/></p>
                </div>
                <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-money-bill-alt icons"></i>
                    <p><c:out value='${jobposting.wage}' default=''/>$ year</p>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-hourglass-start icons"></i>
                    <p><fmt:formatDate value="${jobposting.startDate}" type="date" pattern="yyyy-MM-dd"/></p>
                </div>
                <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-hourglass-end icons"></i>
                    <p><fmt:formatDate value="${jobposting.endDate}" type="date" pattern="yyyy-MM-dd"/></p>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row header-row">
        <div class="col">
            <div class="accordion" role="tablist" id="accordion-1">
                <c:forEach var="candidate" items="${candidates}">
                <div class="accordion-item">
                    <h2 class="accordion-header mb-0" role="tab">
                        <button class="accordion-button candidate-name accordion-button" data-bs-toggle="collapse"
                                data-bs-target="#accordion-1 .item-1" aria-expanded="true"
                                aria-controls="accordion-1 .item-1">Candidate ID: <c:out value='${candidate.candidateID}' default=''/>
                        </button>
                    </h2>
                    <div class="accordion-collapse collapse show item-1 item-content" role="tabpanel"
                         data-bs-parent="#accordion-1">
                        <div class="accordion-body">
                            <div class="row candidate-row">
                                <div class="col-md-5">
                                    <h4>Education</h4>
                                    <hr>
                                    <c:forEach var="education" items="${candidate.educationList}">
                                    <div>
                                        <h6><c:out value='${education.institution}' default=''/></h6>
                                        <p>Level: <c:out value='${education.level}' default=''/></p>
                                        <p>Subject: <c:out value='${education.subject}' default=''/></p>
                                        <p>Duration: <%-- <c:out value='${education.startDate - education.endDate}' default=''/> --%>Start date - End date</p>
                                        <hr>
                                    </div>
                                    </c:forEach>
                                </div>
                                <div class="col-md-5 offset-md-2">
                                    <h4>Work History</h4>
                                    <hr>
                                    <c:forEach var="work" items="${candidate.workHistoryList}">
                                    <div>
                                        <h6><c:out value='${work.company}' default=''/></h6>
                                        <p>Title: <c:out value='${work.title}' default=''/></p>
                                        <p>Duration: <%-- <c:out value='${work.startDate - work.endDate}' default=''/> --%></p>
                                        <p>Reference: <c:out value='${work.reference}' default=''/></p>
                                        <hr>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="row candidate-row">
                                <div class="col-md-5">
                                    <h4>Skills</h4>
                                    <hr>
                                    <c:forEach var="skill" items="${candidate.candidateSkillList}">
                                    <div>
                                        <p>Skill: <c:out value='${skill.skillID.description}' default=''/></p>
                                    </div>
                                    </c:forEach>
                                </div>
                                <div class="col-md-5 offset-md-2">
                                    <h4>Roles</h4>
                                    <hr>
                                    <c:forEach var="role" items="${candidate.roleList}">
                                    <div>
                                        <p>Role: <c:out value='${role.description}' default=''/></p>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="btn-group float-end btn-group" role="group">
                                <button class="btn btn-danger open-work" type="button">Reject</button>
                                <form id="setup_interview" action="<c:url value='/setup-interview'/>" method="post">
                                <button class="btn btn-primary submit-btn" type="submit">Setup Interview</button>
                                <input type="hidden" name="candidateID" value="${candidate.candidateID}">
                                <input type="hidden" name="postingID" value="${jobposting.jobpostingID}">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div class="wrapper">
    <div class="popup work">
        <div class="border rounded popup-content overflow-auto">
            <button class="btn-close float-end close"></button>
            <h3>Remove This Candidate?</h3>
            <div class="d-flex justify-content-center">
                <button class="btn btn-danger" type="button">Permanently Remove This Candidate</button>
            </div>
        </div>
    </div>
</div>
<%--Footer section--%>
<%@include file="/WEB-INF/jspf/footer.jspf" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
<script src="assets/js/popup.js"></script>
</body>

</html>