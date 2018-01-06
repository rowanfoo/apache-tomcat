<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">



<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  

<title>Company Details</title>

<style type="text/css">
.form-style-9{

    background: #FAFAFA;
    padding: 30px;
    margin: 50px auto;
    box-shadow: 1px 1px 25px rgba(0, 0, 0, 0.35);
    border-radius: 10px;
    border: 6px solid #305A72;
}
.form-style-9 ul{
    padding:0;
    margin:0;
    list-style:none;
}
.form-style-9 ul li{
    display: block;
    margin-bottom: 20px;
    min-height: 35px;
}
.form-style-9 ul li  .field-style{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    padding: 10px;
    outline: none;

    border: 1px solid #B0CFE0;
    -webkit-transition: all 0.30s ease-in-out;
    -moz-transition: all 0.30s ease-in-out;
    -ms-transition: all 0.30s ease-in-out;
    -o-transition: all 0.30s ease-in-out;

}.form-style-9 ul li  .field-style:focus{
    box-shadow: 0 0 5px #B0CFE0;
    border:1px solid #B0CFE0;
}
.form-style-9 ul li .field-split{
    width: 49%;
}
.form-style-9 ul li .field-full{
    width: 100%;
}
.form-style-9 ul li input.align-left{
    float:left;
}
.form-style-9 ul li input.align-right{
    float:right;
}
.form-style-9 ul li textarea{
    width: 800px;
    height: 400px;

}
.form-style-9 ul li input[type="button"],
.form-style-9 ul li input[type="submit"] {
    -moz-box-shadow: inset 0px 1px 0px 0px #3985B1;
    -webkit-box-shadow: inset 0px 1px 0px 0px #3985B1;
    box-shadow: inset 0px 1px 0px 0px #3985B1;
    background-color: #216288;
    border: 1px solid #17445E;
    display: inline-block;
    cursor: pointer;
    color: #FFFFFF;
    padding: 8px 18px;
    text-decoration: none;
    font: 12px Arial, Helvetica, sans-serif;
}
.form-style-9 ul li input[type="button"]:hover,
.form-style-9 ul li input[type="submit"]:hover {
    background: linear-gradient(to bottom, #2D77A2 5%, #337DA8 100%);
    background-color: #28739E;
}
</style>

<script >
$(document).ready(function() { 

	
	  $("#year1").prop('selectedIndex', 1);  
	});

</script>

</head>

<body>




<s:form action="save" cssClass="form-style-9" theme="simple" id="myform">

<script>
$('#myform').submit(function() {
	var s =$('#code').val();
	$('#pk1').val(s);

});


</script>


<input type="hidden" name="companypk1.code" id="pk1">
<ul>
<li>

    Code<input list="browsers" name="companypk.code" id="code">
<datalist id="browsers">

	<s:iterator value="codes"  var="stock">
	 <option value="${stock.code}" >
	</s:iterator>



</li>
<li>





		<s:select label="years" name="companypk.year" list="year"  class="field-style field-split align-left"  id="year"/>
		<s:select label="years" name="companypk1.year" list="year"  class="field-style field-split align-right" id="year1" />	

 
		
	
		
		
		<script>
		$('#year').change(function() {
		    var idx = this.selectedIndex;     
		    var t = idx+1;     
		    $("#year1").prop('selectedIndex', t);  
		    
			alert("here");
		
	
			var z =     $("#year1").val();  
		
			
			
			$("form input[name*=company1]").each(function () { 
				  var s = $(this).attr("placeholder");
				  var ans = z+' '+ s;
				  $(this).attr("placeholder",ans);
					
				});
			
			
			
			

		});
		
	
		
		</script>
		
		


</li>


<li>
    <input type="text" name="company.sales" class="field-style field-split align-left" placeholder="sales" />
    <input type="text" name="company1.sales" class="field-style field-split align-right" placeholder=" year sales" />

</li>

<li>
    <input type="text" name="company.ebit" class="field-style field-split align-left" placeholder="ebit" />
    <input type="text" name="company1.ebit" class="field-style field-split align-right" placeholder=" year ebit" />

</li>

<li>
    <input type="text" name="company.npat" class="field-style field-split align-left" placeholder="npat" />
    <input type="text" name="company1.npat" class="field-style field-split align-right" placeholder=" year npat" />

</li>


<li>
    <input type="text" name="company.eps" class="field-style field-split align-left" placeholder="eps" />
    <input type="text" name="company1.eps" class="field-style field-split align-right" placeholder=" year eps" />

</li>

<li>



<li>
    <input type="text" name="company.cash" class="field-style field-split align-left" placeholder="cash" />
    <input type="text" name="company1.cash" class="field-style field-split align-right" placeholder=" year cash" />
</li>

<li>
    <input type="text" name="company.asset" class="field-style field-split align-left" placeholder="asset" />
    <input type="text" name="company1.asset" class="field-style field-split align-right" placeholder=" year asset" />
</li>




<li>
<li>
    <input type="text" name="company.debt" class="field-style field-split align-left" placeholder="debt" />
    <input type="text" name="company1.debt" class="field-style field-split align-right" placeholder=" year debt" />
</li>

<li>
    <input type="text" name="company.equity" class="field-style field-split align-left" placeholder="equity" />
    <input type="text" name="company1.equity" class="field-style field-split align-right" placeholder=" year equity" />
</li>






<li>
     <input type="text" name="company.shares" class="field-style field-split align-left" placeholder="shares" />
     <input type="text" name="company1.shares" class="field-style field-split align-right" placeholder=" year shares" />

</li>
<li>

<li>
     <input type="text" name="company.ceosalary" class="field-style field-split align-left" placeholder="ceo salary" />
     <input type="text" name="company1.ceosalary" class="field-style field-split align-right" placeholder=" year ceo salary" />

</li>

<li>
     <input type="text" name="company.chairmansalary" class="field-style field-split align-left" placeholder="Chairman salary" />
     <input type="text" name="company1.chairmansalary" class="field-style field-split align-right" placeholder=" year Chairman salary" />

</li>
<li>
<li>
     <input type="text" name="company.coosalary" class="field-style field-split align-left" placeholder="COO salary" />
     <input type="text" name="company1.coosalary" class="field-style field-split align-right" placeholder=" year COO salary" />

</li>

<li>
     <input type="text" name="company.cfosalary" class="field-style field-split align-left" placeholder="Cfo salary" />
     <input type="text" name="company1.cfosalary" class="field-style field-split align-right" placeholder=" year Cfo salary" />

</li>




<li>
<input type="text" name="company.category" class="field-style field-full align-none" placeholder="Description" />
</li>
<li>
<li>
<textarea name="company.descp" class="field-style" placeholder="Moat Description"></textarea>
<textarea name="company1.descp" class="field-style" placeholder="Moat Last Year Description"></textarea>

</li>

<li>
<input type="submit" value="Submit" />
</li>
</ul>


</s:form>


</body>

</html>
