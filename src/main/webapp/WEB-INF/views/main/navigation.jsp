<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- 用户状态信息 -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${base}/static/adminlte-2.3.0/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>Alexander Pierce</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- 搜索栏 -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
			</div>
		</form>
		<!-- 菜单管理 -->
		<ul class="sidebar-menu">
			<li class="header">主菜单</li>

			<li class="treeview <c:if test="${menu == 'systemMenu'}">active</c:if>">
				<a href="#">
					<i class="fa fa-files-o"></i>
					<span>系统管理</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu <c:if test="${menu == 'systemMenu'}">menu-open</c:if>" <c:if test="${menu == 'systemMenu'}">style="display: block;"</c:if> >
					<li><a href="${base}/user/list?menu=systemMenu"><i class="fa fa-circle-o"></i>用户管理</a></li>
				</ul>
			</li>
			<li class="treeview <c:if test="${menu == 'visitorMenu'}">active</c:if>">
				<a href="#">
					<i class="fa fa-dashboard"></i>
					<span>游客管理</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu <c:if test="${menu == 'visitorMenu'}">menu-open</c:if>" <c:if test="${menu == 'visitorMenu'}">style="display: block;"</c:if> >
					<li><a href="${base}/visitor/list?menu=visitorMenu"><i class="fa fa-circle-o"></i>游客管理</a></li>
				</ul>
			</li>
			<li class="treeview <c:if test="${menu == 'tourMenu'}">active</c:if>">
				<a href="#">
					<i class="fa fa-th"></i>
					<span>向导管理</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu <c:if test="${menu == 'tourMenu'}">menu-open</c:if>" <c:if test="${menu == 'tourMenu'}">style="display: block;"</c:if> >
					<li><a href="${base}/guide/list?menu=tourMenu"><i class="fa fa-circle-o"></i>向导管理</a></li>
				</ul>
			</li>
			<li class="treeview <c:if test="${menu == 'sightMenu'}">active</c:if>">
				<a href="#">
					<i class="fa fa-th"></i>
					<span>目的地管理</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu <c:if test="${menu == 'sightMenu'}">menu-open</c:if>" <c:if test="${menu == 'sightMenu'}">style="display: block;"</c:if> >
					<li><a href="${base}/sight/list?menu=sightMenu"><i class="fa fa-circle-o"></i>景区管理</a></li>
					<li><a href="${base}/area/list?menu=sightMenu"><i class="fa fa-circle-o"></i>区域管理</a></li>
					<li><a href="${base}/destination/list?menu=sightMenu"><i class="fa fa-circle-o"></i>目的地管理</a></li>
				</ul>
			</li>

			<li class="treeview <c:if test="${menu == 'strategyMenu'}">active</c:if>">
				<a href="#">
					<i class="fa fa-th"></i>
					<span>攻略管理</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu <c:if test="${menu == 'strategyMenu'}">menu-open</c:if>" <c:if test="${menu == 'strategyMenu'}">style="display: block;"</c:if> >
					<li><a href="${base}/user/list?menu=strategyMenu"><i class="fa fa-circle-o"></i>攻略管理</a></li>
				</ul>
			</li>
			<li class="treeview <c:if test="${menu == 'subjectMenu'}">active</c:if>">
				<a href="#">
					<i class="fa fa-th"></i>
					<span>主题管理</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu <c:if test="${menu == 'subjectMenu'}">menu-open</c:if>" <c:if test="${menu == 'subjectMenu'}">style="display: block;"</c:if> >
					<li><a href="${base}/subject/list?menu=subjectMenu"><i class="fa fa-circle-o"></i>主题管理</a></li>
				</ul>
			</li>
			<li class="treeview <c:if test="${menu == 'subjectMenu'}">active</c:if>">
				<a href="#">
					<i class="fa fa-th"></i>
					<span>轮播图管理</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu <c:if test="${menu == 'lunboMenu'}">menu-open</c:if>" <c:if test="${menu == 'lunboMenu'}">style="display: block;"</c:if> >
					<li><a href="${base}/header/index?menu=lunboMenu"><i class="fa fa-circle-o"></i>轮播图管理</a></li>
				</ul>
			</li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>