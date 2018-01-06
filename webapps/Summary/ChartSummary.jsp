<%@ page import="java.util.ArrayList" %>
<%@ page import="util.ChartImage" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>code</title>
</head>

<body>


<s:iterator value="list">

  <s:property />
<div>
    <img alt="" height="500" src="https://chart.finance.yahoo.com/z?s=<s:property />&t=8m&q=l&l=on&z=l&p=m20,m40,m150&a=vm&lang=en-AU&region=AU" width="1000" />
</div>


</s:iterator>









</body>

</html>
