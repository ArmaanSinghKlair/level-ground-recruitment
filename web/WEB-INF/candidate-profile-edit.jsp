<%-- Document : candidate-profile-edit Created on : Mar 2, 2021, 4:58:38 PM Author : AmirS --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Level Ground Recruitment | Edit Profile</title>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/profile-edit.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/footer.css">
</head>

<body onload="<c:if
        test='${requestScope.currentTab != null}'>document.getElementById('${requestScope.currentTab.trim()}').click()</c:if>">

<%@include file="/WEB-INF/jspf/navbar.jspf" %>
<%@include file="/WEB-INF/jspf/alert.jspf" %>

<div class="container">
    <div class="row">
        <div class="col-12 col-lg-10 offset-lg-1">
            <div class="d-md-flex flex-md-row-reverse">
                <ul class="nav nav-tabs d-flex flex-column edit-items" role="tablist">
                    <li class="nav-item shadow-sm" role="presentation"><a class="nav-link active shadow-sm" role="tab"
                                                                          data-bs-toggle="tab" href="#tab-1">Personal
                        Information</a></li>
                    <li class="nav-item shadow-sm" role="presentation"><a class="nav-link shadow-sm" role="tab"
                                                                          data-bs-toggle="tab"
                                                                          href="#tab-2">Education</a></li>
                    <li class="nav-item shadow-sm" role="presentation"><a class="nav-link shadow-sm" role="tab"
                                                                          data-bs-toggle="tab" href="#tab-3">Work
                        History</a></li>
                    <li class="nav-item shadow-sm" role="presentation"><a class="nav-link" role="tab"
                                                                          data-bs-toggle="tab" href="#tab-4">Skills</a>
                    </li>
                    <li class="nav-item" role="presentation"><a class="nav-link" role="tab" data-bs-toggle="tab"
                                                                href="#tab-5">Roles</a></li>
                </ul>
                <div class="tab-content edit-content">
                    <div class="tab-pane fade show active" role="tabpanel" id="tab-1">
                        <div class="row d-flex flex-column justify-content-between align-items-center flex-md-row shadow-sm"
                             id="title-row">
                            <div class="col">
                                <h1 class="display-5"><c:out
                                        value="${candidate.canfirstName} ${candidate.canlastName}"/></h1>
                                <p>Status: ${candidate.placed ? 'Placed' : "Not Placed Yet"}</p>
                                <p class="text-muted">Joined 01 Jan 2021</p>
                            </div>
                            <div class="col d-flex justify-content-center">
                                <button class="btn btn-danger open-remove" type="submit">Remove Account</button>
                            </div>
                        </div>
                        <div class="wrapper">
                            <div class="remove-acc-alert popup">
                                <div class="border rounded popup-content">
                                    <button class="btn btn-primary btn-block d-flex justify-content-end close"
                                            type="button"><i class="icon ion-close-round close-button"></i></button>
                                    <h5 class="text-center">Are you sure you want to remove your Account?</h5>
                                    <form class="ignore popup-form">
                                        <div class="btn-group d-flex popup-btns" role="group">
                                            <button class="btn btn-danger" type="submit">Permanently Remove My Account&nbsp;</button>
                                        </div>
                                    </form>
                                    <p class="lead text-center warming-txt"><em>You can't recover your account after
                                        removing it</em></p>
                                </div>
                            </div>
                        </div>
                        <form class="edit-form">
                            <div class="row">
                                <div class="col-12 col-md-5">
                                    <div class="form-group mb-3"><label class="form-label" for="firstName">First
                                        Name</label><input class="form-control" type="text" id="firstName"
                                                           name="firstName" value="${candidate.canUsername}"></div>
                                </div>
                                <div class="col-12 col-md-5 offset-md-1">
                                    <div class="form-group mb-3"><label class="form-label" for="lastName">Last
                                        Name</label><input class="form-control" type="text" id="lastName"
                                                           name="lastName"
                                                           value="<c:out value='${candidate.canfirstName}' default=''/>">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-md-5">
                                    <div class="form-group mb-3"><label class="form-label"
                                                                        for="username">Username</label><input
                                            class="form-control" type="text" id="username"
                                            value="<c:out value='${candidate.canlastName}' default=''/>"></div>
                                </div>
                                <div class="col-12 col-md-5 offset-md-1">
                                    <div class="form-group mb-3"><label class="form-label"
                                                                        for="status">Status</label><select
                                            class="form-select" id="status" name="select">
                                        <option value="yes" <c:if test="${candidate.placed==true}">selected</c:if>>
                                            Hired
                                        </option>
                                        <option value="no" <c:if test="${candidate.placed==false}">selected</c:if>>
                                            Currently Looking
                                        </option>
                                    </select></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-md-5">
                                    <div class="form-group mb-3"><label class="form-label"
                                                                        for="email">Email</label><input
                                            class="form-control" type="email" id="email" name="email"
                                            value="<c:out value='${candidate.canEmail}' default=''/>"></div>
                                </div>
                                <div class="col-12 col-md-5 offset-md-1">
                                    <div class="form-group mb-3"><label class="form-label"
                                                                        id="email-3">Phone</label><input
                                            class="form-control" type="tel" name="phoneNo"
                                            value="<c:out value='${candidate.canPhoneNo}' default=''/>"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-md-8">
                                    <div class="form-group mb-3"><label class="form-label" id="email"
                                                                        for="about">About</label><textarea
                                            class="form-control" id="about" rows="5" placeholder="About Me..."
                                            name="about"></textarea></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-md-5">
                                    <h5>Change Password</h5>
                                    <div class="form-group mb-3"><label class="form-label" for="cur-pass">Current
                                        Password</label><input class="form-control" type="password" id="cur-pass"
                                                               placeholder="****"></div>
                                    <div class="form-group mb-3"><label class="form-label" for="new-pass">New
                                        Password</label><input class="form-control" type="password" id="new-pass"></div>
                                    <div class="form-group mb-3"><label class="form-label" for="conf-pass">Confirm
                                        Password</label><input class="form-control" type="password" id="conf-pass">
                                    </div>
                                </div>
                                <div class="col-12 col-md-5 offset-md-2 d-flex flex-column justify-content-end align-items-start">
                                    <h5 class="display-4">Apply Changes</h5>
                                    <div class="btn-group d-flex" role="group">
                                        <button class="btn btn-secondary" type="reset" style="color: #f1faee;">Reset
                                        </button>
                                        <button class="btn btn-dark succ" value="edit" type="submit">Save Changes
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" role="tabpanel" id="tab-2">
                        <c:if test="${candidate.educationList.size() == 0}">
                            <div class="d-flex justify-content-center" style="padding:3rem 0;">
                                <div>
                                    <svg xmlns="http://www.w3.org/2000/svg" height="2rem" viewBox="0 -12 512.00032 512"
                                         width="2rem">
                                        <path d="m455.074219 172.613281 53.996093-53.996093c2.226563-2.222657 3.273438-5.367188 2.828126-8.480469-.441407-3.113281-2.328126-5.839844-5.085938-7.355469l-64.914062-35.644531c-4.839844-2.65625-10.917969-.886719-13.578126 3.953125-2.65625 4.84375-.890624 10.921875 3.953126 13.578125l53.234374 29.230469-46.339843 46.335937-166.667969-91.519531 46.335938-46.335938 46.839843 25.722656c4.839844 2.65625 10.921875.890626 13.578125-3.953124 2.660156-4.839844.890625-10.921876-3.953125-13.578126l-53.417969-29.335937c-3.898437-2.140625-8.742187-1.449219-11.882812 1.695313l-54 54-54-54c-3.144531-3.144532-7.988281-3.832032-11.882812-1.695313l-184.929688 101.546875c-2.757812 1.515625-4.644531 4.238281-5.085938 7.355469-.445312 3.113281.601563 6.257812 2.828126 8.480469l53.996093 53.996093-53.996093 53.992188c-2.226563 2.226562-3.273438 5.367187-2.828126 8.484375.441407 3.113281 2.328126 5.839844 5.085938 7.351562l55.882812 30.6875v102.570313c0 3.652343 1.988282 7.011719 5.1875 8.769531l184.929688 101.542969c1.5.824219 3.15625 1.234375 4.8125 1.234375s3.3125-.410156 4.8125-1.234375l184.929688-101.542969c3.199218-1.757812 5.1875-5.117188 5.1875-8.769531v-102.570313l55.882812-30.683594c2.757812-1.515624 4.644531-4.242187 5.085938-7.355468.445312-3.113282-.601563-6.257813-2.828126-8.480469zm-199.074219 90.132813-164.152344-90.136719 164.152344-90.140625 164.152344 90.140625zm-62.832031-240.367188 46.332031 46.335938-166.667969 91.519531-46.335937-46.335937zm-120.328125 162.609375 166.667968 91.519531-46.339843 46.339844-166.671875-91.519531zm358.089844 184.796875-164.929688 90.5625v-102.222656c0-5.523438-4.476562-10-10-10s-10 4.476562-10 10v102.222656l-164.929688-90.5625v-85.671875l109.046876 59.878907c1.511718.828124 3.167968 1.234374 4.808593 1.234374 2.589844 0 5.152344-1.007812 7.074219-2.929687l54-54 54 54c1.921875 1.925781 4.484375 2.929687 7.074219 2.929687 1.640625 0 3.296875-.40625 4.808593-1.234374l109.046876-59.878907zm-112.09375-46.9375-46.339844-46.34375 166.667968-91.515625 46.34375 46.335938zm0 0"/>
                                        <path d="m404.800781 68.175781c2.628907 0 5.199219-1.070312 7.070313-2.933593 1.859375-1.859376 2.929687-4.4375 2.929687-7.066407 0-2.632812-1.070312-5.210937-2.929687-7.070312-1.859375-1.863281-4.441406-2.929688-7.070313-2.929688-2.640625 0-5.210937 1.066407-7.070312 2.929688-1.871094 1.859375-2.929688 4.4375-2.929688 7.070312 0 2.628907 1.058594 5.207031 2.929688 7.066407 1.859375 1.863281 4.441406 2.933593 7.070312 2.933593zm0 0"/>
                                        <path d="m256 314.925781c-2.628906 0-5.210938 1.066407-7.070312 2.929688-1.859376 1.867187-2.929688 4.4375-2.929688 7.070312 0 2.636719 1.070312 5.207031 2.929688 7.078125 1.859374 1.859375 4.441406 2.921875 7.070312 2.921875s5.210938-1.0625 7.070312-2.921875c1.859376-1.871094 2.929688-4.441406 2.929688-7.078125 0-2.632812-1.070312-5.203125-2.929688-7.070312-1.859374-1.863281-4.441406-2.929688-7.070312-2.929688zm0 0"/>
                                    </svg>
                                    No education added yet
                                </div>
                            </div>
                        </c:if>
                        <c:forEach var="education" items="${candidate.educationList}" varStatus="loop">
                            <div class="accordion" role="tablist" id="accordion-${loop.index}">
                                <div class="accordion-item">
                                    <h2 class="accordion-header mb-0" role="tab">
                                        <button class="accordion-button header-btn" data-bs-toggle="collapse"
                                                data-bs-target="#accordion-${loop.index} .item-${loop.index}"
                                                aria-expanded="true"
                                                aria-controls="accordion-${loop.index} .item-${loop.index}">${education.institution}
                                        </button>
                                    </h2>
                                    <div class="accordion-collapse collapse show item-${loop.index}" role="tabpanel"
                                         data-bs-parent="#accordion-${loop.index}">
                                        <div class="accordion-body">
                                            <form action="<c:url value='/candidate-profile'/>" method="post">
                                                <input type="hidden" name="form_name" value="education"/>
                                                <input type="hidden" name="id" value="${education.educationID}"/>
                                                <input type="hidden" name="action" value="profilePageAction"/>
                                                <div class="row">
                                                    <div class="col-12 col-md-5">
                                                        <div class="form-group mb-3"><label
                                                                class="form-label">Institution</label><input
                                                                class="form-control" type="text"
                                                                value="${education.institution}"></div>
                                                    </div>
                                                    <div class="col-12 col-md-5 offset-md-1">
                                                        <div class="form-group mb-3"><label class="form-label">Education
                                                            Level</label><select class="form-select level-slc"
                                                                                 name="education-lvl"
                                                                                 value="${education.level}">
                                                            <optgroup label="University">
                                                                <option value="diploma" selected="">Diploma</option>
                                                                <option value="bachelor">Bachelor</option>
                                                                <option value="master">Master</option>
                                                                <option value="phd">Ph.D</option>
                                                            </optgroup>
                                                            <optgroup label="Under Graduate">
                                                                <option value="High School"></option>
                                                            </optgroup>
                                                        </select></div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-12 col-md-5">
                                                        <div class="form-group mb-3"><label
                                                                class="form-label">Subject</label><input
                                                                class="form-control" type="text"
                                                                value="${education.subject}"></div>
                                                    </div>
                                                    <div class="col-12 col-md-5 offset-md-1">
                                                        <div class="form-group mb-3"><label class="form-label">Start
                                                            Date</label><input class="form-control" type="date"
                                                                               name="start-date"
                                                                               value="<fmt:formatDate value="${education.startDate}" type="date" pattern="yyyy-MM-dd" />">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-12 col-md-5">
                                                        <div class="form-group mb-3"><label class="form-label">End
                                                            Date</label><input class="form-control" type="date"
                                                                               name="end-date"
                                                                               value="<fmt:formatDate value="${education.endDate}" type="date" pattern="yyyy-MM-dd" />">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">
                                                        <div class="btn-group" role="group">
                                                            <button class="btn btn-secondary" type="reset">Reset
                                                            </button>
                                                            <button class="btn btn-success succ" value="edit"
                                                                    type="submit">Save
                                                                Changes
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="tab-pane fade" role="tabpanel" id="tab-3">
                        <c:if test="${candidate.workHistoryList.size() == 0}">
                            <div class="d-flex justify-content-center" style="padding:3rem 0;">
                                <div>
                                    <svg xmlns="http://www.w3.org/2000/svg" height="2rem" viewBox="0 -12 512.00032 512"
                                         width="2rem">
                                        <path d="m455.074219 172.613281 53.996093-53.996093c2.226563-2.222657 3.273438-5.367188 2.828126-8.480469-.441407-3.113281-2.328126-5.839844-5.085938-7.355469l-64.914062-35.644531c-4.839844-2.65625-10.917969-.886719-13.578126 3.953125-2.65625 4.84375-.890624 10.921875 3.953126 13.578125l53.234374 29.230469-46.339843 46.335937-166.667969-91.519531 46.335938-46.335938 46.839843 25.722656c4.839844 2.65625 10.921875.890626 13.578125-3.953124 2.660156-4.839844.890625-10.921876-3.953125-13.578126l-53.417969-29.335937c-3.898437-2.140625-8.742187-1.449219-11.882812 1.695313l-54 54-54-54c-3.144531-3.144532-7.988281-3.832032-11.882812-1.695313l-184.929688 101.546875c-2.757812 1.515625-4.644531 4.238281-5.085938 7.355469-.445312 3.113281.601563 6.257812 2.828126 8.480469l53.996093 53.996093-53.996093 53.992188c-2.226563 2.226562-3.273438 5.367187-2.828126 8.484375.441407 3.113281 2.328126 5.839844 5.085938 7.351562l55.882812 30.6875v102.570313c0 3.652343 1.988282 7.011719 5.1875 8.769531l184.929688 101.542969c1.5.824219 3.15625 1.234375 4.8125 1.234375s3.3125-.410156 4.8125-1.234375l184.929688-101.542969c3.199218-1.757812 5.1875-5.117188 5.1875-8.769531v-102.570313l55.882812-30.683594c2.757812-1.515624 4.644531-4.242187 5.085938-7.355468.445312-3.113282-.601563-6.257813-2.828126-8.480469zm-199.074219 90.132813-164.152344-90.136719 164.152344-90.140625 164.152344 90.140625zm-62.832031-240.367188 46.332031 46.335938-166.667969 91.519531-46.335937-46.335937zm-120.328125 162.609375 166.667968 91.519531-46.339843 46.339844-166.671875-91.519531zm358.089844 184.796875-164.929688 90.5625v-102.222656c0-5.523438-4.476562-10-10-10s-10 4.476562-10 10v102.222656l-164.929688-90.5625v-85.671875l109.046876 59.878907c1.511718.828124 3.167968 1.234374 4.808593 1.234374 2.589844 0 5.152344-1.007812 7.074219-2.929687l54-54 54 54c1.921875 1.925781 4.484375 2.929687 7.074219 2.929687 1.640625 0 3.296875-.40625 4.808593-1.234374l109.046876-59.878907zm-112.09375-46.9375-46.339844-46.34375 166.667968-91.515625 46.34375 46.335938zm0 0"/>
                                        <path d="m404.800781 68.175781c2.628907 0 5.199219-1.070312 7.070313-2.933593 1.859375-1.859376 2.929687-4.4375 2.929687-7.066407 0-2.632812-1.070312-5.210937-2.929687-7.070312-1.859375-1.863281-4.441406-2.929688-7.070313-2.929688-2.640625 0-5.210937 1.066407-7.070312 2.929688-1.871094 1.859375-2.929688 4.4375-2.929688 7.070312 0 2.628907 1.058594 5.207031 2.929688 7.066407 1.859375 1.863281 4.441406 2.933593 7.070312 2.933593zm0 0"/>
                                        <path d="m256 314.925781c-2.628906 0-5.210938 1.066407-7.070312 2.929688-1.859376 1.867187-2.929688 4.4375-2.929688 7.070312 0 2.636719 1.070312 5.207031 2.929688 7.078125 1.859374 1.859375 4.441406 2.921875 7.070312 2.921875s5.210938-1.0625 7.070312-2.921875c1.859376-1.871094 2.929688-4.441406 2.929688-7.078125 0-2.632812-1.070312-5.203125-2.929688-7.070312-1.859374-1.863281-4.441406-2.929688-7.070312-2.929688zm0 0"/>
                                    </svg>
                                    No work history added yet
                                </div>
                            </div>
                        </c:if>
                        <c:forEach var="workHistory" items="${candidate.workHistoryList}" varStatus="loop">
                            <div class="accordion" role="tablist" id="accordion-${loop.index}-workHistory">
                                <div class="accordion-item">
                                    <h2 class="accordion-header mb-0" role="tab">
                                        <button class="accordion-button header-btn" data-bs-toggle="collapse"
                                                data-bs-target="#accordion-${loop.index}-workHistory .item-${loop.index}-workHistory"
                                                aria-expanded="true"
                                                aria-controls="accordion-${loop.index}-workHistory .item-${loop.index}-workHistory">
                                            Work History Title
                                        </button>
                                    </h2>
                                    <div class="accordion-collapse collapse show item-1" role="tabpanel"
                                         data-bs-parent="#accordion-${loop.index}-workHistory">
                                        <div class="accordion-body">
                                            <form action="<c:url value='/candidate-profile'/>" method="post">
                                                <input type="hidden" name="form_name" value="workHistory"/>
                                                <input type="hidden" name="id" value="${workHistory.workhistoryID}"/>
                                                <input type="hidden" name="action" value="profilePageAction"/>
                                                <div class="row">
                                                    <div class="col-12 col-md-5">
                                                        <div class="form-group mb-3"><label
                                                                class="form-label">Company</label><input
                                                                class="form-control" type="text" name="company"
                                                                value="${workHistory.company}"></div>
                                                    </div>
                                                    <div class="col-12 col-md-5 offset-md-1">
                                                        <div class="form-group mb-3"><label
                                                                class="form-label">Title</label><input
                                                                class="form-control" type="text" name="title"
                                                                value="${workHistory.title}"></div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-12 col-md-5">
                                                        <div class="form-group mb-3"><label class="form-label">Start
                                                            Date</label><input name="start-date" class="form-control"
                                                                               type="date"
                                                                               value="<fmt:formatDate value="${workHistory.startDate}" type="date" pattern="yyyy-MM-dd" />">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-md-5 offset-md-1">
                                                        <div class="form-group mb-3"><label class="form-label">End
                                                            Date</label><input class="form-control" name="end-date"
                                                                               type="date"
                                                                               value="<fmt:formatDate value="${workHistory.endDate}" type="date" pattern="yyyy-MM-dd" />">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-12 col-md-5">
                                                        <div class="form-group mb-3"><label
                                                                class="form-label">Reference</label><input
                                                                class="form-control" type="email" name="reference"
                                                                value="${workHistory.reference}"></div>
                                                    </div>
                                                    <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">
                                                        <div class="d-flex justify-content-end align-items-end align-content-end save-btns form-group mb-3">
                                                            <div class="btn-group" role="group">
                                                                <button class="btn btn-secondary" type="reset">Reset
                                                                </button>
                                                                <button class="btn btn-success succ" value="edit"
                                                                        type="submit">Save
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
                        </c:forEach>
                    </div>
                    <div class="tab-pane fade" role="tabpanel" id="tab-4">
                        <div class="accordion" role="tablist" id="accordion-3">
                            <div class="accordion-item">
                                <h2 class="accordion-header mb-0" role="tab">
                                    <button class="accordion-button header-btn" data-bs-toggle="collapse"
                                            data-bs-target="#accordion-3 .item-1" aria-expanded="true"
                                            aria-controls="accordion-3 .item-1">Skill Name
                                    </button>
                                </h2>
                                <div class="accordion-collapse collapse show item-1" role="tabpanel"
                                     data-bs-parent="#accordion-3">
                                    <div class="accordion-body">
                                        <form>
                                            <div class="row">
                                                <div class="col-12 col-md-5"><select class="form-select level-slc"
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
                                                    <div class="d-flex justify-content-end align-items-end align-content-end save-btns form-group mb-3">
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
                    <div class="tab-pane fade" role="tabpanel" id="tab-5">
                        <div class="accordion" role="tablist" id="accordion-3">
                            <div class="accordion-item">
                                <h2 class="accordion-header mb-0" role="tab"><button class="accordion-button header-btn" data-bs-toggle="collapse" data-bs-target="#accordion-3 .item-1" aria-expanded="true" aria-controls="accordion-3 .item-1">Skill Name</button></h2>
                                <div class="accordion-collapse collapse show item-1" role="tabpanel" data-bs-parent="#accordion-3">
                                    <div class="accordion-body">
                                        <form>
                                            <div class="row">
                                                <div class="col-12 col-md-5"><select class="form-select level-slc" name="education-lvl">
                                                    <optgroup label="Soft Skill">
                                                        <option value="diploma" selected>Communication</option>
                                                        <option value="bachelor">Team work</option>
                                                    </optgroup>
                                                    <optgroup label="Software">
                                                        <option value>Office</option>
                                                    </optgroup>
                                                </select></div>
                                                <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">
                                                    <div class="d-flex justify-content-end align-items-end align-content-end save-btns form-group mb-3">
                                                        <div class="btn-group" role="group"><button class="btn btn-secondary" type="reset">Reset</button><button class="btn btn-success succ" type="submit">Save Changes</button></div>
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
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">--%>
<%--    <title>Candidate Profile Edit</title>--%>
<%--    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet"--%>
<%--          href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">--%>
<%--    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">--%>
<%--    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">--%>
<%--    <link rel="stylesheet" href="assets/css/nav-bar.css">--%>
<%--    <link rel="stylesheet" href="assets/css/profile-edit.css">--%>
<%--    <link rel="stylesheet" href="assets/css/styles.css">--%>
<%--</head>--%>

