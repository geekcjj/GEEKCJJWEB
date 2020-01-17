package com.maike.myblog.service.impl;

import com.maike.myblog.entity.BlogUserPwd;
import com.maike.myblog.mapper.BlogUserPwdMapper;
import com.maike.myblog.service.IBlogUserPwdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-27
 */
@Service
public class BlogUserPwdServiceImpl extends ServiceImpl<BlogUserPwdMapper, BlogUserPwd> implements IBlogUserPwdService {
	private BlogUserPwdMapper blogUserPwdMapper;
	@Override
	public Integer blogUserUpdatePassword(BlogUserPwd blogUserPwd) {
		// TODO Auto-generated method stub
		Integer state=blogUserPwdMapper.modifyUserPwd(blogUserPwd);
		return state;
	}

	@Override
	public Integer registerAndIncertUserPassword(BlogUserPwd blogUserPwd) {
		// TODO Auto-generated method stub
		Integer state=blogUserPwdMapper.registerIncertPwd(blogUserPwd);
		return state;
	}

}
