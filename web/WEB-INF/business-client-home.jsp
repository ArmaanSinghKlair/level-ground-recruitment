<%-- 
    Document   : business-client-home
    Created on : Mar 22, 2021, 9:18:43 AM
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
    <link rel="stylesheet" href="assets/css/business.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<div class="container-md">
    <div class="row text-start head-row">
        <div class="col m-auto">
            <h3>Business Name Here</h3>
            <p>Status</p>
        </div>
    </div>
    <div class="row head-row">
        <div class="col-12 col-md-5 sections">
            <div class="d-flex flex-row justify-content-between align-items-baseline">
                <h4>Info</h4>
            </div>
            <hr>
            <form data-aos="fade-up" class="info-form">
                <div class="d-flex form-group mb-3">
                    <h6>About:</h6>
                    <p>Paragraph</p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Email:</h6>
                    <p>Paragraph</p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Phone:</h6>
                    <p>Paragraph</p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Address:</h6>
                    <p>Paragraph</p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Website:</h6>
                    <p>Paragraph</p>
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
                <h4>Postings</h4>
                <div class="wrapper">
                    <div class="popup overflow-auto">
                        <div class="border rounded popup-content overflow-auto">
                            <button class="btn-close float-end close"></button>
                            <h3>Add New Job Posting</h3>
                            <form class="ignore popup-form">
                                <div class="row d-flex justify-content-around new-post-row">
                                    <div class="col-md-6 new-post-row"><label
                                            class="form-label new-post-row">Title</label><input
                                            class="form-control new-post-row" type="text" name="institution"
                                            autofocus="" title="Institution"></div>
                                    <div class="col-md-6 new-post-row"><label
                                            class="form-label new-post-row">Status</label><select
                                            class="form-select level-slc new-post-row" name="education-lvl">
                                        <option value="fullTime" selected="">Full-Time</option>
                                        <option value="partTime">Par-Time</option>
                                        <option value="temperory">Temperory</option>
                                    </select></div>
                                </div>
                                <div class="row d-flex new-post-row">
                                    <div class="col-md-6 form-row new-post-row"><label class="form-label new-post-row">Requirment</label><textarea
                                            class="form-control new-post-row" rows="5"></textarea></div>
                                    <div class="col-md-6 new-post-row"><label class="form-label new-post-row">Description</label><textarea
                                            class="form-control new-post-row" rows="5"></textarea></div>
                                </div>
                                <div class="row d-flex justify-content-around new-post-row">
                                    <div class="col-md-6 new-post-row"><label
                                            class="form-label new-post-row">Wage</label><input
                                            class="form-control new-post-row" type="text" name="institution"
                                            autofocus="" title="Institution"></div>
                                    <div class="col-md-6 new-post-row"><label
                                            class="form-label new-post-row">Location</label><input
                                            class="form-control new-post-row" type="text" name="location"></div>
                                </div>
                                <div class="row d-flex justify-content-around new-post-row">
                                    <div class="col-md-6"><label class="form-label">Start Date</label><input
                                            class="form-control" name="start-date" title="Institution" type="date">
                                    </div>
                                    <div class="col-md-6"><label class="form-label">End Date</label><input
                                            class="form-control" name="start-date" title="Institution" type="date">
                                    </div>
                                </div>
                                <div class="btn-group d-flex popup-btns" role="group">
                                    <button class="btn btn-secondary" type="reset">Reset</button>
                                    <button class="btn btn-success" type="submit">Add</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <button class="btn btn-outline-success open-edu" data-bss-hover-animate="pulse" type="submit"><i
                        class="fas fa-plus-circle open" data-bss-hover-animate="pulse" value="addEducation"></i>
                </button>
            </div>
            <hr>
            <form data-aos="fade-up">
                <div class="d-flex form-group mb-3">
                    <h6>Title:</h6>
                    <p>Paragraph</p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>Start Date:</h6>
                    <p>Paragraph</p>
                </div>
                <div class="d-flex form-group mb-3">
                    <h6>End Date:</h6>
                    <p>Paragraph</p>
                </div>
                <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                    <div class="btn-group" role="group">
                        <button class="btn btn-danger" type="button">Remove</button>
                        <button class="btn submit-btn" type="button">View Candidates</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
<script src="assets/js/popup.js"></script>
</body>

</html>