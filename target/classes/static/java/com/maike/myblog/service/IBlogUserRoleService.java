package com.maike.myblog.service;

import com.maike.myblog.entity.BlogUserRole;

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
public interface IBlogUserRoleService extends IService<BlogUserRole> {
	/**
	 * 查询所有用户和角色
	 * @param userId
	 * @return
	 */
	List<Map<String,Object>> selectUserRole(String userId);
	/**
	 * 注册时用户选择角色
	 * @param blogUserRole
	 * @return
	 */
	Integer registerInsertOrdianryUser(BlogUserRole blogUserRole);
	/**
	 * 添加管理员是选择管理员角色
	 * @param blogUserRole
	 * @return
	 */
	Integer addAdminInsertAdminUser(BlogUserRole blogUserRole);
}
