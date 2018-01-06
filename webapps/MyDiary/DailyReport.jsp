<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="height: 1028px" bgcolor="#708090">
<h1> Daily REPORT  </h1>
<p>total code seen :<s:property value="report.percentCodecomplete" />% </p>
<p>>today code target:<s:property value="report.percenttcodetoday" />% </p>
<br>
<hr width="20%" size="8" align="left">

<p>total prayer :<s:property value="report.percentprayercomplete" />% </p>
<p>>today prayer target:<s:property value="report.percenttprayertoday" />% </p>
<br>
<hr width="20%" size="8" align="left">

<p>total fitness complete :<s:property value="report.percentfitnesscomplete" />% </p>
<p>>today prayer target:<s:property value="report.percentfitnesstoday" />% </p>
<br>

<hr width="20%" size="8" align="left">
<p>total book complete :<s:property value="report.percentBookcomplete" />% </p>
<br>


 <style type="text/css" style="display: none !important;">

* {
 font-size: 6;
 font-family: verdana;
}
 }
 </style>




</body>
</html>