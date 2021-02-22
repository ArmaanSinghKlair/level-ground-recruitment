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
    <body>
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

        <div class="tabs">
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item" role="presentation" data-bss-hover-animate="pulse">
                    <a class="nav-link active" role="tab" data-toggle="tab" href="#tab-1" onclick="revertChanges()">Create
                        Job</a>
                </li>
                <li class="nav-item" role="presentation" data-bss-hover-animate="pulse"><a class="nav-link" role="tab"
                                                                                           data-toggle="tab" data-bss-hover-animate="pulse" href="#tab-2">Manage
                        Jobs</a></li>
            </ul>
            <div class="tab-content">


                <div class="tab-pane active" role="tabpanel" id="tab-1">


                    <div class="container default-container">
                        <div class="inner-container">
                            <h5 class="mb-4 font-weight-bold" id="new-job-title">New Job Posting</h5>
                            <form action="" method="POST">

                                <div class="form-group">
                                    <label for="newJobTitle" class="new-job-label">Title</label>
                                    <input class="form-control" id="newJobTitleInput" type="text" data-toggle="tooltip"
                                           title="Test" placeholder="Enter Title">
                                </div>

                                <div class="form-group">
                                    <label for="requirements" class="new-job-label">Requirements</label>
                                    <input class="form-control" id="requirementsInput" type="text"
                                           placeholder="Enter Requirements">
                                </div>

                                <div class="form-group">
                                    <label for="startDateInput" class="new-job-label">Start Date</label>
                                    <input class="form-control" type="date" value="" id="startDateInput">
                                </div>

                                <div class="form-group">
                                    <label for="endDateInput" class="new-job-label">End Date</label>
                                    <input class="form-control" type="date" value="" id="endDateInput">
                                </div>

                                <div class="form-group">
                                    <label for="statusSelect" class="new-job-label">Status</label>
                                    <select class="form-control" id="statusSelect">
                                        <option>Full Time</option>
                                        <option>Part Time</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="descriptionTextArea" class="new-job-label">Description</label>
                                    <textarea class="form-control" id="textArea" row="3"></textarea>
                                </div>

                                <input class="default-button" type="submit" value="Submit">
                                <button class="default-button" style="display: none;"></button>
                            </form>
                        </div>
                    </div>


                </div>


                <div class="tab-pane" role="tabpanel" id="tab-2">

                    <c:choose>
                        <c:when test="${requestScope.candidateList eq null}">
                            <div class="container default-container text-center mt-5 text-white">
                                <h4>Job List is Empty</h4>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="container default-container">
                                <c:forEach var="job" items="${requestScope.jobList}">

                                    <div class="inner-container">  
                                        <h5 class="mb-4 font-weight-bold" id="new-job-title">*JOB TITLE*</h5>

                                        <form action="" method="POST" class="job-forms" id="jobForm${job.jobpostingID}">

                                            <div class="form-group">
                                                <label for="newJobTitle" class="new-job-label">Title</label>
                                                <input class="form-control" id="newJobTitleInput" type="text"
                                                       value="Web Developer" disabled>
                                            </div>

                                            <div class="form-group">
                                                <label for="requirements" class="new-job-label">Requirements</label>
                                                <input class="form-control" id="requirementsInput" type="text" disabled>
                                            </div>

                                            <div class="form-group">
                                                <label for="startDateInput" class="new-job-label">Start Date</label>
                                                <input class="form-control" type="date" value="" id="startDateInput" disabled>
                                            </div>

                                            <div class="form-group">
                                                <label for="endDateInput" class="new-job-label">End Date</label>
                                                <input class="form-control" type="date" value="" id="endDateInput" disabled>
                                            </div>

                                            <div class="form-group">
                                                <label for="statusSelect" class="new-job-label">Status</label>
                                                <select class="form-control" id="statusSelect" disabled>
                                                    <option>Full Time</option>
                                                    <option>Part Time</option>
                                                </select>
                                            </div>

                                            <div class="form-group">
                                                <label for="descriptionTextArea" class="new-job-label">Description</label>
                                                <textarea class="form-control" id="textArea" row="3" disabled></textarea>
                                            </div>

                                            <div class="hiddenButtons" id="hiddenButtons${job.jobpostingID}" style="display:none;">
                                                <input class="default-button" type="submit" value="Submit">
                                                <input class="default-button" type="reset" value="Cancel" onclick="cancelJobEdit(${job.jobpostingID})">
                                            </div>

                                        </form>

                                        <div class="editButtons" id="editButtons${job.jobpostingID}">
                                            <button class="delete-button" onclick="confirmDelete(${job.jobpostingID})">Delete</button>
                                            <button class="default-button" onclick="openJobEdit(${job.jobpostingID})">Edit</button>
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
