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
<title>Chart Research</title>

 <style type="text/css">

    </style>
</head>

<body>
<%-- 
 This form is to search for image charts.
 --%>
       <script type="text/javascript">





function myFunction() {

 
     };
        </script>
<s:form action="Research/setResearch"  onsubmit="myFunction()" >
     

  Code<input list="browsers" name="code">
  <datalist id="browsers">

		<s:iterator value="codes" >
		 <option value="<s:property value="key" />"> 
		</s:iterator>

  </datalist>
  
   <s:submit value="Submit" />
</s:form>


<div>
	Code:<h3>${code}></h3>





 <s:iterator value="images">
  <s:property escapeHtml="false" />
 </s:iterator>



<br>
<c:if test="${not empty chart}">
<a href="/Research/minichart?code=${chart.pureCode}"?><font face="verdana" color="green" size="5" ><i>small charts</i> </font> </a>
</c:if>
</div>
<div>
<c:if test="${not empty chart}">
  <img alt="" height="1000" src="https://chart.finance.yahoo.com/z?s=${chart.pureCode}.AX&t=2y&q=l&l=on&z=l&p=m20,m40,m100,m200&a=vm&lang=en-AU&region=AU" width="1500" />
</c:if>
    
</div>


</body>

</html>
  