<%-- 
    Document   : business-client-home
    Created on : Mar 22, 2021, 9:18:43 AM
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
    <link rel="stylesheet" href="assets/css/business.css">
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
<div class="wrapper">
    <div class="popup edu">
        <div class="border rounded popup-content overflow-auto">
            <button class="btn-close float-end close"></button>
            <h3>Add New Job Posting</h3>
            <form class="ignore popup-form" action="<c:url value='/business-client-profile'/>" method="post">
                <div class="row d-flex justify-content-around new-post-row">
                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Title</label><input
                            class="form-control new-post-row" type="text" name="title" autofocus=""
                            ></div>
                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Status</label><select
                            class="form-select level-slc new-post-row" name="status">
                        <option value="fullTime" selected="">Full-Time</option>
                        <option value="partTime">Par-Time</option>
                        <option value="temperory">Temperory</option>
                    </select></div>
                </div>
                <div class="row d-flex new-post-row">
                    <div class="col-md-6 form-row new-post-row"><label
                            class="form-label new-post-row">Requirment</label><textarea
                                class="form-control new-post-row" rows="5" name="requirement"></textarea></div>
                    <div class="col-md-6 new-post-row"><label
                            class="form-label new-post-row">Description</label><textarea
                                class="form-control new-post-row" rows="5" name="description"></textarea></div>
                </div>
                <div class="row d-flex justify-content-around new-post-row">
                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Wage</label><input
                            class="form-control new-post-row" type="text" name="wage" autofocus=""
                            ></div>
                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Location</label><input
                            class="form-control new-post-row" type="text" name="location"></div>
                </div>
                <div class="row d-flex justify-content-around new-post-row">
                    <div class="col-md-6"><label class="form-label">Start Date</label><input class="form-control"
                                                                                             name="startDate"
                                                                                             type="date"></div>
                    <div class="col-md-6"><label class="form-label">End Date</label><input class="form-control"
                                                                                           name="endDate"
                                                                                           type="date"></div>
                    <input type="hidden" name="username" value="${businessClient.busClientUsername}">
                </div>
                <div class="btn-group d-flex popup-btns" role="group">
                    <button class="btn btn-secondary" type="reset">Reset</button>
                    <button class="btn btn-success"  type="submit">Add</button>
                </div>
            </form>
        </div>
    </div>
    <div class="popup work">
        <div class="border rounded popup-content overflow-auto">
            <button class="btn-close float-end close"></button>
            <h3>Delete this Posting?</h3>
            <div class="d-flex justify-content-center">
                <form action="<c:url value='/delete-job-posting'/>" method="post">
                <button class="btn btn-danger" type="submit">Permanently Remove This Post</button>
                <input type="hidden" name="postingID" value="${postingID}">
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container-md">
    <div class="row text-start head-row">
        <div class="col m-auto">
            <h3 class="display-5"><c:out value="${businessClient.busClientCompany}"/></h3>
        </div>
    </div>
    <div class="row head-row">
        <div class="col-12 col-md-5 sections">
            <div class="d-flex flex-row justify-content-between align-items-baseline">
                <h4 class="display-6">Info</h4>
            </div>
            <hr>
            <form class="shadow-sm info-form" data-aos="fade-up">
                <div class="d-flex flex-column form-group mb-3">
                    <h6>About: </h6>
                    <p><c:out value="${businessClient.busClientDescription}"/></p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Email: </h6>
                    <p><c:out value="${businessClient.busClientEmail}"/></p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Phone: </h6>
                    <p><c:out value="${businessClient.busClientPhone}"/></p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Address: </h6>
                    <p><c:out value="${businessClient.busClientAddress}"/></p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Website:</h6>
                    <p><c:out value="${businessClient.busClientWebsite}"/></p>
                </div>
                <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                    <div class="btn-group" role="group"><a class="btn" role="button" data-bs-toggle="tooltip"
                                                           data-bss-tooltip="" title="Edit" href="profile-edit.html"><i
                            class="far fa-edit" data-bss-hover-animate="pulse"></i></a></div>
                </div>
            </form>
        </div>
        <div class="col-12 col-md-5 offset-md-2 sections">
            <div class="d-flex flex-row justify-content-between align-items-baseline">
                <h4 class="display-6">Postings</h4>
                <button class="btn btn-outline-success open-edu" data-bss-hover-animate="pulse" type="submit"><i
                        class="fas fa-plus-circle open" data-bss-hover-animate="pulse" value="addEducation"></i>
                </button>
            </div>
            <hr>
            <c:forEach var="posting" items="${jobPostings}">
                <form class="shadow-sm" data-aos="fade-up">
                    <div class="d-flex form-group mb-3">
                        <h6>Title:</h6>
                        <p><c:out value="${posting.jobTitle}"/></p>
                    </div>
                    <div class="d-flex form-group mb-3">
                        <h6>Start Date:</h6>
                        <p><c:out value="${posting.startDate}"/></p>
                    </div>
                    <div class="d-flex form-group mb-3">
                        <h6>End Date:</h6>
                        <p><c:out value="${posting.endDate}"/></p>
                    </div>
                    <div class="posting div">
                        <div class="d-flex justify-content-around modify-btns">
                            <button class="btn btn-danger open-work" type="button" action="<c:set var="postingID" scope="session" value="${posting.jobpostingID}"/>">Remove</button>
                            <button class="btn submit-btn" type="button">View Candidates</button>
                        </div>
                    </div>
                </form>
            </c:forEach>
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

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--    <title>JSP Page</title>--%>
<%--    <link rel="stylesheet"--%>
<%--          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet"--%>
<%--          href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">--%>
<%--    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">--%>
<%--    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">--%>
<%--    <link rel="stylesheet" href="assets/css/business.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">--%>
<%--    <link rel="stylesheet" href="assets/css/nav-bar.css">--%>
<%--    <link rel="stylesheet" href="assets/css/styles.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="wrapper">--%>
<%--    <div class="popup edu">--%>
<%--        <div class="border rounded popup-content overflow-auto">--%>
<%--            <button class="btn-close float-end close"></button>--%>
<%--            <h3>Add New Job Posting</h3>--%>
<%--            <form class="ignore popup-form" action="<c:url value='/business-client-profile'/>" method="post">--%>
<%--                <div class="row d-flex justify-content-around new-post-row">--%>
<%--                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Title</label><input--%>
<%--                            class="form-control new-post-row" type="text" name="title" autofocus="" title="Institution">--%>
<%--                    </div>--%>
<%--                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Status</label><select--%>
<%--                            class="form-select level-slc new-post-row" name="status">--%>
<%--                        <option value="fullTime" selected="">Full-Time</option>--%>
<%--                        <option value="partTime">Part-Time</option>--%>
<%--                        <option value="temporary">Temporary</option>--%>
<%--                    </select></div>--%>
<%--                </div>--%>
<%--                <div class="row d-flex new-post-row">--%>
<%--                    <div class="col-md-6 form-row new-post-row"><label--%>
<%--                            class="form-label new-post-row">Requirement</label><textarea--%>
<%--                            class="form-control new-post-row" rows="5" name="requirement"></textarea></div>--%>
<%--                    <div class="col-md-6 new-post-row"><label--%>
<%--                            class="form-label new-post-row">Description</label><textarea--%>
<%--                            class="form-control new-post-row" rows="5" name="description"></textarea></div>--%>
<%--                </div>--%>
<%--                <div class="row d-flex justify-content-around new-post-row">--%>
<%--                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Wage</label><input--%>
<%--                            class="form-control new-post-row" type="text" name="wage" autofocus="" title="Institution">--%>
<%--                    </div>--%>
<%--                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Location</label><input--%>
<%--                            class="form-control new-post-row" type="text" name="location"></div>--%>
<%--                </div>--%>
<%--                <div class="row d-flex justify-content-around new-post-row">--%>
<%--                    <div class="col-md-6"><label class="form-label">Start Date</label><input class="form-control"--%>
<%--                                                                                             name="startDate"--%>
<%--                                                                                             title="Institution"--%>
<%--                                                                                             type="date"></div>--%>
<%--                    <div class="col-md-6"><label class="form-label">End Date</label><input class="form-control"--%>
<%--                                                                                           name="endDate"--%>
<%--                                                                                           title="Institution"--%>
<%--                                                                                           type="date"></div>--%>
<%--                    <input type="hidden" name="username" value="${businessClient.busClientUsername}">--%>
<%--                </div>--%>
<%--                <div class="btn-group d-flex popup-btns" role="group">--%>
<%--                    <button class="btn btn-secondary" type="reset">Reset</button>--%>
<%--                    <button class="btn btn-success" type="submit">Add</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="popup work">--%>
<%--        <div class="border rounded popup-content overflow-auto">--%>
<%--            <button class="btn-close float-end close"></button>--%>
<%--            <h3>Delete this Posting?</h3>--%>
<%--            <div class="d-flex justify-content-center">--%>
<%--                <button class="btn btn-danger" type="button">Permanently Remove This Post</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="container-md">--%>
<%--    <div class="row text-start head-row">--%>
<%--        <div class="col m-auto">--%>
<%--            <h3><c:out value="${businessClient.busClientCompany}"/></h3>--%>
<%--            <p>Status</p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="row head-row">--%>
<%--        <div class="col-12 col-md-5 sections">--%>
<%--            <div class="d-flex flex-row justify-content-between align-items-baseline">--%>
<%--                <h4>Info</h4>--%>
<%--            </div>--%>
<%--            <hr>--%>
<%--            <form data-aos="fade-up" class="info-form">--%>
<%--                <div class="d-flex form-group mb-3">--%>
<%--                    <h6>About:</h6>--%>
<%--                    <p><c:out value="${businessClient.busClientDescription}"/></p>--%>
<%--                </div>--%>
<%--                <div class="d-flex form-group mb-3">--%>
<%--                    <h6>Email:</h6>--%>
<%--                    <p><c:out value="${businessClient.busClientEmail}"/></p>--%>
<%--                </div>--%>
<%--                <div class="d-flex form-group mb-3">--%>
<%--                    <h6>Phone:</h6>--%>
<%--                    <p><c:out value="${businessClient.busClientPhone}"/></p>--%>
<%--                </div>--%>
<%--                <div class="d-flex form-group mb-3">--%>
<%--                    <h6>Address:</h6>--%>
<%--                    <p><c:out value="${businessClient.busClientAddress}"/></p>--%>
<%--                </div>--%>
<%--                <div class="d-flex form-group mb-3">--%>
<%--                    <h6>Website:</h6>--%>
<%--                    <p><c:out value="${businessClient.busClientWebsite}"/></p>--%>
<%--                </div>--%>
<%--                <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">--%>
<%--                    <div class="btn-group" role="group"><a class="btn" role="button" data-bs-toggle="tooltip"--%>
<%--                                                           data-bss-tooltip="" title="Edit" href="profile-edit.html"><i--%>
<%--                            class="far fa-edit" data-bss-hover-animate="pulse"></i></a></div>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--        <div class="col-12 col-md-5 offset-md-2 sections">--%>
<%--            <div class="d-flex flex-row justify-content-between align-items-baseline">--%>
<%--                <h4>Postings</h4>--%>
<%--                <button class="btn btn-outline-success open-edu" data-bss-hover-animate="pulse" type="submit"><i--%>
<%--                        class="fas fa-plus-circle open" data-bss-hover-animate="pulse" value="addEducation"></i>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <c:forEach var="posting" items="${jobPostings}">--%>
<%--                <hr>--%>
<%--                <div>--%>
<%--                    <div class="d-flex form-group mb-3">--%>
<%--                        <h6>Title:</h6>--%>
<%--                        <p><c:out value="${posting.jobTitle}"/></p>--%>
<%--                    </div>--%>
<%--                    <div class="d-flex form-group mb-3">--%>
<%--                        <h6>Start Date:</h6>--%>
<%--                        <p><c:out value="${posting.startDate}"/></p>--%>
<%--                    </div>--%>
<%--                    <div class="d-flex form-group mb-3">--%>
<%--                        <h6>End Date:</h6>--%>
<%--                        <p><c:out value="${posting.endDate}"/></p>--%>
<%--                    </div>--%>
<%--                    <div class="d-flex justify-content-around modify-btns">--%>
<%--                        <button class="btn btn-danger open-work" type="submit">Remove</button>--%>
<%--                        <button class="btn submit-btn" type="button">View Candidates</button>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/js/bootstrap.bundle.min.js"></script>--%>
<%--<script src="assets/js/bs-init.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>--%>
<%--<script src="assets/js/popup.js"></script>--%>
<%--</body>--%>

<%--</html>--%>