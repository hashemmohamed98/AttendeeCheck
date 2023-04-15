

    // code to read selected table row cell data (values).
    function showEmployeeDetails(x){
        
        var name=$("#empname");
        var username =$("#empusername");
        var StartDate=$("#empstartdate");
        var empid=$("#empid");
         var col1=$("#nm"+x).text(); // get current row 1st TD value
         var col2=$("#un"+x).text();// get current row 2nd TD
         var col3=$("#sd"+x).text(); // get current row 3rd TD
         name.val(col1);
         username.val(col2);
         StartDate.val(col3);
         empid.val(x);
    }
//        $("#dataTable").on('click','#edit'+,function(){
//         // get the current row
//         var currentRow=$(this).closest("tr"); 
//         
//         var col1=currentRow.find("td:eq(0)").text(); // get current row 1st TD value
//         var col2=currentRow.find("td:eq(1)").text(); // get current row 2nd TD
//         var col3=currentRow.find("td:eq(2)").text(); // get current row 3rd TD
//         var col4 = currentRow.find("td:eq(3)").val();
//         var data=col1+"\n"+col2+"\n"+col3+"\n"+col4;
//        
//         alert(data);
//
//    });

//
//
////$(document).ready(function(){
//    $("#dataTable tr").click(function(){
//        $(this).find("td").each(function(){
//            alert($(this).html());
//        });
//    });
//});
//
//
//
//
//
//
//
//
//
////(function($) {
//  "use strict"; // Start of use strict
//
//  // Toggle the side navigation
//  $("#sidebarToggle, #sidebarToggleTop").on('click', function(e) {
//    $("body").toggleClass("sidebar-toggled");
//    $(".sidebar").toggleClass("toggled");
//    if ($(".sidebar").hasClass("toggled")) {
//      $('.sidebar .collapse').collapse('hide');
//    };
//  });
//
//  // Close any open menu accordions when window is resized below 768px
//  $(window).resize(function() {
//    if ($(window).width() < 768) {
//      $('.sidebar .collapse').collapse('hide');
//    };
//    
//    // Toggle the side navigation when window is resized below 480px
//    if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
//      $("body").addClass("sidebar-toggled");
//      $(".sidebar").addClass("toggled");
//      $('.sidebar .collapse').collapse('hide');
//    };
//  });
//
//  // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
//  $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
//    if ($(window).width() > 768) {
//      var e0 = e.originalEvent,
//        delta = e0.wheelDelta || -e0.detail;
//      this.scrollTop += (delta < 0 ? 1 : -1) * 30;
//      e.preventDefault();
//    }
//  });
//
//  // Scroll to top button appear
//  $(document).on('scroll', function() {
//    var scrollDistance = $(this).scrollTop();
//    if (scrollDistance > 100) {
//      $('.scroll-to-top').fadeIn();
//    } else {
//      $('.scroll-to-top').fadeOut();
//    }
//  });
//
//  // Smooth scrolling using jQuery easing
//  $(document).on('click', 'a.scroll-to-top', function(e) {
//    var $anchor = $(this);
//    $('html, body').stop().animate({
//      scrollTop: ($($anchor.attr('href')).offset().top)
//    }, 1000, 'easeInOutExpo');
//    e.preventDefault();
//  });
//
//})(jQuery); // End of use strict
