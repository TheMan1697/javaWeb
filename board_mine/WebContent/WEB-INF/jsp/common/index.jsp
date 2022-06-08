<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="../common/head.jsp" />
</head>
<body>
  <div class="header-inner-text" id="loading">
                <h1 class="header-inner-text1">Think &nbsp; & &nbsp; Fill</h1>
                <h1 class="header-inner-text2">  &nbsp;&nbsp; &nbsp; &nbsp;Beyond &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  Space</h1>
              </div>
               <div class="header-inner-image" id="header">
                <img src="https://cdn.pixabay.com/photo/2015/03/26/15/55/the-thinker-692959_960_720.jpg" class="header-img">
             </div>
  <jsp:include page="../common/nav.jsp" />
    <div class="home">
        <div class="main">
            </div>
            <div class="sudoku">
                <h2 class="sudoku-text">Play</h2>
                <iframe src="http://www.free-sudoku.com/sudoku-webmaster.php?mescandi1=0&fondspage=FFFFFF&lesliens=000&coubo1=1C1D3D&couli1=C0C0C2&coucp1=FFFFFF&counp1=000000&counn1=3F428A&couce1=FFFFFF&coune1=FF0000&coucr1=FFFFFF&hauteur111=750" width="500" height="562" frameborder="0"></iframe><noframes><a href='http://www.free-sudoku.com'>Sudoku</a></noframes>
            </div>
            <!-- <div class="minesweeper">
            <iframe src="http://iconcept.bg/games/minesweeper" width="100%" height= "500px" padding="0";
  margin="0 auto"
  box-sizing= "border-box"
  overflow="hidden"></iframe>
            </div> -->
        </div>
  <jsp:include page="../common/footer.jsp"/>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
   /*  var lastScrollTop = 0, delta = 15;

    $(window).scroll(function(){
        var scrollTop = $(this).scrollTop() 
        if(Math.abs(lastScrollTop - scrollTop) <= delta) 
        return; 

        if ((scrollTop > lastScrollTop) && (lastScrollTop>0)) {
            $(".header-inner-image").css("top","-700px");
        } else {
            $(".header-inner-image").css("top","0px");
        }
        lastScrollTop = scrollTop;
    }); */
    $(window).ready(function(){
        var max = 500;
        $(window).scroll(function(){
            var scrollPX = $(this).scrollTop();
            if( scrollPX  < max ) {
                $("#header").css({"opacity": (max-scrollPX)/max });
            }else{
                $("#header").css({"opacity": 0});
            }    
        });
    }); 
    $(document).ready(function () { 

        setTimeout(function() { 

 			$("#loading").fadeIn(1000); 

        }); 

   }); 


    window.onbeforeunload = function () { $('#loading').show(); }  
    $(window).load(function () {        
        $('#loading').fadeOut(900);
    });
    </script>
</body>
</html>