<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/dist/css/bootstrap-select.css">
<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<title>供应链管理系统</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../template.jsp" flush="true" />
		<!-- Navigation -->

		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">商品入库单</h1>

						<ul id="myTab" class="nav nav-tabs">
							<li class="active"><a href="#underway" data-toggle="tab">进行中订单</a></li>
							<li><a href="#finish" data-toggle="tab">入库记录</a></li>
						</ul>

						<div id="myTabContent" class="tab-content">
							
							<div class="tab-pane fade in active" id="underway">
								<br>
								<c:if test="${!empty listOrder12}">
									<table class="table table-hover">
										<tr>
											<th>商品名称</th>
											<th>单价</th>
											<th>数量</th>
											<th>收获地址</th>
											<th>联系方式</th>
											<th>状态</th>
										</tr>
										<c:forEach items="${listOrder12}" var="ord">
											<tr>
												<td>${ord.product.name}</td>
												<td>${ord.cost}</td>
												<td>${ord.count}</td>
												<td>${ord.adress }</td>
												<td>${ord.tel }</td>
												<td><c:if test="${ord.status ==2}">
														<a class="btn btn-outline btn-info btn-sm"
															href="<c:url value='/SM-ord/finish/${ord.id}' />">确认收货</a>
													</c:if> <c:if test="${ord.status ==1}">待发货</c:if></td>
											</tr>
										</c:forEach>
									</table>
								</c:if>
								<c:if test="${empty listOrder12}">
									<p class="text-muted">无商品信息</p>
								</c:if>
							</div>
							<div class="tab-pane fade" id="finish">
								<br>
								<c:if test="${!empty listOrder3}">
									<table class="table table-hover">
										<tr>
											<th>商品名称</th>
											<th>单价</th>
											<th>数量</th>
											<th>收货地址</th>
											<th>联系方式</th>
											<th>状态</th>
										</tr>
										<c:forEach items="${listOrder3}" var="ord">
											<tr>
												<td>${ord.product.name}</td>
												<td>${ord.cost}</td>
												<td>${ord.count}</td>
												<td>${ord.adress }</td>
												<td>${ord.tel }</td>
												<td>已完成</td>
											</tr>
										</c:forEach>
									</table>
								</c:if>
								<c:if test="${empty listOrder3}">
									<p class="text-muted">无商品信息</p>
								</c:if>
							</div>

						</div>



					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- Page Content -->
	</div>


	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/dist/js/bootstrap-select.js"></script>


</body>
</html>
