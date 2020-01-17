package com.maike.myblog.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @projectname GEEKCJJWeb
 * @author GEEKCJJ
 * @date 2019年10月21日 上午5:41:29
 * @description:
 *
 */
@Controller
public class LogoutController {
	@RequestMapping(value = "/adminLogout", method = { RequestMethod.GET, RequestMethod.POST })
	public String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie, cookie2, cookie3;
		cookie = new Cookie("nickName", null);
		// 不应该在cookie里存重要数据只存一些不重要的信息,可以存一个用户的ID,通过ID查询用户相关信息
		cookie2 = new Cookie("userName", null);
		cookie3 = new Cookie("up", null);// 假如要删除名称为username的Cookie

		cookie.setMaxAge(0); // 立即删除型
		cookie2.setMaxAge(0); // 立即删除型
		cookie3.setMaxAge(0); // 立即删除型
		cookie.setPath("/"); // 项目所有目录均有效，这句很关键，否则不敢保证删除
		cookie2.setPath("/"); // 项目所有目录均有效，这句很关键，否则不敢保证删除
		cookie3.setPath("/"); // 项目所有目录均有效，这句很关键，否则不敢保证删除
		response.addCookie(cookie); // 重新写入，将覆盖之前的
		response.addCookie(cookie2); // 重新写入，将覆盖之前的
		response.addCookie(cookie3); // 重新写入，将覆盖之前的
		return "redirect:backlogin";
	}
}
