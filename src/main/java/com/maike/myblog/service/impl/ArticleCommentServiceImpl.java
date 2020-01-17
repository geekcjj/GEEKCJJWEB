package com.maike.myblog.service.impl;

import com.maike.myblog.entity.ArticleComment;
import com.maike.myblog.mapper.ArticleCommentMapper;
import com.maike.myblog.service.IArticleCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@Service
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleComment>
		implements IArticleCommentService {

}
