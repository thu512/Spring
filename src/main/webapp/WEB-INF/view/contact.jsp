<%--
  Created by IntelliJ IDEA.
  User: lcj
  Date: 2018. 5. 31.
  Time: 오후 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c8964b99151f984719d62be2219a1c85&libraries=services"></script>

<div class="container-fluid">
    <div class="block-header">
        <h2>Contact</h2>
    </div>
    <div class="row clearfix">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="card">
                <div class="header">
                    <h2>Introduce</h2>

                </div>
                <div class="body">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item">
                                <img src="/AdminBSBMaterialDesign-master/img/gsitm.jpg" style="width:100%; height: 546px;"/>
                            </div>
                            <div class="item active">
                                <img src="/AdminBSBMaterialDesign-master/img/GS_SHOP_logo.png" style="width:100%; height: 546px;"/>
                            </div>

                            <div class="item">
                                <img src="/AdminBSBMaterialDesign-master/img/home.jpeg" style="width:100%; height: 546px;"/>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button"
                           data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button"
                           data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Basic Examples -->
    <div class="block-header">
        <h2>오시는 위치</h2>
    </div>
    <div class="row clearfix">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="card">
                <div id="map" style="width:100%;height:400px;"></div>

                <script>
                    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                        mapOption = {
                            center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                            level: 4 // 지도의 확대 레벨
                        };

                    // 지도를 생성합니다
                    var map = new daum.maps.Map(mapContainer, mapOption);

                    // 주소-좌표 변환 객체를 생성합니다
                    var geocoder = new daum.maps.services.Geocoder();

                    // 주소로 좌표를 검색합니다
                    geocoder.addressSearch('경기도 남양주시 퇴계원로 19', function (result, status) {

                        // 정상적으로 검색이 완료됐으면
                        if (status === daum.maps.services.Status.OK) {

                            var coords = new daum.maps.LatLng(result[0].y, result[0].x);

                            // 결과값으로 받은 위치를 마커로 표시합니다
                            var marker = new daum.maps.Marker({
                                map: map,
                                position: coords
                            });

                            // 인포윈도우로 장소에 대한 설명을 표시합니다
                            var infowindow = new daum.maps.InfoWindow({
                                content: '<div style="width:150px;text-align:center;padding:6px 0;">이창주</div>'
                            });
                            infowindow.open(map, marker);

                            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                            map.setCenter(coords);
                        }
                    });
                </script>
            </div>
        </div>
    </div>
</div>

