<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>REPORT 1 </h1>
<h1>total code seen :<s:property value="report.percenttcodeWeekly" />% </h1>
<br>


<h1>total prayer :<s:property value="report.percenttprayerWeekly" />% </h1>
<br>


<h1>total fitness complete :<s:property value="report.percentfitnessWeekly" />% </h1>
<br>


</body>
</html>