package com.maike.myblog.service;

import com.maike.myblog.entity.ArticleComment;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-08
 */
public interface IArticleCommentService extends IService<ArticleComment> {
	List<Map<String,Object>> selectArticleComment(String articleId);
	List<Map<String,Object>> selectAllArticleComment();
	int insertOneArticleComment(ArticleComment articleComment);
	int deleteOneArticleComment(int id);
	int deleteMoreArticleComment(String... ids);
	int updateOneArticleComment(ArticleComment articleComment);
	List<Map<String,Object>> blogAllArticleComment();
	List<Map<String,Object>> blogTop10ArticleComment();
	List<Map<String,Object>> blogNew10ArticleComment();
}
