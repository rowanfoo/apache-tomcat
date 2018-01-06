<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weekly Mode</title>
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
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
    $(function(){
    	  $( "#datepicker" ).datepicker({
    	    showWeek: true,
    	    firstDay: 1,
    	    maxDate: 'today',
    	    onSelect: function(dateText, inst){
    	      dateFormat: "'Week Number '" + $.datepicker.iso8601Week(new Date(dateText)),
    	        $(this).val($.datepicker.iso8601Week(new Date(dateText)));
    	    }   
    	  });
    	});    
    
    
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
<s:set var="prefix">au%3A </s:set>
<s:set var="postfix">&x=57&y=18&time=8&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=50&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11   </s:set>
<!-- <s:set var="src" value="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb="/> -->
<s:set var="src"> http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=</s:set>


<body style="height: 1028px" bgcolor="#E6E6E6">
    <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:100;">

  <p class="Body"><span class="C-1">Weekly mode listing</span></p>


<s:form action="getWeek">
 

     	<p>Date: <input type="text" id="datepicker" name=weekNo  >
     <br>
     <br>
      
   <s:submit value="Submit" />
 
</s:form>


  
</div>
  <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:10;">

<table class="auto-style1" style="width: 100%">
<tr>
  <th>Week number : <s:property value="weekNo" /></th>
</tr>

<s:iterator value="modeList">
 
  <!--
    <s:if test="%{wishlist[code] !=null } ">
      <tr bgcolor=\"#FF0000\" >
    </s:if>
    <s:else>
     "1111111111"
    </s:else>
    -->
 <c:if test="${empty wishlist[code]}">
<tr>
</c:if>
<c:if test="${not empty wishlist[code]}">
   <tr bgcolor=\"#FF0000\" >
</c:if>
  
    
      
  
   	  <td>  <a href="<s:property value="src" /><s:property value="prefix" /><s:property value="pureCode" /><s:property value="postfix" /> " target="_blank" ><font size="3"><s:property value="code" /> </font> </a></td>

      <td ><s:property value="name" /></td>
      <td ><s:property value="mode" /></td>
      <td ><s:property value="modeUsefullNumber" /></td>
      
   
   </tr>
  
  
  
  
  
</s:iterator>

</table>

  </div>





 <style type="text/css" style="display: none !important;">

* {
 font-size: 6;
 font-family: verdana;
}
 }
 </style>




</body>
</html>