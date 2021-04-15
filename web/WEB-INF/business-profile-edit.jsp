<%-- 
    Document   : business-profile-edit
    Created on : Mar 24, 2021, 10:46:16 AM
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
    <title>Level Ground Recruitment | Edit Profile</title>
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
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/profile-edit.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<%--Navigation bar--%>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<%--Alter section--%>
<%@include file="/WEB-INF/jspf/alert.jspf" %>
<div class="container">
    <div class="row">
        <div class="col-12 col-lg-10 offset-lg-1">
            <div class="d-md-flex flex-md-row-reverse">
                <ul class="nav nav-tabs d-flex flex-column edit-items" role="tablist">
                    <li class="nav-item shadow-sm" role="presentation"><a class="nav-link active" role="tab"
                                                                          data-bs-toggle="tab" href="#tab-1">Business
                        Information</a></li>
                    <li class="nav-item shadow-sm" role="presentation"><a class="nav-link" role="tab"
                                                                          data-bs-toggle="tab" href="#tab-4">Job
                        Postings</a></li>
                </ul>
                <div class="tab-content edit-content">
                    <div class="tab-pane fade show active" role="tabpanel" id="tab-1">
                        <div class="row d-flex flex-column align-items-center flex-md-row">
                            <div class="col">
                                <h1><c:out value="${businessClient.busClientUsername}"/></h1>
                                <p class="text-muted">Joined 01 Jan 2021</p>
                            </div>
                            <div class="col d-flex justify-content-center">
                                <button class="btn btn-danger open-remove" type="submit">Remove Account</button>
                            </div>
                        </div>
                        <div class="wrapper">
                            <div class="remove-acc-alert popup">
                                <div class="border rounded popup-content">
                                    <button class="btn-close float-end close"></button>
                                    <h5 class="text-center">Are you sure you want to remove your Account?</h5>
                                    <div class="d-flex justify-content-center" style="padding: 15px;">
                                        <button class="btn btn-danger" type="submit">Permanently Remove My Account
                                        </button>
                                    </div>
                                    <p class="lead text-center warming-txt"><em>You can't recover your account after
                                        removing it</em></p>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <form class="edit-form" id="edit-profile" action="<c:url value='/edit-client-profile'/>" method="post">
                            <div class="row">
                                <div class="col-12 col-md-5">
                                    <div class="form-group mb-3"><label class="form-label" for="businessName">Business
                                        Name</label><input class="form-control" type="text" id="businessName"
                                                           name="businessName" value="<c:out value="${businessClient.busClientCompany}" default=''/>"></div>
                                </div>
                                <div class="col-12 col-md-5 offset-md-1">
                                    <div class="form-group mb-3"><label class="form-label"
                                                                        for="username">Username</label><input
                                                           class="form-control" type="text" id="username" name="username" value="<c:out value="${businessClient.busClientUsername}" default=''/>"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-md-5">
                                    <div class="form-group mb-3"><label class="form-label"
                                                                        for="email">Email</label><input
                                            class="form-control" type="email" id="email" name="email" value="<c:out value="${businessClient.busClientEmail}" default=''/>"></div>
                                </div>
                                <div class="col-12 col-md-5 offset-md-1">
                                    <div class="form-group mb-3"><label class="form-label"
                                                                        for="phone">Phone</label><input
                                            class="form-control" type="tel" id="phone" name="phone" value="<c:out value="${businessClient.busClientPhone}" default=''/>"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-11">
                                    <div class="form-group mb-3"><label class="form-label" for="address">Address</label><input
                                            class="form-control" type="text" id="address" name="address" value="<c:out value="${businessClient.busClientAddress}" default=''/>"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-11">
                                    <div class="form-group mb-3"><label class="form-label" for="website">Website</label><input
                                            class="form-control" type="text" id="website" name="website" value="<c:out value="${businessClient.busClientWebsite}" default=''/>"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-md-8">
                                    <div class="form-group mb-3"><label class="form-label"
                                                                        for="about">About</label><textarea
                                            class="form-control" id="about" rows="5" placeholder="About Business..."
                                            name="about"><c:out value="${businessClient.busClientDescription}" default=''/></textarea></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-md-5">
                                    <h5>Change Password</h5>
                                    <div class="form-group mb-3"><label class="form-label" for="cur-pass">Current
                                            Password</label><input class="form-control" type="password" id="cur-pass" name="cur-pass"
                                                               placeholder="****"></div>
                                    <div class="form-group mb-3"><label class="form-label" for="new-pass">New
                                        Password</label><input class="form-control" type="password" id="new-pass" name="new-pass"></div>
                                    <div class="form-group mb-3"><label class="form-label" for="conf-pass">Confirm
                                        Password</label><input class="form-control" type="password" id="conf-pass" name="conf-pass">
                                    </div>
                                </div>
                                <div class="col-12 col-md-5 offset-md-2 d-flex flex-column justify-content-end align-items-start">
                                    <h5 class="display-4">Apply Changes</h5>
                                    <div class="btn-group d-flex" role="group">
                                        <button class="btn btn-secondary" type="reset" style="color: #f1faee;">Reset
                                        </button>
                                        <button class="btn btn-dark succ" type="submit">Save Changes</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" role="tabpanel" id="tab-4">
                        <div class="accordion" role="tablist" id="accordion-3">
                            <c:forEach var="posting" items="${jobPostings}">
                            <div class="accordion-item">
                                <h2 class="accordion-header mb-0" role="tab">
                                    <button class="accordion-button d-flex justify-content-between header-btn"
                                            data-bs-toggle="collapse" data-bs-target="#accordion-3 .item-1"
                                            aria-expanded="true" aria-controls="accordion-3 .item-1"><c:out value="${posting.jobTitle}" default=''/> <fmt:formatDate value="${posting.postDate}" type="date" pattern="yyyy-MM-dd"/></button>
                                </h2>
                                <div class="accordion-collapse collapse show item-1" role="tabpanel"
                                     data-bs-parent="#accordion-3">
                                    <div class="accordion-body">
                                        <form id="Posting_edit" action="<c:url value='/edit-job-posting'/>" method="post">
                                            <div class="row">
                                                <div class="col justify-content-center"><label class="col-form-label">Title<input
                                                        class="form-control" type="text" value="<c:out value="${posting.jobTitle}" default=''/>"></label></div>
                                                <div class="col justify-content-center"><label class="col-form-label">Status<select
                                                        class="form-select">
                                                    <option value="fullTime" <c:if test="${posting.jobStatus.equals('fullTime')}">selected</c:if>>Full-Time</option>
                                                    <option value="partTime" <c:if test="${posting.jobStatus.equals('partTime')}">selected</c:if>>Part-Time</option>
                                                    <option value="temporary" <c:if test="${posting.jobStatus.equals('temporary')}">selected</c:if>>Temporary</option>
                                                </select></label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col"><label class="col-form-label">Wage<input
                                                        class="form-control" type="text" value="<c:out value="${posting.wage}" default=''/>"></label></div>
                                                <div class="col"><label class="col-form-label">Location<input
                                                        class="form-control" type="text" value="<c:out value="${posting.location}" default=''/>"></label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col"><label class="col-form-label">Start Date<input
                                                        class="form-control" type="date" value="<fmt:formatDate value="${posting.startDate}" type="date" pattern="yyyy-MM-dd"/>"></label></div>
                                                <div class="col"><label class="col-form-label">End Date<input
                                                        class="form-control" type="date" value="<fmt:formatDate value="${posting.endDate}" type="date" pattern="yyyy-MM-dd"/>"></label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col justify-content-center"><label class="form-label">Description</label><textarea
                                                        class="form-control" rows="3" value="<c:out value="${posting.jobDescription}" default=''/>"></textarea></div>
                                            </div>
                                            <div class="row">
                                                <div class="col justify-content-center"><label class="form-label">Requirements</label><textarea
                                                        class="form-control" rows="3" value="<c:out value="${posting.requirements}" default=''/>"></textarea></div>
                                            </div>
                                            <div class="row" style="padding-top: 20px;">
                                                <div class="col d-flex justify-content-end">
                                                    <form id="permanent_deletion" action="<c:url value='/delete-job-posting'/>" method="post">
                                                    <button class="btn btn-danger open-work" type="submit"
                                                            style="margin-right: 20px;">Remove
                                                    </button>
                                                    <input id="<c:out value="${posting.jobpostingID}"/>" type="hidden" name="postingID" value="<c:out value="${posting.jobpostingID}"/>">
                                                    </form>
                                                    <button class="btn btn-primary succ open-edu" type="button">Save
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
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