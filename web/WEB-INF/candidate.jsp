<%--
    Document   : candidate
    Created on : Feb 23, 2021, 9:58:01 AM
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
        <title>capstone</title>
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
        <link rel="stylesheet" href="assets/css/profile.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/css/footer.css">
    </head>

    <body onload="<c:if
              test='${requestScope.currentTab != null}'>document.getElementById('${requestScope.currentTab.trim()}').click()</c:if>">

          <%@include file="/WEB-INF/jspf/navbar.jspf" %>
          <%@include file="/WEB-INF/jspf/alert.jspf" %>

          <div class="wrapper"></div>
          <div class="container-md">

              <div class="row text-start head-row">
                  <div class="col m-auto">
                      <h3 class="display-5">
                          <c:out value="${candidate.canfirstName} ${candidate.canlastName}"/>
                      </h3>
                      <p class="lead">
                          Status: ${candidate.placed ? 'Placed' : "Not placed yet"}
                      </p>
                  </div>
              </div>
              <div class="row head-row">
                  <div class="col-12 col-md-5 sections">
                      <div class="d-flex flex-row justify-content-between align-items-baseline">
                          <h4 class="display-6">Info</h4>
                      </div>
                      <hr>
                      <form class="shadow-sm info-form" data-aos="fade-up">
                          <div class="form-group mb-3">
                              <div class="d-flex align-items-baseline">
                                  <h6>About:&nbsp;</h6>
                                  <p>
                                      <%--                            <c:out value="${candidate.canAbout}"/>--%>
                                  </p>
                              </div>
                              <div class="d-flex align-items-baseline">
                                  <h6>Email:&nbsp;</h6>
                                  <p>
                                      <c:out value="${candidate.canEmail}"/>
                                  </p>
                              </div>
                              <div class="d-flex align-items-baseline">
                                  <h6>Phone Number:&nbsp;</h6>
                                  <p>
                                      <c:out value="${candidate.canPhoneNo}"/>
                                  </p>
                              </div>
                          </div>
                          <div class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                              <div class="btn-group" role="group">
                                  <a class="btn" role="button" data-bs-toggle="tooltip" data-bss-tooltip=""
                                     title="Edit profile" href="<c:url value="/candidate-profile-edit"/>">
                                      <i class="far fa-edit" data-bss-hover-animate="pulse"></i>
                                  </a>
                              </div>
                          </div>
                      </form>
                  </div>
                  <div class="col-12 col-md-5 offset-md-2 sections">
                      <div class="d-flex flex-row justify-content-between align-items-baseline">
                          <h4 class="display-6">Education</h4>
                          <button class="btn btn-outline-success open-edu" data-bss-hover-animate="pulse"
                                  type="submit">
                              <i class="fas fa-plus-circle open" data-bss-hover-animate="pulse" value="addEducation">
                              </i>
                          </button>
                      </div>
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
                          <form class="shadow-sm" data-aos="fade-up" action="<c:url value='/candidate-profile'/>"
                                method="post">
                              <input type="hidden" name="form_name" value="education"/>
                              <input type="hidden" name="id" value="${education.educationID}"/>
                              <input type="hidden" name="action" value="profilePageAction"/>

                              <div class="form-group mb-3">
                                  <div class="d-flex align-items-baseline">
                                      <h6>Institution:&nbsp;</h6>
                                      <p>${education.institution}</p>
                                  </div>
                                  <div class="d-flex align-items-baseline">
                                      <h6>Education Level:&nbsp;</h6>
                                      <p>${education.level}</p>
                                  </div>
                                  <div class="d-flex align-items-baseline">
                                      <h6>Subject:&nbsp;</h6>
                                      <p>${education.subject}</p>
                                  </div>
                                  <div class="d-flex align-items-baseline">
                                      <h6>Start Date:&nbsp;</h6>
                                      <p>
                                          <fmt:formatDate value="${education.startDate}" type="date"
                                                          pattern="yyyy-MM-dd"/>
                                      </p>
                                  </div>
                                  <div class="d-flex align-items-baseline">
                                      <h6>End Date:&nbsp;</h6>
                                      <p>
                                          <c:choose>
                                              <c:when test="${education.endDate !=null}">
                                                  <fmt:formatDate value="${education.endDate}" type="date"
                                                                  pattern="yyyy-MM-dd"/>
                                              </c:when>
                                              <c:otherwise>
                                                  current
                                              </c:otherwise>
                                          </c:choose>
                                      </p>
                                  </div>
                              </div>
                              <form
                                  class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                                  <div class="btn-group" role="group">
                                      <button class="btn" data-bs-toggle="tooltip" data-bss-tooltip="" type="submit"
                                              title="Delete" value="delete" name="submit">
                                          <i class="far fa-window-close" data-bss-hover-animate="pulse"></i>
                                      </button>
                                  </div>
                              </form>
                          </form>
                      </c:forEach>
                      <div class="edu popup">
                          <!-- ERRORS SHOWN FOR THIS TAB HERE-->
                          <c:if
                              test="${requestScope.fail == true && requestScope.currentTab.equals('add-education-cta')}">
                              <div class="alert alert-warning" role="alert">
                                  <c:forEach var="error" items="${requestScope.errList}">
                                      <div>&#9888; ${error}</div>
                                  </c:forEach>
                              </div>
                          </c:if>
                          <div class="border rounded popup-content">
                              <button
                                  class="btn-close float-end close"></button>
                              <h3>Add New Education</h3>
                              <form class="ignore popup-form" action="<c:url value='/candidate-profile'/>"
                                    method="post">
                                  <input type="hidden" name="form_name" value="education"/>
                                  <input type="hidden" name="action" value="profilePageAction"/>
                                  <div class="row d-flex justify-content-around">
                                      <div class="col-md-6"><label class="col-form-label">Institution</label>
                                      </div>
                                      <div class="col-md-6"><input class="form-control" type="text" name="institution"
                                                                   autofocus="" value="${requestScope.education.institution}"
                                                                   autocomplete="off">
                                      </div>
                                  </div>
                                  <div class="row d-flex">
                                      <div class="col-md-6 form-row"><label class="col-form-label">Education
                                              Level</label></div>
                                      <div class="col-md-6 form-row"><select class="form-select level-slc"
                                                                             name="education-lvl">
                                              <optgroup label="University">
                                                  <option value="diploma" selected="">Diploma</option>
                                                  <option value="bachelor">Bachelor</option>
                                                  <option value="master">Master</option>
                                                  <option value="phd">Ph.D</option>
                                              </optgroup>
                                              <optgroup label="Under Graduate">
                                                  <option value="">High School</option>
                                              </optgroup>
                                          </select>
                                      </div>
                                  </div>
                                  <div class="row d-flex justify-content-around">
                                      <div class="col-md-6"><label class="col-form-label">Subject</label></div>
                                      <div class="col-md-6"><input class="form-control" type="text" name="subject"
                                                                   autocomplete="off" value="${requestScope.education.subject}">
                                      </div>
                                  </div>
                                  <div class="row d-flex justify-content-around">
                                      <div class="col-md-6"><label class="col-form-label">Start Date</label></div>
                                      <div class="col-md-6"><input class="form-control" name="start-date" type="date"
                                                                   value="<fmt:formatDate value="${requestScope.education.startDate}" type="date" pattern="yyyy-MM-dd" />">
                                      </div>
                                  </div>
                                  <div class="row d-flex justify-content-around">
                                      <div class="col-md-6"><label class="col-form-label">End Date</label></div>
                                      <div class="col-md-6"><input class="form-control" name="end-date" type="date"
                                                                   value="<fmt:formatDate value="${requestScope.education.endDate}" type="date" pattern="yyyy-MM-dd" />">
                                      </div>
                                  </div>
                                  <div class="btn-group d-flex popup-btns" role="group">
                                      <button
                                          class="btn btn-secondary" type="reset">Reset
                                      </button>
                                      <button
                                          class="btn btn-success" name="submit" type="submit" value="add">Add
                                      </button>
                                  </div>
                              </form>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="row row-cols-2 row-cols-sm-1 head-row">
                  <div class="col-12 col-md-5 sections">
                      <div class="d-flex flex-row justify-content-between align-items-baseline">
                          <h4 class="display-6">Work History</h4>
                          <div class="popup work">
                              <!-- ERRORS SHOWN FOR THIS TAB HERE-->
                              <c:if
                                  test="${requestScope.fail == true && requestScope.currentTab.equals('add-workHistory-cta')}">
                                  <div class="alert alert-warning" role="alert">
                                      <c:forEach var="error" items="${requestScope.errList}">
                                          <div>&#9888; ${error}</div>
                                      </c:forEach>
                                  </div>
                              </c:if>

                              <div class="border rounded popup-content">
                                  <button
                                      class="btn-close float-end close"></button>
                                  <h3>Add New Work History</h3>
                                  <form class="ignore popup-form" action="<c:url value='/candidate-profile'/>"
                                        method="post">
                                      <input type="hidden" name="form_name" value="workHistory"/>
                                      <input type="hidden" name="action" value="profilePageAction"/>

                                      <div class="row d-flex justify-content-around">
                                          <div class="col-md-6">
                                              <label class="col-form-label">Company</label>
                                          </div>
                                          <div class="col-md-6">
                                              <input class="form-control" type="text" name="company" autofocus=""
                                                     value="${requestScope.workHistory.company}">
                                          </div>
                                      </div>
                                      <div class="row d-flex justify-content-around">
                                          <div class="col-md-6">
                                              <label class="col-form-label">Title</label>
                                          </div>
                                          <div class="col-md-6">
                                              <input class="form-control" type="text" name="title"
                                                     value="${requestScope.workHistory.title}">
                                          </div>
                                      </div>
                                      <div class="row d-flex justify-content-around">
                                          <div class="col-md-6">
                                              <label class="col-form-label">Start Date</label>
                                          </div>
                                          <div class="col-md-6">
                                              <input class="form-control" name="start-date" type="date"
                                                     value="<fmt:formatDate value="${requestScope.workHistory.startDate}" type="date" pattern="yyyy-MM-dd" />">
                                          </div>
                                      </div>
                                      <div class="row d-flex justify-content-around">
                                          <div class="col-md-6">
                                              <label class="col-form-label">End Date</label>
                                          </div>
                                          <div class="col-md-6">
                                              <input class="form-control" name="end-date"
                                                     type="date"
                                                     value="<fmt:formatDate value="${requestScope.workHistory.endDate}" type="date" pattern="yyyy-MM-dd" />">
                                          </div>
                                      </div>
                                      <div class="row d-flex justify-content-around">
                                          <div class="col-md-6">
                                              <label class="col-form-label">Reference</label>
                                          </div>
                                          <div class="col-md-6">
                                              <input class="form-control" type="email" name="reference"
                                                     value="${requestScope.workHistory.reference}">
                                          </div>
                                      </div>
                                      <div class="btn-group d-flex popup-btns" role="group">
                                          <button class="btn btn-secondary" type="reset">Reset</button>
                                          <button class="btn btn-success" type="submit" name="submit"
                                                  value="add">Add
                                          </button>
                                      </div>
                                  </form>
                              </div>
                          </div>
                          <button class="btn btn-outline-success open-work" data-bss-hover-animate="pulse"
                                  type="submit" value="addWork">
                              <i class="fas fa-plus-circle" data-bss-hover-animate="pulse"></i>
                          </button>
                      </div>
                      <hr>
                      <c:if test="${candidate.workHistoryList.size()== 0}">
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

                      <c:forEach var="workHistory" items="${candidate.workHistoryList}">
                          <form class="shadow-sm" data-aos="fade-up" action="<c:url value='/candidate-profile'/>"
                                method="POST">
                              <input type="hidden" name="form_name" value="workHistory"/>
                              <input type="hidden" name="id" value="${workHistory.workhistoryID}"/>
                              <input type="hidden" name="action" value="profilePageAction"/>
                              <div class="form-group mb-3">
                                  <div class="d-flex align-items-baseline">
                                      <h6>Company:&nbsp;</h6>
                                      <p>${workHistory.company}</p>
                                  </div>
                                  <div class="d-flex align-items-baseline">
                                      <h6>Title:&nbsp;</h6>
                                      <p>${workHistory.title}</p>
                                  </div>
                                  <div class="d-flex align-items-baseline">
                                      <h6>Start Date:&nbsp;</h6>
                                      <p>
                                          <fmt:formatDate value="${workHistory.startDate}" type="date"
                                                          pattern="yyyy-MM-dd"/>
                                      </p>
                                  </div>
                                  <div class="d-flex align-items-baseline">
                                      <h6>End Date:&nbsp;</h6>
                                      <p>
                                          <c:choose>
                                              <c:when test="${workHistory.endDate !=null}">
                                                  <fmt:formatDate value="${workHistory.endDate}" type="date"
                                                                  pattern="yyyy-MM-dd"/>
                                              </c:when>
                                              <c:otherwise>
                                                  current
                                              </c:otherwise>
                                          </c:choose>
                                      </p>
                                  </div>
                                  <div class="d-flex align-items-baseline">
                                      <h6>Reference:&nbsp;</h6>
                                      <p>${workHistory.reference}</p>
                                  </div>
                              </div>
                              <div class="d-flex d-sm-flex d-xl-flex justify-content-end modify-btns">
                                  <div class="btn-group" role="group">
                                      <button class="btn" data-bs-toggle="tooltip" data-bss-tooltip="" type="submit"
                                              title="Delete" value="delete" name="submit">
                                          <i class="far fa-window-close" data-bss-hover-animate="pulse"></i>
                                      </button>
                                  </div>
                              </div>
                          </form>
                      </c:forEach>
                  </div>

                  <div class="col-12 col-md-5 offset-md-2 sections">
                      <div class="d-flex flex-row justify-content-between align-items-baseline">
                          <h4 class="display-6">Skills</h4>
                          <div class="popup skill">
                              <!-- ERRORS SHOWN FOR THIS TAB HERE-->
                              <c:if
                                  test="${requestScope.fail == true && requestScope.currentTab.equals('add-skills-cta')}">
                                  <div class="alert alert-warning" role="alert">
                                      <c:forEach var="error" items="${requestScope.errList}">
                                          <div>&#9888; ${error}</div>
                                      </c:forEach>
                                  </div>
                              </c:if>
                              <div class="border rounded popup-content">
                                  <button class="btn-close float-end close"></button>
                                  <h3>Add New Skill</h3>
                                  <form class="ignore popup-form" action="<c:url value='/candidate-profile'/>"
                                        method="post">
                                      <input type="hidden" name="form_name" value="skills"/>
                                      <input type="hidden" name="action" value="profilePageAction"/>
                                      <div class="row d-flex justify-content-around align-items-center">
                                          <div class="col">
                                              <select class="form-select level-slc" name="id">
                                                  <c:forEach var="skill" items="${skills}">
                                                      <option value="${skill.skillID}"
                                                              <c:if
                                                                  test='${skills.get(0)==skill}'>selected=""
                                                              </c:if>
                                                              >${skill.description}
                                                      </option>
                                                  </c:forEach>
                                              </select>
                                          </div>
                                      </div>
                                      <div class="btn-group d-flex popup-btns" role="group">
                                          <button class="btn btn-secondary" type="reset">Reset</button>
                                          <button class="btn btn-success" name="submit" type="submit" value="add">Add</button>
                                      </div>
                                  </form>
                              </div>
                          </div>
                          <button class="btn btn-outline-success open-skill" data-bss-hover-animate="pulse"
                                  type="submit">
                              <i class="fas fa-plus-circle" data-bss-hover-animate="pulse" value="addSkill"></i>
                          </button>
                      </div>
                      <hr>
                      <c:if test="${candidate.candidateSkillList.size()== 0}">
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
                                  No skills added yet
                              </div>
                          </div>
                      </c:if>
                      <c:forEach var="candidateSkill" items="${candidate.candidateSkillList}">
                          <form class="shadow-sm d-flex justify-content-between align-items-baseline skill-form"
                                data-aos="fade-up" action="<c:url value='/candidate-profile'/>" method="POST">
                              <input type="hidden" name="form_name" value="skills"/>
                              <input type="hidden" name="id" value="${candidateSkill.canskillID}"/>
                              <input type="hidden" name="action" value="profilePageAction"/>
                              <div class="form-group mb-3">
                                  <p>${candidateSkill.skillID.description}</p>
                              </div>
                              <div
                                  class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                                  <div class="btn-group" role="group">
                                      <button class="btn" data-bs-toggle="tooltip" data-bss-tooltip="" type="submit"
                                              title="Delete" value="delete" name="submit">
                                          <i class="far fa-window-close" data-bss-hover-animate="pulse"></i>
                                      </button>
                                  </div>
                              </div>
                          </form>
                      </c:forEach>
                      <div class="row" id="roles">
                          <div class="col">
                              <div class="d-flex flex-row justify-content-between align-items-baseline">
                                  <h4 class="display-6">Roles</h4>
                                  <div class="popup role">
                                      <div class="border rounded popup-content"><button
                                              class="btn-close float-end close"></button>
                                          <h3>Add New Role</h3>
                                          <form class="ignore popup-form">
                                              <div class="row d-flex justify-content-around align-items-center">
                                                  <div class="col">
                                                      <select class="form-select level-slc" name="education-lvl">
                                                          <c:forEach var="role" items="${roles}">
                                                              <option value="${role.roleID}"
                                                                      <c:if
                                                                          test='${roles.get(0)==role}'>selected=""
                                                                      </c:if>
                                                                      >${role.description}
                                                              </option>
                                                          </c:forEach>
                                                      </select>
                                                  </div>
                                              </div>
                                              <div class="btn-group d-flex popup-btns" role="group">
                                                  <button class="btn btn-secondary" type="reset">Reset</button>
                                                  <button class="btn btn-success" type="submit">Add</button>
                                              </div>
                                          </form>
                                      </div>
                                  </div>
                                  <button class="btn btn-outline-success open-role" data-bss-hover-animate="pulse" type="submit">
                                      <i class="fas fa-plus-circle" data-bss-hover-animate="pulse" value="addRole"></i>
                                  </button>
                              </div>
                              <hr>
                              <c:if test="${candidate.candidateRoleList.size()== 0}">
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
                                          No Roles added yet
                                      </div>
                                  </div>
                              </c:if>
                              <c:forEach var="candidateRole" items="${candidate.candidateRoleList}">
                                  <form class="shadow-sm d-flex justify-content-between align-items-baseline skill-form"
                                        data-aos="fade-up" action="<c:url value='/candidate-profile'/>" method="POST">
                                      <input type="hidden" name="form_name" value="roles"/>
                                      <input type="hidden" name="id" value="${candidateRole.canroleID}"/>
                                      <input type="hidden" name="action" value="profilePageAction"/>
                                      <div class="form-group mb-3">
                                          <p>${candidateSkill.roleID.description}</p>
                                      </div>
                                      <div
                                          class="d-sm-flex d-xl-flex justify-content-sm-end justify-content-xl-end modify-btns">
                                          <div class="btn-group" role="group">
                                              <button class="btn" data-bs-toggle="tooltip" data-bss-tooltip="" type="submit"
                                                      title="Delete" value="delete" name="submit">
                                                  <i class="far fa-window-close" data-bss-hover-animate="pulse"></i>
                                              </button>
                                          </div>
                                      </div>
                                  </form>
                              </c:forEach>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          <%@include file="/WEB-INF/jspf/footer.jspf" %>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          <script
          src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/js/bootstrap.bundle.min.js"></script>
          <script src="assets/js/bs-init.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
          <script src="assets/js/popup.js"></script>
    </body>
</html>