<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>向导详情</title>
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
			<h1>向导信息</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">向导信息</li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary ">
						<div class="box-header with-border"></div>
						<c:choose>
							<c:when test="${guide!=null}">
								<form class="form-horizontal">
									<div class="box-body">
										<div class="col-md-12 col-md-offset-3">
											<input type="hidden" name="id" value="${guide.id}">
											<div class="form-group">
												<label class="col-md-1 control-label">姓名</label>
												<div class="col-md-3">
													<input type="text" name="name" value="${guide.name}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">用户名</label>
												<div class="col-md-3">
													<input type="text" name="userName" value="${guide.userName}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">邮箱</label>
												<div class="col-md-3">
													<input type="text" name="email" value="${guide.email}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">电话</label>
												<div class="col-md-3">
													<input type="text" name="phone" value="${guide.phone}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">性别</label>
												<div class="col-md-3">
													<input type="text" name="sex" value="${guide.sex}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">年龄</label>
												<div class="col-md-3">
													<input type="text" name="age" value="${guide.age}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">生日</label>
												<div class="col-md-3">
													<input type="text" name="age" value="${guide.birthday}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">熟悉地区</label>
												<div class="col-md-3">
													<input type="text" name="age" value="${guide.area}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">是否有车</label>
												<div class="col-md-3">
													<input type="text" name="age" value="${guide.hasCar}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">创建时间</label>
												<div class="col-md-3">
													<input type="text" name="age" value="${guide.createTime}" class="form-control" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">修改时间</label>
												<div class="col-md-3">
													<input type="text" name="age" value="${guide.updateTime}" class="form-control" disabled="disabled"/>
												</div>
											</div>
										</div>
									</div>
								</form>
							</c:when>
							<c:otherwise>
								<c:otherwise>
									<div class="box-body">
										<div class="callout callout-info">
											<p>无数据</p>
										</div>
									</div>
								</c:otherwise>
							</c:otherwise>
						</c:choose>

						<div class="box-footer">
							<div class="form-group col-md-offset-5">
								<button type="submit" class="btn btn-info" onclick="window.location.href = '${base}/guide/list'">返回</button>
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

