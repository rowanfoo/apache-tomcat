<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
    
     
      google.charts.load('current', {'packages':['bar']});

      google.charts.setOnLoadCallback(drawChart);
      google.charts.setOnLoadCallback(drawChart2);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
        	 ['Year', 'npat', 'equity','debt'],
       <s:iterator value="companys"  var="companyx"> 	
         
          ['${companyx.id.year}',  ${companyx.npat}, ${companyx.equity},${companyx.debt}],
       
        </s:iterator>
        
          ]);
  
        
        var options = {
          title: 'Company Performance',
          subtitle: 'Equity, Debt  and Profit: 2014-2017',
          displayAnnotations: true

        };
  
        

var chart = new google.charts.Bar(document.getElementById('curve_chart'));
        chart.draw(data, google.charts.Bar.convertOptions(  options));

        
        
        
        
        
      }
        
            
            function drawChart2() {
                var data = google.visualization.arrayToDataTable([
                	 ['Year', 'ROE', 'ROA'],
               <s:iterator value="companys"  var="companyx"> 	
                 
                  ['${companyx.id.year}',  ${(companyx.npat/companyx.equity)*100}, ${(companyx.npat/(companyx.equity+companyx.debt)*100)}],
               
                </s:iterator>
                
                  ]);
          
                
                var options = {
                  title: 'ROE vs ROA',
                  subtitle: 'ROE, ROA and Profit: 2014-2017',
                  displayAnnotations: true

                };
            
            
            
            

    var chart = new google.charts.Bar(document.getElementById('curve_chart2'));
            chart.draw(data, google.charts.Bar.convertOptions(  options));

            
            
            
            
            
          }
        
        
        
    </script>
  </head>
  <body>
 
    <div id="curve_chart" style="width: 900px; height: 500px"></div>
    <div id="curve_chart2" style="width: 900px; height: 500px"></div>

  </body>
</html>