<%-- 
    Document   : businessClientPage
    Created on : Feb. 16, 2021, 11:19:44 a.m.
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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    </head>
    <body onload="<c:if test='${requestScope.currentTab != null}'>document.getElementById('${requestScope.currentTab.trim()}').click()</c:if>">

            <!--
                ***NAVBAR SECTION***
                
                Most of this code is reused from Amir's jsp page to keep things consistent.
                I've renamed the different tabs appropriately
                
                Lastly, I've condensed the login/signup buttons into one button that displays the user's type (in this case, Business Client).
                This button has a drop-down menu for signing out.
            
                Currently there is no functionality to access different tabs on this navbar section
            -->
            <nav class="navbar navbar-light navbar-expand-lg navigation-clean-button">
                <div class="container"><a class="navbar-brand d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center" href="index.html"><img class="logo" src="assets/img/logo.png">
                        <h4 class="brand-name">Level Ground Recruitment</h4>
                    </a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navcol-1">
                        <ul class="nav navbar-nav mr-auto flex-md-shrink-0">
                            <li class="nav-item"><a class="nav-link active" data-bs-hover-animate="pulse" href="#">Home</a></li>
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


        <!--
            ***ALERT SECTION***
            displays alerts. The code is the same as in the signup.jsp page
        -->
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


        <!--
           ***MAIN SECTION***
           
           Main section of the code on this page.
           2 different tabs for Create Job and Manage Job, each display their own content.
            
           Switching back to Create Job from Manage Job will revert any unsaved changes in Manage Job
        -->
        <div class="tabs">
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">
                    <a class="nav-link active" role="tab" data-toggle="tab" href="#tab-1" onclick="revertChanges()">Create Job</a>
                </li>
                <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">
                    <a class="nav-link" role="tab" data-toggle="tab" data-bss-hover-animate="pulse" href="#tab-2">Manage Jobs</a></li>
            </ul>
            <div class="tab-content">



                <!--
                    ***CREATE JOB SECTION***
                    Displays a form that the Business Client can submit to create a new Job Posting
                -->
                <div class="tab-pane active" role="tabpanel" id="tab-1">


                    <div class="container default-container">
                        <div class="inner-container shadow p-3 mb-5">
                            <h5 class="container-header">New Job Posting</h5>
                            <form action="" method="POST">

                                <div class="form-group">
                                    <label for="newJobTitle" class="section-label">Title</label>
                                    <input class="form-control" id="newJobTitle" name="new-job-title" type="text" placeholder="Enter Title">
                                </div>

                                <div class="form-group">
                                    <label for="requirements" class="section-label">Requirements</label>
                                    <input class="form-control" id="requirementsInput" name="new-job-requirements" type="text" placeholder="Enter Requirements">
                                </div>

                                <div class="form-group">
                                    <label for="startDate" class="section-label">Start Date</label>
                                    <input class="form-control" type="date" id="startDateInput" name="new-job-startdate">
                                </div>

                                <div class="form-group">
                                    <label for="endDateInput" class="section-label">End Date</label>
                                    <input class="form-control" type="date" id="endDateInput" name="new-job-enddate">
                                </div>

                                <div class="form-group">
                                    <label for="status" class="section-label">Status</label>
                                    <select class="form-control" id="statusSelect" name="new-job-status">
                                        <option>Full Time</option>
                                        <option>Part Time</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="description" class="section-label">Description</label>
                                    <textarea class="form-control" id="textArea" name="new-job-description" row="3"></textarea>
                                </div>

                                <input class="default-button primary-button" type="submit" value="Submit">

                            </form>
                        </div>
                    </div>


                </div>


                <!--
                     ***MANAGE JOBS SECTION***
                    Displays a list of job postings that this Business Client has submitted.
                    The Business Client has the option to edit one of their job postings from this tab.
                
                    Will not show job postings from other Business Clients.
                -->
                <div class="tab-pane" role="tabpanel" id="tab-2">

                    <c:choose>
                        <c:when test="${requestScope.jobList eq null}">
                            <div class="container default-container">
                                <h4 id="empty-list-title">Job List is Empty</h4>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="container default-container">
                                <c:forEach var="job" items="${requestScope.jobList}">

                                    <div class="inner-container shadow p-3 mb-5">  
                                        <h5 class="container-header">Job #${job.jobpostingID}</h5>

                                        <form action="" method="POST" class="job-forms" id="jobForm${job.jobpostingID}">

                                            <div class="form-group">
                                                <label for="jobTitle" class="section-label">Title</label>
                                                <input class="form-control" id="jobTitle" type="text"
                                                       name="title" value="${job.title}" disabled>
                                            </div>

                                            <div class="form-group">
                                                <label for="requirements" class="section-label">Requirements</label>
                                                <input class="form-control" id="requirements" type="text" name="requirements" value="${job.requirements}"disabled>
                                            </div>

                                            <div class="form-group">
                                                <label for="startDate" class="section-label">Start Date</label>
                                                <input class="form-control" type="date" id="startDate" name="start-date" value="${job.startDate}" disabled>
                                            </div>

                                            <div class="form-group">
                                                <label for="endDate" class="section-label">End Date</label>
                                                <input class="form-control" type="date" id="endDate" name="end-date" value="$job.endDate}" disabled>
                                            </div>

                                            <div class="form-group">
                                                <label for="statusSelect" class="section-label">Status</label>
                                                <select class="form-control" id="statusSelect" name="status" disabled>
                                                    <option ${job.jobStatus eq 'Full Time' ? '' : 'selected'}>Full Time</option>
                                                    <option ${job.jobStatus eq 'Part Time' ? '': 'selected'}>Part Time</option>
                                                </select>
                                            </div>

                                            <div class="form-group">
                                                <label for="descriptionTextArea" class="new-job-label">Description</label>
                                                <textarea class="form-control" id="description" name="description" row="3" disabled>${job.jobDescription}</textarea>
                                            </div>

                                            <div class="hiddenButtons" id="hiddenButtons${job.jobpostingID}" style="display:none;">
                                                <input class="default-button primary-button" type="submit" value="Submit">
                                                <input class="default-button primary-button" type="reset" value="Cancel" onclick="cancelJobEdit(${job.jobpostingID})">
                                            </div>

                                        </form>

                                        <div class="editButtons" id="editButtons${job.jobpostingID}">
                                            <button class="default-button delete-button" id="delete-button" onclick="confirmDelete(${job.jobpostingID})">Delete</button>
                                            <button class="default-button primary-button" onclick="openJobEdit(${job.jobpostingID})">Edit</button>
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
