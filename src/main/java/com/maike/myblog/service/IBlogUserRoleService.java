package com.maike.myblog.service;

import com.maike.myblog.entity.BlogUserRole;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface IBlogUserRoleService extends IService<BlogUserRole> {
	/**
	 * 普通网站用户注册时,插入普通用户角色
	 */
	int registerAddOrdianryUserRole(String id, String userId);

	/**
	 * 在后台添加管理员时,插入用户角色
	 */
	int addAdminUserRole(String id, String userId, String roleId);

	/**
	 * 根据userId查询初用户所有的角色
	 */
	List<Map<String, Object>> listAllUserRoleByUserId(String userId);
}
