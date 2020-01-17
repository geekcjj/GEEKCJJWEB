package com.maike.myblog.service;

import com.maike.myblog.entity.BlogUserPwd;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-27
 */
public interface IBlogUserPwdService extends IService<BlogUserPwd> {
	//用户修改密码
	Integer blogUserUpdatePassword(BlogUserPwd blogUserPwd);
	//用户注册时同时在密码表里插入密码
	Integer registerAndIncertUserPassword(BlogUserPwd blogUserPwd);
}
