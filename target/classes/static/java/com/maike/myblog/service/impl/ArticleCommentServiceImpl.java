package com.maike.myblog.service.impl;

import com.maike.myblog.entity.ArticleComment;
import com.maike.myblog.mapper.ArticleCommentMapper;
import com.maike.myblog.service.IArticleCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-08
 */
@Service
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleComment> implements IArticleCommentService {

	@Override
	public List<Map<String, Object>> selectArticleComment(String articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectAllArticleComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOneArticleComment(ArticleComment articleComment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneArticleComment(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMoreArticleComment(String... ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneArticleComment(ArticleComment articleComment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> blogAllArticleComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> blogTop10ArticleComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> blogNew10ArticleComment() {
		// TODO Auto-generated method stub
		return null;
	}

}
