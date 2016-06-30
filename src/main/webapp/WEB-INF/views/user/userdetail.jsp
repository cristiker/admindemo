<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>用户信息</title>
<head>
	<jsp:include page="../main/resource.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<%--头部--%>
	<jsp:include page="../main/header.jsp"/>
	<%--导航栏--%>
	<jsp:include page="../main/navigation.jsp"/>
	<%--主体部分--%>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>管理员详情</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">管理员详情</li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary ">
						<div class="box-header with-border"></div>
						<c:choose>
							<c:when test="${user!=null}">
								<form class="form-horizontal">
									<div class="box-body">
										<div class="col-md-12 col-md-offset-3">
											<div class="form-group">
												<label class="col-md-1 control-label">姓名</label>
												<div class="col-md-3">
													<input type="text" name="name" value="${user.name}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">用户名</label>
												<div class="col-md-3">
													<input type="text" name="userName" value="${user.userName}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">头像</label>
												<div class="col-md-3">
													<c:if test="${user.userImage!=null and user.userImage!=''}">
														<c:forTokens items="${user.userImage}" delims="#" var="img" varStatus="vs">
															<img src='${base}/image/view/${img}' class='img-responsive'>
															<c:if test="${!vs.last}"><br></c:if>
														</c:forTokens>
													</c:if>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">邮箱</label>
												<div class="col-md-3">
													<input type="text" name="email" value="${user.email}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">电话</label>
												<div class="col-md-3">
													<input type="text" name="phone" value="${user.phone}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">性别</label>
												<div class="col-md-1">
													<label>
														<input type="radio" name="sex" class="minimal-red" value="M" <c:if test="${user.sex eq 'M'}">checked</c:if>/>男
													</label>
												</div>
												<div class="col-md-1">
													<label>
														<input type="radio" name="sex" class="minimal-red" value="W" <c:if test="${user.sex eq 'W'}">checked</c:if>/>女
													</label>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">年龄</label>
												<div class="col-md-3">
													<input type="text" name="age" value="${user.age}" class="form-control" disabled="disabled"/>
												</div>
											</div>

										</div>
									</div>
								</form>
							</c:when>
							<c:otherwise>
								<div class="box-body">
									<div class="callout callout-info">
										<p>无数据</p>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
						<div class="box-footer">
							<div class="form-group col-md-offset-5">
								<button type="submit" class="btn btn-info" onclick="window.location.href = '${base}/user/list'">返回</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../main/footer.jsp"/>
	<jsp:include page="../main/control-sidebar.jsp"/>
</div>
<script src="${base}/static/adminlte-2.3.0/dist/js/demo.js"></script>
<script src="${base}/static/adminlte-2.3.0/dist/js/app.min.js"></script>
</body>
</html>

