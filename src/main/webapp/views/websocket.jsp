<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    #all {
        width: 400px;
        height: 200px;
        overflow: auto;
        border: 2px solid red;
    }

    #me {
        width: 400px;
        height: 200px;
        overflow: auto;
        border: 2px solid blue;
    }

    #to {
        width: 400px;
        height: 200px;
        overflow: auto;
        border: 2px solid green;
    }
</style>

<script>
    let websocket = {
        id:null,
        stompClient:null,
        init:function(){
            this.id = $('#adm_id').text();
            $("#connect").click(function() {
                websocket.connect();
            });
            $("#disconnect").click(function() {
                websocket.disconnect();
            });
            $("#sendall").click(function() {
                websocket.sendAll();
            });
            $("#sendme").click(function() {
                websocket.sendMe();
            });
            $("#sendto").click(function() {
                websocket.sendTo();
            });
        },
        connect:function(){
            var sid = this.id;
            var socket = new SockJS('${adminserver}/ws');
            // SockJS는 웹소켓을 지원하지 않는 브라우저에서도 웹소켓과 유사한 방식으로 통신할 수 있게 해주는 js라이브러리
            this.stompClient = Stomp.over(socket);
            // Stomp는 웹소켓 프로토콜을 사용하는 메시징 서비스를 제공.(Simple Text Oriented Messaging Protocol)

            this.stompClient.connect({}, function(frame) {
                //첫 번째 매개변수는 연결 설정 객체, STOMP 메시지 브로커와의 인증을 위한 정보를 제공합니다.
                //두 번째 매개변수는 연결이 성공했을 때 실행될 콜백 함수입니다. 서버에서 전송한 메시지를 수신하기 위해 콜백 함수를 등록합니다.
                websocket.setConnected(true);
                console.log('Connected: ' + frame);
                this.subscribe('/send', function(msg) {
                    //두번째 매개변수 function(msg)는
                    //메시지가 도착했을 때 호출할 콜백 함수입니다. 이 함수는 서버에서 보낸 메시지를 전달받습니다
                    $("#all").prepend(
                        "<h4>" + JSON.parse(msg.body).sendid +":"+
                        JSON.parse(msg.body).content1
                        + "</h4>");
                });
                this.subscribe('/send/'+sid, function(msg) {
                    $("#me").prepend(
                        "<h4>" + JSON.parse(msg.body).sendid +":"+
                        JSON.parse(msg.body).content1+ "</h4>");
                });
                this.subscribe('/send/to/'+sid, function(msg) {
                    $("#to").prepend(
                        "<h4>" + JSON.parse(msg.body).sendid +":"+
                        JSON.parse(msg.body).content1
                        + "</h4>");
                });
            });
        },
        disconnect:function(){
            if (this.stompClient !== null) {
                this.stompClient.disconnect();
            }
            websocket.setConnected(false);
            console.log("Disconnected");
        },
        setConnected:function(connected){
            if (connected) {
                $("#status").text("Connected");
            } else {
                $("#status").text("Disconnected");
            }
        },
        sendAll:function(){
            var msg = JSON.stringify({
                'sendid' : this.id,
                'content1' : $("#alltext").val()
            });
            this.stompClient.send("/receiveall", {}, msg);
        },
        //sendid와 content1 데이터를 JSON.stringify로 JSON객체로 만들고 msg 변수에 대입.
        //stompClient.send로 정보 전송. 받을 주소는 /receiveall, 헤더는 공백, 데이터는 msg
        sendTo:function(){
            var msg = JSON.stringify({
                'sendid' : this.id,
                'receiveid' : $('#target').val(),
                'content1' : $('#totext').val()
            });
            this.stompClient.send('/receiveto', {}, msg);
        },
        sendMe:function(){
            var msg = JSON.stringify({
                'sendid' : this.id,
                'content1' : $('#metext').val()
            });
            this.stompClient.send("/receiveme", {}, msg);
        }
    };
    $(function(){
        websocket.init();
    })

</script>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">WebSocket</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">WebSocket</h6>
        </div>
        <div class="card-body">
            <div id="container"></div>
            <div class="col-sm-5">
                <h1 id="adm_id">${loginadm.id}</h1>
                <H1 id="status">Status</H1>
                <button id="connect">Connect</button>
                <button id="disconnect">Disconnect</button>

                <h3>All</h3>
                <input type="text" id="alltext"><button id="sendall">Send</button>
                <div id="all"></div>

                <h3>Me</h3>
                <input type="text" id="metext"><button id="sendme">Send</button>
                <div id="me"></div>

                <h3>To</h3>
                <input type="text" id="target">
                <input type="text" id="totext"><button id="sendto">Send</button>
                <div id="to"></div>

            </div>
        </div>
    </div>
    <!-- /.container-fluid -->
</div>