<%--<body onload="<c:if--%>
<%--        test='${requestScope.currentTab != null}'>document.getElementById('${requestScope.currentTab.trim()}').click()</c:if>">--%>

<%--<%@include file="/WEB-INF/jspf/navbar.jspf" %>--%>
<%--<c:if test="${requestScope.errList != null}">--%>
<%--    <div class="alert alert-warning" role="alert">--%>
<%--        <c:forEach var="error" items="${requestScope.errList}">--%>
<%--            <div>&#9888; ${error}</div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--</c:if>--%>
<%--<c:if test="${requestScope.success == true}">--%>
<%--    <div class="alert alert-success" role="alert">--%>
<%--        <span><c:out value="${sucessMessage}"/></span>--%>
<%--    </div>--%>
<%--</c:if>--%>

<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-12 col-lg-10 offset-lg-1">--%>
<%--            <div class="d-md-flex flex-md-row-reverse">--%>
<%--                <ul class="nav nav-tabs d-flex flex-column edit-items" role="tablist">--%>
<%--                    <li class="nav-item" role="presentation"><a class="nav-link active" role="tab" data-toggle="tab"--%>
<%--                                                                href="#tab-1">Personal Information</a></li>--%>
<%--                    <li class="nav-item" role="presentation"><a class="nav-link" role="tab" data-toggle="tab"--%>
<%--                                                                id="edit-education-cta"--%>
<%--                                                                href="#tab-2">Education</a></li>--%>
<%--                    <li class="nav-item" role="presentation"><a class="nav-link" role="tab" data-toggle="tab"--%>
<%--                                                                id="edit-workHistory-cta"--%>
<%--                                                                href="#tab-3">Work History</a></li>--%>

