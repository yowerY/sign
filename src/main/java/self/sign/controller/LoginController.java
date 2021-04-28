package self.sign.controller;

import com.alibaba.fastjson.JSONObject;
import self.sign.entity.Course;
import self.sign.entity.User;
import self.sign.services.CourseService;
import self.sign.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private CourseService courseService;
	
	/**
	 * 确认费用登录接口
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Map<String,Object> map, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String psw = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, psw);

		Subject currentUser = SecurityUtils.getSubject();

		if(StringUtils.isEmpty(username)){
			return "redirect:/";
		}
		try {
			log.info("对用户[" + username + "]进行登录验证..验证开始");
			currentUser.login(token);
			log.info("对用户[" + username + "]进行登录验证..验证通过");
		}catch(UnknownAccountException uae){
			log.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
		}catch(IncorrectCredentialsException ice){
			log.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
		}catch(LockedAccountException lae){
			log.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
		}catch(ExcessiveAttemptsException eae){
			log.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
		}catch(AuthenticationException ae){
			log.info("对用户[" + username + "]进行登录验证..验证未通过");
			ae.printStackTrace();
		}

		//验证是否登录成功
		if(currentUser.isAuthenticated()){
			log.info("用户[" + username + "]登录认证通过");
			return "redirect:/index";

		}else{
			token.clear();
			request.setAttribute("error", "login failed");
			return "login";
		}
	}

	@RequestMapping("/loginPath")
	public String loginPath(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		List<Course> courseList = courseService.getCourseListByUserId(((User)SecurityUtils.getSubject().getPrincipal()).getId());
		request.setAttribute("courseList", courseList);

		return "index";
	}
	
	
	/**
	 * 验证是否登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/get/loginInfo")
	@ResponseBody
	public String checkLogin(HttpServletRequest request, HttpServletResponse response){
		Object username = SecurityUtils.getSubject().getPrincipal();
		JSONObject jo = new JSONObject();
		jo.put("isLogin", false);
		if(username!=null){
			jo.put("isLogin", true);
		}
		return jo.toJSONString();
		
	}
}
