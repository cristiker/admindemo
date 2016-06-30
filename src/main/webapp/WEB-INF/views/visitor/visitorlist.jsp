<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>游客列表</title>
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
                游客列表
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
                <li class="active">游客列表</li>
            </ol>
        </section>
        <section>
           <%--<div class="col-md-offset-1 col-md-10">--%>
               <form id="user-search" class="form-horizontal">
                   <div class="form-group">
                       <label class="col-md-1 control-label">用户名</label>
                       <div class="col-md-2">
                           <input type="text" name="userName" class="form-control" id="username1"/>
                       </div>
                       <label class="col-md-1 control-label">邮箱</label>
                       <div class="col-md-2">
                           <input type="text" name="email" class="form-control" id="email"/>
                       </div>
                       <label class="col-md-1 control-label">手机</label>
                       <div class="col-md-2">
                           <input type="text" name="phone" class="form-control" id="phone"/>
                       </div>
                       <button type="button" id="search" class="btn">查询</button>
                   </div>
               </form>
          <%-- </div>--%>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <%--<h3 class="box-title">游客列表</h3>--%>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <table id="dtable" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>用户名</th>
                                        <th>邮箱</th>
                                        <th>手机</th>
                                        <th>年龄</th>
                                        <th>状态</th>
                                        <th>创建时间</th>
                                        <th>修改时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <%--页尾部分--%>
    <jsp:include page="../main/footer.jsp"/>
    <%--样式风格控制--%>
    <jsp:include page="../main/control-sidebar.jsp"/>
</div>
<!-- AdminLTE App -->
<script src="${base}/static/adminlte-2.3.0/dist/js/demo.js"></script>
<script src="${base}/static/adminlte-2.3.0/dist/js/app.min.js"></script>
<script src="${base}/static/views/visitor/visitorlist.js"></script>
<!-- AdminLTE for demo purposes -->
</body>
</html>

