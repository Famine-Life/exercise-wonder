/**
 * 签到
 **/

$(function () {
    $("#qd_btn").click(function () {
        $.ajax({
            url:"qd",
            type:"post",
            success:function (res) {
                console.log(res);
                if(res==="success"){
                    alert("签到成功!");
                    //刷新页面
                    window.location.reload();
                }
                if(res==="isQded"){
                    alert("你已经签到过了！");
                }
            }
        });
    });

})