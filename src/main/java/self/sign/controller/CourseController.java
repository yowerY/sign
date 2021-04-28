package self.sign.controller;

import self.sign.entity.Course;
import self.sign.services.CourseService;
import self.sign.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/page")
    public String coursePage(HttpServletRequest request, HttpServletResponse response) {
        return "coursePage";
    }

    @RequestMapping("/queryPage")
    @ResponseBody
    public PageVO<Course> queryPage(HttpServletRequest request, PageVO pageParam, Course dtoParam) {
        PageVO<Course> page = courseService.queryPage(pageParam,dtoParam);
        return page;
    }
}
