
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
      <script src="/Research/kinetic-v5.1.0.min.js"></script>


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
<div>
  <a href="javascript:dtext=true;dline=false;circle = false;dtriangle=false">Text2</a>&nbsp;
  <a href="javascript:dtext=false;dline=true;circle = false;dtriangle=false">Line</a>&nbsp;
  <a href="javascript:dtext=false;dline=false;circle = false;dtriangle=true;triangerotate=0">Arrow UP </a>&nbsp;
  <a href="javascript:dtext=false;dline=false;circle = false;dtriangle=true;triangerotate=180">Arrow DOWN</a>&nbsp;&nbsp;
  <a href="javascript:dtext=false;dline=false;circle = true;dtriangle=false">Circle</a>&nbsp;&nbsp;
  <a href="javascript:dtext=false;dline=false;circle = false;dtriangle=false">* NO *</a>
<br>
<input type="text" id="title" placeholder="Your Title" /></br>
</div>
  <div id="container"></div>







        <script type="text/javascript">
        var dtext=false;
        var dline = false;
        var dtriangle=false;
        var circle = false;
        var layer;
        var stage;
        var moving = false;
        var line;
        var y1 = 0;
        var x1 = 0;
        var x2 = 0;
        var y2 = 0;
        var triangerotate = 0;
        var draggerOffset=40;
        var myGuageX;
        var myGuageY;
        var myGuageRadius=50;
        var timer;
        var background;

        $(function() {

        	stage = new Kinetic.Stage({
            container: 'container',
            width: 1500,
            height: 1000,
          });

         layer = new Kinetic.Layer();

          background = new Kinetic.Rect({
             x: 0,
             y: 0,
             width: stage.getWidth(),
             height: stage.getHeight()
         });


        var img = new Image();
        img.src ="${chart.image}";

        img.onload = function(){
        	   Image= new Kinetic.Image({ x: 0, y: 0, width: 1500, height: 1000,image: img});
        	   layer.add(Image);
        	   layer.draw();
         };

        layer.add(background);
        layer.draw();

        stage.add(layer);

        stage.on('dblclick', function(){ createline();})

        layer.on('mousedown', function () {

        	   var mousePos = stage.getPointerPosition();
               x1 = mousePos.x;
               y1 = mousePos.y;

			if(dtext){
			var message =   $('#title')[0].value;


		     var label = new Kinetic.Text({
	                x: x1,
	                y: y1,
	                text: message,
	                fontSize: 14,
	                fontFamily: 'Calibri',
	                draggable: true,
	                fill: 'blue'
	            });
	            layer.add(label);
	            layer.draw();
	            $('#title')[0].value='';
			}

			if(dtriangle){


				var triangle=new Kinetic.RegularPolygon({
					x:x1,
					y:y1,
					sides:3,
					radius:10,
					fill:'red',
					stroke:'black',
					strokeWidth:1
					});


	    triangle.setRotation(triangerotate);
	    layer.add(triangle);
	            layer.draw();


			}
      if(circle){
				myGuageX=x1;
			  myGuageY=y1;
			  addcircle();
			}


        });

        layer.off('mouseup');
        layer.on("mouseup", function () {


        });




        });



     function myFunction() {
		$('#image').val(layer.toDataURL('image/png')   );
     }

     function addcircle(){
     		var dragger=new Kinetic.Group({

     	    });
     	    layer.add(dragger);

     	    var dragLine=new Kinetic.Line({
     	        points: [myGuageX,myGuageY, myGuageX+draggerOffset+myGuageRadius,myGuageY],
     	        stroke: 'green',
     	        strokeWidth: 2,
     	        lineJoin: 'round',
     	        dashArray: [5,2]
     	    });
     	    dragger.add(dragLine);

     	    var dragCircle=new Kinetic.Circle({
     	        x: myGuageX+draggerOffset+myGuageRadius,
     	        y: myGuageY,
     	        radius: 7,
     	        fill: 'skyblue',
     	        stroke: 'lightgray',
     	        strokeWidth: 3,
     	        draggable:true,
     	        dragBoundFunc: function(pos) {
     	            return { x: pos.x, y: this.getAbsolutePosition().y }
     	        }
     	    });
     	    dragCircle.on("dragmove",function(){
     	        var x1=this.getX();
     	        var y1=this.getY();
     	        var x2=myGuage.getX();
     	        var y2=myGuage.getY();
     	        var dx=x1-x2;
     	        var dy=y1-y2;
     	        var r=Math.sqrt(dx*dx+dy*dy)-draggerOffset;
     	        r=Math.max(5,r);
     	        myGuage.resize(r);
     	        dragLine.setPoints([myGuageX,myGuageY, x1,y1]);
     	    });
     	    dragger.add(dragCircle);


     	    // this circle represents your guage
     	    var myGuage = new Kinetic.Circle({
     	        x: myGuageX,
     	        y: myGuageY,
     	        radius: 50,
     	        stroke: 'blue',
     	        draggable:true,
     	        strokeWidth: 3
     	    });
     	    myGuage.resize=function(scaleFactor){
     	        // Here is where you would scale your guage by scaleFactor
     	        // In this demo, I just resize this gold circle
     	        this.setRadius(scaleFactor);
     	    };
     	    layer.add(myGuage);

     	    layer.draw();
     	}


      function createline(){
        console.log('createline');
          var pos = stage.getPointerPosition(); var startx = pos.x -1; var starty = pos.y - 1;
          var points = [startx, starty, pos.x, pos.y ];
          if(dline){
            var p = new Kinetic.Circle({x: pos.x, y: pos.y, radius: 6, stroke: 'black', strokeWidth: 1, draggable: true});
            line = new Kinetic.Line({x: 0, y: 0, points: points, stroke: 'black', strokeWidth: 5});
            p.on('dragstart', function(){timer = setInterval(makeline, 100);  });
            p.on('dragend', function(){clearInterval(timer);  line.remove(); p.remove(); layer.draw(); var lines = new Kinetic.Line({x: 0, y: 0, points: line.points(), stroke: 'black', strokeWidth: 5, draggable: true});
            layer.add(lines);
            layer.draw();});

            line.on('click', function(){p.remove(); this.draggable(true); layer.draw();})
            line.on('dblclick', function(){this.remove(); layer.draw();})
            layer.add(p,line); layer.draw();
          }

          function makeline(){
           var p = stage.getPointerPosition();
           var points = [startx, starty, p.x, p.y];
           line.setPoints(points);
           layer.draw();
          };


         };


        </script>

      <form name=frmTest  action="SaveChart/saveChart" method="post"  onsubmit="myFunction()" >
          <input type="hidden" name="image" id="image">
            <input type="hidden" name="mode" value="${mode}">
              <input type="hidden" name="code" value="${code}">
                <input type="hidden" name="category" value="${category}">
  <s:textarea label="Notes" name="notes" cols="105" rows="15"/>


            <input type="submit" value="submit">
      </form>








</div>

<br>
  <br>
  <br>
    <br>
    <br>




      <br>




  </body>
</html>
