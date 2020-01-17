package com.maike.myblog.service;

import com.maike.myblog.entity.BlogUser;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
public interface IBlogUserService extends IService<BlogUser> {
	//用户ID登录
	Map<String,Object> blogUserLoginByUserName(String loginName,String password);
	//手机号登录
	Map<String,Object> blogUserLoginByPhone(String loginName,String password);
	//用户邮箱登录
	Map<String,Object> blogUserLoginByEmail(String loginName,String password);
	//Admin用户登录
	//Map<String,Object> blogAdminUserLogin(String loginName,String password);
	//用户注册
	Integer blogUserRegister(BlogUser blogUser);
	//用户修改信息
	Integer blogUserUpdate(BlogUser blogUser);
	//用户信息展示
	List<BlogUser> blogUserInfomationDisplay(BlogUser blogUser);
	//判断是否存在相同的用户名
	Integer isExistUsername(String username);
	//查询用户的角色
	List<Map<String,Object>> selectUserRole(BlogUser blogUser);
	//查询用户的简单信息,包括头像地址
	Map<String,Object> selectUserBriefByUserName(String userName);
	//查询用户的UserId,即为blog_user的主键id
	Map<String,Object> selectUserInfoByUserName(String userName);
}
