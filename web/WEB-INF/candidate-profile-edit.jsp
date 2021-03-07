<%-- Document : candidate-profile-edit Created on : Mar 2, 2021, 4:58:38 PM Author : AmirS --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Candidate Profile Edit</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
        <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
        <link rel="stylesheet" href="assets/css/nav-bar.css">
        <link rel="stylesheet" href="assets/css/profile-edit.css">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>

    <body>

        <%@include file="/WEB-INF/jspf/navbar.jspf"%>
        <%@include file="/WEB-INF/jspf/alert.jspf"%>
        
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-10 offset-lg-1">
                    <div class="d-md-flex flex-md-row-reverse">
                        <ul class="nav nav-tabs d-flex flex-column edit-items" role="tablist">
                            <li class="nav-item" role="presentation"><a class="nav-link active" role="tab" data-toggle="tab"
                                                                        href="#tab-1">Personal Information</a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" role="tab" data-toggle="tab"
                                                                        href="#tab-2">Education</a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" role="tab" data-toggle="tab"
                                                                        href="#tab-3">Work History</a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" role="tab" data-toggle="tab"
                                                                        href="#tab-4">Skills</a></li>
                        </ul>
                        <div class="tab-content edit-content">
                            <div class="tab-pane fade show active" role="tabpanel" id="tab-1">
                                <h1>Name</h1>
                                <p>Status</p>
                                <p class="text-muted">Joined 01 Jan 2021</p>
                                <div class="wrapper">
                                    <div class="remove-acc-alert popup">
                                        <div class="border rounded popup-content">
                                            <button class="btn btn-block d-flex justify-content-end close"
                                                    type="button"><i class="icon ion-close-round"></i></button>
                                            <h5 class="text-center">Are you sure you want to remove your Account?</h5>
                                            <form class="ignore popup-form">
                                                <div role="group" class="btn-group d-flex popup-btns">
                                                    <button class="btn btn-danger" type="submit">Permanently Remove My
                                                        Account 
                                                    </button>
                                                </div>
                                            </form>
                                            <p class="lead text-center warming-txt"><em>You can&#39;t recover your account after
                                                    removing it</em></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-end">
                                    <button class="btn btn-danger open-remove" type="submit">Remove Account</button>
                                </div>
                                <hr>
                                <form class="edit-form">
                                    <div class="form-row">
                                        <div class="col-12 col-md-5">
                                            <div class="form-group"><label for="firstName">First Name</label><input
                                                    class="form-control" type="text" id="firstName" name="firstName"></div>
                                        </div>
                                        <div class="col-12 col-md-5 offset-md-1">
                                            <div class="form-group"><label for="lastName">Last Name</label><input
                                                    class="form-control" type="text" id="lastName" name="lastName"></div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-12 col-md-5">
                                            <div class="form-group"><label for="username">Username</label><input
                                                    class="form-control" type="text" id="username"></div>
                                        </div>
                                        <div class="col-12 col-md-5 offset-md-1">
                                            <div class="form-group"><label id="email" for="status">Status</label><select
                                                    class="form-control" id="status" name="select">
                                                    <option value="">Hired</option>
                                                    <option value="">Currently Looking</option>
                                                </select></div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-12 col-md-5">
                                            <div class="form-group"><label for="email">Email</label><input class="form-control"
                                                                                                           type="email"
                                                                                                           id="email"
                                                                                                           name="email"></div>
                                        </div>
                                        <div class="col-12 col-md-5 offset-md-1">
                                            <div class="form-group"><label id="email-3">Phone</label><input class="form-control"
                                                                                                            type="tel"></div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-12 col-md-8">
                                            <div class="form-group"><label id="email" for="about">About</label><textarea
                                                    class="form-control" id="about" rows="5" placeholder="About Me..."
                                                    name="about"></textarea></div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-12 col-md-5">
                                            <h5>Change Password</h5>
                                            <div class="form-group"><label for="cur-pass">Current Password</label><input
                                                    class="form-control" type="password" id="cur-pass" placeholder="****"></div>
                                            <div class="form-group"><label for="new-pass">New Password</label><input
                                                    class="form-control" type="password" id="new-pass"></div>
                                            <div class="form-group"><label for="conf-pass">Confirm Password</label><input
                                                    class="form-control" type="password" id="conf-pass"></div>
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
                            <div class="tab-pane fade" role="tabpanel" id="tab-2">
                                <div role="tablist" id="accordion-1">
                                    <div class="card">
                                        <div class="card-header" role="tab">
                                            <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="true"
                                                                aria-controls="accordion-1 .item-1" href="#accordion-1 .item-1"
                                                                class="header-btn">Institution Name</a></h5>
                                        </div>
                                        <div class="collapse show item-1" role="tabpanel" data-parent="#accordion-1">
                                            <div class="card-body">
                                                <form>
                                                    <div class="form-row">
                                                        <div class="col-12 col-md-5">
                                                            <div class="form-group"><label>Institution</label><input
                                                                    class="form-control" type="text"></div>
                                                        </div>
                                                        <div class="col-12 col-md-5 offset-md-1">
                                                            <div class="form-group"><label>Education Level</label><select
                                                                    class="form-control level-slc" name="education-lvl">
                                                                    <optgroup label="University">
                                                                        <option value="diploma" selected="">Diploma</option>
                                                                        <option value="bachelor">Bachelor</option>
                                                                        <option value="master">Master</option>
                                                                        <option value="phd">Ph.D</option>
                                                                    </optgroup>
                                                                </select></div>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="col-12 col-md-5">
                                                            <div class="form-group"><label>Subject</label><input
                                                                    class="form-control" type="text"></div>
                                                        </div>
                                                        <div class="col-12 col-md-5 offset-md-1">
                                                            <div class="form-group"><label>Start Date</label><input
                                                                    class="form-control" type="date"></div>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="col-12 col-md-5">
                                                            <div class="form-group"><label>Start Date</label><input
                                                                    class="form-control" type="date"></div>
                                                        </div>
                                                        <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">
                                                            <div class="form-group d-flex justify-content-end align-items-end align-content-end save-btns">
                                                                <div class="btn-group" role="group">
                                                                    <button class="btn btn-secondary" type="reset">Reset
                                                                    </button>
                                                                    <button class="btn btn-success succ" type="submit">Save
                                                                        Changes
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" role="tabpanel" id="tab-3">
                                <div role="tablist" id="accordion-2">
                                    <div class="card">
                                        <div class="card-header" role="tab">
                                            <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="true"
                                                                aria-controls="accordion-2 .item-1" href="#accordion-2 .item-1"
                                                                class="header-btn">Work History Title</a></h5>
                                        </div>
                                        <div class="collapse show item-1" role="tabpanel" data-parent="#accordion-2">
                                            <div class="card-body">
                                                <form>
                                                    <div class="form-row">
                                                        <div class="col-12 col-md-5">
                                                            <div class="form-group"><label>Company</label><input
                                                                    class="form-control" type="text"></div>
                                                        </div>
                                                        <div class="col-12 col-md-5 offset-md-1">
                                                            <div class="form-group"><label>Title</label><input
                                                                    class="form-control" type="text"></div>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="col-12 col-md-5">
                                                            <div class="form-group"><label>Start Date</label><input
                                                                    class="form-control" type="date"></div>
                                                        </div>
                                                        <div class="col-12 col-md-5 offset-md-1">
                                                            <div class="form-group"><label>End Date</label><input
                                                                    class="form-control" type="date"></div>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="col-12 col-md-5">
                                                            <div class="form-group"><label>Reference</label><input
                                                                    class="form-control" type="email"></div>
                                                        </div>
                                                        <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">
                                                            <div class="form-group d-flex justify-content-end align-items-end align-content-end save-btns">
                                                                <div class="btn-group" role="group">
                                                                    <button class="btn btn-secondary" type="reset">Reset
                                                                    </button>
                                                                    <button class="btn btn-success succ" type="submit">Save
                                                                        Changes
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" role="tabpanel" id="tab-4">
                                <div role="tablist" id="accordion-3">
                                    <div class="card">
                                        <div class="card-header" role="tab">
                                            <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="true"
                                                                aria-controls="accordion-3 .item-1" href="#accordion-3 .item-1"
                                                                class="header-btn">Skill Name</a></h5>
                                        </div>
                                        <div class="collapse show item-1" role="tabpanel" data-parent="#accordion-3">
                                            <div class="card-body">
                                                <form>
                                                    <div class="form-row">
                                                        <div class="col-12 col-md-5"><select class="form-control level-slc"
                                                                                             name="education-lvl">
                                                                <optgroup label="Soft Skill">
                                                                    <option value="diploma" selected="">Communication</option>
                                                                    <option value="bachelor">Team work</option>
                                                                </optgroup>
                                                                <optgroup label="Software">
                                                                    <option value="">Office</option>
                                                                </optgroup>
                                                            </select></div>
                                                        <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">
                                                            <div class="form-group d-flex justify-content-end align-items-end align-content-end save-btns">
                                                                <div class="btn-group" role="group">
                                                                    <button class="btn btn-secondary" type="reset">Reset
                                                                    </button>
                                                                    <button class="btn btn-success succ" type="submit">Save
                                                                        Changes
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
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
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
        <script src="assets/js/popup.js"></script>
    </body>

</html>