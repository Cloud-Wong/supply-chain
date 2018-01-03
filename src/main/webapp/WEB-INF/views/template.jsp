<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top" role="navigation"
		style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">${sessionScope.company.name } ID:${sessionScope.company.id }供应链管理</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> Company
							Profile</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/BI-com/logout"><i class="fa fa-sign-out fa-fw"></i>
							Logout</a></li>
				</ul></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<!-- 树形菜单栏 -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<!-- 搜索框 -->
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Search...">
							<span class="input-group-btn">
								<button style="height: 34px;" class="btn btn-default"
									type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</li>
					<!-- 控制台主页 -->
					<li><a href="${pageContext.request.contextPath}/index.jsp"><i
							class="fa fa-dashboard fa-fw"></i>控制台</a></li>
					<!-- 基础数据 -->
					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
							基础数据<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a
								href="${pageContext.request.contextPath}/BI-dep/department">部门档案</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/BI-emp/employee">员工档案</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/BI-cus/customer">客户档案</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/BI-sup/supplyer">供应商档案</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/BI-pro/product">存货档案</a>
							</li>
						</ul> <!-- /.nav-second-level --></li>
					<!-- 库存管理 -->
					<li><a href="tables.html"><i class="fa fa-table fa-fw"></i>
							库存管理<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a
								href="${pageContext.request.contextPath}/BI-pro/inventory">期初库存</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/SM-ord/warehousingEntry">商品入库</a></li>
							<li><a
								href="${pageContext.request.contextPath}/SM-ord/dispatch">发货单</a></li>
						</ul></li>
					<!-- 销售管理 -->
					<li><a href="#"><i class="fa fa-edit fa-fw"></i> 销售管理<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="${pageContext.request.contextPath}/SM-ite/itemUpshelf">货架信息</a></li>
							<li><a href="${pageContext.request.contextPath}/SM-ord/sorder">销售订单</a></li>
						</ul> <!-- /.nav-second-level -->
					<li><a href="#"><i class="fa fa-wrench fa-fw"></i>采购管理<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="${pageContext.request.contextPath}/SM-ite/showAllPutaway">商品采购</a></li>
							<li><a href="${pageContext.request.contextPath}/SM-ord/porder">采购订单</a></li>
						</ul> <!-- /.nav-second-level --></li>
					<li><a href="#"><i class="fa fa-sitemap fa-fw"></i> 财务管理<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#">应收账款管理</a></li>
							<li><a href="#">应付账款管理</a></li>
						</ul> <!-- /.nav-second-level --></li>
					<li><a href="#"><i class="fa fa-files-o fa-fw"></i> 其他模块<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="blank.html">帮助</a></li>
							<li><a href="login.html">关于</a></li>
						</ul> <!-- /.nav-second-level --></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- 树形菜单栏 结束 -->
	</nav>
</body>
</html>