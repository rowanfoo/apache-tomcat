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
</head>

<body>
<%-- 
 This form is to search for researched charts.
 --%>
 <h3>Retrieve Saved Charts</h3>

<s:form action="SaveChart/getResearch">
     

  Code<input list="browsers" name="code">
  <datalist id="browsers">

		<s:iterator value="codes" >
		 <option value="<s:property value="key" />"> 
		</s:iterator>

  </datalist>
    <s:select  label="Category"
		headerKey="" headerValue="--- Select ---"
		list="categorylist"
		name="category" />
		
   <s:submit value="Submit" />
</s:form>
			<h3></b><font size="3">${code}</font></h3>
			<h3></b><font size="3">${category}</font></h3>

<div>
	



<s:if test="%{allnotesimages.isEmpty()}">
  <p> No images retreive for ${code} </p>
</s:if>



 <s:iterator var="parent" value="allnotesimages">
 <s:iterator value="#parent">
  
    <img alt="Embedded Image" src="<s:property escapeHtml="false" value="value" /> "></img>
   
		<p><s:property  value="key" /> </p>
     </s:iterator>

</s:iterator>
</div>

<div>
<s:if test="%{#chart != null}">
    <img alt="" height="1000" src="https://chart.finance.yahoo.com/z?s=${chart.pureCode}.AX&t=6m&q=l&l=on&z=l&p=m20,m40,m150,m400&a=vm&lang=en-AU&region=AU" width="1500" />
</s:if>
</div>
</body>

</html>
  