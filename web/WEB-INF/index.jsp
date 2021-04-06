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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:200,200i,300,300i,400,400i,600,600i,800,800i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/index.css">
    <link rel="stylesheet" href="assets/css/nav-bar.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/footer.css">
</head>

<body>
<div class="wrapper"></div>
<nav class="navbar navbar-light navbar-expand-lg navigation-clean-button">
    <div class="container-fluid"><a class="navbar-brand d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-center align-items-center justify-content-sm-center align-items-sm-center justify-content-md-center align-items-md-center justify-content-lg-center align-items-lg-center justify-content-xl-center align-items-xl-center" href="index.html"><img class="logo" src="assets/img/logo.png">
        <h4 class="brand-name">Level Ground Recruitment</h4>
    </a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="navbar-nav me-auto flex-md-shrink-0">
                <li class="nav-item"><a class="nav-link" data-bss-hover-animate="pulse" href="index.html">Job Postings</a></li>
                <li class="nav-item"><a class="nav-link open-work" data-bss-hover-animate="pulse" href="#">Contact Us</a>
                    <section class="testimonials-clean popup work"><button class="btn-close float-end close"></button>
                        <div class="container">
                            <div class="intro">
                                <h2 class="text-center">Contact Us</h2>
                            </div>
                            <form class="d-flex flex-column contact-from"><label class="form-label">Name<input class="form-control" type="text"></label><label class="form-label">Email<input class="form-control" type="email"></label><label class="form-label">Message<textarea class="form-control" rows="5" placeholder="Your Message..."></textarea></label>
                                <div class="btn-group" role="group"><button class="btn btn-secondary" type="button">Reset</button><button class="btn btn-success" type="button">Submit</button></div>
                            </form>
                        </div>
                    </section>
                </li>
                <li class="nav-item"><a class="nav-link open-edu" data-bss-hover-animate="pulse" href="#">About</a>
                    <section class="testimonials-clean popup edu"><button class="btn-close float-end close"></button>
                        <div class="container">
                            <div class="intro">
                                <h2 class="text-center">Testimonials </h2>
                                <p class="text-center">Our customers love us! Read what they have to say below. Aliquam sed justo ligula. Vestibulum nibh erat, pellentesque ut laoreet vitae.</p>
                            </div>
                            <div class="row people">
                                <div class="col-md-6 col-lg-4 item">
                                    <div class="box">
                                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
                                    </div>
                                    <div class="author"><img class="rounded-circle" src="https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=200&w=200&s=707b9c33066bf8808c934c8ab394dff6">
                                        <h5 class="name">Ben Johnson</h5>
                                        <p class="title">CEO of Company Inc.</p>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4 item">
                                    <div class="box">
                                        <p class="description">Praesent aliquam in tellus eu gravida. Aliquam varius finibus est, et interdum justo suscipit id.</p>
                                    </div>
                                    <div class="author"><img class="rounded-circle" src="https://uifaces.co/our-content/donated/KtCFjlD4.jpg">
                                        <h5 class="name">Carl Kent</h5>
                                        <p class="title">Founder of Style Co.</p>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4 item">
                                    <div class="box">
                                        <p class="description">Aliquam varius finibus est, et interdum justo suscipit. Vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p>
                                    </div>
                                    <div class="author"><img class="rounded-circle" src="https://uifaces.co/our-content/donated/N5PLzyan.jpg">
                                        <h5 class="name">Emily Clark</h5>
                                        <p class="title">Owner of Creative Ltd.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </li>
            </ul><span class="d-md-flex flex-md-shrink-0 justify-content-md-center align-items-md-center navbar-text actions"> <a data-bss-hover-animate="pulse" class="login" href="login.html">Log In</a><a class="btn btn-primary action-button" role="button" data-bss-hover-animate="pulse" href="login.html">Sign Up</a></span>
        </div>
    </div>
</nav>
<div class="container">
    <section data-aos="fade-up" class="article-clean">
        <div class="container">
            <div class="row shadow-sm">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro">
                        <h1 class="text-center">Our Mission</h1>
                        <p class="text-center"><span class="by">by</span> <em class="text-capitalize">Author Name</em> <span class="date">Jan 01, 2021 </span></p><img class="img-fluid" src="https://d3jh33bzyw1wep.cloudfront.net/s3/W1siZiIsIjIwMTkvMTAvMTgvMTMvMDQvNDYvMjM0L0pvaG4tYW5kLUplbm5pZmVyLXJlc3VtZXMtaGlyaW5nLWJpYXMtZXhwZXJpbWVudC5qcGciXV0">
                    </div>
                    <div class="text">
                        <p>Sed lobortis mi. Suspendisse vel placerat ligula. <span style="text-decoration: underline;">Vivamus</span> ac sem lac. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p>
                        <p>Praesent sed lobortis mi. Suspendisse vel placerat ligula. Vivamus ac lacus. <strong>Ut vehicula rhoncus</strong> elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit <em>pulvinar dict</em> vel in justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p>
                        <h2>Aliquam In Arcu </h2>
                        <p>Suspendisse vel placerat ligula. Vivamus ac sem lac. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p>
                        <figure class="figure d-block"><img class="figure-img" src="https://eslbrains.com/wp-content/uploads/2020/07/unconscious-bias-in-recruitment.png">
                            <figcaption class="figure-caption">Caption</figcaption>
                        </figure>
                        <p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae. Suspendisse vel placerat ligula. Vivamus ac sem lac. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section data-aos="fade-up" class="features-boxed">
        <div class="container">
            <div class="intro">
                <h2 class="text-center">Features </h2>
                <p class="text-center">Nunc luctus in metus eget fringilla. Aliquam sed justo ligula. Vestibulum nibh erat, pellentesque ut laoreet vitae.</p>
            </div>
            <div class="row justify-content-center features">
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-right" data-aos-delay="200">
                    <div class="box"><i class="fa fa-map-marker icon"></i>
                        <h3 class="name">Works everywhere</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-up" data-aos-delay="100">
                    <div class="box"><i class="fa fa-clock-o icon"></i>
                        <h3 class="name">Always available</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-left" data-aos-delay="300">
                    <div class="box"><i class="fa fa-list-alt icon"></i>
                        <h3 class="name">Customizable </h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-up-right" data-aos-delay="500">
                    <div class="box"><i class="fa fa-leaf icon"></i>
                        <h3 class="name">Organic </h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-up" data-aos-delay="400">
                    <div class="box"><i class="fa fa-plane icon"></i>
                        <h3 class="name">Fast </h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a class="learn-more" href="#">Learn more »</a>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item" data-aos="fade-up-left" data-aos-delay="600">
                    <div class="box"><i class="fa fa-phone icon"></i>
                        <h3 class="name">Mobile-first</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a class="learn-more" href="#">Learn more »</a>
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