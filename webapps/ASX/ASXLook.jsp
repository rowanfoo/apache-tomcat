<!--Page Preamble-->
<!--Master A Preamble-->

<%@ page import="java.text.DecimalFormat" %>
<%@ page import="access.NewsAccess" %>
<%@ page import="java.util.ArrayList" %>


<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<meta name="generator" content="Serif WebPlus X8 (16,0,1,21)">


		<!--Page Head-->
		<!--Master A Head-->
		<link rel="stylesheet" type="text/css" href="wpscripts/wpstyles.css">
		<style type="text/css">
			/*Page StyleSheet*/
			/*Master A StyleSheet*/
			.OBJ-1 { border:1px solid #000000;border-radius:0; }
		</style>
	</head>
	<body __AddCode="PageInBodyTag" __AddCode="Master A In Body Tag" style="height:2000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/">
		<!--Page Body Start-->
		<!--Master A Body Start-->


<br>
<a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ asx.code }&x=64&y=14&time=8&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=50&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=9"  target="_blank" >  <font size="5">daily</font> </a>&nbsp

<a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ asx.code }&x=50&y=19&time=12&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=3&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=10&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11 "  target="_blank" > <font size="5">monthly</font> </a>
<font size="5"><i>${ asx.code }</i> </font>
		<div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:60%;/*Spread DIV Style*//*Master A DIV Style*/">
			<!--Page Start-->
			<!--Master A Start-->






			<!-- Document Frame ifrm_1 -->

			<!--Preamble for Document Frame ifrm_1-->
			<iframe id="ifrm_1" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ asx.code }&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&x=54&y=17&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11" class="OBJ-1" __AddCode="here"  scrolling="no" style=width:100%;height:100%;/*Add Style*/" ></iframe>
				<!--Postamble for Document Frame ifrm_1-->




			<!--Master A End-->
			<!--Page End-->
		</div>
		<!--Master A Body End-->
		<!--Page Body End-->
<br>
<br>
<br>



<s:form action="updateLookASX">
     	<s:textarea label="Notes" name="notes" cols="200" rows="8"/>
     <br>
     <br>
      <s:hidden name="index" value="%{index}" />
   <s:submit value="Submit" />
   <s:submit value="next" action="lookNext"/>
  
</s:form>






<br>


	

	</body>
</html>
<!--Master A Postamble-->
<!--Page Postamble-->
