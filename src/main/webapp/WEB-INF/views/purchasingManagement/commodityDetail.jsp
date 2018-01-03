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
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">采购商品</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-info">
						<div class="panel-heading">商品详情</div>
						<!-- /.panel-heading -->
						<div class="panel-body ">
							<h4 class="text-info">
								商品名称：<span>${ itemUpshelf.product.name}</span><br>
							</h4>
							<h4 class="text-info">
								销售公司：<span>${ itemUpshelf.company.name}</span><br>
							</h4>
							<h4 class="text-info">
								单位：<span>${ itemUpshelf.product.unit}</span><br> <br>
							</h4>
							<div class="col-lg-9" style="margin-left: -15px;">
								<ul id="myTab" class="nav nav-tabs">
									<li class="active"><a href="#detail" data-toggle="tab">
											商品介绍 </a></li>
									<li><a href="#fq" data-toggle="tab">F&#38;Q</a></li>

								</ul>

								<div id="myTabContent" class="tab-content">
									<div class="tab-pane fade in active" id="detail">
										<p>&nbsp; &nbsp;${ itemUpshelf.description}</p>
									</div>
									<div class="tab-pane fade" id="fq">
										<p>&nbsp; &nbsp;iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布
											iPhone、iPod Touch 和 Apple TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X
											操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
									</div>

								</div>
							</div>
							<div class="col-lg-9" style="margin-left: -15px;">
								<input type="button" class="btn btn-outline btn-warning"
									onclick="javascript:history.back(-1);" value="取消">
								<button class="btn btn-outline btn-success" data-toggle="modal"
									data-target="#porder">下单</button>

								<div class="modal fade" id="porder" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">

										<div class="modal-content">
											<form:form action="/supply-chain/SM-ord/order/save"
												commandName="order">

												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h4 class="modal-title" id="myModalLabel">填写订单信息</h4>
												</div>
												<div class="modal-body">

													<div class="form-group">
														<label>商品入库参照</label>
														<form:select path="pproduct.id"
															class="form-control selectpicker" id="lunch"
															data-live-search="true" items="${listProduct }"
															itemLabel="name" itemValue="id" title="请选择存货名称">
														</form:select>

													</div>
													<div class="form-group">
														<label>单价</label>
														<form:input path="cost" type="text" class="form-control"
															placeholder="单价" />
													</div>
													<div class="form-group">
														<label>数量</label>
														<form:input path="count" type="text" class="form-control"
															placeholder="数量" />
													</div>
													<div class="form-group">
														<label>收获地址</label>
														<form:input path="adress" type="text" class="form-control"
															placeholder="地址" />
													</div>
													<div class="form-group">
														<label>联系方式</label>
														<form:input path="tel" type="text" class="form-control"
															placeholder="联系方式" />
													</div>
													<form:hidden path="pcompany.id"
														value="${sessionScope.company.id }" />
													<form:hidden path="scompany.id"
														value="${ itemUpshelf.company.id}" />
													<form:hidden path="sproduct.id"
														value="${ itemUpshelf.company.id}" />
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">关闭</button>
													<button type="submit" class="btn btn-primary">购买</button>
												</div>
											</form:form>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal -->
								</div>
							</div>

						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->

			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->


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


</body>
</html>
