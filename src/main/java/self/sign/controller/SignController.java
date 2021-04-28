package self.sign.controller;

import self.sign.services.SignRecordService;
import self.sign.util.ShiroWebUtil;
import self.sign.vo.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Controller
@RequestMapping("/sign")
public class SignController {

    @Autowired
    private SignRecordService signRecordService;

    @PostMapping("/add")
    @ResponseBody
    public ResultDto<Boolean> sign(@RequestParam Long courseId, HttpServletRequest request){
        signRecordService.sign(courseId, ShiroWebUtil.getCurrentUser());
        return  new ResultDto<>(true);
    }
}
