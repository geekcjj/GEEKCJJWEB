package com.maike.myblog.mapper;

import com.maike.myblog.entity.BlogUserRole;

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
public interface BlogUserRoleMapper extends BaseMapper<BlogUserRole> {
	/**
	 * 普通网站用户注册时,插入用户角色
	 */
	int registerInsertOrdianryUser(@Param(value = "id") String id, @Param(value = "userId") String userId);

	/**
	 * 在后台添加管理员时,插入用户角色
	 */
	int addAdminInsertAdminUser(@Param(value = "id") String id, @Param(value = "userId") String userId,
			@Param(value = "roleId") String roleId);

	/**
	 * 根据userId查询初用户所有的角色
	 */
	List<Map<String, Object>> selectUserRole(@Param(value = "userId") String userId);
}
