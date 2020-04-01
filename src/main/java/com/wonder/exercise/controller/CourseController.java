package com.wonder.exercise.controller;

import com.wonder.exercise.entity.*;
import com.wonder.exercise.response.Msg;
import com.wonder.exercise.service.*;
import com.wonder.exercise.util.RoleEnum;
import com.wonder.exercise.vo.commentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理课程相关的请求
 */
@Controller
public class CourseController {

    @Autowired
    CommentService commentService;

    @Autowired
    CourseService courseService;

    @Autowired
    UserSelectCourseService userSelectCourseService;

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    /**
     * 返回所有课程信息页面
     * @return
     */
    @GetMapping("courses")
    public String getCourse(HttpServletRequest request, Model model){
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList",courseList);

        return "courses/courses";
    }



    /**
     * 获取当前登录账号的课程信息
     * @return
     */
    @GetMapping("getLoginUserCourse")
    public String getLoginUserCourse(HttpServletRequest request, Model model){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        //未登录则跳转到登录页面
        if(userInfo==null){
            return "redirect:/login";
        }
        Integer role = userInfo.getRole();
        String role_name = RoleEnum.ROLETYPE.values()[role].name();
        List<Course> courseList = new ArrayList<>();
//        System.out.println("test:"+role_name);
        //如果是老师则从课程table里取
        if(role_name.equals("teacher")){
           courseList = courseService.selectByUser(userInfo);
        }else{
            //否则都从选课表中取
            List<UserSelectCourse> userSelectCoursesList = userSelectCourseService.selectByUserId(userInfo.getId());
            for (UserSelectCourse userSelectCourse: userSelectCoursesList) {
                Course course = courseService.selectByPrimaryKey(userSelectCourse.getCourseId());
                courseList.add(course);
            }
        }
        //测试用的
        for (Course c:courseList) {
            System.out.println("课程列表：");
            System.out.println(c.toString());
        }

        model.addAttribute("courseList",courseList);
        //model.addAttribute("nowDayCourseList",courseList);
        return "user/userCourseInfo";
    }


    /**
     * 返回添加课程页面，并插入输入到model
     * @param request
     * @param model
     * @return
     */
    @GetMapping("addCourse")
    public String toAddCourse(HttpServletRequest request, Model model){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if (userInfo==null){
            return "redirect:/login";
        }
        String roleName = (String) request.getSession().getAttribute("roleName");
        //如果当前身份不是是老师，或者管理员
        if(!roleName.equals("teacher")&&!roleName.equals("admin")){
            return "redirect:/403"; //权限不足
        }
        List<Project> projectList = projectService.selectAll();
        model.addAttribute("projectList",projectList);


        return "courses/addCourse";
    }



    /**
     * 添加课程  "Course{" +
     *                 "id=" + id +
     *                 ", name='" + name + '\'' +
     *                 ", text='" + text + '\'' +
     *                 ", projectId=" + projectId +
     *                 ", startTime=" + startTime +
     *                 ", endTime=" + endTime +
     *                 ", placeId=" + placeId +
     *                 ", courseTime=" + courseTime +
     *                 ", userId=" + userId +
     *                 ", money=" + money +
     *                 ", img='" + img + '\'' +
     *                 ", delFlag=" + delFlag +
     *                 ", createTime=" + createTime +
     *                 ", updateTime=" + updateTime +
     *                 '}';
     * @param course
     * @param request
     * @param model
     * @return
     */
    @PostMapping("addCourse")
    public String addCourse(Course course,HttpServletRequest request, Model model){
        System.out.println("add Course:"+course.toString());
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if (userInfo==null){
            return "redirect:/login";
        }
//        Integer role = userInfo.getRole();
//        String role_name = RoleEnum.ROLETYPE.values()[role].name();
        String roleName = (String) request.getSession().getAttribute("roleName");
        //如果当前身份不是是老师，或者管理员
        if(!roleName.equals("teacher")&&!roleName.equals("admin")){
            return "redirect:/403"; //权限不足
        }
        course.setId(null);
        course.setUserId(userInfo.getId());
        course.setImg("/images/yoga-1842292_640.jpg");
        course.setDelFlag(0);
        course.setStartTime(new Timestamp(System.currentTimeMillis()));
        course.setCreateTime(new Timestamp(System.currentTimeMillis()));
        course.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        int i = courseService.insertSelective(course);
        if (i!=1){
            return "error";
        }

        return "redirect:/courses";
    }


    @GetMapping("course/edit/{id}")
    public ModelAndView toEditUser(@PathVariable("id") Integer id, Model model){
        Course course = courseService.selectByPrimaryKey(id);
        List<Project> projectList = projectService.selectAll();
        model.addAttribute("projectList",projectList);
        return new ModelAndView("courses/edit", "course", course);
    }

    /**
     * 管理员修改课程信息
     */
    @ResponseBody
    @PostMapping("course/edit")
    public String editCourse(Course course, HttpServletRequest request, Model model){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }
        String roleName =(String) request.getSession().getAttribute("roleName");
        if(!roleName.equals("admin")){
            return "redirect:/403";
        }
        System.out.println("course/edit:"+course.toString());
        int i = courseService.updateByPrimaryKeySelective(course);
        if(i!=1){
            return "更新失败!";
        }

        return "更新成功!";
    }


    /**
     * 删除课程
     */
    @ResponseBody
    @DeleteMapping(value = "course/{id}")
    public Msg deleteCourse(@PathVariable("id") Integer id, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            response.sendRedirect("/login");
        }
        String roleName =(String) request.getSession().getAttribute("roleName");
        if(!roleName.equals("admin")){
            response.sendRedirect("/403");
        }

        try {
            int i = courseService.deleteByPrimaryKey(id);
            if (i!=1){
                return Msg.fail().add("result","删除失败!");
            }
        } catch (Exception e) {
            return Msg.fail().add("result","删除失败!");
        }
        return  Msg.success().add("result","删除成功!");
    }

    /**
     * 根据id查看单个课程详情
     */
    @GetMapping(value = "/course/{id}/detail")
    public String courseDetail(@PathVariable("id") Integer id,HttpServletRequest request,Model model){
        //System.out.println(id);
        //获取课程
        Course course = courseService.selectByPrimaryKey(id);
        model.addAttribute("course",course);
        //获取课程选课数量
        UserSelectCourseExample userSelectCourseExample = new UserSelectCourseExample();
        UserSelectCourseExample.Criteria criteria = userSelectCourseExample.createCriteria();
        criteria.andCourseIdEqualTo(id);
        long l = userSelectCourseService.countByExample(userSelectCourseExample);
        //System.out.println("该课选课数量:"+l);
        model.addAttribute("selectedCount",l);
        //获取课程评论, 并使用Vo层返回
        List<commentVo> commentVos=new ArrayList<commentVo>();
        List<comment> comments = commentService.selectByCourseId(id);
        for (comment comment: comments) {
            commentVo commentVo = new commentVo();
            commentVo.setId(comment.getId());
            commentVo.setComment(comment.getComment());
            commentVo.setCommentTime(comment.getCommentTime());
            commentVo.setCourseId(comment.getCourseId());
            commentVo.setUserId(comment.getUserId());
            commentVo.setDelFlag(comment.getDelFlag());
            User user = userService.selectByPrimaryKey(comment.getUserId());
            commentVo.setUsername(user.getRealName());
            commentVos.add(commentVo);
        }
        model.addAttribute("comments",commentVos);


        return  "courses/courseDetail";
    }

}
