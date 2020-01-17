package com.maike.myblog.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maike.myblog.entity.ArticlesBlog;
import com.maike.myblog.service.impl.ArticlesBlogServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
@Controller
@RequestMapping("/blogarticle")
public class ArticlesBlogController extends BaseController{
	@RequestMapping(value="/p/{articleId}")
	public String Article(@PathVariable(value="articleId") String articleId,
			HttpServletRequest request,HttpServletResponse response,HttpSession session,Model map) {
		ArticlesBlog articlesBlog= articlesBlogService.getOne(new QueryWrapper<ArticlesBlog>().eq("id", articleId));
		System.out.println(articlesBlog.getTitle());
		map.addAttribute("authorId", articlesBlog.getAuthorId());
		map.addAttribute("articleUrl", articlesBlog.getArticleUrl());
		map.addAttribute("authorName", articlesBlog.getAuthorName());
		map.addAttribute("authorPic", articlesBlog.getAuthorPic());
		map.addAttribute("browseCount", articlesBlog.getBrowseCount());
		map.addAttribute("categoryId", articlesBlog.getCategoryId());
		map.addAttribute("content", articlesBlog.getContent());
		map.addAttribute("description", articlesBlog.getDescription());
		map.addAttribute("articleTitle", articlesBlog.getTitle());
		map.addAttribute("articleLike", articlesBlog.getLikes());
		map.addAttribute("articleId", articlesBlog.getId());
		map.addAttribute("tagId", articlesBlog.getTagId());
		return "blogArticle";
	}
}
