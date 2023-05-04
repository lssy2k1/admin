<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let marker_add = {
        init:function(){
            $('#register_btn').click(() => {
                marker_add.send();
            })
        },
        send:function(){
            $('#register_form').attr({
                method:'post',
                action:'/marker/addimpl',
                enctype: 'multipart/form-data'
            });
            $('#register_form').submit();
        }
    };

    $(function(){
        marker_add.init();
    })
</script>

<%--heading----------------------------------------%>
<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Marker Add</h1>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Marker Add</h6>
        </div>
        <div class="card-body">

            <form id="register_form" class="form-horizontal well">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="title">TITLE:</label>
                    <div class="col-sm-10">
                        <input type="text" name="title" class="form-control" id="title" placeholder="Enter title">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="target">TARGET:</label>
                    <div class="col-sm-10">
                        <input type="text" name="target" class="form-control" id="target" placeholder="Enter target">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lat">LAT:</label>
                    <div class="col-sm-10">
                        <input type="text" name="lat" class="form-control" id="lat" placeholder="Enter lat">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lng">LNG:</label>
                    <div class="col-sm-10">
                        <input type="text" name="lng" class="form-control" id="lng" placeholder="Enter lng">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="loc">LOC:</label>
                    <div class="col-sm-10">
                        <input type="text" name="loc" class="form-control" id="loc" placeholder="Enter loc">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="imgfile">IMG FILE:</label>
                    <div class="col-sm-10">
                        <input type="file" name="imgfile" class="form-control" id="imgfile" placeholder="Input imgfile">
                    </div>
                </div>

<%--button-----------------------------button----------------------------------%>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="register_btn" type="button" class="btn btn-default">Register</button>
                    </div>
                </div>
            </form>

            <div id="container">
            </div>
        </div>
    </div>
</div>