<%--                </ul>--%>
<%--                <div class="tab-content edit-content">--%>
<%--                    <div class="tab-pane fade show active" role="tabpanel" id="tab-1">--%>
<%--                        <h1><c:out value="${candidate.canfirstName} ${candidate.canlastName}"/></h1>--%>
<%--                        <p>Status: ${candidate.placed ? 'Placed' : "Not Placed Yet"}</p>--%>
<%--                        <div class="wrapper">--%>
<%--                            <div class="remove-acc-alert popup">--%>
<%--                                <div class="border rounded popup-content">--%>
<%--                                    <button class="btn btn-block d-flex justify-content-end close"--%>
<%--                                            type="button"><i class="icon ion-close-round"></i></button>--%>
<%--                                    <h5 class="text-center">Are you sure you want to remove your Account?</h5>--%>
<%--                                    <form class="ignore popup-form" action="<c:url value='/candidate-profile'/>"--%>
<%--                                          method="post">--%>
<%--                                        <input type="hidden" name="action" value="profilePageAction"/>--%>
<%--                                        <div role="group" class="btn-group d-flex popup-btns">--%>
<%--                                            <button class="btn btn-danger" type="submit" name="submit"--%>
<%--                                                    value="deleteCandidate">Permanently Remove My--%>
<%--                                                Account --%>
<%--                                            </button>--%>
<%--                                        </div>--%>
<%--                                    </form>--%>
<%--                                    <p class="lead text-center warming-txt"><em>You can&#39;t recover your account after--%>
<%--                                        removing it</em></p>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="d-flex justify-content-end">--%>
<%--                            <button class="btn btn-danger open-remove" type="submit">Remove Account</button>--%>
<%--                        </div>--%>
<%--                        <hr>--%>
<%--                        <form class="edit-form" action="<c:url value='/candidate-profile'/>" method="post">--%>
<%--                            <input type="hidden" name="form_name" value="profile"/>--%>
<%--                            <input type="hidden" name="action" value="profilePageAction"/>--%>
<%--                            <input type="hidden" name="username" value="${candidate.canUsername}"/>--%>
<%--                            <div class="form-row">--%>
<%--                                <div class="col-12 col-md-5">--%>
<%--                                    <div class="form-group"><label for="firstName">First Name</label><input--%>
<%--                                            class="form-control" type="text" id="firstName" name="firstName"--%>
<%--                                            value="<c:out value='${candidate.canfirstName}' default=''/>"></div>--%>
<%--                                </div>--%>
<%--                                <div class="col-12 col-md-5 offset-md-1">--%>
<%--                                    <div class="form-group"><label for="lastName">Last Name</label><input--%>
<%--                                            class="form-control" type="text" id="lastName" name="lastName"--%>
<%--                                            value="<c:out value='${candidate.canlastName}' default=''/>"></div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-row">--%>
<%--                                <div class="col-12 col-md-5">--%>

