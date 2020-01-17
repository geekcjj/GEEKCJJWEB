package com.maike.myblog.service;

import com.maike.myblog.entity.Tags;
import com.maike.myblog.entity.UserRole;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-30
 */
public interface IUserRoleService extends IService<UserRole> {
	List<Map<String,Object>> selectAllUserRole();
	int insertOneUserRole(Tags tag);
	int deleteOneUserRole(int id);
	int deleteMoreUserRole(String... ids);
	int updateOneUserRole(Tags tag);
	List<Map<String,Object>> blogAllUserRole();
}
