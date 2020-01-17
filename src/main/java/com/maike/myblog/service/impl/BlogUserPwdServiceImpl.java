package com.maike.myblog.service.impl;

import com.maike.myblog.entity.BlogUserPwd;
import com.maike.myblog.mapper.BlogUserPwdMapper;
import com.maike.myblog.service.IBlogUserPwdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

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
public class BlogUserPwdServiceImpl extends ServiceImpl<BlogUserPwdMapper, BlogUserPwd> implements IBlogUserPwdService {
	@Resource
	private BlogUserPwdMapper blogUserPwdMapper;

	@Override
	public int registerAddBlogUserPwd(String id, String blogUserId, String password) {
		// TODO Auto-generated method stub
		return blogUserPwdMapper.registerInsertPwd(id, blogUserId, password);
	}

	@Override
	public int blogUserUpdateBlogUserPwd(String blogUserId, String password) {
		// TODO Auto-generated method stub
		return blogUserPwdMapper.modifyUserPwd(blogUserId, password);
	}

}
