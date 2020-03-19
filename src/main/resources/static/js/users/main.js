/*!
  * users main JS.
 *
 */
"use strict";
//# sourceURL=main.js

// DOM 加载完再执行
$(function() {

    console.log("233");
    // 获取编辑用户的界面
    $("#user").on("click",".edit-user", function () {
        var u = "/user/edit/" + $(this).attr("userId");
        console.log(u);
        $.ajax({
            url: "/user/edit/" + $(this).attr("userId"),
            success: function(data){
                $("#userFormContainer").html(data);
            },
            error : function() {
                console.log("error");
            }
        });
    });

    // 提交变更后，清空表单
    $("#submitEdit").click(function() {
        $.ajax({
            url: "/user/edit/",
            type: 'POST',
            data:$('#userForm').serialize(),
            success: function(data){
                $('#userForm')[0].reset();
                console.log(data);
                window.location.reload();
            },
            error : function() {
                console.log("error");

            }
        });
    });

    // 删除用户
    $("#user").on("click",".delete-user", function () {
        var r=confirm("确认删除吗？");
        if (r==true)
        {
            $.ajax({
                url: "/user/" + $(this).attr("userId") ,
                type: 'DELETE',
                success: function(data){
                    alert(data.extend.result);
                    window.location.reload();
                },
                error : function() {
                    console.log("error");
                }
            });
        }

    });
});