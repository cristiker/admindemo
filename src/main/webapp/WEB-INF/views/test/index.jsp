<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8" %>

<html>
<title>用户信息</title>
<head>
	<script src="${base}/static/js/jquery-1.8.3.js"></script>
	<script src="${base}/static/js/main.js"></script>
	<script>
		$(function(){
			$("#register").click(function(){
				var param = $("#form").serializeObject();
				var list = new Array();
				list.push("habit");
				param = checkList(param,list);
				register(param);
			})
		})
		function register(param){
			var url="${base}/api/user/registeruser/";
			$.ajax({
					type:"post",
					data:JSON.stringify(param),
					url:url,
					dataType: "json",
					contentType:"application/json",
					success:function(data) {
						var obj = eval(data);
						if(obj.success){
							alert(JSON.stringify(data))
						}else{
							alert(obj.msg);
						}
					},
					error:function(e){
						alert(e);
					}
				}
			)
		}

	</script>
</head>
<body>
<div>
	<form id="form" >
		<label>用户名</label>
		<input type="text" name="userName"/><br>
		<label>密码</label>
		<input type="text" name="password"/><br>
		<label>性别</label>
		<input type="radio" name="sex" value="男"/>男<br>
		<input type="radio" name="sex" value="女"/>女<br>
		<label>爱好</label>
		<input type="checkbox" name="habit" value="羽毛球"/>羽毛球
		<input type="checkbox" name="habit" value="乒乓球"/>乒乓球
		<input type="checkbox" name="habit" value="足球"/>足球
		<input type="checkbox" name="habit" value="篮球"/>篮球
		<label>年龄</label><input type="text" name="age"/><br>
	</form>
	<input type="button" id="register" value="注册">
</div>
</body>
</html>
