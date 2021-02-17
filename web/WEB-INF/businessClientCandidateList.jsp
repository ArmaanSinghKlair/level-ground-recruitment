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

        <div class="container section-header">
            Candidate #01
        </div>
        <div class="container current-job-container shadow-sm p-3 mb-5">

            <div class="row">
                <div class="col-md-3">

                    <dt class="job-item-header col-sm-6">Company</dt>
                    <dd class="col-sm-6">Husky Energy</dd>

                    <dt class="job-item-header col-sm-6">Posting Date</dt>
                    <dd class="col-sm-6">2021-02-16</dd>

                    <dt class="job-item-header col-sm-6">Start Date</dt>
                    <dd class="col-sm-6">2021-02-17</dd>

                    <dt class="job-item-header col-sm-6">End Date</dt>
                    <dd class="col-sm-6">2021-02-18</dd>

                    <dt class="job-item-header col-sm-6">Status</dt>
                    <dd class="col-sm-6">Full Time</dd>
                </div>

                <div class="col-md-7">
                    <p class="job-description border-dark">Design Beautiful websites using HTML, CSS, and JavaScript.
                        Gain an expert knowledge of JS frameworks such as Angular, React, and Vue.</p>
                </div>
                <div class="col-md-1">
                    <button type="submit" class="edit-button">Interview</button>
                    <button type="submit" class="edit-button">Hire</button>
                </div>
            </div>
        </div>

    </div> 






    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
</body>
</html>
