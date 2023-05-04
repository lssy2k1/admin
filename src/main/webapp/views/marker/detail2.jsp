<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
  let markerss = [];
  let map03 = {
    map: null,
    init: function () {
      this.display();
      $('#s_btn').click(function () {
        map03.removeMarker();
        map03.go(37.5733686, 127.0755721, 's');
      });
      $('#b_btn').click(function () {
        map03.removeMarker();
        map03.go(35.1531696, 129.118666, 'b');
      });
      $('#j_btn').click(function () {
        map03.removeMarker();
        map03.go(33.2501708, 126.5636786, 'j');
      });
    },//end of init
    display: function () {
      var mapContainer = document.querySelector('#map03 > #map');
      var mapOption = {
        center: new kakao.maps.LatLng(37.5333184, 127.0486847), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
      };
      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      map = new kakao.maps.Map(mapContainer, mapOption);


      var mapTypeControl = new kakao.maps.MapTypeControl();
      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
      // 마커가 표시될 위치입니다
      var markerPosition = new kakao.maps.LatLng(37.5333184, 127.0486847);
      var marker = new kakao.maps.Marker({
        position: markerPosition
      });
      markerss.push(marker);
      // 마커가 지도 위에 표시되도록 설정합니다
      marker.setMap(map);
    },
    removeMarker: function removeMarker(map){
      for(let i = 0; i < markerss.length; i++){
        markerss[i].setMap(null);
      }
    },
    go: function (lat, lng, loc) {

      var mapContainer = document.querySelector('#map03 > #map');
      var mapOption = {
        center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
      };

      // // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      // map = new kakao.maps.Map(mapContainer, mapOption);
      // var mapTypeControl = new kakao.maps.MapTypeControl();
      // // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      // map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
      // // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      // var zoomControl = new kakao.maps.ZoomControl();
      // map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

      var moveLatLon = new kakao.maps.LatLng(lat, lng);
      // 지도 중심을 이동 시킵니다
      map.panTo(moveLatLon);
      var markerPosition = new kakao.maps.LatLng(lat, lng);
      var marker = new kakao.maps.Marker({
        position: markerPosition
      });
      markerss.push(marker);
      marker.setMap(map);
      map03.markers(loc);
    },
    markers : function(loc){
      $.ajax({
        url:'/markers',
        data:{'loc':loc},
        success:function(data){
          //alert(data);
          map03.displaymarkers(data);
        }
      });
    },
    displaymarkers: function(positions){
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
      for (var i = 0; i < positions.length; i ++) {
        var imageSize = new kakao.maps.Size(20, 30);
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        var markerPosition = new kakao.maps.LatLng( positions[i].lat, positions[i].lng);
        var marker = new kakao.maps.Marker({
          map: map,
          position: markerPosition,
          title : positions[i].title,
          image : markerImage
        });
        markerss.push(marker);
        // infoWindow
        var iwContent = '<h2>'+positions[i].title+'</h2>';
        iwContent += '<img src="/img/'+positions[i].img+'" style="width:50px">';

        var infowindow = new kakao.maps.InfoWindow({
          position : markerPosition,
          content : iwContent
        });

        kakao.maps.event.addListener(marker, 'mouseover', mouseoverListener(marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', mouseoutListener(marker, infowindow));
        kakao.maps.event.addListener(marker, 'click', mouseclickListener(positions[i].id));


        function mouseoverListener(marker, infowindow) {
          return function(){
            infowindow.open(map, marker);
          };
        }
        function mouseoutListener(marker, infowindow) {
          return function(){
            infowindow.close();
          };
        }
        function mouseclickListener(target) {
          return function(){
            location.href = '/map/detail?id=' +target;
          };
        }
      } // end for
    }
  };
  $(function(){
    map03.init();
  })

</script>
<div class="col-sm-8 text-left">
  <div class="container" id = "map03">
    <h3>Map03</h3>
    <button id= "s_btn" class = "btn" type = "button">seoul</button>
    <button id= "b_btn" class = "btn" type = "button">busan</button>
    <button id= "j_btn" class = "btn" type = "button">jeju</button>
    <div id = "map"></div>
  </div>
</div>