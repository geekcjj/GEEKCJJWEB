package com.maike.myblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maike.myblog.utils.Result;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {
	@RequestMapping(value = "/blog/getAllCategoryCount", method = { RequestMethod.GET, RequestMethod.POST })
	public Result blogAllFriendLink() {
		return Result.success(categoryService.blogAllCategoryAndCount());
	}
}
