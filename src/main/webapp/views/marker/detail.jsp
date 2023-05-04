<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f15191dfbc91ce9a8cbdd265aeabcf7e"></script>--%>

<style>
    #marker_map > #map{
        width : 500px;
        height : 500px;
        border : 2px solid red;
    }
</style>
<script>
    let marker_detail = {
        init:function(){
            $('#register_btn').click(() => {
                marker_detail.send();
            })
            $('#delete_btn').click(() => {
                var b = confirm("삭제하실래요?");
                if(b){
                    location.href="/marker/deleteimpl?id=${marker.id}";
                }
            })
        },
        send:function(){
            $('#register_form').attr({
                method:'post',
                action:'/marker/updateimpl',
                enctype: 'multipart/form-data'
            });
            $('#register_form').submit();
        }
    };
    let marker_map = {
        map: null,
        init: function () {
            this.display();
        },
        display: function () {
            var mapContainer = document.querySelector('#marker_map > #map');
            var mapOption = {
                center: new kakao.maps.LatLng(${marker.lat}, ${marker.lng}),
                level: 8
            };
            map = new kakao.maps.Map(mapContainer, mapOption);
///////
            var mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
            var markerPosition = new kakao.maps.LatLng(${marker.lat}, ${marker.lng});
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);
/////
            var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
            var imageSize = new kakao.maps.Size(20, 30);
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
            var markerPosition = new kakao.maps.LatLng(${marker.lat}, ${marker.lng});
            var marker = new kakao.maps.Marker({
                map: map,
                position: markerPosition,
                title : ${marker.title},
                image : markerImage
            });
/////
<%--            var iwContent = '<h2>'+"${marker.title}"+'</h2>';--%>
<%--            iwContent += '<img src="/img/${marker.img} style="width:50px">';--%>

<%--            var infowindow = new kakao.maps.InfoWindow({--%>
<%--                position : markerPosition,--%>
<%--                content : iwContent--%>
<%--            });--%>
<%--            kakao.maps.event.addListener(marker, 'mouseover', () => {--%>
<%--                infowindow.open(map,marker);--%>
<%--            });--%>
<%--            kakao.maps.event.addListener(marker, 'mouseout', () => {--%>
<%--                infowindow.close();--%>
<%--            });--%>
<%--            kakao.maps.event.addListener(marker, 'click', () => {--%>
<%--                location.href = '/marker/detail?id='+${marker.target};--%>
<%--            });--%>
        }
    };
    $(function(){
        marker_detail.init();
        marker_map.init();
    })
</script>
<%--heading----------------------------------------%>
<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Marker Detail</h1>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">${marker.id} Detail</h6>
        </div>
        <div class="card-body">

            <form id="register_form" class="form-horizontal well">
                <input type="hidden" name = "id" value="${marker.id}">
                <input type="hidden" name = "img" value="${marker.img}">
                <div class="form-group">
                    <div class="col-sm-10">
                        <img src = "/img/${marker.img}" style ="width : 500px; height : 500px">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="title">TITLE:</label>
                    <div class="col-sm-10">
                        <input type="text" name="title" class="form-control" id="title" value="${marker.title}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="target">TARGET:</label>
                    <div class="col-sm-10">
                        <input type="text" name="target" class="form-control" id="target" value="${marker.target}">
                    </div>
                    <div class = "col-sm-10" class >
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lat">LAT:</label>
                    <div class="col-sm-10">
                        <input type="text" name="lat" class="form-control" id="lat" value="${marker.lat}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lng">LNG:</label>
                    <div class="col-sm-10">
                        <input type="text" name="lng" class="form-control" id="lng" value="${marker.lng}">
                    </div>
                    <div class = "col-sm-10" class >
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="loc">LOC:</label>
                    <div class="col-sm-10">
                        <input type="text" name="loc" class="form-control" id="loc" value="${marker.loc}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="imgfile">IMGFILE:</label>
                    <div class="col-sm-10">
                        <input type="file" name="imgfile" class="form-control" id="imgfile">
                    </div>
                </div>


<%--button -----------------------------button ----------------------------button--%>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="register_btn" type="button" class="btn btn-default">Update</button>
                        <button id="delete_btn" type="button" class="btn btn-default">Delete</button>

                    </div>
                </div>
            </form>

            <div id="container">
            </div>
<%--            지도--------------------------------------------------%>
            <div class="col-sm-8 text-left">
                <div class="container" id = "marker_map">
                    <h3>MARKER MAP</h3>
                    <div id = "map"></div>
                </div>
            </div>
        </div>
    </div>
</div>