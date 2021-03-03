$(".open-edu").on("click", function () {
  $(".edu").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".close").on("click", function () {
  $(".wrapper").removeClass("active");
    $(".wrapper").removeClass("active-popup");
  $(".edu").fadeOut();
  $(".work").fadeOut();
  $(".skill").fadeOut();
    $(".remove-acc-alert").fadeOut();
});

$(".open-work").on("click", function () {
  $(".work").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".open-skill").on("click", function () {
  $(".skill").fadeIn("slow");
  $(".wrapper").addClass("active");
});

$(".open-remove").on("click", function () {
  $(".remove-acc-alert").fadeIn("slow");
  $(".wrapper").addClass("active-popup");
});
