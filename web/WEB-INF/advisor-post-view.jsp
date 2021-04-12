<%-- 
    Document   : advisor-post-view
    Created on : Mar 28, 2021, 9:26:16 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <link rel="stylesheet" href="assets/css/advisor-job-view.css">
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
                <div class="col"><a href="#">
                        <h2 class="display-5 info-heading">${company.busClientCompany}</h2>
                    </a>
                    <p><br>${company.busClientDescription}<br><br></p>
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
                    <div class="col">
                        <h1 class="display-5">${job.jobTitle}</h1>
                    <hr>
                    <div class="shadow job-post">
                        <div class="d-flex flex-column align-items-baseline justify-content-md-between flex-lg-row job-header">
                            <span class="badge rounded-pill bg-secondary stat-badge">${job.jobStatus}</span>
                            <p>Post date: <c:if test="${job.postDate eq null || job.postDate eq ''}">N/A</c:if><fmt:formatDate value="${job.postDate}" type="date"
                                                                                                                     pattern="yyyy-MM-dd"/></p>
                        </div>
                        <hr>
                        <div>
                            <h4>Description</h4>
                            <p>${job.jobDescription}<c:if test="${job.jobDescription eq null || job.jobDescription eq ''}">N/A</c:if><br></p>
                                <hr>
                            </div>
                            <div>
                                <h4>Requirements</h4>
                                <p>${job.requirements}<c:if test="${job.requirements eq null || job.requirements eq ''}">N/A</c:if><br></p>
                                <hr>
                            </div>
                            <div class="row d-flex flex-column flex-lg-row">
                                <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i
                                        class="fas fa-map-pin icons"></i>
                                    <p>${job.location}<c:if test="${job.location eq null || job.location eq ''}">N/A</c:if></p>
                                </div>
                                <div class="col-md-5 offset-lg-1 d-flex justify-content-between align-items-baseline"><i
                                        class="fas fa-money-bill-alt icons"></i>

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
                        <div class="row d-flex flex-column flex-lg-row">
                            <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i
                                    class="fas fa-hourglass-start icons"></i>
                                <p><c:if test="${job.startDate eq null || job.startDate eq ''}">N/A</c:if><fmt:formatDate value="${job.startDate}" type="date"
                                                                                                                           pattern="yyyy-MM-dd"/></p>
                            </div>
                            <div class="col-md-5 offset-lg-1 d-flex justify-content-between align-items-baseline"><i
                                    class="fas fa-hourglass-end icons"></i>
                                <p><c:if test="${job.endDate eq null || job.endDate eq ''}">N/A</c:if><fmt:formatDate value="${job.endDate}" type="date"
                                                                                                                       pattern="yyyy-MM-dd"/></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row head-row">
                <div class="col">
                    <div class="d-flex flex-column flex-md-row">
                        <h1 class="display-5 col">Candidates
                            <c:choose>

                                <c:when test="${requestScope.candidateList eq null}">
                                    - N/A
                                </c:when>

                                <c:otherwise>
                                    <div class="d-flex align-self-center justify-content-md-end input-group col">
                                        <div class="form-outline"><input type="search" id="form1" class="form-control"
                                                                         placeholder="Search..."></div>
                                        <button class="btn btn-primary" type="button"><i class="fa fa-search"></i></button>
                                    </div>
                                </c:otherwise>

                            </c:choose></h1>
                    </div>
                    <hr>

                    <%--<c:forEach var="candidate" items="${requestScope.candidateList}">--%>
                    <div class="accordion" role="tablist" id="accordion-1">
                        <div class="accordion-item">
                            <h2 class="accordion-header" role="tab">
                                <button class="accordion-button" data-bs-toggle="collapse" data-bs-target="#accordion-1 .item-1"
                                        aria-expanded="true" aria-controls="accordion-1 .item-1">Candidate ID: ${candidateID}
                                </button>
                            </h2>
                            <div class="accordion-collapse collapse show item-1 shadow" role="tabpanel"
                                 data-bs-parent="#accordion-1">
                                <div class="accordion-body">
                                    <div class="row candidate-row">
                                        <div class="col-md-5">
                                            <c:choose>
                                                <c:when test="${candidate.educationList eq null}">
                                                    <h4>Education - N/A</h4>
                                                    <hr>
                                                </c:when>

                                                <c:otherwise>
                                                    <h4>Education</h4>
                                                    <hr>
                                                    <div>
                                                        <c:forEach var="education" items="${candidate.educationList}">

                                                            <div class="d-flex align-items-baseline">
                                                                <h6>Institution:&nbsp;</h6>
                                                                <p>${education.institution}</p>
                                                            </div>
                                                            <div class="d-flex align-items-baseline">
                                                                <h6>Education Level:&nbsp;</h6>
                                                                <p>${education.level}</p>
                                                            </div>
                                                            <div class="d-flex align-items-baseline">
                                                                <h6>Subject:&nbsp;</h6>
                                                                <p>${education.subject}</p>
                                                            </div>
                                                            <div class="d-flex align-items-baseline">
                                                                <h6>Date:&nbsp;</h6>
                                                                <p><fmt:formatDate value="${education.startDate}" type="date"
                                                                                pattern="yyyy-MM-dd"/> - 
                                                                    <c:choose>
                                                                        <c:when test="${education.endDate !=null}">
                                                                            <fmt:formatDate value="${education.endDate}" type="date"
                                                                                            pattern="yyyy-MM-dd"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            current
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </p>
                                                            </div>

                                                        </c:forEach>
                                                        <hr/>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>

                                        <div class="col-md-5 offset-md-2">
                                            <c:choose>
                                                <c:when test="${candidate.workHistoryList eq null}">
                                                    <h4>Work History - N/A</h4>
                                                    <hr>
                                                </c:when>

                                                <c:otherwise>
                                                    <h4>Work History</h4>
                                                    <hr>
                                                    <div>
                                                        <c:forEach var="work" items="${candidate.workHistoryList}">
                                                            <div class="d-flex align-items-baseline">
                                                                <h6>Company:&nbsp;</h6>
                                                                <p>${work.company}</p>
                                                            </div>
                                                            <div class="d-flex align-items-baseline">
                                                                <h6>Title:&nbsp;</h6>
                                                                <p>${work.title}</p>
                                                            </div>
                                                            <div class="d-flex align-items-baseline">
                                                                <h6>Start Date:&nbsp;</h6>
                                                                <p><fmt:formatDate value="${work.startDate}" type="date"
                                                                                pattern="yyyy-MM-dd"/> 
                                                                </p>
                                                            </div>
                                                            <div class="d-flex align-items-baseline">
                                                                <h6>End Date:&nbsp;</h6>
                                                                <p>
                                                                    <c:choose>
                                                                        <c:when test="${work.endDate !=null}">
                                                                            <fmt:formatDate value="${work.endDate}" type="date"
                                                                                            pattern="yyyy-MM-dd"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            current
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </p>
                                                            </div>
                                                            <div class="d-flex align-items-baseline">
                                                                <h6>Reference:&nbsp;</h6>
                                                                <p>${work.reference}</p>
                                                            </div>
                                                        </c:forEach>
                                                        <hr/>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>
                                    <div class="row candidate-row">
                                        <div class="col-md-5">
                                            <c:choose>
                                                <c:when test="${candidate.skillList eq null}">
                                                    <h4>Skill - N/A</h4>
                                                    <hr>
                                                </c:when>

                                                <c:otherwise>
                                                    <h4>Skill</h4>
                                                    <hr/>
                                                    <div>
                                                        <c:forEach var="skill" items="${skillList}">
                                                            <p>${skill.description}</p>
                                                        </c:forEach>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                        <div class="col-md-5 offset-md-2">
                                            <c:choose>
                                                <c:when test="${candidate.roleList eq null}">
                                                    <h4>Role - N/A</h4>
                                                    <hr>
                                                </c:when>

                                                <c:otherwise>
                                                    <h4>Role</h4>
                                                    <hr/>
                                                    <c:forEach var="role" items="${candidate.roleList}">
                                                        <div>
                                                            <p>${role.description}</p>
                                                        </div>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>
                                    <form class="d-flex justify-content-end can-from">
                                        <div class="btn-group" role="group">
                                            <button class="btn btn-danger open-work" type="button">Reject</button>
                                            <button class="btn btn-success" type="button">Approve</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--</c:forEach>--%>
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