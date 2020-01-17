package com.maike.myblog.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maike.myblog.entity.BlogUser;
import com.maike.myblog.utils.DetermineLoginName;

/**
 * @projectname GEEKCJJBlog
 * @author GEEKCJJ
 * @date 2019年9月27日 下午2:14:44
 * @description:
 *
 */
@Controller
//这里很关键一点事不能使用@RestController，必须使用@Controller
//springboot控制层返回html，模板页面,如果在controler里使用html必须用@Controller
public class IndexController extends BaseController{
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping(value="/backlogin",method={RequestMethod.POST,RequestMethod.GET})
	public String adminlogin() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "geekcjjback/login";
	}
	@RequestMapping(value="/backManage",method={RequestMethod.POST,RequestMethod.GET})
	public String backManage() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "geekcjjback/index";
	}
	@RequestMapping(value="/loginRedirectToAdmin",method={RequestMethod.POST,RequestMethod.GET})
	//@ResponseBody
	public String RedirectToAdmin(@RequestParam(value="loginName", required = false) String loginName,@RequestParam(value="password", required = false) String password,@RequestParam(value="loginUserIdType", required = false) String loginUserIdType,
			HttpServletRequest request,HttpServletResponse response) {
		//String un=request.getParameter("loginName");
		//String ps=request.getParameter("password");
		//System.out.println("用户名:"+un+"|密码:"+ps);
		System.out.println("用户名:"+loginName+"|||密码:"+password+"登录账号类型:"+loginUserIdType);
		if(loginName!=null||password!=null) {
			BlogUser userMap;
			/**
			 * 判断登录名是否为手机
			 */
			if(loginUserIdType.equals("phone")||loginUserIdType=="phone") {
				userMap=blogUserService.getOne(new QueryWrapper<BlogUser>().eq("phone", loginName));
			}else if(loginUserIdType.equals("email")||loginUserIdType=="email") {
				userMap=blogUserService.getOne(new QueryWrapper<BlogUser>().eq("email", loginName));
			}else {
				userMap=blogUserService.getOne(new QueryWrapper<BlogUser>().eq("username", loginName));
			}
			Cookie cookie;
			try {
				cookie = new Cookie("nickName", URLEncoder.encode(userMap.getNickname(), "utf-8"));
				// cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
				//不应该在cookie里存重要数据只存一些不重要的信息,可以存一个用户的ID,通过ID查询用户相关信息
				Cookie cookie2 = new Cookie("userName", URLEncoder.encode(userMap.getUsername(), "utf-8"));
				// cookie.setPath("/");
				cookie2.setMaxAge(60 * 60 * 24);
				System.out.println(cookie2.getValue());
				response.addCookie(cookie2);
				Cookie cookie3 = new Cookie("up", URLEncoder.encode(userMap.getUserPic(), "utf-8"));
				// cookie.setPath("/");
				cookie3.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie3);
				return "redirect:backManage";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "redirect:backlogin";
			}
		}
		return "redirect:backlogin";
	}
	@RequestMapping(value="/techBlogList",method={RequestMethod.POST,RequestMethod.GET})
	public String techBlogList() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "techBlogList";
	}
	@RequestMapping(value="/newTalkList",method={RequestMethod.POST,RequestMethod.GET})
	public String newInfoList() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "newTalkList";
	}
	@RequestMapping(value="/resourceDownload",method={RequestMethod.POST,RequestMethod.GET})
	public String resourceDownload() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "resourceDownload";
	}
	@RequestMapping(value="/thinkingLife",method={RequestMethod.POST,RequestMethod.GET})
	public String thinkingLife() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "thinkingLifeBlogList";
	}
	@RequestMapping(value="/leavemessage-board",method={RequestMethod.POST,RequestMethod.GET})
	public String leaveMessageBoard() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "leavemessages";
	}
	@RequestMapping(value="/aboutgeekcjj",method={RequestMethod.POST,RequestMethod.GET})
	public String aboutgeekcjj() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "aboutgeekcjj";
	}
}
