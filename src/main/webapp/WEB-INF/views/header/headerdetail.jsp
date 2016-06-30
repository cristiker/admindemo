<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>轮播图详情</title>
<head>
	<jsp:include page="../main/resource.jsp"/>
	<script type="text/javascript">
		function saveOrUpdate(){
			$.ajax({
				type:"post",
				url:"${base}/header/updateheader",
				data:$("#form").serializeObject(),
				dataType: "json",
				success:function(data){
					if(data.success){
						alert(data.msg);
					}else{
						alert(data.msg);
					}
				}
			})
		}

		$(function(){
			$("#head-image-file").fileinput({
				uploadUrl: "${base}/image/save",
				deleteUrl: "${base}/image/delete",
				showPreview: true,
				dropZoneEnabled:false,
				allowedFileExtensions: ["jpg", "png", "gif"],
				maxImageWidth: 200,
				maxImageHeight:100,
				maxFileCount: 1,
				resizeImage: true,
				initialPreview:[
					<c:if test="${obj.headImg!=null and obj.headImg!=''}">
					<c:forTokens items="${obj.headImg}" delims="#" var="i" varStatus="vs">
					"<img src='${base}/image/view/${i}' class='file-preview-image'>"
					<c:if test="${!vs.last}">,</c:if>
					</c:forTokens>
					</c:if>

				],
				initialPreviewConfig: [
					<c:if test="${obj.headImg!=null and obj.headImg!=''}">
					<c:forTokens items="${obj.headImg}" delims="#" var="i" varStatus="vs">
					{
						url: '${base}/image/delete',
						frameAttr: {
							style: 'height:80px',
							title: 'My Custom Title',
						}
					}
					<c:if test="${!vs.last}">,</c:if>
					</c:forTokens>
					</c:if>

				]
			}).on('filepreupload', function(event, data, id, index) {
			}).on('fileuploaded', function(event, data, id, index) {
				var obj = data.response;
				if(obj.success){
					var ids = $("#head-img").val();
					if(ids!=""){
						ids+="#"+obj.data.result;
					}else{
						ids = obj.data.result;
					}
					$("#head-img").val(ids);
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
			<h1>轮播图</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">轮播图</li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary ">
						<div class="box-header with-border"></div>
						<c:choose>
							<c:when test="${obj != null}">
								<form id="form" class="form-horizontal">
									<div class="box-body">
										<div class="col-md-12 col-md-offset-3">
											<input type="hidden" name="id" value="${obj.id}">
											<input type="hidden" id="head-img" name="headImg" value="${obj.headImg}">
											<div class="form-group">
												<label class="col-md-1 control-label">标题</label>
												<div class="col-md-3">
													<input type="text" name="title" value="${obj.title}" class="form-control"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">轮播图</label>
												<div class="col-md-3">
													<input id="head-image-file" type="file" class="file-loading"  accept="image/*">
												</div>
											</div>

										</div>
									</div>
								</form>
							</c:when>
							<c:otherwise>
								<form id="form" class="form-horizontal">
									<div class="box-body">
										<div class="col-md-12 col-md-offset-3">
											<input type="hidden" name="id" value="${obj.id}">
											<input type="hidden" id="head-img" name="headImg" value="${obj.headImg}">
											<div class="form-group">
												<label class="col-md-1 control-label">标题</label>
												<div class="col-md-3">
													<input type="text" name="title" value="${obj.title}" class="form-control"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-1 control-label">轮播图</label>
												<div class="col-md-3">
													<input id="head-image-file" type="file" class="file-loading"  accept="image/*">
												</div>
											</div>

										</div>
									</div>
								</form>
							</c:otherwise>
						</c:choose>

						<div class="box-footer">
							<c:choose>
								<c:when test="${obj!=null}">
									<div class="form-group col-md-offset-5">
										<button class="btn btn-info" onclick="saveOrUpdate()">修改</button>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group col-md-offset-5">
										<button class="btn btn-info" onclick="saveOrUpdate()">保存</button>
									</div>
								</c:otherwise>
							</c:choose>

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

