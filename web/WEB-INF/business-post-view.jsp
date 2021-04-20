<%-- 
    Document   : business-post-view
    Created on : Mar 22, 2021, 9:21:52 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Level Ground Recruitment | View Job Postings</title>
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
    <link rel="stylesheet" href="assets/css/business-post.css">
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
    <div class="row header-row">
        <div class="col header-row">
            <h1 class="display-4 job-title"><c:out value='${jobposting.jobTitle}' default=''/></h1>
        </div>
    </div>
    <div class="row header-row">
        <div class="shadow-sm job-post" style="padding: 20px">
            <div class="d-flex flex-column align-items-baseline flex-md-row justify-content-md-between job-header"><span
                    class="badge rounded-pill bg-secondary stat-badge"><c:out value='${jobposting.jobStatus}'
                                                                              default=''/></span>
                <p>Post date: <fmt:formatDate value="${jobposting.postDate}" type="date" pattern="yyyy-MM-dd"/></p>
                <a href="#accordion-0" class="btn btn-success" type="button">Applicants <span class="badge bg-dark notif"
                                                                               style="margin-left: 5px"><c:out
                        value='${jobposting.applicants}' default=''/></span>
                </a>
            </div>
            <hr>
            <div>
                <h4>Description</h4>
                <p><c:out value='${jobposting.jobDescription}' default=''/><br></p>
                <hr>
            </div>
            <div>
                <h4>Requirements</h4>
                <p><c:out value='${jobposting.requirements}' default=''/><br></p>
                <hr>
            </div>
            <div class="row">
                <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-map-pin business-icon"></i>
                    <p><c:out value='${jobposting.location}' default=''/></p>
                </div>
                <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-money-bill-alt business-icon"></i>
                    <p><c:out value='${jobposting.wage}' default=''/>$ year</p>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-hourglass-start business-icon"></i>
                    <p><fmt:formatDate value="${jobposting.startDate}" type="date" pattern="yyyy-MM-dd"/></p>
                </div>
                <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline"><i
                        class="fas fa-hourglass-end business-icon"></i>
                    <p><fmt:formatDate value="${jobposting.endDate}" type="date" pattern="yyyy-MM-dd"/></p>
                </div>
            </div>
        </div>
    </div>

    <div class="row header-row">
        <div class="col">
            <div class="d-flex flex-column flex-md-row">
                <h1 class="display-5 col canHeader">Candidates</h1>
            </div>


            <c:forEach var="candidate" items="${candidates}" varStatus="loop">
                <div class="accordion" role="tablist" id="accordion-${loop.index}">
                    <div class="accordion-item">
                        <h2 class="accordion-header mb-0" role="tab">
                            <button class="accordion-button collapsed candidate-name accordion-button" data-bs-toggle="collapse"
                                    data-bs-target="#accordion-${loop.index} .item-${loop.index}" aria-expanded="true"
                                    aria-controls="accordion-${loop.index} .item-${loop.index}">Candidate ID: <c:out
                                    value='${candidate.candidateID}' default=''/>
                            </button>
                        </h2>
                        <div class="accordion-collapse collapse collapsed item-${loop.index} item-content" role="tabpanel"
                             data-bs-parent="#accordion-${loop.index}">
                            <div class="accordion-body">
                                <div class="row candidate-row">
                                    <div class="col-md-5">
                                        <h4>Education</h4>
                                        <hr>
                                        <c:if test="${candidate.educationList.size() == 0}">
                                            <div class="d-flex justify-content-center" style="padding:3rem 0;">
                                                <div>
                                                    <svg xmlns="http://www.w3.org/2000/svg" height="2rem" viewBox="0 -12 512.00032 512"
                                                         width="2rem">
                                                        <path
                                                                d="m455.074219 172.613281 53.996093-53.996093c2.226563-2.222657 3.273438-5.367188 2.828126-8.480469-.441407-3.113281-2.328126-5.839844-5.085938-7.355469l-64.914062-35.644531c-4.839844-2.65625-10.917969-.886719-13.578126 3.953125-2.65625 4.84375-.890624 10.921875 3.953126 13.578125l53.234374 29.230469-46.339843 46.335937-166.667969-91.519531 46.335938-46.335938 46.839843 25.722656c4.839844 2.65625 10.921875.890626 13.578125-3.953124 2.660156-4.839844.890625-10.921876-3.953125-13.578126l-53.417969-29.335937c-3.898437-2.140625-8.742187-1.449219-11.882812 1.695313l-54 54-54-54c-3.144531-3.144532-7.988281-3.832032-11.882812-1.695313l-184.929688 101.546875c-2.757812 1.515625-4.644531 4.238281-5.085938 7.355469-.445312 3.113281.601563 6.257812 2.828126 8.480469l53.996093 53.996093-53.996093 53.992188c-2.226563 2.226562-3.273438 5.367187-2.828126 8.484375.441407 3.113281 2.328126 5.839844 5.085938 7.351562l55.882812 30.6875v102.570313c0 3.652343 1.988282 7.011719 5.1875 8.769531l184.929688 101.542969c1.5.824219 3.15625 1.234375 4.8125 1.234375s3.3125-.410156 4.8125-1.234375l184.929688-101.542969c3.199218-1.757812 5.1875-5.117188 5.1875-8.769531v-102.570313l55.882812-30.683594c2.757812-1.515624 4.644531-4.242187 5.085938-7.355468.445312-3.113282-.601563-6.257813-2.828126-8.480469zm-199.074219 90.132813-164.152344-90.136719 164.152344-90.140625 164.152344 90.140625zm-62.832031-240.367188 46.332031 46.335938-166.667969 91.519531-46.335937-46.335937zm-120.328125 162.609375 166.667968 91.519531-46.339843 46.339844-166.671875-91.519531zm358.089844 184.796875-164.929688 90.5625v-102.222656c0-5.523438-4.476562-10-10-10s-10 4.476562-10 10v102.222656l-164.929688-90.5625v-85.671875l109.046876 59.878907c1.511718.828124 3.167968 1.234374 4.808593 1.234374 2.589844 0 5.152344-1.007812 7.074219-2.929687l54-54 54 54c1.921875 1.925781 4.484375 2.929687 7.074219 2.929687 1.640625 0 3.296875-.40625 4.808593-1.234374l109.046876-59.878907zm-112.09375-46.9375-46.339844-46.34375 166.667968-91.515625 46.34375 46.335938zm0 0"/>
                                                        <path
                                                                d="m404.800781 68.175781c2.628907 0 5.199219-1.070312 7.070313-2.933593 1.859375-1.859376 2.929687-4.4375 2.929687-7.066407 0-2.632812-1.070312-5.210937-2.929687-7.070312-1.859375-1.863281-4.441406-2.929688-7.070313-2.929688-2.640625 0-5.210937 1.066407-7.070312 2.929688-1.871094 1.859375-2.929688 4.4375-2.929688 7.070312 0 2.628907 1.058594 5.207031 2.929688 7.066407 1.859375 1.863281 4.441406 2.933593 7.070312 2.933593zm0 0"/>
                                                        <path
                                                                d="m256 314.925781c-2.628906 0-5.210938 1.066407-7.070312 2.929688-1.859376 1.867187-2.929688 4.4375-2.929688 7.070312 0 2.636719 1.070312 5.207031 2.929688 7.078125 1.859374 1.859375 4.441406 2.921875 7.070312 2.921875s5.210938-1.0625 7.070312-2.921875c1.859376-1.871094 2.929688-4.441406 2.929688-7.078125 0-2.632812-1.070312-5.203125-2.929688-7.070312-1.859374-1.863281-4.441406-2.929688-7.070312-2.929688zm0 0"/>
                                                    </svg>
                                                    No education added yet
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:forEach var="education" items="${candidate.educationList}">
                                            <div class="shadow-sm items">
                                                <h6><c:out value='${education.institution}' default=''/></h6>
                                                <p>Level: <c:out value='${education.level}' default=''/></p>
                                                <p>Subject: <c:out value='${education.subject}' default=''/></p>
                                                <p>Start Date: <fmt:formatDate value="${education.startDate}"
                                                                               type="date" pattern="yyyy-MM-dd"/></p>
                                                <p>End Date:
                                                    <c:choose>
                                                    <c:when test="${education.endDate !=null}">
                                                        <fmt:formatDate value="${education.endDate}" type="date"
                                                                        pattern="yyyy-MM-dd"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                    current
                                                    </c:otherwise>
                                                    </c:choose>
                                                <p/>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-5 offset-md-2">
                                        <h4>Work History</h4>
                                        <hr>
                                        <c:if test="${candidate.workHistoryList.size() == 0}">
                                            <div class="d-flex justify-content-center" style="padding:3rem 0;">
                                                <div>
                                                    <svg xmlns="http://www.w3.org/2000/svg" height="2rem" viewBox="0 -12 512.00032 512"
                                                         width="2rem">
                                                        <path
                                                                d="m455.074219 172.613281 53.996093-53.996093c2.226563-2.222657 3.273438-5.367188 2.828126-8.480469-.441407-3.113281-2.328126-5.839844-5.085938-7.355469l-64.914062-35.644531c-4.839844-2.65625-10.917969-.886719-13.578126 3.953125-2.65625 4.84375-.890624 10.921875 3.953126 13.578125l53.234374 29.230469-46.339843 46.335937-166.667969-91.519531 46.335938-46.335938 46.839843 25.722656c4.839844 2.65625 10.921875.890626 13.578125-3.953124 2.660156-4.839844.890625-10.921876-3.953125-13.578126l-53.417969-29.335937c-3.898437-2.140625-8.742187-1.449219-11.882812 1.695313l-54 54-54-54c-3.144531-3.144532-7.988281-3.832032-11.882812-1.695313l-184.929688 101.546875c-2.757812 1.515625-4.644531 4.238281-5.085938 7.355469-.445312 3.113281.601563 6.257812 2.828126 8.480469l53.996093 53.996093-53.996093 53.992188c-2.226563 2.226562-3.273438 5.367187-2.828126 8.484375.441407 3.113281 2.328126 5.839844 5.085938 7.351562l55.882812 30.6875v102.570313c0 3.652343 1.988282 7.011719 5.1875 8.769531l184.929688 101.542969c1.5.824219 3.15625 1.234375 4.8125 1.234375s3.3125-.410156 4.8125-1.234375l184.929688-101.542969c3.199218-1.757812 5.1875-5.117188 5.1875-8.769531v-102.570313l55.882812-30.683594c2.757812-1.515624 4.644531-4.242187 5.085938-7.355468.445312-3.113282-.601563-6.257813-2.828126-8.480469zm-199.074219 90.132813-164.152344-90.136719 164.152344-90.140625 164.152344 90.140625zm-62.832031-240.367188 46.332031 46.335938-166.667969 91.519531-46.335937-46.335937zm-120.328125 162.609375 166.667968 91.519531-46.339843 46.339844-166.671875-91.519531zm358.089844 184.796875-164.929688 90.5625v-102.222656c0-5.523438-4.476562-10-10-10s-10 4.476562-10 10v102.222656l-164.929688-90.5625v-85.671875l109.046876 59.878907c1.511718.828124 3.167968 1.234374 4.808593 1.234374 2.589844 0 5.152344-1.007812 7.074219-2.929687l54-54 54 54c1.921875 1.925781 4.484375 2.929687 7.074219 2.929687 1.640625 0 3.296875-.40625 4.808593-1.234374l109.046876-59.878907zm-112.09375-46.9375-46.339844-46.34375 166.667968-91.515625 46.34375 46.335938zm0 0"/>
                                                        <path
                                                                d="m404.800781 68.175781c2.628907 0 5.199219-1.070312 7.070313-2.933593 1.859375-1.859376 2.929687-4.4375 2.929687-7.066407 0-2.632812-1.070312-5.210937-2.929687-7.070312-1.859375-1.863281-4.441406-2.929688-7.070313-2.929688-2.640625 0-5.210937 1.066407-7.070312 2.929688-1.871094 1.859375-2.929688 4.4375-2.929688 7.070312 0 2.628907 1.058594 5.207031 2.929688 7.066407 1.859375 1.863281 4.441406 2.933593 7.070312 2.933593zm0 0"/>
                                                        <path
                                                                d="m256 314.925781c-2.628906 0-5.210938 1.066407-7.070312 2.929688-1.859376 1.867187-2.929688 4.4375-2.929688 7.070312 0 2.636719 1.070312 5.207031 2.929688 7.078125 1.859374 1.859375 4.441406 2.921875 7.070312 2.921875s5.210938-1.0625 7.070312-2.921875c1.859376-1.871094 2.929688-4.441406 2.929688-7.078125 0-2.632812-1.070312-5.203125-2.929688-7.070312-1.859374-1.863281-4.441406-2.929688-7.070312-2.929688zm0 0"/>
                                                    </svg>
                                                    No work history added yet
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:forEach var="work" items="${candidate.workHistoryList}">
                                            <div class="shadow-sm items">
                                                <h6><c:out value='${work.company}' default=''/></h6>
                                                <p>Title: <c:out value='${work.title}' default=''/></p>
                                                <p>Start Date: <fmt:formatDate value="${work.startDate}" type="date"
                                                                               pattern="yyyy-MM-dd"/></p>
                                                <p>End Date:
                                                    <c:choose>
                                                    <c:when test="${work.endDate !=null}">
                                                        <fmt:formatDate value="${work.endDate}" type="date"
                                                                        pattern="yyyy-MM-dd"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                    current
                                                    </c:otherwise>
                                                    </c:choose>
                                                <p/>
                                                <p>Reference: <c:out value='${work.reference}' default=''/></p>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="row candidate-row">
                                    <div class="col-md-5">
                                        <h4>Skills</h4>
                                        <hr>
                                        <c:if test="${candidate.candidateSkillList.size() == 0}">
                                            <div class="d-flex justify-content-center" style="padding:3rem 0;">
                                                <div>
                                                    <svg xmlns="http://www.w3.org/2000/svg" height="2rem" viewBox="0 -12 512.00032 512"
                                                         width="2rem">
                                                        <path
                                                                d="m455.074219 172.613281 53.996093-53.996093c2.226563-2.222657 3.273438-5.367188 2.828126-8.480469-.441407-3.113281-2.328126-5.839844-5.085938-7.355469l-64.914062-35.644531c-4.839844-2.65625-10.917969-.886719-13.578126 3.953125-2.65625 4.84375-.890624 10.921875 3.953126 13.578125l53.234374 29.230469-46.339843 46.335937-166.667969-91.519531 46.335938-46.335938 46.839843 25.722656c4.839844 2.65625 10.921875.890626 13.578125-3.953124 2.660156-4.839844.890625-10.921876-3.953125-13.578126l-53.417969-29.335937c-3.898437-2.140625-8.742187-1.449219-11.882812 1.695313l-54 54-54-54c-3.144531-3.144532-7.988281-3.832032-11.882812-1.695313l-184.929688 101.546875c-2.757812 1.515625-4.644531 4.238281-5.085938 7.355469-.445312 3.113281.601563 6.257812 2.828126 8.480469l53.996093 53.996093-53.996093 53.992188c-2.226563 2.226562-3.273438 5.367187-2.828126 8.484375.441407 3.113281 2.328126 5.839844 5.085938 7.351562l55.882812 30.6875v102.570313c0 3.652343 1.988282 7.011719 5.1875 8.769531l184.929688 101.542969c1.5.824219 3.15625 1.234375 4.8125 1.234375s3.3125-.410156 4.8125-1.234375l184.929688-101.542969c3.199218-1.757812 5.1875-5.117188 5.1875-8.769531v-102.570313l55.882812-30.683594c2.757812-1.515624 4.644531-4.242187 5.085938-7.355468.445312-3.113282-.601563-6.257813-2.828126-8.480469zm-199.074219 90.132813-164.152344-90.136719 164.152344-90.140625 164.152344 90.140625zm-62.832031-240.367188 46.332031 46.335938-166.667969 91.519531-46.335937-46.335937zm-120.328125 162.609375 166.667968 91.519531-46.339843 46.339844-166.671875-91.519531zm358.089844 184.796875-164.929688 90.5625v-102.222656c0-5.523438-4.476562-10-10-10s-10 4.476562-10 10v102.222656l-164.929688-90.5625v-85.671875l109.046876 59.878907c1.511718.828124 3.167968 1.234374 4.808593 1.234374 2.589844 0 5.152344-1.007812 7.074219-2.929687l54-54 54 54c1.921875 1.925781 4.484375 2.929687 7.074219 2.929687 1.640625 0 3.296875-.40625 4.808593-1.234374l109.046876-59.878907zm-112.09375-46.9375-46.339844-46.34375 166.667968-91.515625 46.34375 46.335938zm0 0"/>
                                                        <path
                                                                d="m404.800781 68.175781c2.628907 0 5.199219-1.070312 7.070313-2.933593 1.859375-1.859376 2.929687-4.4375 2.929687-7.066407 0-2.632812-1.070312-5.210937-2.929687-7.070312-1.859375-1.863281-4.441406-2.929688-7.070313-2.929688-2.640625 0-5.210937 1.066407-7.070312 2.929688-1.871094 1.859375-2.929688 4.4375-2.929688 7.070312 0 2.628907 1.058594 5.207031 2.929688 7.066407 1.859375 1.863281 4.441406 2.933593 7.070312 2.933593zm0 0"/>
                                                        <path
                                                                d="m256 314.925781c-2.628906 0-5.210938 1.066407-7.070312 2.929688-1.859376 1.867187-2.929688 4.4375-2.929688 7.070312 0 2.636719 1.070312 5.207031 2.929688 7.078125 1.859374 1.859375 4.441406 2.921875 7.070312 2.921875s5.210938-1.0625 7.070312-2.921875c1.859376-1.871094 2.929688-4.441406 2.929688-7.078125 0-2.632812-1.070312-5.203125-2.929688-7.070312-1.859374-1.863281-4.441406-2.929688-7.070312-2.929688zm0 0"/>
                                                    </svg>
                                                    No skill added yet
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:forEach var="skill" items="${candidate.candidateSkillList}">
                                            <div class="shadow-sm items">
                                                <p>Skill: <c:out value='${skill.skillID.description}' default=''/></p>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-5 offset-md-2">
                                        <h4>Roles</h4>
                                        <hr>
                                        <c:if test="${candidate.roleList.size() == 0}">
                                            <div class="d-flex justify-content-center" style="padding:3rem 0;">
                                                <div>
                                                    <svg xmlns="http://www.w3.org/2000/svg" height="2rem" viewBox="0 -12 512.00032 512"
                                                         width="2rem">
                                                        <path
                                                                d="m455.074219 172.613281 53.996093-53.996093c2.226563-2.222657 3.273438-5.367188 2.828126-8.480469-.441407-3.113281-2.328126-5.839844-5.085938-7.355469l-64.914062-35.644531c-4.839844-2.65625-10.917969-.886719-13.578126 3.953125-2.65625 4.84375-.890624 10.921875 3.953126 13.578125l53.234374 29.230469-46.339843 46.335937-166.667969-91.519531 46.335938-46.335938 46.839843 25.722656c4.839844 2.65625 10.921875.890626 13.578125-3.953124 2.660156-4.839844.890625-10.921876-3.953125-13.578126l-53.417969-29.335937c-3.898437-2.140625-8.742187-1.449219-11.882812 1.695313l-54 54-54-54c-3.144531-3.144532-7.988281-3.832032-11.882812-1.695313l-184.929688 101.546875c-2.757812 1.515625-4.644531 4.238281-5.085938 7.355469-.445312 3.113281.601563 6.257812 2.828126 8.480469l53.996093 53.996093-53.996093 53.992188c-2.226563 2.226562-3.273438 5.367187-2.828126 8.484375.441407 3.113281 2.328126 5.839844 5.085938 7.351562l55.882812 30.6875v102.570313c0 3.652343 1.988282 7.011719 5.1875 8.769531l184.929688 101.542969c1.5.824219 3.15625 1.234375 4.8125 1.234375s3.3125-.410156 4.8125-1.234375l184.929688-101.542969c3.199218-1.757812 5.1875-5.117188 5.1875-8.769531v-102.570313l55.882812-30.683594c2.757812-1.515624 4.644531-4.242187 5.085938-7.355468.445312-3.113282-.601563-6.257813-2.828126-8.480469zm-199.074219 90.132813-164.152344-90.136719 164.152344-90.140625 164.152344 90.140625zm-62.832031-240.367188 46.332031 46.335938-166.667969 91.519531-46.335937-46.335937zm-120.328125 162.609375 166.667968 91.519531-46.339843 46.339844-166.671875-91.519531zm358.089844 184.796875-164.929688 90.5625v-102.222656c0-5.523438-4.476562-10-10-10s-10 4.476562-10 10v102.222656l-164.929688-90.5625v-85.671875l109.046876 59.878907c1.511718.828124 3.167968 1.234374 4.808593 1.234374 2.589844 0 5.152344-1.007812 7.074219-2.929687l54-54 54 54c1.921875 1.925781 4.484375 2.929687 7.074219 2.929687 1.640625 0 3.296875-.40625 4.808593-1.234374l109.046876-59.878907zm-112.09375-46.9375-46.339844-46.34375 166.667968-91.515625 46.34375 46.335938zm0 0"/>
                                                        <path
                                                                d="m404.800781 68.175781c2.628907 0 5.199219-1.070312 7.070313-2.933593 1.859375-1.859376 2.929687-4.4375 2.929687-7.066407 0-2.632812-1.070312-5.210937-2.929687-7.070312-1.859375-1.863281-4.441406-2.929688-7.070313-2.929688-2.640625 0-5.210937 1.066407-7.070312 2.929688-1.871094 1.859375-2.929688 4.4375-2.929688 7.070312 0 2.628907 1.058594 5.207031 2.929688 7.066407 1.859375 1.863281 4.441406 2.933593 7.070312 2.933593zm0 0"/>
                                                        <path
                                                                d="m256 314.925781c-2.628906 0-5.210938 1.066407-7.070312 2.929688-1.859376 1.867187-2.929688 4.4375-2.929688 7.070312 0 2.636719 1.070312 5.207031 2.929688 7.078125 1.859374 1.859375 4.441406 2.921875 7.070312 2.921875s5.210938-1.0625 7.070312-2.921875c1.859376-1.871094 2.929688-4.441406 2.929688-7.078125 0-2.632812-1.070312-5.203125-2.929688-7.070312-1.859374-1.863281-4.441406-2.929688-7.070312-2.929688zm0 0"/>
                                                    </svg>
                                                    No role added yet
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:forEach var="role" items="${candidate.roleList}">
                                            <div class="shadow-sm items">
                                                <p>Role: <c:out value='${role.description}' default=''/></p>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div>
                                    <div class="btn-group float-end btn-group sub-rej-btn d-flex justify-content-end" role="group">
                                        <button class="btn btn-danger open-work" type="button"
                                                name="${candidate.candidateID}${jobposting.jobpostingID}"
                                                onclick="document.getElementById('deletecandidateID').value=${candidate.candidateID}
                                                        document.getElementById('deletepostingID').value=${jobposting.jobpostingID}">
                                            Reject
                                        </button>
                                        <form id="setup_interview" action="<c:url value='/setup-interview'/>" method="post">
                                            <button class="btn btn-primary submit-btn" type="submit">Setup Interview
                                            </button>
                                            <input type="hidden" name="candidateID" value="${candidate.candidateID}">
                                            <input type="hidden" name="postingID" value="${jobposting.jobpostingID}">
                                        </form>
                                    </div>
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
    <div class="popup work">
        <div class="border rounded popup-content overflow-auto">
            <button class="btn-close float-end close"></button>
            <h3>Remove This Candidate?</h3>
            <div class="d-flex justify-content-center">
                <form id="setup_interview" action="<c:url value='/reject-candidate'/>" method="post">
                    <button class="btn btn-danger" type="submit">Permanently Remove This Candidate</button>
                    <input id="deletecandidateID" type="hidden" name="candidateID" value="">
                    <input id="deletepostingID" type="hidden" name="postingID" value="">
                </form>
            </div>
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