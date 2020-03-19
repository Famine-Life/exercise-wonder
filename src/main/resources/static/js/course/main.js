/*!
  * course main JS.
 *
 */
"use strict";
//# sourceURL=main.js

// DOM 加载完再执行
$(function() {

    console.log("233");
    // 获取编辑用户的界面
    $("#course").on("click",".edit-course", function () {
        var u = "/course/edit/" + $(this).attr("courseId");
        console.log(u);
        $.ajax({
            url: "/course/edit/" + $(this).attr("courseId"),
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
            url: "/course/edit/",
            type: 'POST',
            data:$('#courseForm').serialize(),
            success: function(data){
                $('#courseForm')[0].reset();
                alert(data);
                window.location.reload();
            },
            error : function() {
                console.log("error");

            }
        });
    });

    // 删除用户
    $("#course").on("click",".delete-course", function () {
        var r=confirm("确认删除吗？");
        if (r==true)
        {
            $.ajax({
                url: "/course/" + $(this).attr("courseId") ,
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


    $("#projectId  option[value='s2'] ").attr("selected",true)

});