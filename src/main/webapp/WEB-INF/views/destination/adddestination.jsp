<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>新增目的地</title>
<head>
	<jsp:include page="../main/resource.jsp"/>
	<script>
		function saveDestination(){
			$.ajax({
				type:"post",
				url:"${base}/destination/adddestination",
				data:$("#form").serializeObject(),
				dataType: "json",
				success:function(data){
					if(data.success){
						window.location.href="${base}/destination/list";
					}else{
						alert(data.msg);
					}
				}
			})
		}

		function displayResult(item, val, text) {
			$("#country-id").val(val);
			$('.alert').show().html('You selected <strong>' + val + '</strong>: <strong>' + text + '</strong>');
		}

		$(function(){
			$('#country-name').typeahead({
				ajax:{
					url:"${base}/area/search",
					timeout:100,
					method:'post',
					triggerLength:1,
					preDispatch:function(query){
						var para={};
						para.parentId=$("#state-id").val();
						para.type = 2;
						para.query=query;
						return para;
					},
					preProcess:function(result){
						var obj = eval('(' + result + ')')
						console.log(obj.data.list);
						return obj.data.list;
					}

				},
				display:"areaName",
				val:"id",
				items:8,
				itemSelected: displayResult
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
			<h1>新增目的地</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">新增目的地</li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary ">
						<div class="box-header with-border"></div>
						<form id="form" class="form-horizontal">
							<div class="box-body">
								<div class="col-md-12 col-md-offset-3">

									<div class="form-group">
										<label class="col-md-1 control-label">所属洲</label>
										<div class="col-md-3">
											<select id="state-id" name="stateId" class="form-control">
												<c:forEach items="${states}" var="state" varStatus="status">
													<option value="${state.id}">${state.areaName}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-1 control-label">所属国家</label>
										<div class="col-md-3">
											<input type="text" id="country-name" class="form-control" />
											<input type="hidden" id="country-id" name="countryId"/>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-1 control-label">目的地</label>
										<div class="col-md-3">
											<input type="text" name="destinationName" class="form-control" />
										</div>
									</div>


								</div>
							</div>
						</form>

						<div class="box-footer">
							<div class="form-group col-md-offset-5">
								<button type="submit" class="btn btn-info" onclick="saveDestination()">保存</button>
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

