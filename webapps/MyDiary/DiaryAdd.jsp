


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>
</head>

<body style="height: 1028px" bgcolor="#708090">



<s:form action="addDiary">
 
  <s:textfield label="codes:" key="diary.codes" size="60"/>
  <s:textarea  label="code Notes:" name="diary.codeNotes" cols="50" rows="15"/>
   <s:textfield label="book No:" key="diary.bookNo"  size="10"/>
   <s:textarea label="book Notes:"  name="diary.bookNotes" cols="50" rows="10"/>
 
    <s:textfield label="prayer Minute:" key="diary.prayerMinute" size="10"/>
      <s:textfield label="Fitness minutes:" key="diary.fitnessMinute" size="10"/>
    <s:textarea label="Notes"  name="diary.notes" cols="50" rows="12"/>
     
   <s:submit value="Submit" />
 
</s:form>





<style type="text/css" style="display: none !important;">

textarea#styled {
 width: 600px;
 height: 120px;
 border: 3px solid #cccccc;
 padding: 5px;
 font-family: Tahoma, sans-serif;
 background-image: url(bg.gif);
 background-position: bottom right;
 background-repeat: no-repeat;
}

.fixed-size  {
  width: 200px;
}

</style>
</body>

</html>
