$(function () {
    $(".selectCourseBtn").click(function () {
        //let course_id = $(this).val();
        let course_id = $(this).attr("value");
        console.log("course_id",course_id);
        $.ajax({
            url:"/popmoney",
            data:{
                "id":course_id
            },
            type:"post",
            success:function (res) {
                console.log(res);
                console.log(res.extend.result);
                if(res.code===100){
                    alert(res.extend.result);
                    //选课
                    $.ajax({
                        url:"/addSelectCourse",
                        data:{
                            "id":course_id
                        },
                        type:"post",
                        success:function (res) {
                            console.log(res);
                            if(res.code===100){
                                alert("买课成功!");
                            }
                            if(res.code===200){
                                alert(res.extend.result);
                            }
                        }
                    })
                }
                if(res.code===200){
                    alert(res.extend.result);
                }
            }
        });



    })

    // $(".course-name").click(function () {
    //     let course_id = $(this).siblings("#course_id").attr("value");
    //     console.log(course_id);
    //
    //
    //
    // })

})