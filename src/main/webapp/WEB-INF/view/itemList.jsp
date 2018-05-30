<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta id="_csrf" name="_csrf" th:content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header"
	th:content="${_csrf.headerName}" />
<script type="text/javascript">
	var token = '<c:out value="${_csrf.token}" />';
	var header = '<c:out value="${_csrf.headerName}" />';
</script>

</form>
<div class="container-fluid">
	<div class="block-header">
		<h2>상품 별 가격</h2>
	</div>
	<!-- Basic Examples -->
	<div class="row clearfix">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="card">
				<div class="header theader">
					<select class="form-control col-md-2" id="itemList">
						<option value='all'>전체</option>
						<c:forEach var="list" items="${itemList}" varStatus="status">
							<option value='<c:out value="${list.ic}" />'>${list.in}</option>
						</c:forEach>
					</select>

				</div>
				<div class="body">
					<div class="table-responsive">
						<table
							class="table table-bordered table-striped table-hover js-basic-example dataTable">
							<thead>
								<tr>
									<th>번호</th>
									<th>제품명</th>
									<th>공시가격</th>
									<th>할인가격</th>
									<th>공시 일자</th>
									<th>네이버 쇼핑</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>번호</th>
									<th>제품명</th>
									<th>공시가격</th>
									<th>할인가격</th>
									<th>공시 일자</th>
									<th>네이버 쇼핑</th>
								</tr>
							</tfoot>

						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- #END# Basic Examples -->
	<!-- Exportable Table -->
	<div class="row clearfix">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="card">
				<div class="header">
					<h2>EXPORTABLE TABLE</h2>

				</div>
				<div class="body">
					<div class="table-responsive">
						<table
							class="table table-bordered table-striped table-hover dataTable js-exportable">
							<thead>
								<tr>
									<th>번호</th>
									<th>제품명</th>
									<th>공시가격</th>
									<th>할인가격</th>
									<th>공시 일자</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>번호</th>
									<th>제품명</th>
									<th>공시가격</th>
									<th>할인가격</th>
									<th>공시 일자</th>
								</tr>
							</tfoot>

						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- #END# Exportable Table -->
</div>
<style>
.bootstrap-select {
	border: 0px !important;
	border-bottom-width: 0px !important;
}

.bootstrap-select button {
	display: none !important;
}

.theader {
	height: 80px;
}

.table-responsive {
	overflow-x: visible !important;
}
</style>
