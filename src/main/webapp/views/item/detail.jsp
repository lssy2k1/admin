<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let item_detail = {
        init:function(){
            $('#register_btn').click(() => {
                item_detail.send();
            })
            $('#delete_btn').click(() => {
                var b = confirm("삭제하실래요?");
                if(b){
                    location.href="/item/deleteimpl?id=${gitem.id}";
                }
            })
        },
        send:function(){
            $('#register_form').attr({
                method:'post',
                action:'/item/updateimpl',
                enctype: 'multipart/form-data'
            });
            $('#register_form').submit();
        }
    };

    // let item_delete = {
    //     init:function(){
    //         $('#delete_btn').click(() => {
    //             let c = confirm("삭제하시겠습니까?");
    //             if(c) {
    //                 item_delete.send();
    //             }
    //         })
    //     },
    //     send:function(){
    //         $('#register_form').attr({
    //             method:'post',
    //             action:'/item/deleteimpl',
    //             enctype: 'multipart/form-data'
    //         });
    //         $('#register_form').submit();
    //     }
    // };
    $(function(){
        item_detail.init();
        //item_delete.init();
    })
</script>

<%--heading----------------------------------------%>
<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Item Detail</h1>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">${gitem.id} Detail</h6>
        </div>
        <div class="card-body">

            <form id="register_form" class="form-horizontal well">
                <input type="hidden" name = "id" value="${gitem.id}">
                <input type="hidden" name = "imgname" value="${gitem.imgname}">
<%--detail을 누르면 img, name, price만 보여진다. 그런데 변경 후 업데이트를 하면 파라미터가 부족
부족한 파라미터를 히든태그로 보내주게 됨...
또한 이미지가 교체되는 경우와 교체 안하는 경우!--%>

                <div class="form-group">
                    <div class="col-sm-10">
                        <img src = "/img/${gitem.imgname}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">NAME:</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" id="name" value="${gitem.name}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="price">PRICE:</label>
                    <div class="col-sm-10">
                        <input type="number" name="price" class="form-control" id="price" value="${gitem.price}">
                    </div>
                    <div class = "col-sm-10" class >
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="img">IMAGE:</label>
                    <div class="col-sm-10">
                        <input type="file" name="img" class="form-control" id="img" placeholder="Input image">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="register_btn" type="button" class="btn btn-default">Update</button>
                        <button id="delete_btn" type="button" class="btn btn-default">Delete</button>

                    </div>
                </div>
            </form>

            <div id="container">
            </div>
        </div>
    </div>
</div>