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
						<h1 class="page-header">期初库存</h1>
						<c:if test="${!empty inventory.product.name}">
							<form:form action="/supply-chain/IM-inv/inventory/save"
								commandName="inventory" id="inventoryForm">

								<div class="form-group">
									<label>ID</label>
									<form:input path="id" type="text" class="form-control"
										disabled="true"></form:input>
									<form:hidden path="id" />
								</div>
								<div class="form-group">
									<label>存货名称</label>
									<form:select path="product.id"
										class="form-control selectpicker" id="lunch"
										data-live-search="true" items="${listProduct }"
										itemLabel="name" itemValue="id" title="请选择存货名称">

									</form:select>
								</div>
								<div class="form-group">
									<label>数量</label>
									<form:input path="stock" type="text" class="form-control"
										placeholder="数量" />
								</div>
								<form:hidden path="company.id" value="${sessionScope.company.id }" />
								<input type="button" class="btn btn-outline btn-warning"
									onclick="javascript:history.back(-1);" value="取消">
								<button type="submit" class="btn btn-outline btn-info ">修改</button>

							</form:form>
						</c:if>
						<c:if test="${empty inventory.product.name}">
							<button style="margin-top: -63px;" data-toggle="modal"
								data-target="#addInventory"
								class="btn btn-outline btn-success pull-right">添加存货</button>
							<div class="modal fade" id="addInventory" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">

									<div class="modal-content">
										<form:form action="/supply-chain/IM-inv/inventory/save"
											commandName="inventory" id="inventoryForm">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">添加存货</h4>
											</div>
											<div class="modal-body">

												<div class="form-group">
													<label>存货名称</label>
													<form:select path="product.id"
														class="form-control selectpicker" id="lunch"
														data-live-search="true" items="${listProduct }"
														itemLabel="name" itemValue="id" title="请输入存货名称">
													</form:select>
												</div>
												<div class="form-group">
													<label>数量</label>
													<form:input path="stock" type="text" class="form-control"
														placeholder="数量" />
												</div>
												<form:hidden path="company.id" value="${sessionScope.company.id }" />
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">关闭</button>
												<button type="submit" class="btn btn-primary">添加</button>
											</div>
										</form:form>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal -->
							</div>
						</c:if>

						<c:if
							test="${!empty listInventory && empty inventory.product.name}">
							<table class="table table-hover">
								<tr>
									<th>库存编号</th>
									<th>存货名称</th>
									<th>单位</th>
									<th>数量</th>
									<th>修改</th>
									<th>删除</th>
								</tr>
								<c:forEach items="${listInventory}" var="inv">
									<tr>
										<td>${inv.id}</td>
										<td>${inv.product.name}</td>
										<td>${inv.product.unit }</td>
										<td>${inv.stock }</td>
										<td><a class="btn btn-outline btn-info btn-sm"
											href="<c:url value='/IM-inv/edit/${inv.id}' />">修改</a></td>
										<td><a class="btn btn-outline btn-danger btn-sm"
											href="<c:url value='/IM-inv/delete/${inv.id}' />">删除</a></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<c:if test="${empty listInventory}">
							<p class="text-muted">尚未添加库存信息</p>
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
	<script type="text/javascript">
		$(document).ready(function() {
			// Generate a simple captcha

			$('#inventoryForm').bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					
					stock : {
						validators : {
							notEmpty : {
								message : '库存数量不能为空'
							},
							numeric: {
		                        message: '必须为数字'
		                    }
						}
					}
				}
			});



		});
	</script>
</body>
</html>
