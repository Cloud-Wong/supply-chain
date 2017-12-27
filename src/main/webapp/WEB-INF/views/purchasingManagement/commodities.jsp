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
<!-- DataTables JavaScript -->
<link
	href="${pageContext.request.contextPath}/resources/dist/css/dataTables.bootstrap.css"
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
						<h1 class="page-header">商品信息</h1>
						<c:if test="${!empty listItemUpshelf}">
							<table class="table table-hover table-striped table-bordered"
								id="commodities">
								<thead>
									<tr>
										<th>商品名称</th>
										<th>单位</th>
										<th>描述</th>
										<th>查看商品详情</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listItemUpshelf}" var="ite">
										<tr>

											<td>${ite.product.name}</td>
											<td>${ite.product.unit }</td>
											<td>${ite.description }</td>
											<td><a class="btn btn-outline btn-info btn-sm"
												href="<c:url value='/SM-ite/showCommodityDetail/${ite.id}' />">商品详情</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
						<c:if test="${empty listItemUpshelf}">
							<p class="text-muted">无商品信息</p>
						</c:if>

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
	<!-- bootstrapValidator  -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/dist/js/bootstrapValidator.js"></script>
	<!-- DataTables JavaScript -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/dist/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/dist/js/dataTables.bootstrap.min.js"></script>
	
	<script>
		$(document).ready(function() {
			$('#commodities').DataTable({

			});
		});
	</script>

</body>
</html>
