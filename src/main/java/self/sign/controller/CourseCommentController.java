package self.sign.controller;

import self.sign.entity.CourseComment;
import self.sign.services.CourseCommentService;
import self.sign.util.ShiroWebUtil;
import self.sign.vo.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Controller
@RequestMapping("/courseComment")
public class CourseCommentController {

    @Autowired
    private CourseCommentService courseCommentService;

    @PostMapping("/add")
    @ResponseBody
    public ResultDto<Boolean> add(@RequestParam Long courseId,@RequestParam String comment,@RequestParam Integer level, HttpServletRequest request){
        courseCommentService.addComment(courseId,comment,level, ShiroWebUtil.getCurrentUser());
        return  new ResultDto<>(true);
    }

    @RequestMapping("/page")
    public String commentPage(HttpServletRequest request, HttpServletResponse response,Long courseId) {
        List<CourseComment> list = courseCommentService.listByCourseId(courseId);
        request.setAttribute("list",list);
        return "comment";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<CourseComment> list(HttpServletRequest request, Long courseId) {
        List<CourseComment> list = courseCommentService.listByCourseId(courseId);
        return list;
    }
}
