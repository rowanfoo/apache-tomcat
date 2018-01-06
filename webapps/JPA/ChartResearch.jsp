<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

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


<div>









 <s:iterator value="allImage">
		<s:property escapeHtml="false" /> 
     </s:iterator>


<s:form action="setChartImage">
<s:hidden name="image" value="" />
 <input type="hidden" name="type" value="${type}">
 <input type="hidden" name="code" value="${code}">
 <s:submit key="submit" />
</s:form>

<script>
function myFunction(img) {
  alert("hi");
       document.getElementsByName("image")[0].setAttribute("value", img);
       alert("hi2");
       
       document.getElementById("setChartImage").submit();
       
       alert("hi4");
     
     };

</script>
</div>

</body>

</html>
