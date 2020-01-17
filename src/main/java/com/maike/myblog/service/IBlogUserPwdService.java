package com.maike.myblog.service;

import com.maike.myblog.entity.BlogUserPwd;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface IBlogUserPwdService extends IService<BlogUserPwd> {
	/**
	 * 用户或管理员注册时插入密码
	 */
	int registerAddBlogUserPwd(String id, String blogUserId, String password);

	/**
	 * 用户或管理员修改密码
	 */
	int blogUserUpdateBlogUserPwd(String blogUserId, String password);
}
