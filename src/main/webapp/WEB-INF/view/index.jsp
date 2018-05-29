<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Welcome To | Bootstrap Based Admin Template - Material
	Design</title>
<!-- Favicon-->
<link rel="icon" href="favicon.ico" type="image/x-icon">

<!-- Google Fonts -->
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
</head>

<body class="theme-red">
	<!-- Page Loader -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="preloader">
				<div class="spinner-layer pl-red">
					<div class="circle-clipper left">
						<div class="circle"></div>
					</div>
					<div class="circle-clipper right">
						<div class="circle"></div>
					</div>
				</div>
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<!-- #END# Page Loader -->
	<!-- Overlay For Sidebars -->
	<div class="overlay"></div>
	<!-- #END# Overlay For Sidebars -->
	<!-- Search Bar -->
	<div class="search-bar">
		<div class="search-icon">
			<i class="material-icons">search</i>
		</div>
		<input type="text" placeholder="START TYPING...">
		<div class="close-search">
			<i class="material-icons">close</i>
		</div>
	</div>
	<!-- #END# Search Bar -->
	<!-- Top Bar -->
	<nav class="navbar">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="javascript:void(0);" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse"
					aria-expanded="false"></a> <a href="javascript:void(0);"
					class="bars"></a> <a class="navbar-brand" href="index.html"><img
					src="/AdminBSBMaterialDesign-master/img/GS_SHOP_logo.png"
					style="width: 170px; height: 60px; margin-top: -20px;"></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<!-- Call Search -->
					<li><a href="javascript:void(0);" class="js-search"
						data-close="true"><i class="material-icons">search</i></a></li>
					<!-- #END# Call Search -->


					<li class="pull-right"><a href="javascript:void(0);"
						class="js-right-sidebar" data-close="true"><i
							class="material-icons">more_vert</i></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- #Top Bar -->
	<section>
		<!-- Left Sidebar -->
		<aside id="leftsidebar" class="sidebar">
			<!-- User Info -->
			<div class="user-info">
				<div class="image"></div>
				<div class="info-container">
					<div class="name" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">John Doe</div>
					<div class="email">john.doe@example.com</div>
					<div class="btn-group user-helper-dropdown">
						<i class="material-icons" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
						<ul class="dropdown-menu pull-right">

							<li><a href="javascript:void(0);"><i
									class="material-icons">input</i>Sign Out</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- #User Info -->
			<!-- Menu -->
			<div class="menu">
				<ul class="list">
					<li class="header">MAIN NAVIGATION</li>

					<li class="active"><a href="javascript:void(0);"
						class="menu-toggle"> <i class="material-icons">view_list</i> <span>Tables</span>
					</a>
						<ul class="ml-menu">
							<li><a href="pages/tables/normal-tables.html">분류 리스트</a></li>
							<li><a href="pages/tables/jquery-datatable.html">상품 리스트</a>
							</li>
							<li><a href="pages/tables/editable-table.html">네이버 쇼핑
									리스트</a></li>
						</ul></li>

					<li><a href="javascript:void(0);" class="menu-toggle"> <i
							class="material-icons">pie_chart</i> <span>Charts</span>
					</a>
						<ul class="ml-menu">
							<li><a href="pages/charts/morris.html">Morris</a></li>
							<li><a href="pages/charts/flot.html">Flot</a></li>
							<li><a href="pages/charts/chartjs.html">ChartJS</a></li>
							<li><a href="pages/charts/sparkline.html">Sparkline</a></li>
							<li><a href="pages/charts/jquery-knob.html">Jquery Knob</a>
							</li>
						</ul></li>


				</ul>
			</div>
			<!-- #Menu -->
			<!-- Footer -->
			<div class="legal">
				<div class="copyright">
					&copy; 2018 - 2019 <a href="javascript:void(0);">LCJ - Material
						Design</a>.
				</div>
				<div class="version">
					<b>Version: </b> 1.0.0
				</div>
			</div>
			<!-- #Footer -->
		</aside>
		<!-- #END# Left Sidebar -->
		<!-- Right Sidebar -->
		<aside id="rightsidebar" class="right-sidebar">
			<ul class="nav nav-tabs tab-nav-right" role="tablist">
				<li role="presentation" class="active"><a href="#skins"
					data-toggle="tab">SKINS</a></li>

			</ul>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane fade in active in active"
					id="skins">
					<ul class="demo-choose-skin">
						<li data-theme="red" class="active">
							<div class="red"></div> <span>Red</span>
						</li>
						<li data-theme="pink">
							<div class="pink"></div> <span>Pink</span>
						</li>
						<li data-theme="purple">
							<div class="purple"></div> <span>Purple</span>
						</li>
						<li data-theme="deep-purple">
							<div class="deep-purple"></div> <span>Deep Purple</span>
						</li>
						<li data-theme="indigo">
							<div class="indigo"></div> <span>Indigo</span>
						</li>
						<li data-theme="blue">
							<div class="blue"></div> <span>Blue</span>
						</li>
						<li data-theme="light-blue">
							<div class="light-blue"></div> <span>Light Blue</span>
						</li>
						<li data-theme="cyan">
							<div class="cyan"></div> <span>Cyan</span>
						</li>
						<li data-theme="teal">
							<div class="teal"></div> <span>Teal</span>
						</li>
						<li data-theme="green">
							<div class="green"></div> <span>Green</span>
						</li>
						<li data-theme="light-green">
							<div class="light-green"></div> <span>Light Green</span>
						</li>
						<li data-theme="lime">
							<div class="lime"></div> <span>Lime</span>
						</li>
						<li data-theme="yellow">
							<div class="yellow"></div> <span>Yellow</span>
						</li>
						<li data-theme="amber">
							<div class="amber"></div> <span>Amber</span>
						</li>
						<li data-theme="orange">
							<div class="orange"></div> <span>Orange</span>
						</li>
						<li data-theme="deep-orange">
							<div class="deep-orange"></div> <span>Deep Orange</span>
						</li>
						<li data-theme="brown">
							<div class="brown"></div> <span>Brown</span>
						</li>
						<li data-theme="grey">
							<div class="grey"></div> <span>Grey</span>
						</li>
						<li data-theme="blue-grey">
							<div class="blue-grey"></div> <span>Blue Grey</span>
						</li>
						<li data-theme="black">
							<div class="black"></div> <span>Black</span>
						</li>
					</ul>
				</div>

			</div>
		</aside>
		<!-- #END# Right Sidebar -->
	</section>

	<section class="content">
		<div class="container-fluid">

			<!-- 메인 섹션 -->
			<tiles:insertAttribute name="body" />

		</div>
	</section>

	<!-- Jquery Core Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Select Plugin Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/bootstrap-select/js/bootstrap-select.js"></script>

	<!-- Slimscroll Plugin Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/node-waves/waves.js"></script>

	<!-- Jquery CountTo Plugin Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/jquery-countto/jquery.countTo.js"></script>

	<!-- Morris Plugin Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/raphael/raphael.min.js"></script>
	<script src="/AdminBSBMaterialDesign-master/plugins/morrisjs/morris.js"></script>

	<!-- ChartJs -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/chartjs/Chart.bundle.js"></script>

	<!-- Flot Charts Plugin Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/flot-charts/jquery.flot.js"></script>
	<script
		src="/AdminBSBMaterialDesign-master/plugins/flot-charts/jquery.flot.resize.js"></script>
	<script
		src="/AdminBSBMaterialDesign-master/plugins/flot-charts/jquery.flot.pie.js"></script>
	<script
		src="/AdminBSBMaterialDesign-master/plugins/flot-charts/jquery.flot.categories.js"></script>
	<script
		src="/AdminBSBMaterialDesign-master/plugins/flot-charts/jquery.flot.time.js"></script>

	<!-- Sparkline Chart Plugin Js -->
	<script
		src="/AdminBSBMaterialDesign-master/plugins/jquery-sparkline/jquery.sparkline.js"></script>
	<!-- Demo Js -->
	<script src="/AdminBSBMaterialDesign-master/js/demo.js"></script>

	<!-- Custom Js -->
	<script src="/AdminBSBMaterialDesign-master/js/admin.js"></script>
	<script src="/AdminBSBMaterialDesign-master/js/pages/index.js"></script>


</body>

</html>