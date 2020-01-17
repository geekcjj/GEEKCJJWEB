package com.maike.myblog.service;

import com.maike.myblog.entity.BlogUser;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface IBlogUserService extends IService<BlogUser> {
	/**
	 * 通过用户名登录
	 */
	Map<String, Object> userLoginByUserName(String username, String password);

	/**
	 * 通过邮箱登录
	 */
	Map<String, Object> userLoginByEmail(String userEmail, String password);

	/**
	 * 通过手机号登录
	 */
	Map<String, Object> userLoginByPhone(String phoneNumber, String password);

	/**
	 * 根据用户名查询是否存在账号
	 */
	int isExistByUserName(String username);

	/**
	 * 根据邮箱查询是否存在账号
	 */
	int isExistByUserEmail(String userEmail);

	/**
	 * 根据手机号查询是否存在账号
	 */
	int isExistByPhoneNumber(String phoneNumber);

	/**
	 * 根据用户名查询用户简单信息
	 */
	Map<String, Object> mapUserBriefByUserName(String userName);

	/**
	 * 根据用户名查询用户详细信息
	 */
	Map<String, Object> mapUserInfoByUserName(String userName);

	/**
	 * 查询所有用户信息
	 */
	PageInfo<Map<String, Object>> listUserInfo(int currentPage, int pageSize);

	/**
	 * 查询所有管理员用户信息
	 */
	PageInfo<BlogUser> listAdminUserInfo(int currentPage, int pageSize);

	/**
	 * 查询所有普通用户信息
	 */
	PageInfo<BlogUser> listOrdianryUserInfo(int currentPage, int pageSize);
}
