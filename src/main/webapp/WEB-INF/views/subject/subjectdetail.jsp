<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>用户信息</title>
<head>
	<jsp:include page="../main/resource.jsp"/>
	<script>
		function back(){
			window.history.go(-1);
		}

		$(function(){
			$("#user-image-file").fileinput({
				uploadUrl: "${base}/image/save",
				deleteUrl: "${base}/image/delete",
				showPreview: true,
				dropZoneEnabled:false,
				allowedFileExtensions: ["jpg", "png", "gif"],
				maxImageWidth: 200,
				maxImageHeight:100,
				maxFileCount: 1,
				resizeImage: true
			}).on('filepreupload', function(event, data, id, index) {
			}).on('fileuploaded', function(event, data, id, index) {
				var obj = data.response;
				if(obj.success){
					var ids = $("#user-image").val();
					if(ids!=""){
						ids+="#"+obj.data.result;
					}else{
						ids = obj.data.result;
					}
					$("#user-image").val(ids);
					alert($("#user-image").val());
				}
			});
		})


	</script>
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
			<h1>主题详情</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">主题详情</li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary ">
						<div class="box-header with-border"></div>
							<c:choose>
								<c:when test="${subject!=null}">
									<form id="form" class="form-horizontal">
										<div class="box-body">
											<div class="col-md-12 col-md-offset-3">
												<input type="hidden" id="user-image" name="subjectImg" value="${subject.subjectImg}"/>
												<div class="form-group">
													<label class="col-md-1 control-label">主题名称</label>
													<div class="col-md-3">
														<input type="text" name="subjectName" value="${subject.subjectName}" disabled="disabled" class="form-control" />
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-1 control-label">主题内容</label>
													<div class="col-md-3">
														<input type="text" name="subjectContent" value="${subject.subjectContent}" disabled="disabled" class="form-control" />
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-1 control-label">状态</label>
													<div class="col-md-1">
														<label>
															<input type="radio" name="status" class="minimal-red" disabled="disabled" <c:if test="${subject.status eq 1}"> checked="checked"</c:if> value="1" />未启用
														</label>
													</div>
													<div class="col-md-1">
														<label>
															<input type="radio" name="status" class="minimal-red" disabled="disabled" <c:if test="${subject.status eq 2}"> checked="checked"</c:if> value="2"/>启用
														</label>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-1 control-label">主题图片</label>
													<div class="col-md-3">
														<c:if test="${subject.subjectImg!=null and subject.subjectImg!=''}">
															<c:forTokens items="${subject.subjectImg}" delims="#" var="i" varStatus="vs">
																<img src='${base}/image/view/${i}' class='img-responsive'>
																<c:if test="${!vs.last}"><br></c:if>
															</c:forTokens>
														</c:if>
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
								<button type="submit" class="btn btn-info" onclick="back()">返回</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<%--<div class="alert alert-success alert-dismissable">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<h4>	<i class="icon fa fa-check"></i> Alert!</h4>
			Success alert preview. This alert is dismissable.
		</div>--%>
	</div>
	<jsp:include page="../main/footer.jsp"/>
	<jsp:include page="../main/control-sidebar.jsp"/>
</div>
<script src="${base}/static/adminlte-2.3.0/dist/js/demo.js"></script>
<script src="${base}/static/adminlte-2.3.0/dist/js/app.min.js"></script>
</body>
</html>

