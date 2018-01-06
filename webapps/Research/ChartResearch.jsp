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

<s:form action="Research/getResearch">


  Code<input list="browsers" name="code">
  <datalist id="browsers">

		<s:iterator value="codes" >
		 <option value="<s:property value="key" />">
		</s:iterator>

  </datalist>

   <s:submit value="Submit" />
</s:form>
	<c:choose>
	    <c:when test="${wishlist}">
		<h3></h3></b><font size="3" color="#556b2f">${code}  --  WISHLIST</font></h3>
	    </c:when>
	    <c:otherwise>
			<h3></b><font size="3">${code}</font></h3>
      </c:otherwise>
	</c:choose>

<div>









 <s:iterator value="allnotesimages">


   <s:property escapeHtml="false" value="value" />
		<p><s:property  value="key" /> </p>
     </s:iterator>


</div>

  <p>${chart.minichartnotes}</p>

	<table class="auto-style1" style="width: 100%">
	<tr>
	<td> Date : <font size="3">: ${data.date }</font></td>
	</tr>


	<tr>
	<td> 400d : <font size="3">: <fmt:formatNumber type="number"   maxFractionDigits="3" value="${data.fourhundred }" />  </font></td>
	<td> 400d chg : <font size="3">: <fmt:formatNumber type="PERCENT"   minFractionDigits="1"   maxIntegerDigits="4" value="${data.fourhundredchg }" />  </font> </td>
	</tr>

	<tr>

	<c:choose>
	    <c:when test="${crossovertwohundred <0}">
        <td bgcolor="#FF0000">
           </c:when>
	    <c:otherwise>
         <td bgcolor="#00FF00">
          </c:otherwise>
	</c:choose>
	 Cross over 200/400 : <font size="3">: <fmt:formatNumber type="PERCENT"   maxIntegerDigits="3" value="${crossovertwohundred }" />  </font> </td>


	</tr>
	<tr>
	<td> 200d : <font size="3">: <fmt:formatNumber type="number"   maxFractionDigits="3" value="${data.twohundred }" />  </font>  </td>
	<td> 200d chg : <font size="3">: <fmt:formatNumber type="PERCENT"   minFractionDigits="1"   maxIntegerDigits="4" value="${data.twohundredchg }" />  </font>    </td>
	</tr>

	<tr>
	<td> 150d : <font size="3">: <fmt:formatNumber type="number"   maxFractionDigits="3" value="${data.onehundredfifty }" />  </font>   </td>
	<td> 150d chg : <font size="3">: <fmt:formatNumber type="PERCENT"   minFractionDigits="1"   maxIntegerDigits="4" value="${data.onehundredfiftychg }" />  </font>   </td>
	</tr>

	<tr>
	<td> 40d : <font size="3">: <fmt:formatNumber type="number"   maxFractionDigits="3" value="${data.fourty }" />  </font>  </td>
	<td> 40d chg : <font size="3">: <fmt:formatNumber type="PERCENT"   minFractionDigits="1"   maxIntegerDigits="4" value="${data.fourtychg }" />  </font>   </td>
	</tr>

	<tr>
	<c:choose>
	    <c:when test="${crossovertwohundred <0}">
        <td bgcolor="#FF0000">
           </c:when>
	    <c:otherwise>
         <td bgcolor="#00FF00">
          </c:otherwise>
	</c:choose>
	 Cross over 20/40 : <font size="3">: <fmt:formatNumber type="PERCENT"   maxIntegerDigits="3" value="${crossovertwenty }" />  </font> </td>

	</tr>


	<tr>
	<td> 20d : <font size="3">: <fmt:formatNumber type="number"   maxFractionDigits="3" value="${data.twenty }" />  </font></td>
	<td> 20d chg : <font size="3">: <fmt:formatNumber type="PERCENT"   minFractionDigits="1"   maxIntegerDigits="4" value="${data.twentychg }" />  </font></td>
	</tr>


	</table>
	<br></br>
	<s:iterator value="mynotes">
 		<p><font face="SANS SERIF" size="3">  <s:property /></font> </p>
    <br>
     </s:iterator>



<div>
<s:if test="%{#chart != null}">
    <img alt="" height="1000" src="https://chart.finance.yahoo.com/z?s=${chart.pureCode}.AX&t=6m&q=l&l=on&z=l&p=m20,m40,m150,m400&a=vm&lang=en-AU&region=AU" width="1500" />
</s:if>
</div>
</body>

</html>
