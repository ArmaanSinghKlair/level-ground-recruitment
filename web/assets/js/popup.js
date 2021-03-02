$(".open-edu").on("click", function () {
  $(".edu").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".close").on("click", function () {
  $(".wrapper").removeClass("active");
  $(".edu").fadeOut();
  $(".work").fadeOut();
  $(".skill").fadeOut();
});

$(".open-work").on("click", function () {
  $(".work").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".open-skill").on("click", function () {
  $(".skill").fadeIn("slow");
  $(".wrapper").addClass("active");
});
