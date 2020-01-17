package com.maike.myblog.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.maike.myblog.utils.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
@RestController
//@RequestMapping("/category")
public class CategoryController extends BaseController{
	@RequestMapping(value="/blog/category/getAllCategoryCount")
	public Result getAllCategoryCount() {
		return Result.success(categoryService.blogAllCategory());
	}
}
