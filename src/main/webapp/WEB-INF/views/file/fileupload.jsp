<%@page contentType="text/html;charset=UTF-8" %>

<html>
<title>用户登录</title>
<head>
	<script src="${base}/static/js/jquery-1.8.3.js"></script>
	<script src="${base}/static/js/main.js"></script>
	<script type="text/javascript">
		i = 1;
		j = 1;
		$(document).ready(function(){

			$("#btn_add1").click(function(){
				document.getElementById("newUpload1").innerHTML+='<div id="div_'+i+'"><input  name="file_'+i+'" type="file"  /><input type="button" value="删除"  onclick="del_1('+i+')"/></div>';
				i = i + 1;
			});

			$("#btn_add2").click(function(){
				document.getElementById("newUpload2").innerHTML+='<div id="div_'+j+'"><input  name="file_'+j+'" type="file"  /><input type="button" value="删除"  onclick="del_2('+j+')"/></div>';
				j = j + 1;
			});
		});

		function del_1(o){
			document.getElementById("newUpload1").removeChild(document.getElementById("div_"+o));
		}

		function del_2(o){
			document.getElementById("newUpload2").removeChild(document.getElementById("div_"+o));
		}

	</script>
</head>
<body>

<div>
	<h1>springMVC字节流输入上传文件</h1>
	<form name="userForm1" action="${base}/image/save" enctype="multipart/form-data" method="post">
		<div id="newUpload1">
			<input type="file" name="file">
		</div>

		<input type="button" id="btn_add1" value="增加一行" >
		<input type="submit" value="上传" >
	</form>
	<%--<br>
	<br>
	<hr align="left" width="60%" color="#FF0000" size="3">
	<br>
	<br>
	<h1>springMVC包装类上传文件</h1>
	<form name="userForm2" action="${base}/file/upload2" enctype="multipart/form-data" method="post">
	<div id="newUpload2">
		<input type="file" name="file">
	</div>
	<input type="button" id="btn_add2" value="增加一行" />
	<input type="submit" value="上传" />--%>


	</form>
</div>
</body>
</html>
