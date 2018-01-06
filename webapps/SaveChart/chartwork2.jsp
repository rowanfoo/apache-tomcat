
<%@ page import="access.TechStrAccess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="access.StockAccess" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Home</title>
    <meta name="generator" content="Serif WebPlus X8 (16,0,1,21)">
    <meta name="viewport" content="width=960">


      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>jQuery UI Datepicker - Default functionality</title>
      <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
      <link rel="stylesheet" href="/resources/demos/style.css">
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
      <script src="/Research/sketch.js"></script>

      <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      <script>
      $( function() {
      	$( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
      } );
      </script>



    <link rel="stylesheet" type="text/css" href="wpscripts/wpstyles.css">
    <style type="text/css">
      .OBJ-1 { border:1px solid #000000;border-radius:2px / 2px;background-color:#ffffff;background:#ffffff; }
      .C-1 { line-height:18.00px;font-family:"Verdana", sans-serif;font-style:normal;font-weight:normal;color:#000000;background-color:transparent;text-decoration:none;font-variant:normal;font-size:16.0px;vertical-align:0; }
    .auto-style1 {
	margin-top: 253px;
}


th, td {
    padding: 15px;
    text-align: left;
}
th, td {
    border-bottom: 1px solid #ddd;
}
tr:nth-child(even) {background-color: #f2f2f2}
TD{font-family: Consolas;}
    </style>
  </head>


<body style="height: 1028px" bgcolor="#E6E6E6">


    <div id="divMain" style="background:transparent;margin-left:auto;margin-left;position:relative;width:100%;height:100%">


        <p class="Body"><span class="C-1">Welcome Rowan Save Charts system </span></p>
 <p class="Body"><span class="C-1">code:${code }  || category :${category } </span></p>

        <div class="tools">
          <a href="#tools_sketch" data-tool="marker">Marker</a>
          <a href="#tools_sketch" data-tool="eraser">Eraser</a>
          <a href='#tools_sketch' data-size="3" style='background: #ccc'>size3</a> ;
          <a href='#tools_sketch' data-size="10" style='background: #ccc'>size10</a> ;
          <a href='#tools_sketch' data-color="#0f0" style='width: 10px; background: "#0f0";'>Green</a>;
    	  <a href='#tools_sketch' data-color="#ff0" style='width: 10px; background: "#ff0";'>Yellow</a>;
      	  <a href='#tools_sketch' data-color="#f0f" style='width: 10px; background: "#f0f";'>Purple</a>;
     	  <a href='#tools_sketch' data-color="#00f" style='width: 10px; background: "#00f";'>Blue</a>;
      	  <a href='#tools_sketch' data-color="#f00" style='width: 10px; background: "#f00";'>Red</a>;
          <a id='ctr' href='#' onclick='dontDraw();'> XX Line </a>
          <a id='ctr' href='#' onclick='DrawLine();'> YY Line </a>


        </div>

 <canvas id="tools_sketch" width="1500" height="815" style="background:no-repeat center;"></canvas>


        <script type="text/javascript">

        var startPosArr=[];
         var finalPosArr=[];
         var drawLine = false;
        var dontDrawLine = true;

        function dontDraw(){
            dontDrawLine=false;
          
        }
        function DrawLine(){
            dontDrawLine=true;
        }




      var img = new Image();
          $(function() {
              var canvasOffset = $('#tools_sketch').offset();
              var finalPos = {x:0, y:0};
              var startPos = {x:0, y:0};
            $('#tools_sketch').sketch({defaultColor: "#ff0"});
            var canvas = document.getElementById('tools_sketch');
            var context = canvas.getContext('2d');
            context.strokeStyle = '#ff0000';
      //      context.stroke();



            img.src ="${chart.image}";

          var bgi = "url(" + img.src + ")";
          $("#tools_sketch").css("background-image", bgi);



        function line(cnvs) {
            alert('draw line');
            if(dontDrawLine == true){
                var s =  $('#tools_sketch').sketch();
            // thid is to clear previous hand draws
                s.actions = [];

              cnvs.clearRect(0,0,canvas.width,canvas.height);
              for (i = 0; i < startPosArr.length; i++) {
            //  cnvs.beginPath();
              //    cnvs.moveTo(startPosArr[i].x, startPosArr[i].y);
                //  cnvs.lineTo(finalPosArr[i].x, finalPosArr[i].y);
                //  cnvs.stroke();

                  var action = {

                          events: [{event: 'mousedown', x: startPosArr[i].x, y:  startPosArr[i].y}, {event: 'mouseup', x: finalPosArr[i].x, y:finalPosArr[i].y}],
                          size: 5,
                          tool: "marker"
                      };
                       s.actions.push(action);
                       s.redraw();

              }

          }



        }
        $('#tools_sketch').mousemove(function(e) {
            //  alert('mouse move ' );
              if (drawLine === true) {
                  finalPos = {x: e.pageX - canvasOffset.left, y:e.pageY - canvasOffset.top};


                //  line(context);

              }
          });

          $('#tools_sketch').mousedown(function(e) {
          //  alert(e.pageX  +'xx '+ e.pageY );
        //    alert((e.pageX - canvasOffset.left)  +'xx '+ (e.pageY - canvasOffset.top ));

              drawLine = true;
          //    context.strokeStyle = 'blue';
        //      context.lineWidth = 5;
        //      context.lineCap = 'round';
        //      context.beginPath();
              startPos = { x: e.pageX - canvasOffset.left, y: e.pageY - canvasOffset.top};
          });

          $('#tools_sketch').mouseup(function() {
             startPosArr.push(  {x:startPos.x, y:startPos.y}    );
             finalPosArr.push( {x:finalPos.x, y:finalPos.y}  );
              // Replace with var that is second canvas
              line(context);
              finalPos = {x:0, y:0};
              startPos = {x:0, y:0};
              drawLine = false;
          });
      });

function myFunction() {
  alert("hi");
    var canvas = $('#combined')[0]
    var ctx = canvas.getContext('2d')

    ctx.drawImage(img, canvas.width / 2 - img.width / 2,
           canvas.height / 2 - img.height / 2
       )
       ctx.drawImage($('#tools_sketch')[0],0,0)
       var imageData = canvas.toDataURL('image/png');

       document.getElementsByName("image")[0].setAttribute("value", imageData);

     };






        </script>

      <form name=frmTest  action="SaveChart/saveChart" method="post"  onsubmit="myFunction()" >
          <input type="hidden" name="image">
          <input type="hidden" name="mode" value="${mode}">
            <input type="hidden" name="code" value="${code}">
              <input type="hidden" name="category" value="${category}">
          <s:textarea label="Notes" name="notes" cols="105" rows="15"/>
    <input type="submit" value="submit">
      </form>
<canvas id="combined"  width="1500" height="815" style="background:no-repeat center;"></canvas>

</div>

<br>
  <br>
  <br>
    <br>
    <br>




      <br>




  </body>
</html>
