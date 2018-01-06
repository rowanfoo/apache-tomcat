<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
        <%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome <i>${sessionScope.userName}</i>, you have logged in successfully!</h3>
<h4>${index}</h4>
<s:form action="testSession">
     	
     <br>
     <br>
      <s:hidden name="index" value="%{index}" />
   <s:submit value="Submit" />
 
</s:form>



</body>
</html>