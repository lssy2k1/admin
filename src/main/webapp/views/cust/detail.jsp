<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let cust_update = {
        init:function(){
            $('#update_btn').click(() => {
                cust_update.send();
            })
        },
        send:function(){
            $('#update_form').attr({
                method:'post',
                action:'/cust/updateimpl'
            });
            $('#update_form').submit();
        }
    };
    let cust_delete = {
        init:function(){
            $('#delete_btn').click(() => {
                let a = confirm("삭제하시겠습니까?");
                if (a) {
                    cust_delete.send();
                }
            })
        },
        send:function(){
            $('#update_form').attr({
                method:'post',
                action:'/cust/deleteimpl'
            });
            $('#update_form').submit();
        }
    };
    $(function(){
        cust_update.init();
        cust_delete.init();
    })
</script>


<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Cust Add</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Cust Add</h6>
        </div>
        <div class="card-body">

            <form id="update_form" class="form-horizontal well">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id">ID:</label>
                    <div class="col-sm-10">
                        <input type="text" name="id" class="form-control" id="id" value="${dcust.id}" readOnly>
                    </div>
                    <div class = "col-sm-10" class >
                        <span id = "check_id" class = "bg-danger"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd">Password:</label>
                    <div class="col-sm-10">
                        <input type="password" name="pwd" class="form-control" id="pwd">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">NAME:</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" id="name" value="${dcust.name}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="update_btn" type="button" class="btn btn-default">Update</button>
                        <button id="delete_btn" type="button" class="btn btn-default">Delete</button>
                    </div>
                </div>
            </form>

            <div id="container">
            </div>
        </div>
    </div>
</div>