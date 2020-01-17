package com.maike.myblog.mapper;

import com.maike.myblog.entity.BlogUser;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface BlogUserMapper extends BaseMapper<BlogUser> {
	/**
	 * 通过用户名登录
	 */
	Map<String, Object> blogUserLoginByUserName(@Param("userName") String username, @Param("password") String password);

	/**
	 * 通过邮箱登录
	 */
	Map<String, Object> blogUserLoginByEmail(@Param("userEmail") String userEmail, @Param("password") String password);

	/**
	 * 通过手机号登录
	 */
	Map<String, Object> blogUserLoginByPhone(@Param("phoneNumber") String phoneNumber,
			@Param("password") String password);

	/**
	 * 根据用户名查询是否存在账号
	 */
	int isExistUserName(@Param("username") String username);

	/**
	 * 根据邮箱查询是否存在账号
	 */
	int isExistUserEmail(@Param("userEmail") String userEmail);

	/**
	 * 根据手机号查询是否存在账号
	 */
	int isExistPhoneNumber(@Param("phoneNumber") String phoneNumber);

	/**
	 * 根据用户名查询用户简单信息
	 */
	Map<String, Object> selectUserBriefByUserName(@Param("userName") String userName);

	/**
	 * 根据用户名查询用户详细信息
	 */
	Map<String, Object> selectUserInfoByUserName(@Param("userName") String userName);

	/**
	 * 查询所有用户列表
	 */
	List<Map<String, Object>> selectAllUserInfo();
}
