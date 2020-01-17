package com.maike.myblog.mapper;

import com.maike.myblog.entity.BlogUser;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
public interface BlogUserMapper extends BaseMapper<BlogUser> {
	Map<String,Object> blogUserLoginByUserName(@Param("userName") String userName,@Param("password") String password);
	Map<String,Object> blogUserLoginByEmail(@Param("userEmail") String userName,@Param("password") String password);
	Map<String,Object> blogUserLoginByPhone(@Param("phoneNumber") String userName,@Param("password") String password);
	Integer isExistUserName(@Param("username") String userName);
	Map<String,Object> selectUserInfoByUserName(@Param("userName") String userName);
	Map<String,Object> selectUserBriefByUserName(@Param("userName") String userName);
}
