
$(".close").on("click", function () {
  $(".wrapper").removeClass("active");
  $(".wrapper").removeClass("active-popup");
  $(".edu").fadeOut();
  $(".contact").fadeOut();
  $(".about").fadeOut();
  $(".work").fadeOut();
  $(".skill").fadeOut();
  $(".remove-acc-alert").fadeOut();
});

$(".open-edu").on("click", function () {
  $(".edu").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".open-work").on("click", function () {
  $(".work").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".open-skill").on("click", function () {
  $(".skill").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".open-contact").on("click", function () {
  $(".contact").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".open-about").on("click", function () {
  $(".about").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".open-remove").on("click", function () {
  $(".remove-acc-alert").fadeIn("slow");
  $(".wrapper").addClass("active-popup");
});
