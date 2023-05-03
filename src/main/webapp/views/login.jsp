<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let login_form = {
        init : function(){
            $('#login_btn').click(function(){
                login_form.send();
            });
        },
        send : function(){
            $('#login_form').attr({
                'action':'/loginimpl',//MainController로 요청을 보낸다.
                'method':'get'
            });
            $('#login_form').submit();
        }
    };
    $(function(){
        login_form.init()
    });
</script>

<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Login</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Login</h6>
        </div>
        <div class="card-body">

            <div id="container">

                <form id = "login_form" class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id">id:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label><input type="checkbox" name="remember"> Remember me</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type = "button" id = "login_btn" class="btn btn-warning">Login</button>
                        </div>
                    </div>
                </form>

            </div>

        </div>
    </div>

</div>
<!-- /.container-fluid -->
