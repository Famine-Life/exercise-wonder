$(function () {
   $(".pushmoney-btn").click(function () {
        let money = $("#money").val();
        console.log(money);
        $.ajax({
            url:"pushmoney",
            data:{
                money:money
            },
            type:"post",
            success:function (res) {
                console.log(res);
                if(res.code===100){
                    alert("充值成功!");
                    window.location.reload();
                }
                if(res.code===200){
                    alert(res.extend.result);
                    window.location.reload();
                }
            }
        });
   })

})