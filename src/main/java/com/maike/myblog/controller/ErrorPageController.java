package com.maike.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @projectname GEEKCJJWeb
 * @author GEEKCJJ
 * @date 2019年10月18日 下午8:11:54
 * @description:
 *
 */
@Controller
public class ErrorPageController {
	@RequestMapping(value = "/404", method = { RequestMethod.POST, RequestMethod.GET })
	public String noFindPage() {
		return "404";
	}

	@RequestMapping(value = "/403", method = { RequestMethod.POST, RequestMethod.GET })
	public String serviceError() {
		// 访问自定义目录下/templates/my/index.html，要注意路径格式
		// model.setViewName("geekcjjback/login.html");
		return "403";
	}
}