<%--                                </div>--%>
<%--                                <div class="col-12 col-md-5 offset-md-1">--%>
<%--                                    <div class="form-group"><label id="email" for="status">Status</label><select--%>
<%--                                            class="form-control" id="status" name="placed">--%>
<%--                                        <option value="yes" <c:if test="${candidate.placed==true}">selected</c:if>>--%>
<%--                                            Hired--%>
<%--                                        </option>--%>
<%--                                        <option value="no" <c:if test="${candidate.placed==false}">selected</c:if>>--%>
<%--                                            Currently Looking--%>
<%--                                        </option>--%>
<%--                                    </select></div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-row">--%>
<%--                                <div class="col-12 col-md-5">--%>
<%--                                    <div class="form-group"><label for="email">Email</label><input class="form-control"--%>
<%--                                                                                                   type="email"--%>
<%--                                                                                                   id="email"--%>
<%--                                                                                                   name="email"--%>
<%--                                                                                                   value="<c:out value='${candidate.canEmail}' default=''/>">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="col-12 col-md-5 offset-md-1">--%>
<%--                                    <div class="form-group"><label id="email-3">Phone</label><input class="form-control"--%>
<%--                                                                                                    name="phoneNo"--%>
<%--                                                                                                    type="tel"--%>
<%--                                                                                                    value="<c:out value='${candidate.canPhoneNo}' default=''/>">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="form-row">--%>
<%--                                <div class="col-12 col-md-5">--%>
<%--                                    <h5>Change Password</h5>--%>
<%--                                    <div class="form-group"><label for="cur-pass">Current Password</label><input--%>
<%--                                            name="currentPassword"--%>
<%--                                            class="form-control" type="password" id="cur-pass" placeholder="****"></div>--%>
<%--                                    <div class="form-group"><label for="new-pass">New Password</label><input--%>
<%--                                            name="password"--%>
<%--                                            class="form-control" type="password" id="new-pass"></div>--%>
<%--                                    <div class="form-group"><label for="conf-pass">Confirm Password</label><input--%>
<%--                                            name="password-repeat"--%>
<%--                                            class="form-control" type="password" id="conf-pass"></div>--%>
<%--                                </div>--%>
<%--                                <div class="col-12 col-md-5 offset-md-2 d-flex flex-column justify-content-end align-items-start">--%>
<%--                                    <h5 class="display-4">Apply Changes</h5>--%>
<%--                                    <div class="btn-group d-flex" role="group">--%>
<%--                                        <button class="btn btn-secondary" type="reset" style="color: #f1faee;">Reset--%>
<%--                                        </button>--%>
<%--                                        <button class="btn btn-dark succ" type="submit" name="submit" value="edit">Save--%>
<%--                                            Changes--%>
<%--                                        </button>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                    <div class="tab-pane fade" role="tabpanel" id="tab-2">--%>
<%--                        <c:if test="${candidate.educationList.size() == 0}">--%>
<%--                            <div class="d-flex justify-content-center" style="padding:3rem 0;">--%>
<%--                                <div>--%>
<%--                                    <svg xmlns="http://www.w3.org/2000/svg" height="2rem" viewBox="0 -12 512.00032 512"--%>
<%--                                         width="2rem">--%>
<%--                                        <path d="m455.074219 172.613281 53.996093-53.996093c2.226563-2.222657 3.273438-5.367188 2.828126-8.480469-.441407-3.113281-2.328126-5.839844-5.085938-7.355469l-64.914062-35.644531c-4.839844-2.65625-10.917969-.886719-13.578126 3.953125-2.65625 4.84375-.890624 10.921875 3.953126 13.578125l53.234374 29.230469-46.339843 46.335937-166.667969-91.519531 46.335938-46.335938 46.839843 25.722656c4.839844 2.65625 10.921875.890626 13.578125-3.953124 2.660156-4.839844.890625-10.921876-3.953125-13.578126l-53.417969-29.335937c-3.898437-2.140625-8.742187-1.449219-11.882812 1.695313l-54 54-54-54c-3.144531-3.144532-7.988281-3.832032-11.882812-1.695313l-184.929688 101.546875c-2.757812 1.515625-4.644531 4.238281-5.085938 7.355469-.445312 3.113281.601563 6.257812 2.828126 8.480469l53.996093 53.996093-53.996093 53.992188c-2.226563 2.226562-3.273438 5.367187-2.828126 8.484375.441407 3.113281 2.328126 5.839844 5.085938 7.351562l55.882812 30.6875v102.570313c0 3.652343 1.988282 7.011719 5.1875 8.769531l184.929688 101.542969c1.5.824219 3.15625 1.234375 4.8125 1.234375s3.3125-.410156 4.8125-1.234375l184.929688-101.542969c3.199218-1.757812 5.1875-5.117188 5.1875-8.769531v-102.570313l55.882812-30.683594c2.757812-1.515624 4.644531-4.242187 5.085938-7.355468.445312-3.113282-.601563-6.257813-2.828126-8.480469zm-199.074219 90.132813-164.152344-90.136719 164.152344-90.140625 164.152344 90.140625zm-62.832031-240.367188 46.332031 46.335938-166.667969 91.519531-46.335937-46.335937zm-120.328125 162.609375 166.667968 91.519531-46.339843 46.339844-166.671875-91.519531zm358.089844 184.796875-164.929688 90.5625v-102.222656c0-5.523438-4.476562-10-10-10s-10 4.476562-10 10v102.222656l-164.929688-90.5625v-85.671875l109.046876 59.878907c1.511718.828124 3.167968 1.234374 4.808593 1.234374 2.589844 0 5.152344-1.007812 7.074219-2.929687l54-54 54 54c1.921875 1.925781 4.484375 2.929687 7.074219 2.929687 1.640625 0 3.296875-.40625 4.808593-1.234374l109.046876-59.878907zm-112.09375-46.9375-46.339844-46.34375 166.667968-91.515625 46.34375 46.335938zm0 0"/>--%>
<%--                                        <path d="m404.800781 68.175781c2.628907 0 5.199219-1.070312 7.070313-2.933593 1.859375-1.859376 2.929687-4.4375 2.929687-7.066407 0-2.632812-1.070312-5.210937-2.929687-7.070312-1.859375-1.863281-4.441406-2.929688-7.070313-2.929688-2.640625 0-5.210937 1.066407-7.070312 2.929688-1.871094 1.859375-2.929688 4.4375-2.929688 7.070312 0 2.628907 1.058594 5.207031 2.929688 7.066407 1.859375 1.863281 4.441406 2.933593 7.070312 2.933593zm0 0"/>--%>
<%--                                        <path d="m256 314.925781c-2.628906 0-5.210938 1.066407-7.070312 2.929688-1.859376 1.867187-2.929688 4.4375-2.929688 7.070312 0 2.636719 1.070312 5.207031 2.929688 7.078125 1.859374 1.859375 4.441406 2.921875 7.070312 2.921875s5.210938-1.0625 7.070312-2.921875c1.859376-1.871094 2.929688-4.441406 2.929688-7.078125 0-2.632812-1.070312-5.203125-2.929688-7.070312-1.859374-1.863281-4.441406-2.929688-7.070312-2.929688zm0 0"/>--%>
<%--                                    </svg>--%>
<%--                                    No education added yet--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </c:if>--%>
<%--                        <c:forEach var="education" items="${candidate.educationList}" varStatus="loop">--%>
<%--                            <div role="tablist" id="accordion-${loop.index}">--%>
<%--                                <div class="card">--%>
<%--                                    <div class="card-header" role="tab">--%>
<%--                                        <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="true"--%>
<%--                                                            aria-controls="accordion-1 .item-1"--%>
<%--                                                            href="#accordion-${loop.index} .item-${loop.index}"--%>
<%--                                                            class="header-btn">${education.institution}</a></h5>--%>
<%--                                    </div>--%>
<%--                                    <div class="collapse show item-1" role="tabpanel"--%>
<%--                                         data-parent="#accordion-${loop.index}">--%>
<%--                                        <div class="card-body">--%>
<%--                                            <form action="<c:url value='/candidate-profile'/>" method="post">--%>
<%--                                                <input type="hidden" name="form_name" value="education"/>--%>
<%--                                                <input type="hidden" name="id" value="${education.educationID}"/>--%>
<%--                                                <input type="hidden" name="action" value="profilePageAction"/>--%>
<%--                                                <div class="form-row">--%>
<%--                                                    <div class="col-12 col-md-5">--%>
<%--                                                        <div class="form-group"><label>Institution</label><input--%>
<%--                                                                name="institution"--%>
<%--                                                                class="form-control" type="text"--%>
<%--                                                                value="${education.institution}"></div>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="col-12 col-md-5 offset-md-1">--%>
<%--                                                        <div class="form-group"><label>Education Level</label><select--%>
<%--                                                                class="form-control level-slc" name="education-lvl"--%>
<%--                                                                value="${education.level}">--%>
<%--                                                            <optgroup label="University">--%>
<%--                                                                <option value="diploma" selected="">Diploma</option>--%>
<%--                                                                <option value="bachelor">Bachelor</option>--%>
<%--                                                                <option value="master">Master</option>--%>
<%--                                                                <option value="phd">Ph.D</option>--%>
<%--                                                                <option value="High School Diploma">High School--%>
<%--                                                                    Diploma--%>
<%--                                                                </option>--%>
<%--                                                            </optgroup>--%>
<%--                                                        </select></div>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                                <div class="form-row">--%>
<%--                                                    <div class="col-12 col-md-5">--%>
<%--                                                        <div class="form-group"><label>Subject</label><input--%>
<%--                                                                name="subject"--%>
<%--                                                                class="form-control" type="text"--%>
<%--                                                                value="${education.subject}"></div>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="col-12 col-md-5 offset-md-1">--%>
<%--                                                        <div class="form-group"><label>Start Date</label><input--%>
<%--                                                                name="start-date"--%>
<%--                                                                class="form-control" type="date"--%>
<%--                                                                value="<fmt:formatDate value="${education.startDate}" type="date" pattern="yyyy-MM-dd" />"/>--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                                <div class="form-row">--%>
<%--                                                    <div class="col-12 col-md-5">--%>
<%--                                                        <div class="form-group"><label>End Date</label><input--%>
<%--                                                                name="end-date"--%>
<%--                                                                value="<fmt:formatDate value="${education.endDate}" type="date" pattern="yyyy-MM-dd" />"--%>
<%--                                                                class="form-control" type="date"></div>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">--%>
<%--                                                        <div class="form-group d-flex justify-content-end align-items-end align-content-end save-btns">--%>
<%--                                                            <div class="btn-group" role="group">--%>
<%--                                                                <button class="btn btn-secondary" type="reset">Reset--%>
<%--                                                                </button>--%>
<%--                                                                <button class="btn btn-success succ" type="submit"--%>
<%--                                                                        name="submit" value="edit">Save--%>
<%--                                                                    Changes--%>
<%--                                                                </button>--%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </form>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
<%--                    <div class="tab-pane fade" role="tabpanel" id="tab-3">--%>
<%--                        <c:if test="${candidate.workHistoryList.size() == 0}">--%>
<%--                            <div class="d-flex justify-content-center" style="padding:3rem 0;">--%>
<%--                                <div>--%>
<%--                                    <svg xmlns="http://www.w3.org/2000/svg" height="2rem" viewBox="0 -12 512.00032 512"--%>
<%--                                         width="2rem">--%>
<%--                                        <path d="m455.074219 172.613281 53.996093-53.996093c2.226563-2.222657 3.273438-5.367188 2.828126-8.480469-.441407-3.113281-2.328126-5.839844-5.085938-7.355469l-64.914062-35.644531c-4.839844-2.65625-10.917969-.886719-13.578126 3.953125-2.65625 4.84375-.890624 10.921875 3.953126 13.578125l53.234374 29.230469-46.339843 46.335937-166.667969-91.519531 46.335938-46.335938 46.839843 25.722656c4.839844 2.65625 10.921875.890626 13.578125-3.953124 2.660156-4.839844.890625-10.921876-3.953125-13.578126l-53.417969-29.335937c-3.898437-2.140625-8.742187-1.449219-11.882812 1.695313l-54 54-54-54c-3.144531-3.144532-7.988281-3.832032-11.882812-1.695313l-184.929688 101.546875c-2.757812 1.515625-4.644531 4.238281-5.085938 7.355469-.445312 3.113281.601563 6.257812 2.828126 8.480469l53.996093 53.996093-53.996093 53.992188c-2.226563 2.226562-3.273438 5.367187-2.828126 8.484375.441407 3.113281 2.328126 5.839844 5.085938 7.351562l55.882812 30.6875v102.570313c0 3.652343 1.988282 7.011719 5.1875 8.769531l184.929688 101.542969c1.5.824219 3.15625 1.234375 4.8125 1.234375s3.3125-.410156 4.8125-1.234375l184.929688-101.542969c3.199218-1.757812 5.1875-5.117188 5.1875-8.769531v-102.570313l55.882812-30.683594c2.757812-1.515624 4.644531-4.242187 5.085938-7.355468.445312-3.113282-.601563-6.257813-2.828126-8.480469zm-199.074219 90.132813-164.152344-90.136719 164.152344-90.140625 164.152344 90.140625zm-62.832031-240.367188 46.332031 46.335938-166.667969 91.519531-46.335937-46.335937zm-120.328125 162.609375 166.667968 91.519531-46.339843 46.339844-166.671875-91.519531zm358.089844 184.796875-164.929688 90.5625v-102.222656c0-5.523438-4.476562-10-10-10s-10 4.476562-10 10v102.222656l-164.929688-90.5625v-85.671875l109.046876 59.878907c1.511718.828124 3.167968 1.234374 4.808593 1.234374 2.589844 0 5.152344-1.007812 7.074219-2.929687l54-54 54 54c1.921875 1.925781 4.484375 2.929687 7.074219 2.929687 1.640625 0 3.296875-.40625 4.808593-1.234374l109.046876-59.878907zm-112.09375-46.9375-46.339844-46.34375 166.667968-91.515625 46.34375 46.335938zm0 0"/>--%>
<%--                                        <path d="m404.800781 68.175781c2.628907 0 5.199219-1.070312 7.070313-2.933593 1.859375-1.859376 2.929687-4.4375 2.929687-7.066407 0-2.632812-1.070312-5.210937-2.929687-7.070312-1.859375-1.863281-4.441406-2.929688-7.070313-2.929688-2.640625 0-5.210937 1.066407-7.070312 2.929688-1.871094 1.859375-2.929688 4.4375-2.929688 7.070312 0 2.628907 1.058594 5.207031 2.929688 7.066407 1.859375 1.863281 4.441406 2.933593 7.070312 2.933593zm0 0"/>--%>
<%--                                        <path d="m256 314.925781c-2.628906 0-5.210938 1.066407-7.070312 2.929688-1.859376 1.867187-2.929688 4.4375-2.929688 7.070312 0 2.636719 1.070312 5.207031 2.929688 7.078125 1.859374 1.859375 4.441406 2.921875 7.070312 2.921875s5.210938-1.0625 7.070312-2.921875c1.859376-1.871094 2.929688-4.441406 2.929688-7.078125 0-2.632812-1.070312-5.203125-2.929688-7.070312-1.859374-1.863281-4.441406-2.929688-7.070312-2.929688zm0 0"/>--%>
<%--                                    </svg>--%>
<%--                                    No work history added yet--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </c:if>--%>
<%--                        <c:forEach var="workHistory" items="${candidate.workHistoryList}" varStatus="loop">--%>

