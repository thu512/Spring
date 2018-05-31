<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- #END# Widgets -->
<!-- Google Fonts -->
<head>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">

<!-- Bootstrap Core Css -->
<link
	href="/AdminBSBMaterialDesign-master/plugins/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Waves Effect Css -->
<link href="/AdminBSBMaterialDesign-master/plugins/node-waves/waves.css"
	rel="stylesheet" />

<!-- Animation Css -->
<link
	href="/AdminBSBMaterialDesign-master/plugins/animate-css/animate.css"
	rel="stylesheet" />

<!-- Morris Chart Css-->
<link href="/AdminBSBMaterialDesign-master/plugins/morrisjs/morris.css"
	rel="stylesheet" />

<!-- Custom Css -->
<link href="/AdminBSBMaterialDesign-master/css/style.css"
	rel="stylesheet">

<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
<link href="/AdminBSBMaterialDesign-master/css/themes/all-themes.css"
	rel="stylesheet" />
<!-- JQuery DataTable Css -->
<link
	href="/AdminBSBMaterialDesign-master/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css"
	rel="stylesheet">
</head>

            <!-- CPU Usage -->
            <div class="row clearfix">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="card">
                        <div class="header">
                            <div class="row clearfix">
                                <div class="col-xs-12 col-sm-6">
                                    <h2>CPU USAGE (%)</h2>
                                </div>
                                <div class="col-xs-12 col-sm-6 align-right">
                                    <div class="switch panel-switch-btn">
                                        <span class="m-r-10 font-12">REAL TIME</span>
                                        <label>OFF<input type="checkbox" id="realtime" checked><span class="lever switch-col-cyan"></span>ON</label>
                                    </div>
                                </div>
                            </div>
                            <ul class="header-dropdown m-r--5">
                                <li class="dropdown">
                                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                        <i class="material-icons">more_vert</i>
                                    </a>
                                    <ul class="dropdown-menu pull-right">
                                        <li><a href="javascript:void(0);">Action</a></li>
                                        <li><a href="javascript:void(0);">Another action</a></li>
                                        <li><a href="javascript:void(0);">Something else here</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="body">
                            <div id="real_time_chart" class="dashboard-flot-chart"></div>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- #END# CPU Usage -->
            <!-- Jquery Core Js -->
            <script
		src="/AdminBSBMaterialDesign-master/plugins/jquery/jquery.min.js"></script>
	<script>
	$(function () {
	    //Widgets count
	    $('.count-to').countTo();

	    //Sales count to
	    $('.sales-count-to').countTo({
	        formatter: function (value, options) {
	            return '$' + value.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, ' ').replace('.', ',');
	        }
	    });

	    initRealTimeChart();
	    
	});
	var realtime = 'on';
	function initRealTimeChart() {
	    //Real time ==========================================================================================
	    var plot = $.plot('#real_time_chart', [getRandomData()], {
	        series: {
	            shadowSize: 0,
	            color: 'rgb(0, 188, 212)'
	        },
	        grid: {
	            borderColor: '#f3f3f3',
	            borderWidth: 1,
	            tickColor: '#f3f3f3'
	        },
	        lines: {
	            fill: true
	        },
	        yaxis: {
	            min: 0,
	            max: 100
	        },
	        xaxis: {
	            min: 0,
	            max: 100
	        }
	    });

	    function updateRealTime() {
	        plot.setData([getRandomData()]);
	        plot.draw();

	        var timeout;
	        if (realtime === 'on') {
	            timeout = setTimeout(updateRealTime, 320);
	        } else {
	            clearTimeout(timeout);
	        }
	    }

	    updateRealTime();

	    $('#realtime').on('change', function () {
	        realtime = this.checked ? 'on' : 'off';
	        updateRealTime();
	    });
	    //====================================================================================================
	}
	var data = [], totalPoints = 110;
	function getRandomData() {
	    if (data.length > 0) data = data.slice(1);

	    while (data.length < totalPoints) {
	        var prev = data.length > 0 ? data[data.length - 1] : 50, y = prev + Math.random() * 10 - 5;
	        if (y < 0) { y = 0; } else if (y > 100) { y = 100; }

	        data.push(y);
	    }

	    var res = [];
	    for (var i = 0; i < data.length; ++i) {
	        res.push([i, data[i]]);
	    }

	    return res;
	}
	</script>
   

            