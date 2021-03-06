<%-- 
    Document   : advisor-business-view
    Created on : Mar 28, 2021, 9:25:32 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <link rel="stylesheet" href="assets/css/advisor-post-view.css">
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
            <div class="row text-start d-flex flex-column flex-md-row head-row">
                <div class="col m-auto">
                    <h2 class="info-heading">${company.busClientCompany}</h2>
                    <p>${company.busClientDescription}</p>
                    <hr>
                    <div class="row d-flex flex-column flex-sm-row">
                        <div class="col d-flex align-self-center"><i class="fas fa-envelope business-icon"
                                                                     style="font-size: 24px;"></i>
                            <p>${company.busClientEmail}<c:if test="${company.busClientEmail eq null || company.busClientEmail eq ''}">N/A</c:if></p>
                            </div>
                            <div class="col d-flex align-self-center"><i class="fas fa-globe-americas business-icon"
                                                                         style="font-size: 24px;"></i>
                                <p>${company.busClientWebsite}<c:if test="${company.busClientWebsite eq null || company.busClientWebsite eq ''}">N/A</c:if></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row d-flex flex-column flex-sm-row">
                            <div class="col d-flex align-self-center"><i class="fas fa-phone-alt business-icon"
                                                                         style="font-size: 24px;"></i>
                                <p>${company.busClientPhone}<c:if test="${company.busClientPhone eq null || company.busClientPhone eq ''}">N/A</c:if></p>
                            </div>
                            <div class="col d-flex align-self-center"><i class="fas fa-map-pin business-icon"></i>
                                <p>${company.busClientAddress}<c:if test="${company.busClientAddress eq null || company.busClientAddress eq ''}">N/A</c:if></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row head-row">
                    <div class="col">
                        <div class="d-flex flex-column flex-md-row">
                            <h1 class="display-5 col">Job Posts
                            <c:if test="${requestScope.jobList eq null || fn:length(requestScope.jobList) eq 0}">
                                - N/A
                            </c:if>
                        </h1>
                    </div>
                    <hr>

                    <c:forEach var="job" items="${requestScope.jobList}">
                        <div class="accordion" role="tablist" id="accordion-${job.jobpostingID}">
                            <div class="accordion-item">
                                <h2 class="accordion-header" role="tab">
                                    <button class="accordion-button collapsed header-btn" data-bs-toggle="collapse" data-bs-target="#accordion-${job.jobpostingID} .item-1"
                                            aria-expanded="true" aria-controls="accordion-${job.jobpostingID} .item-1">${job.jobTitle}
                                    </button>
                                </h2>
                                <div class="accordion-collapse collapse collapsed item-1" role="tabpanel" data-bs-parent="#accordion-${job.jobpostingID}">
                                    <div class="accordion-body">
                                        <div class="shadow job-post">
                                            <div class="d-flex flex-column align-items-baseline flex-md-row justify-content-md-between job-header">
                                                <span class="badge rounded-pill bg-secondary stat-badge">${job.jobStatus}</span>
                                                <p>Post date: <c:if test="${job.postDate eq null || job.postDate eq ''}">N/A</c:if>
                                                    <fmt:formatDate value="${job.postDate}" type="date"
                                                                    pattern="yyyy-MM-dd"/></p>

                                                <form action="<c:url value='/advisor-profile'/>" method="POST">
                                                    <input type="hidden" name="jobID" value="${job.jobpostingID}">
                                                    <input type="hidden" name="clientID" value="${company.businessclientID}">
                                                    <input type="hidden" name="advisorForm" value="load-can">
                                                    <button class="btn btn-success" type="submit">Applicants<span
                                                            class="badge bg-dark notif"><c:out value='${job.applicants}' default=''/></span></button>
                                                </form>
                                            </div>
                                            <hr>
                                            <div>
                                                <h4>Description</h4>
                                                <p>${job.jobDescription}<c:if test="${job.jobDescription eq null || job.jobDescription eq ''}">N/A</c:if><br>
                                                    </p>
                                                    <hr>
                                                </div>
                                                <div>
                                                    <h4>Requirements</h4>
                                                    <p>${job.requirements}<c:if test="${job.requirements eq null || job.requirements eq ''}">N/A</c:if><br>
                                                    </p>
                                                    <hr>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i class="fas fa-map-pin business-icon"></i>
                                                        <p>${job.location}<c:if test="${job.location eq null || job.location eq ''}">N/A</c:if></p>
                                                    </div>
                                                    <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline">
                                                        <i class="fas fa-money-bill-alt business-icon"></i>
                                                        <p><c:choose>
                                                            <c:when test="${job.wage eq null || job.wage eq 0}">
                                                                N/A  
                                                            </c:when>

                                                            <c:otherwise>
                                                                $${job.wage} year
                                                            </c:otherwise>
                                                        </c:choose></p>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i
                                                        class="fas fa-hourglass-start business-icon"></i>
                                                    <p><c:if test="${job.startDate eq null || job.startDate eq ''}">N/A</c:if><fmt:formatDate value="${job.startDate}" type="date"
                                                                                                                                               pattern="yyyy-MM-dd"/></p>
                                                </div>
                                                <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline">
                                                    <i class="fas fa-hourglass-end business-icon"></i>
                                                    <p><c:if test="${job.endDate eq null || job.endDate eq ''}">N/A</c:if><fmt:formatDate value="${job.endDate}" type="date"
                                                                                                                                           pattern="yyyy-MM-dd"/></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
        <%--Footer--%>
        <%@ include file="/WEB-INF/jspf/footer.jspf" %>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
        <script src="assets/js/popup.js"></script>
    </body>

</html>