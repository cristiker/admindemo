<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>游客详情</title>
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
			<h1>游客详情</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">游客详情</li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary ">
						<div class="box-header with-border"></div>
						<c:choose>
							<c:when test="${visitor!=null}">
								<form class="form-horizontal">
								<div class="box-body">
									<div class="col-md-12 col-md-offset-3">
										<div class="form-group">
											<label class="col-md-1 control-label">姓名</label>
											<div class="col-md-3">
												<input type="text" name="name" value="${visitor.name}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">头像</label>
											<div class="col-md-3">
												<img src="/image/view/${visitor.userImage}" width="200">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">用户名</label>
											<div class="col-md-3">
												<input type="text" name="userName" value="${visitor.userName}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">邮箱</label>
											<div class="col-md-3">
												<input type="text" name="email" value="${visitor.email}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">电话</label>
											<div class="col-md-3">
												<input type="text" name="phone" value="${visitor.phone}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">性别</label>
											<div class="col-md-1">
												<label>
													<input type="radio" name="sex" class="minimal-red" value="M" disabled="disabled" <c:if test="${visitor.sex eq 'M'}">checked</c:if>/>男
												</label>
											</div>
											<div class="col-md-1">
												<label>
													<input type="radio" name="sex" class="minimal-red" value="W" disabled="disabled" <c:if test="${visitor.sex eq 'W'}">checked</c:if>/>女
												</label>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">年龄</label>
											<div class="col-md-3">
												<input type="text" name="age" value="${visitor.age}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">身份证图片</label>
											<div class="col-md-3">
												<img src="/image/view/${visitor.imgIdentify}" width="200">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">身份证号</label>
											<div class="col-md-3">
												<input type="text" name="identifyNumber" value="${visitor.identifyNumber}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">生日</label>
											<div class="col-md-3">
												<input type="text" name="birthday" value="${visitor.birthday}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">国籍</label>
											<div class="col-md-3">
												<input type="text" name="country" value="${visitor.country}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">省</label>
											<div class="col-md-3">
												<input type="text" name="province" value="${visitor.province}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">市</label>
											<div class="col-md-3">
												<input type="text" name="city" value="${visitor.city}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">地址</label>
											<div class="col-md-3">
												<input type="text" name="location" value="${visitor.location}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">QQ</label>
											<div class="col-md-3">
												<input type="text" name="qq" value="${visitor.qq}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">微信</label>
											<div class="col-md-3">
												<input type="text" name="weixin" value="${visitor.weixin}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">联系人</label>
											<div class="col-md-3">
												<input type="text" name="contactName" value="${visitor.contactName}" class="form-control" disabled="disabled"/>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-1 control-label">联系方式</label>
											<div class="col-md-3">
												<input type="text" name="contactNumber" value="${visitor.contactNumber}" class="form-control" disabled="disabled"/>
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
								<button type="submit" class="btn btn-info" onclick="window.location.href = '${base}/visitor/list'">返回</button>
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

