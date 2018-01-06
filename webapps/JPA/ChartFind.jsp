<%@ page import="java.util.ArrayList" %>
<%@ page import="util.ChartImage" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />

  <style type="text/css">
p {
    font: normal 11px Verdana, Arial, sans-serif;

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
  .auto-style1 {
	margin-top: 253px;
}


    </style>
    
        <title>jQuery UI Datepicker - Default functionality</title>
      <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
      <link rel="stylesheet" href="/resources/demos/style.css">
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
      <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
      $( function() {
      	$( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
      } );
      </script>
    
    
</head>

<body>
<%--
 This form is to search for researched charts.
 --%>

<s:form action="findTrades">


  Code<input list="browsers" name="code">
  <datalist id="browsers">

		<s:iterator value="stocks" >
		 <option value="<s:property value="code" />">
		</s:iterator>

  </datalist>
	<p>Date: <input type="text" id="datepicker" name="date"></p>
	  <s:select  label="Category"
		headerKey="-1" headerValue="--- Select ---"
		list="#{'Buy':'Buy', 'Sell':'Sell'}"
		name="type" />

	<s:checkbox name="week" fieldValue="true" label="Get this week all"/>
		
   <s:submit value="Submit" />
</s:form>

<div>









 <s:iterator value="allImage">
         <img alt="Embedded Image" src="<s:property escapeHtml="false" />"></img>
 </s:iterator>


</div>

 <s:iterator value="trades">
 <p>  <s:property value="id.date" /></p>
 <p>  <s:property value="notes" /></p>
  <p>  --------------------   </p>
 </s:iterator>


</body>

</html>
