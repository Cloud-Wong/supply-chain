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
<title>供应链管理系统</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../template.jsp" flush="true" />
		<!-- Navigation -->

		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">部门档案</h1>

						<form:form action="/supply-chain/BI-dep/department/save"
							commandName="department" class="form-inline">
							<c:if test="${!empty department.departmentName}">
								<div class="form-group">
									<label for="exampleInputName2">ID</label>
									<form:input path="id" type="text" class="form-control"
										disabled="true"></form:input>
									<form:hidden path="id" />
								</div>
							</c:if>
							<div class="form-group">
								<form:input path="departmentName" type="text"
									class="form-control" placeholder="请填写部门名称" />
							</div>
							<form:hidden path="company.id" value="${sessionScope.company.id }" />
							<c:if test="${empty department.departmentName}">
								<button type="submit" class="btn btn-outline btn-success">添加部门</button>
							</c:if>
							<c:if test="${!empty department.departmentName}">
								<button type="submit" class="btn btn-default">修改</button>
							</c:if>
							
						</form:form>
						<!-- 添加部门内联表单 -->

						<c:if test="${!empty listDepartment}">
							<table class="table table-hover">
								<tr>
									<th>部门编号</th>
									<th>部门名称</th>
									<th>修改</th>
									<th>解散</th>
								</tr>
								<c:forEach items="${listDepartment}" var="dep">
									<tr>
										<td>${dep.id}</td>
										<td>${dep.departmentName}</td>
										<td><a class="btn btn-outline btn-info btn-sm"
											href="<c:url value='/BI-dep/edit/${dep.id}' />">修改</a></td>
										<td><a class="btn btn-outline btn-danger btn-sm"
											data-toggle="modal" data-target="#deleteDepartment"
											style="cursor: pointer;">解散</a></td>
									</tr>
									<div class="modal fade" id="deleteDepartment" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h4 class="modal-title" id="myModalLabel">警告！</h4>
												</div>
												<div class="modal-body">删除部门将级联删除部门内的所有员工，是否继续删除？</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">取消</button>
													<a type="button"
														href="<c:url value='/BI-dep/delete/${dep.id}' />"
														class="btn btn-primary">删除</a>
												</div>
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal -->
									</div>
								</c:forEach>
							</table>
						</c:if>
						<!-- 部门列表 -->
						<c:if test="${empty listDepartment}">
							<p class="text-muted">尚未添加部门信息</p>
						</c:if>

					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
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
</body>
</html>