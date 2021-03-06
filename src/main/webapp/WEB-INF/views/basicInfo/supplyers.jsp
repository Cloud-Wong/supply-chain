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
<!-- bootstrapValidator  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/dist/css/bootstrapValidator.css" />
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
						<h1 class="page-header">供应商档案</h1>
						<c:if test="${!empty supplyer.name}">
							<form:form action="/supply-chain/BI-sup/supplyer/save"
								commandName="supplyer" id="supplyerForm">

								<div class="form-group">
									<label>ID</label>
									<form:input path="id" type="text" class="form-control"
										disabled="true"></form:input>
									<form:hidden path="id" />
								</div>

								<div class="form-group">
									<label>供应商名称</label>
									<form:input path="name" type="text" class="form-control"
										placeholder="供应商名称" />
								</div>
								<div class="form-group">
									<label>地址</label>
									<form:input path="adress" type="text" class="form-control"
										placeholder="地址" />
								</div>
								<div class="form-group">
									<label>联系方式</label>
									<form:input path="tel" type="text" class="form-control"
										placeholder="联系方式" />
								</div>
								<form:hidden path="company.id" value="${sessionScope.company.id }" />
								<input type="button" class="btn btn-outline btn-warning"
									onclick="javascript:history.back(-1);" value="取消">
								<button type="submit" class="btn btn-outline btn-info ">修改</button>
	
							</form:form>
						</c:if>
						<c:if test="${empty supplyer.name}">
							<button style="margin-top: -63px;" data-toggle="modal"
								data-target="#addSupplyer"
								class="btn btn-outline btn-success pull-right">添加供应商</button>
							<div class="modal fade" id="addSupplyer" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">

									<div class="modal-content">
										<form:form action="/supply-chain/BI-sup/supplyer/save"
											commandName="supplyer" id="supplyerForm">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">添加供应商</h4>
											</div>
											<div class="modal-body">

												<div class="form-group">
													<label>供应商名称</label>
													<form:input path="name" type="text" class="form-control"
														placeholder="名称" />
												</div>
												<div class="form-group">
													<label>供应商地址</label>
													<form:input path="adress" type="text" class="form-control"
														placeholder="地址" />
												</div>
												<div class="form-group">
													<label>联系方式</label>
													<form:input path="tel" type="text" class="form-control"
														placeholder="联系方式" />
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

						<c:if test="${!empty listSupplyer && empty supplyer.name}">
							<table class="table table-hover">
								<tr>
									<th>供应商编号</th>
									<th>供应商名称</th>
									<th>地址</th>
									<th>联系方式</th>
									<th>修改</th>
									<th>删除</th>
								</tr>
								<c:forEach items="${listSupplyer}" var="sup">
									<tr>
										<td>${sup.id}</td>
										<td>${sup.name}</td>
										<td>${sup.adress }</td>
										<td>${sup.tel }</td>
										<td><a class="btn btn-outline btn-info btn-sm"
											href="<c:url value='/BI-sup/edit/${sup.id}' />">修改</a></td>
										<td><a class="btn btn-outline btn-danger btn-sm"
											href="<c:url value='/BI-sup/delete/${sup.id}' />">删除</a></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<c:if test="${empty listSupplyer}">
							<p class="text-muted">尚未添加供应商信息</p>
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
	<!-- bootstrapValidator  -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/dist/js/bootstrapValidator.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			// Generate a simple captcha

			$('#supplyerForm').bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					name : {
						validators : {
							notEmpty : {
								message : '供应商名称不能为空'
							}
						}
					},
					adress : {
						validators : {
							notEmpty : {
								message : '地址不能为空'
							}
						}
					},
					tel : {
						validators : {
							notEmpty : {
								message : '联系方式不能为空'
							}
						}
					}
				}
			});

			// Validate the form manually
			$('#validateBtn').click(function() {
				$('#defaultForm').bootstrapValidator('validate');
			});

		});
	</script>
</body>
</html>
