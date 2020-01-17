package com.maike.myblog.mapper;

import com.maike.myblog.entity.BlogUserPwd;

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
public interface BlogUserPwdMapper extends BaseMapper<BlogUserPwd> {
	/**
	 * 用户或管理员注册时插入密码
	 */
	int registerInsertPwd(@Param("id") String id, @Param("blogUserId") String blogUserId,
			@Param("password") String password);

	/**
	 * 用户或管理员修改密码
	 */
	int modifyUserPwd(@Param("blogUserId") String blogUserId, @Param("password") String password);
}
