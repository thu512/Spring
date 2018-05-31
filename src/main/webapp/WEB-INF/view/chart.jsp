<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
		src="/AdminBSBMaterialDesign-master/plugins/jquery/jquery.min.js"></script>
<div class="row clearfix">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="card">
			<div class="header">
				<h2>월별 제품군별 평균 가격</h2>

			</div>
			<div class="body">
				<canvas id="line_chart" height="150"></canvas>
			</div>
		</div>
	</div>
</div>
<!-- Jquery Core Js -->

<script>
$(function () {
    new Chart(document.getElementById("line_chart").getContext("2d"), getChartJs('line'));
    
});

function getChartJs(type) {
    var config = null;
    var labels = new Array();
    var data = new Array();
    var data2 = new Array();
    <c:forEach var="list" items="${data}" varStatus="status">
    	labels.push('<c:out value="${list.name}" />');
    	data.push('<c:out value="${list.price}" />');
		
	</c:forEach>
	<c:forEach var="list" items="${data2}" varStatus="status">
		
		data2.push('<c:out value="${list.price}" />');
	
	</c:forEach>
	
    if (type === 'line') {
        config = {
            type: 'line',
            data: {
                labels: labels,
                datasets: [{
                	label: "4월",
                    data: data,
                    borderColor: 'rgba(0, 188, 212, 0.75)',
                    backgroundColor: 'rgba(0, 188, 212, 0.3)',
                    pointBorderColor: 'rgba(0, 188, 212, 0)',
                    pointBackgroundColor: 'rgba(0, 188, 212, 0.9)',
                    pointBorderWidth: 1
                },
                {
                	label: "3월",
                    data: data2,
                    borderColor: 'rgba(233, 30, 99, 0.75)',
                    backgroundColor: 'rgba(233, 30, 99, 0.3)',
                    pointBorderColor: 'rgba(233, 30, 99, 0)',
                    pointBackgroundColor: 'rgba(233, 30, 99, 0.9)',
                    pointBorderWidth: 1
                }]
            },
            options: {
                responsive: true,
                legend: false
            }
        }
    }
    
    return config;
}

</script>

