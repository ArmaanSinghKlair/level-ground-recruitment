<%-- 
    Document   : advisor-home
    Created on : Mar 27, 2021, 9:48:54 AM
    Author     : AmirS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Level Ground Recruitment | Advisor Profile</title>
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
        <link rel="stylesheet" href="assets/css/advisor.css">
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
        <div class="container">
            <div class="row text-start d-flex flex-column flex-md-row head-row">
                <div class="col m-auto">
                    <h3 class="info-heading">Advisor Control Panel</h3>
                    <p>${advisor.advisorfirstName}</p>
                    <p>${advisor.advisorlastName}</p>
                    <p>${advisor.advisorEmail}</p>
                </div>
                <div class="col d-flex flex-column justify-content-end">
                    <div class="d-flex flex-column align-items-start control-clum">
                        <button class="btn btn-outline-secondary add-btn open-edu" type="button">Add new advisor</button>
                        <button class="btn btn-outline-secondary add-btn open-skill" type="button">Add new skill</button>
                        <button class="btn btn-outline-secondary add-btn open-work" type="button">Add new role</button>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col head-row">
                    <h3>Assigned Businesses<c:if test="${requestScope.companyList eq null}">
                            - EMPTY
                        </c:if></h3>


                    <c:forEach var="company" items="${requestScope.companyList}">
                        <div class="accordion" role="tablist" id="accordion-1">
                            <div class="accordion-item">
                                <h2 class="accordion-header" role="tab">
                                    <button class="accordion-button" data-bs-toggle="collapse" data-bs-target="#accordion-1 .item-1"
                                            aria-expanded="true" aria-controls="accordion-1 .item-1">${company.busClientCompany}
                                    </button>
                                </h2>
                                <div class="accordion-collapse collapse show item-1" role="tabpanel" data-bs-parent="#accordion-1">
                                    <div class="accordion-body">
                                        <p>${company.busClientDescription}</p>
                                        <hr>
                                        <div class="row d-flex flex-column flex-sm-row">
                                            <div class="col d-flex align-self-center"><i class="fas fa-envelope business-icon"
                                                                                         style="font-size: 24px;"></i>
                                                <p>${company.busClientEmail}</p>
                                            </div>
                                            <div class="col d-flex align-self-center"><i class="fas fa-globe-americas business-icon"
                                                                                         style="font-size: 24px;"></i>
                                                <p>${company.busClientWebsite}</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row d-flex flex-column flex-sm-row">
                                            <div class="col d-flex align-self-center"><i class="fas fa-phone-alt business-icon"
                                                                                         style="font-size: 24px;"></i>
                                                <p>${company.busClientPhone}</p>
                                            </div>
                                            <div class="col d-flex align-self-center"><i class="fas fa-map-pin business-icon"></i>
                                                <p>${company.busClientAddress}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col d-flex justify-content-end control-btns">
                                                <button class="btn btn-primary list-btn" type="button">List job postings</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="wrapper">
            <div class="edu popup">
                <div class="border rounded popup-content">
                    <button class="btn-close float-end close"></button>
                    <h3>Add New Advisor</h3>
                    <form class="ignore popup-form" action="<c:url value='/user-registration'/>" method="POST">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6"><label class="col-form-label">Username</label></div>
                                <div class="col-md-6"><input class="form-control" type="text" name="username"></div>
                            </div>
                            <div class="row">
                                <div class="col-md-6"><label class="col-form-label">Password</label></div>
                                <div class="col-md-6"><input class="form-control" type="password" name="password"></div>
                            </div>
                            <div class="row">
                                <div class="col-md-6"><label class="col-form-label">First name</label></div>
                                <div class="col-md-6"><input class="form-control" type="text" name="firstName"></div>
                            </div>
                            <div class="row">
                                <div class="col-md-6"><label class="col-form-label">Last name</label></div>
                                <div class="col-md-6"><input class="form-control" type="text" name="lastName"></div>
                            </div>
                            <div class="row">
                                <div class="col-md-6"><label class="col-form-label">Email</label></div>
                                <div class="col-md-6"><input class="form-control" type="email" name="email"></div>
                            </div>
                        </div>
                        <div class="btn-group d-flex popup-btns" role="group">
                            <button class="btn btn-secondary" type="reset">Reset</button>
                            <button class="btn btn-success" type="submit">Add</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="skill popup">
                <div class="border rounded popup-content">
                    <button class="btn-close float-end close"></button>
                    <h3>Add New Skill</h3>
                    <form class="ignore popup-form" action="<c:url value='/advisor-profile'/>" method="POST">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6"><label class="col-form-label">Skill name</label></div>
                                <div class="col-md-6"><input class="form-control" type="text" name="skill"></div>
                            </div>
                        </div>
                        <div class="btn-group d-flex popup-btns" role="group">
                            <button class="btn btn-secondary" type="reset">Reset</button>
                            <button class="btn btn-success" type="submit">Add</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="work popup">
                <div class="border rounded popup-content">
                    <button class="btn-close float-end close"></button>
                    <h3>Add New Role</h3>
                    <form class="ignore popup-form" action="<c:url value='/advisor-profile'/>" method="POST">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6"><label class="col-form-label">Role name</label></div>
                                <div class="col-md-6"><input class="form-control" type="text" name="role"></div>
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
        <%--Footer section--%>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/bs-init.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
        <script src="assets/js/popup.js"></script>
    </body>

</html>