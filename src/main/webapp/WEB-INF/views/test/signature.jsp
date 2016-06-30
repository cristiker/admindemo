<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | 404 Page not found</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <%--css和js文件--%>
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
                404 Error Page
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Examples</a></li>
                <li class="active">404 error</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <form action="${base}/signature/insert" method="post">
                <div>秘钥</div>
                <div><input type="text" name="secretKey"></div>
                <div>用户ID</div>
                <div><input type="text" name="userId"></div>
                <input type="submit" value="保存"/>
            </form>

        </section>
    </div>
    <%--页尾部分--%>
    <jsp:include page="../main/footer.jsp"/>
    <%--样式风格控制--%>
    <jsp:include page="../main/control-sidebar.jsp"/>
</div>
<script src="${base}/static/adminlte-2.3.0/dist/js/demo.js"></script>
</body>
</html>
