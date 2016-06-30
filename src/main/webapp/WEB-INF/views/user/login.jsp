<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户登录</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<jsp:include page="../main/resource.jsp"/>
</head>
<body class="hold-transition login-page">
<div class="login-box">
	<div class="login-logo">
		<a href="#"></a>
	</div><!-- /.login-logo -->
	<div class="login-box-body">
		<p class="login-box-msg">用户登录</p>
		<form action="${base}/system/login" method="POST" class="login-form">
			<div class="form-group has-feedback">
				<input type="email" class="form-control" name="userName" placeholder="用户名" datatype="s" nullmsg="用户名不能为空">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" name="password" placeholder="Password" datatype="s" nullmsg="密码不能为空">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-xs-8">
					<div class="checkbox icheck">
						<label>
							<input type="checkbox">记住我
						</label>
					</div>
				</div><!-- /.col -->
				<div class="col-xs-4">
					<button type="button" id="login" class="btn btn-primary btn-block btn-flat">登录</button>
				</div><!-- /.col -->
			</div>
		</form>

		<div class="social-auth-links text-center">
			<%--<p>- OR -</p>--%>
			<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i>Facebook登录</a>
			<a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i>Google+登录</a>
		</div><!-- /.social-auth-links -->

		<a href="#">忘记密码</a><br>
		<a href="${base}/user/toregister" class="text-center">注册新用户</a>

	</div><!-- /.login-box-body -->
</div><!-- /.login-box -->
<script src="${base}/static/adminlte-2.3.0/plugins/iCheck/icheck.min.js"></script>
<script>
	$(function () {
		$('input').iCheck({
			checkboxClass: 'icheckbox_square-blue',
			radioClass: 'iradio_square-blue',
			increaseArea: '20%' // optional
		});

		$(".login-form").Validform({
			btnSubmit:"#login",
			tiptype:3,
			async:true,
			ajaxPost:true,
			beforeCheck:function(curform){
			},
			beforeSubmit:function(curform){
			},
			callback:function(data){
				if(data.success){
					window.location.href="${base}/user/list";
				}else{
					alert(data.msg);
				}
			}
		});
		/*$("#login").click(function(){
			$.ajax({
				url:"${base}/user/login",
				data:{userName:"admin",password:"123456"},
				type:"post",
				/!*contentType:"application/x-www-form-urlencoded",*!/
				success:function(data){
					alert(JSON.stringify(data));
				}
			})
		});*/



	});
</script>
</body>
</html>

