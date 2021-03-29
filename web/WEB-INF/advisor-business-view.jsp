<%-- 
    Document   : advisor-business-view
    Created on : Mar 28, 2021, 9:25:32 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
        <link rel="stylesheet" href="assets/css/advisor-job-view.css">
        <link rel="stylesheet" href="assets/css/advisor-post-view.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
        <link rel="stylesheet" href="assets/css/nav-bar.css">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>

    <body>
        <div class="container">
            <div class="row text-start d-flex flex-column flex-md-row head-row">
                <div class="col m-auto">
                    <h2 class="info-heading">Company Name</h2>
                    <p>Company about section...</p>
                    <hr>
                    <div class="row d-flex flex-column flex-sm-row">
                        <div class="col d-flex align-self-center"><i class="fas fa-envelope business-icon" style="font-size: 24px;"></i>
                            <p>Email</p>
                        </div>
                        <div class="col d-flex align-self-center"><i class="fas fa-globe-americas business-icon" style="font-size: 24px;"></i>
                            <p>Website</p>
                        </div>
                    </div>
                    <hr>
                    <div class="row d-flex flex-column flex-sm-row">
                        <div class="col d-flex align-self-center"><i class="fas fa-phone-alt business-icon" style="font-size: 24px;"></i>
                            <p>Phone</p>
                        </div>
                        <div class="col d-flex align-self-center"><i class="fas fa-map-pin business-icon"></i>
                            <p>Address</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row head-row">
                <div class="col">
                    <div class="d-flex flex-column flex-md-row">
                        <h1 class="display-5 col">Job Posts</h1>
                        <div class="d-flex align-self-center justify-content-md-end input-group col">
                            <div class="form-outline"><input type="search" id="form1" class="form-control" placeholder="Search..."></div><button class="btn btn-primary" type="button"><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                    <hr>
                    <div class="accordion" role="tablist" id="accordion-1">
                        <div class="accordion-item">
                            <h2 class="accordion-header" role="tab"><button class="accordion-button" data-bs-toggle="collapse" data-bs-target="#accordion-1 .item-1" aria-expanded="true" aria-controls="accordion-1 .item-1">Job Title</button></h2>
                            <div class="accordion-collapse collapse show item-1" role="tabpanel" data-bs-parent="#accordion-1">
                                <div class="accordion-body">
                                    <div class="shadow job-post">
                                        <div class="d-flex flex-column align-items-baseline flex-md-row justify-content-md-between job-header"><span class="badge rounded-pill bg-secondary stat-badge">Full-Time</span>
                                            <p>Post date: 1 Jan, 2021</p><button class="btn btn-success" type="button">Applicants<span class="badge bg-dark notif">42</span></button>
                                        </div>
                                        <hr>
                                        <div>
                                            <h4>Description</h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id ornare arcu odio ut.<br></p>
                                            <hr>
                                        </div>
                                        <div>
                                            <h4>Requirements</h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id ornare arcu odio ut.<br></p>
                                            <hr>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i class="fas fa-location-arrow icons"></i>
                                                <p>Location</p>
                                            </div>
                                            <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline"><i class="far fa-money-bill-alt icons"></i>
                                                <p>$50,000 year</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i class="fas fa-hourglass-start icons"></i>
                                                <p>1 Jan, 2021</p>
                                            </div>
                                            <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline"><i class="fas fa-hourglass-end icons"></i>
                                                <p>1 Dec, 2021</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
    </body>

</html>