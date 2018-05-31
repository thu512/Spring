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
		<h2>네이버 쇼핑</h2>
	</div>
	<!-- Basic Examples -->
	<div class="row clearfix">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="card">

				<div class="body">
					<div class="table-responsive">
						<table
							class="table table-bordered table-striped table-hover js-basic-example1 dataTable"
							data-order='[[ 3, "asc" ]]'>
							<thead>
								<tr>
									<th>이미지</th>
									<th>제품명</th>
									<th>쇼핑몰</th>
									<th>판매가격</th>
									<th>사러가기</th>
								</tr>
							</thead>
							<tbody>

								<c:choose>
									<c:when test="${fn:length(item) == 0}">
										<tr>
											<td colspan=5>조회된 자료가 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="list" items="${item}" varStatus="status">
											<tr>
												<td><img src='<c:out value="${list.image}" />'
													style="width: 150px; height: 150px;"></td>
												<td>${list.title}</td>
												<td>${list.mallName}</td>
												<td>${list.lprice}</td>
												<td><a href='<c:out value="${list.link}" />'>사러가기</a></td>

											</tr>

										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>

						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
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
td{
 vertical-align: middle !important;
}
</style>
<!-- Jquery Core Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/jquery/jquery.min.js"></script>
<script>
	$(function() {
		$('.js-basic-example1').DataTable({
			responsive : true,
			 order: [[ 3, 'asc' ]],
             columnDefs: [
                 {
                     "targets": 3,
                     "render": function(data, row){
                         return parseInt(data)
                     }
                 },{
                	 "targets": 0,
                	 width:"150px"
                	 },
                	 
                 {
                	 "targets": 1,
                	 width:"300px"
                }
                
             ]

		});

	});
</script>

