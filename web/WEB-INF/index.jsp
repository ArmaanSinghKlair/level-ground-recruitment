<%-- 
    Document   : index
    Created on : Feb 15, 2021, 10:58:15 AM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Level Ground Recruitment</title>
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
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="assets/css/index.css">
</head>

<body>
<%--Wrapper div--%>
<div class="wrapper"></div>
<%--Navigation bar--%>
<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
<%--Alter section--%>
<%@include file="/WEB-INF/jspf/alert.jspf" %>
<div class="container">
    <section data-aos="fade-up" class="article-clean">
        <div class="container">
            <div class="row shadow-sm">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro">
                        <h1 class="text-center">Our Mission</h1>
                        <p class="text-center">
                            <span class="by">by </span><em class="text-capitalize">Author Name</em>
                            <span class="date">Jan 01, 2021 </span>
                        </p>
                        <img class="img-fluid"
                             src="https://d3jh33bzyw1wep.cloudfront.net/s3/W1siZiIsIjIwMTkvMTAvMTgvMTMvMDQvNDYvMjM0L0pvaG4tYW5kLUplbm5pZmVyLXJlc3VtZXMtaGlyaW5nLWJpYXMtZXhwZXJpbWVudC5qcGciXV0"
                             alt="abc"/>
                    </div>
                    <div class="text">
                        <p>
                            Sed lobortis mi. Suspendisse vel placerat ligula. <span style="text-decoration: underline;">Vivamus</span>
                            ac sem lac. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget
                            velit pulvinar dictum vel in justo. Vestibulum ante ipsum primis in faucibus orci luctus et
                            ultrices posuere cubilia Curae.
                        </p>
                        <p>
                            Praesent sed lobortis mi. Suspendisse vel placerat ligula. Vivamus ac lacus. <strong>Ut
                            vehicula rhoncus</strong> elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit
                            <em>pulvinar dict</em> vel in justo. Vestibulum ante ipsum primis in faucibus orci luctus et
                            ultrices posuere cubilia Curae.
                        </p>
                        <h2>Aliquam In Arcu </h2>
                        <p>
                            Suspendisse vel placerat ligula. Vivamus ac sem lac. Ut vehicula rhoncus elementum. Etiam
                            quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo. Vestibulum
                            ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.
                        </p>
                        <figure class="figure d-block">
                            <img class="figure-img"
                                 src="https://eslbrains.com/wp-content/uploads/2020/07/unconscious-bias-in-recruitment.png"
                                 alt="second article picture">
                            <figcaption class="figure-caption">Caption</figcaption>
                        </figure>
                        <p>
                            Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.
                            Suspendisse vel placerat ligula. Vivamus ac sem lac. Ut vehicula rhoncus elementum. Etiam
                            quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section data-aos="fade-up" class="features-boxed">
        <div class="container">
            <div class="intro">
                <h2 class="text-center">Features </h2>
                <p class="text-center">
                    Nunc luctus in metus eget fringilla. Aliquam sed justo ligula. Vestibulum nibh
                    erat, pellentesque ut laoreet vitae.
                </p>
            </div>
            <div class="row justify-content-center features">
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-right" data-aos-delay="200">
                    <div class="box">
                        <i class="fa fa-map-marker icon"></i>
                        <h3 class="name">Works everywhere</h3>
                        <p class="description">
                            Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu.
                        </p>
                        <a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-up" data-aos-delay="100">
                    <div class="box">
                        <i class="fa fa-clock-o icon"></i>
                        <h3 class="name">Always available</h3>
                        <p class="description">
                            Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu.
                        </p>
                        <a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-left" data-aos-delay="300">
                    <div class="box"><i class="fa fa-list-alt icon"></i>
                        <h3 class="name">Customizable </h3>
                        <p class="description">
                            Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu.
                        </p>
                        <a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-up-right" data-aos-delay="500">
                    <div class="box">
                        <i class="fa fa-leaf icon"></i>
                        <h3 class="name">Organic </h3>
                        <p class="description">
                            Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu.
                        </p>
                        <a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-up" data-aos-delay="400">
                    <div class="box">
                        <i class="fa fa-plane icon"></i>
                        <h3 class="name">Fast </h3>
                        <p class="description">
                            Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu.
                        </p>
                        <a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-up-left" data-aos-delay="600">
                    <div class="box">
                        <i class="fa fa-phone icon"></i>
                        <h3 class="name">Mobile-first</h3>
                        <p class="description">
                            Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus.
                            Praesent aliquam in tellus eu.
                        </p>
                        <a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
            </div>
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </section>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
<script src="assets/js/popup.js"></script>
</body>

</html>