<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>code</title>
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
 This form is to search for image charts.
 --%>

<s:form action="setResearch">
     

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
		
   <s:submit value="Submit" />
</s:form>


<div>
	Code:<h3>${code}></h3>







</div>
<div>
</div>
</body>

</html>
  