<%--                            <div role="tablist" id="accordion-${loop.index}-workHistory">--%>
<%--                                <div class="card">--%>
<%--                                    <div class="card-header" role="tab">--%>
<%--                                        <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="true"--%>
<%--                                                            aria-controls="accordion-${loop.index}-workHistory .item-1"--%>
<%--                                                            href="#accordion-${loop.index}-workHistory .item-1"--%>
<%--                                                            class="header-btn">${workHistory.company}</a></h5>--%>
<%--                                    </div>--%>
<%--                                    <div class="collapse show item-1" role="tabpanel"--%>
<%--                                         data-parent="#accordion-${loop.index}-workHistory">--%>
<%--                                        <div class="card-body">--%>
<%--                                            <form action="<c:url value='/candidate-profile'/>" method="post">--%>
<%--                                                <input type="hidden" name="form_name" value="workHistory"/>--%>
<%--                                                <input type="hidden" name="id" value="${workHistory.workhistoryID}"/>--%>
<%--                                                <input type="hidden" name="action" value="profilePageAction"/>--%>
<%--                                                <div class="form-row">--%>
<%--                                                    <div class="col-12 col-md-5">--%>
<%--                                                        <div class="form-group"><label>Company</label><input--%>
<%--                                                                name="company"--%>
<%--                                                                class="form-control" type="text"--%>
<%--                                                                value="${workHistory.company}"></div>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="col-12 col-md-5 offset-md-1">--%>
<%--                                                        <div class="form-group"><label>Title</label><input name="title"--%>
<%--                                                                                                           class="form-control"--%>
<%--                                                                                                           type="text"--%>
<%--                                                                                                           value="${workHistory.title}">--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                                <div class="form-row">--%>
<%--                                                    <div class="col-12 col-md-5">--%>
<%--                                                        <div class="form-group"><label>Start Date</label><input--%>
<%--                                                                name="start-date"--%>
<%--                                                                class="form-control" type="date"--%>
<%--                                                                value="<fmt:formatDate value="${workHistory.startDate}" type="date" pattern="yyyy-MM-dd" />">--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="col-12 col-md-5 offset-md-1">--%>
<%--                                                        <div class="form-group"><label>End Date</label><input--%>
<%--                                                                name="end-date"--%>
<%--                                                                class="form-control" type="date"--%>
<%--                                                                value="<fmt:formatDate value="${workHistory.endDate}" type="date" pattern="yyyy-MM-dd" />">--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                                <div class="form-row">--%>
<%--                                                    <div class="col-12 col-md-5">--%>
<%--                                                        <div class="form-group"><label>Reference</label><input--%>
<%--                                                                name="reference" value="${workHistory.reference}"--%>
<%--                                                                class="form-control" type="email"></div>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">--%>
<%--                                                        <div class="form-group d-flex justify-content-end align-items-end align-content-end save-btns">--%>
<%--                                                            <div class="btn-group" role="group">--%>
<%--                                                                <button class="btn btn-secondary" type="reset">Reset--%>
<%--                                                                </button>--%>
<%--                                                                <button class="btn btn-success succ" type="submit"--%>
<%--                                                                        name="submit" value="edit">Save--%>
<%--                                                                    Changes--%>
<%--                                                                </button>--%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </form>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
<%--                    <!----%>
<%--                <div class="tab-pane fade" role="tabpanel" id="tab-4">--%>
<%--                    <div role="tablist" id="accordion-3">--%>
<%--                        <div class="card">--%>
<%--                            <div class="card-header" role="tab">--%>
<%--                                <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="true"--%>
<%--                                                    aria-controls="accordion-3 .item-1" href="#accordion-3 .item-1"--%>
<%--                                                    class="header-btn">Skill Name</a></h5>--%>
<%--                            </div>--%>
<%--                            <div class="collapse show item-1" role="tabpanel" data-parent="#accordion-3">--%>
<%--                                <div class="card-body">--%>
<%--                                    <form>--%>
<%--                                        <div class="form-row">--%>
<%--                                            <div class="col-12 col-md-5"><select class="form-control level-slc"--%>
<%--                                                                                 name="education-lvl">--%>
<%--                                                    <optgroup label="Soft Skill">--%>
<%--                                                        <option value="diploma" selected="">Communication</option>--%>
<%--                                                        <option value="bachelor">Team work</option>--%>
<%--                                                    </optgroup>--%>
<%--                                                    <optgroup label="Software">--%>
<%--                                                        <option value="">Office</option>--%>
<%--                                                    </optgroup>--%>
<%--                                                </select></div>--%>
<%--                                            <div class="col-12 col-md-5 offset-md-1 d-flex justify-content-around align-items-end">--%>
<%--                                                <div class="form-group d-flex justify-content-end align-items-end align-content-end save-btns">--%>
<%--                                                    <div class="btn-group" role="group">--%>
<%--                                                        <button class="btn btn-secondary" type="reset">Reset--%>
<%--                                                        </button>--%>
<%--                                                        <button class="btn btn-success succ" type="submit">Save--%>
<%--                                                            Changes--%>
<%--                                                        </button>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </form>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                            -->--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script src="assets/js/jquery.min.js"></script>--%>
<%--<script src="assets/bootstrap/js/bootstrap.min.js"></script>--%>
<%--<script src="assets/js/bs-init.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>--%>
<%--<script src="assets/js/popup.js"></script>--%>
<%--</body>--%>

<%--</html>--%>