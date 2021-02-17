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
                        <a class="btn btn-primary action-button" role="button" data-bs-hover-animate="pulse" href="login.html">Business Client</a>
                    </span>
                </div>
            </div>
        </nav>

        <div class="container new-job-container shadow-sm p-3 mb-5">

            <h5 class="text-left mb-4 font-weight-bold" id="new-job-title">New Job Posting</h5>
            <form action="" method="POST">

                <div class="form-group">
                    <label for="newJobTitle" class="new-job-label">Title</label>
                    <input type="text" class="form-control" id="newJobTitleInput" placeholder="Enter Title">
                </div>
                
                <div class="form-group">
                    <label for="requirements" class="new-job-label">Requirements</label>
                    <input type="text" class="form-control" id="requirementsInput" placeholder="Enter Requirements">
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
                    <textarea class="form-control" id="exampleTextArea" row="3"></textarea>
                </div>

                <button type="submit" class="default-button">Submit</button>
            </form>
        </div>
        <hr/>



        <c:forEach var="job" items="${requestScope.jobList}">
            <div class="container section-header">
                *JOB TITLE*
            </div>
            <div class="container current-job-container shadow-sm p-3 mb-5" id="jobPosting">

                <div class="row">
                    <div class="col-md-4">

                        <dt class="job-item-header col-sm-5">Job ID</dt>
                        <dd class="col-sm-7">${job.jobpostingID}</dd>

                        <dt class="job-item-header col-sm-5">Requirements</dt>
                        <dd class="col-sm-7">${job.requirements}</dd>

                        <dt class="job-item-header col-sm-5">Start Date</dt>
                        <dd class="col-sm-7">${job.startDate}</dd>

                        <dt class="job-item-header col-sm-5">End Date</dt>
                        <dd class="col-sm-7">${job.endDate}</dd>

                        <dt class="job-item-header col-sm-5">Status</dt>
                        <dd class="col-sm-7">*STATUS*</dd>
                    </div>

                    <div class="col-md-6">
                        <p class="job-description">*DESCRIPTION*</p>
                    </div>
                    <div class="col-md-1">
                        <button type="button" class="default-button" onclick="openEditWindow()">Edit</button>
                    </div>
                </div>
            </div>
        </c:forEach>


        <script>

            function openEditWindow()
            {
                //document.getElementById("jobPosting").style.display = "block";
                var jobPosting = document.getElementById("jobPosting");

                jobPosting.
                        alert("open edit window");
            }

            function closeEditWindow()
            {
                document.getElementById("jobPosting").style.display = "none";
            }

        </script>



        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
    </body>
</html>
