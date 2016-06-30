<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>区域管理</title>
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
				区域列表
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">区域列表</li>
			</ol>
		</section>
		<section>
			<form id="user-search" class="form-horizontal">
				<div class="form-group">
					<label class="col-md-1 control-label">名称</label>
					<div class="col-md-2">
						<input type="text" name="areaName" class="form-control" id="username1"/>
					</div>
					<label class="col-md-1 control-label">类型</label>
					<div class="col-md-2">
						<select name="type" class="form-control">
							<option value="">全部</option>
							<option value="1">洲</option>
							<option value="2">国家</option>
						</select>
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
							<%--<h3 class="box-title">系统管理员</h3>--%>
						</div><!-- /.box-header -->
						<div class="box-body">
							<button type="button" class="btn btn-default btn-sm" onclick="addState()">添加洲</button>
							<table id="dtable" class="table table-bordered table-hover">
								<thead>
								<tr>
									<th>类型</th>
									<th>名称</th>
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
						<h5 id="modal-title" class="modal-title">添加洲</h5>
					</div>
					<div class="modal-body">
						<form id="add-area-form" class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">名称</label>
								<div class="col-sm-8">
									<input type="text" name="areaName" class="form-control" id="model-areaName" placeholder="名称">
									<input type="hidden" name="type" id="model-type" >
									<input type="hidden" name="parentId" id="model-parentId" >
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
<script src="${base}/static/views/area/arealist.js"></script>
</body>
</html>

