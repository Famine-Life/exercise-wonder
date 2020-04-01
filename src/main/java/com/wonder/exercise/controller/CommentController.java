package com.wonder.exercise.controller;


import com.wonder.exercise.entity.User;
import com.wonder.exercise.entity.comment;
import com.wonder.exercise.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 评论功能控制器
 */
@Controller
public class CommentController {

    @Autowired
    comment commentBean;

    @Autowired
    CommentService commentService;


    /**
     *  发布评论，0失败，1成功，2未登录
     * @param course_id
     * @param comment
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @PostMapping(value = "comment")
    public Map comment(@RequestParam(value = "id") Integer course_id,
                       @RequestParam(value = "context") String comment,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        User userInfo = (User)request.getSession().getAttribute("userInfo");
        System.out.println(course_id+"\n"+comment);

        Map<String,Object> map = new HashMap<>();
        if(userInfo==null){
            map.put("code",2);
            map.put("msg","请先登录!");
            return map;
        }

        commentBean.setId(null);
        commentBean.setUserId(userInfo.getId());
        commentBean.setCourseId(course_id);
        commentBean.setComment(comment);
        commentBean.setCommentTime(new Timestamp(System.currentTimeMillis()));
        int i = commentService.insertSelective(commentBean);
        if(i!=1){
            map.put("code",0);
            map.put("msg","评论失败，请重新评论!");
            return map;
        }
        map.put("code",1);
        map.put("msg","评论成功！");

        return map;
    }

}
