package com.maike.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectname GEEKCJJBlog
 * @author GEEKCJJ
 * @date 2019年9月23日 上午1:05:45
 * @description:
 *
 */
@Controller
//这里很关键一点事不能使用@RestController，必须使用@Controller
//springboot控制层返回html，模板页面,如果在controler里使用html必须用@Controller
public class ErrorPageController {
	@RequestMapping(value="/404",method={RequestMethod.POST,RequestMethod.GET})
	public String errorPage404() {
		return "404";
	}
	@RequestMapping(value="/403",method={RequestMethod.POST,RequestMethod.GET})
	public String errorPage403() {
		return "403";
	}
}
