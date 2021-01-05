<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
<style type="text/css">
body{background-image:url(1.png);height:100%;background-size:50%;background-repeat:no-repeat; background-position:30px 2.5%;}
.form{position:absolute;top:130px;left:700px;}

div {
  margin-top: 20px;
  margin-bottom: 20px;
  margin-right: 20px;
}


</style>
</head>
<body>

<div class="form">
<form action='${requestUri}' method='get'>
<input type='text' name='main' placeholder = '請輸入書名' required style=" ;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#FDC2B7;width:80%;height:30px;"/>
<input type='image' value="" src="2.jpg" onClick="document.formname.submit();" style="width:30px;height:30px;"/>
<br><br>
<label for="Advanced Keyword" style="font-size:20px;">Advanced Keyword</label><br>
<div ><input type="text" name="keyword1" placeholder = 'Keyword' style="border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:60%;height:30px;">&ensp;&ensp;<input type="text" name="weight1" placeholder = 'Weight' oninput = "value=value.replace(/[^\d.]/g,'')" style="border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:15%;height:30px;"></div> 
<div ><input type="text" name="keyword2" placeholder = 'Keyword' style="border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:60%;height:30px;">&ensp;&ensp;<input type="text" name="weight2" placeholder = 'Weight' oninput = "value=value.replace(/[^\d.]/g,'')" style="border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:15%;height:30px;"></div>  
<div ><input type="text" name="keyword3" placeholder = 'Keyword' style="border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:60%;height:30px;">&ensp;&ensp;<input type="text" name="weight3" placeholder = 'Weight' oninput = "value=value.replace(/[^\d.]/g,'')" style="border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:15%;height:30px;"></div>  

<label for="Type Keyword" style="font-size:20px;">Type Keyword</label><br><br>


<select>
    <option>N/A</option>
    <option>Document(.pdf)</option>
    <option>Slides(.pptx)</option>
    <option>Picture(.png)</option>
    <option>Picture(.jpg)</option>
</select>




</form></div>
</body>
</html>