<%-- 
    Document   : business-post-view
    Created on : Mar 22, 2021, 9:21:52 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/business-post.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<div class="container">
    <div class="row header-row">
        <div class="col header-row">
            <div class="d-md-flex justify-content-md-between align-items-md-baseline job-header">
                <h1 class="display-4 job-title">Job Title</h1>
                <p class="lead">Status</p>
                <p class="lead text-muted">Posted on: 01 Jan, 2020</p>
                <p class="lead text-muted">Expires on: 01 Jan, 2020</p>
            </div>
        </div>
    </div>
    <div class="row header-row">
        <div class="shadow job-post">
            <hr>
            <div>
                <h4>Description</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                    et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus
                    vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id
                    ornare arcu odio ut.<br></p>
                <hr>
            </div>
            <div>
                <h4>Requirements</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                    et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus
                    vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id
                    ornare arcu odio ut.<br></p>
                <hr>
            </div>
            <div class="row header-row" style="margin-bottom: 0;">
                <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-location-arrow icons"></i>
                    <p>Location</p>
                </div>
                <div class="col-md-5 offset-md-2 d-flex justify-content-between align-items-baseline"><i
                        class="far fa-money-bill-alt icons"></i>
                    <p>$50,000 year</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row header-row">
        <div class="col">
            <div role="tablist" id="accordion-1">
                <div class="card">
                    <div class="card-header" role="tab">
                        <h5 class="mb-0"><a data-bs-toggle="collapse" aria-expanded="true"
                                            aria-controls="accordion-1 .item-1" href="#accordion-1 .item-1"
                                            class="candidate-name accordion-button">Candidate ID: 123456789</a></h5>
                    </div>
                    <div class="collapse show item-1 item-content" role="tabpanel" data-bs-parent="#accordion-1">
                        <div class="card-body">
                            <div class="row candidate-row">
                                <div class="col-md-5">
                                    <h4>Education</h4>
                                    <hr>
                                    <div>
                                        <h6>Institution</h6>
                                        <p>level</p>
                                        <p>Subject</p>
                                        <p>Start date - End date</p>
                                        <hr>
                                    </div>
                                </div>
                                <div class="col-md-5 offset-md-2">
                                    <h4>Work History</h4>
                                    <hr>
                                    <div>
                                        <h6>Company</h6>
                                        <p>Title:&nbsp;</p>
                                        <p>Start Date:</p>
                                        <p>End Date:</p>
                                        <p>Reference:</p>
                                        <hr>
                                    </div>
                                </div>
                            </div>
                            <div class="row candidate-row">
                                <div class="col-md-5">
                                    <h4>Skill</h4>
                                    <hr>
                                    <div>
                                        <p>skill</p>
                                    </div>
                                </div>
                                <div class="col-md-5 offset-md-2">
                                    <h4>Role</h4>
                                    <hr>
                                    <div>
                                        <p>Role</p>
                                    </div>
                                </div>
                            </div>
                            <div class="btn-group float-end btn-group" role="group">
                                <button class="btn btn-danger" type="button">Reject</button>
                                <button class="btn btn-primary submit-btn" type="button">Setup Interview</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
</body>

</html>