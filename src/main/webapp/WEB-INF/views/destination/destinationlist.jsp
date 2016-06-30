<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>目的地管理</title>
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
			<h1>
				目的地列表
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">目的地列表</li>
			</ol>
		</section>
		<section>
			<form id="user-search" class="form-horizontal">
				<div class="form-group">
					<label class="col-md-1 control-label">目的地名称</label>
					<div class="col-md-2">
						<input type="text" name="destinationName" class="form-control" id="destination-name"/>
					</div>

					<label class="col-md-1 control-label">所属洲</label>
					<div class="col-md-2">
						<%--<input type="text" name="status" class="form-control" id="status"/>--%>
						<select name="stateId" class="form-control">
							<option value="">全部</option>
							<c:forEach items="${states}" var="state" varStatus="status">
								<option value="${state.id}">${state.areaName}</option>
							</c:forEach>
						</select>
					</div>

					<label class="col-md-1 control-label">所属国家</label>
					<div class="col-md-2">
						<input type="text" name="country" class="form-control" id="country"/>
					</div>
					<button type="button" id="search" class="btn">查询</button>
				</div>
			</form>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="box">
						<div class="box-header">
							<%--<h3 class="box-title">目的地列表</h3>--%>
						</div><!-- /.box-header -->
						<div class="box-body">
							<button type="button" class="btn btn-default btn-sm" onclick="addDestination()">新增目的地</button>
							<table id="dtable" class="table table-bordered table-hover">
								<thead>
								<tr>
									<th>目的地名称</th>
									<th>所属国家</th>
									<th>所属洲</th>
									<th>状态</th>
									<th>创建时间</th>
									<th>更新时间</th>
									<th>操作</th>
								</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
						</div><!-- /.box-body -->
					</div><!-- /.box -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</section>
	</div>
	<div class="container">
		<div class="modal" data-backdrop="static" id="mymodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
						<h5 class="modal-title">添加管理员</h5>
					</div>
					<div class="modal-body">
						<form id="add-user-form" class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-8">
									<input type="text" name="userName" class="form-control" id="model-userName" placeholder="用户名">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" id="save-user-btn" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="../main/footer.jsp"/>
	<jsp:include page="../main/control-sidebar.jsp"/>
</div>
<script src="${base}/static/adminlte-2.3.0/dist/js/demo.js"></script>
<script src="${base}/static/adminlte-2.3.0/dist/js/app.min.js"></script>
<script src="${base}/static/views/destination/destinationlist.js"></script>
</body>
</html>

