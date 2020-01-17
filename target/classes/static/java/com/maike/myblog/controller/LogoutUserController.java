package com.maike.myblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @projectname GEEKCJJBlog
 * @author GEEKCJJ
 * @date 2019年9月28日 下午5:53:17
 * @description:
 *
 */
@Controller
//这里很关键一点事不能使用@RestController，必须使用@Controller
//springboot控制层返回html，模板页面,如果在controler里使用html必须用@Controller
public class LogoutUserController {
	@RequestMapping("/adminLogout")
	public String logoutAdmin(@RequestParam(value="loginName",required=false) String loginName,@RequestParam(value="password",required=false) String password,HttpServletRequest request,
			HttpServletResponse response,HttpSession session) {
		//删除（思路就是替换原来的cookie,并设置它的生存时间为0）：
		Cookie cookie = new Cookie("nickName",null);//cookie名字要相同
		cookie.setMaxAge(0); //
		//cookie.setPath(request.getContextPath());  // 相同路径
		response.addCookie(cookie);
		Cookie cookie1 = new Cookie("userName",null);//cookie名字要相同
		cookie.setMaxAge(0); //
		//cookie.setPath(request.getContextPath());  // 相同路径
		response.addCookie(cookie);
		Cookie cookie2 = new Cookie("up",null);//cookie名字要相同
		cookie.setMaxAge(0); //
		//cookie.setPath(request.getContextPath());  // 相同路径
		response.addCookie(cookie);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "redirect:backlogin";
	}
	@RequestMapping(value="/logoutBlogUser",method={RequestMethod.POST,RequestMethod.GET})
	public String logoutBlogUser() {
		//访问自定义目录下/templates/my/index.html，要注意路径格式
		//model.setViewName("geekcjjback/login.html");
		return "login";
	}
}
