<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookle</title>
<link rel="shortcut icon" href="favicon.ico" />
<style type="text/css">

div {margin-top: 20px;margin-bottom: 20px;margin-right: 20px;}


</style>
</head>
<body>

<div class="form">
<form action='${requestUri}' method='get'>
<br><br><br><br>
<table style="margin-left:80px;">
<thead>
</thead>
<tbody>
<tr>
<td rowspan="10">
<img src="01.png" width=500>
</td>
<td colspan="2">
<input type='text' name='main' placeholder = '請輸入書名' required style=" font-size:18px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#FDC2B7;width:500px;height:30px;"/>
</td>
<td style="padding:20px;">
<input type='image' value="" src="2.jpg" onClick="document.formname.submit();" style="width:40px;height:40px;"/>
</td>
</tr>
<tr>
<td>
<label for="Advanced Keyword" style="font-size:20px;">Advanced Keyword</label>
<div ><input type="text" name="keyword1" placeholder = 'Keyword' style="font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:60%;height:23px;">&ensp;&ensp;<input type="text" name="weight1" placeholder = 'Weight' oninput = "value=value.replace(/[^\d.]/g,'')" style="font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:15%;height:23px;"></div>
<div ><input type="text" name="keyword2" placeholder = 'Keyword' style="font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:60%;height:23px;">&ensp;&ensp;<input type="text" name="weight2" placeholder = 'Weight' oninput = "value=value.replace(/[^\d.]/g,'')" style="font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:15%;height:23px;"></div>
<div ><input type="text" name="keyword3" placeholder = 'Keyword' style="font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:60%;height:23px;">&ensp;&ensp;<input type="text" name="weight3" placeholder = 'Weight' oninput = "value=value.replace(/[^\d.]/g,'')" style="font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD
;width:15%;height:23px;"></div>  
</td>
</tr>
<tr>
<td>
<label for="Type Keyword" style="font-size:20px;">Type Keyword</label>
</td>
</tr>
<tr>
<td>
<select>
    <option>N/A</option>
    <option>Document(.pdf)</option>
    <option>Slides(.pptx)</option>
    <option>Picture(.png)</option>
    <option>Picture(.jpg)</option>
</select>
</td>
</tr>
</tbody>
</table>
</form></div>
</body>
</html>