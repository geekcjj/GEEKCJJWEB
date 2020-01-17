package com.maike.myblog.service.impl;

import com.maike.myblog.entity.BlogUserRole;
import com.maike.myblog.mapper.BlogUserRoleMapper;
import com.maike.myblog.service.IBlogUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@Service
public class BlogUserRoleServiceImpl extends ServiceImpl<BlogUserRoleMapper, BlogUserRole>
		implements IBlogUserRoleService {
	@Resource
	private BlogUserRoleMapper blogUserRoleMapper;

	@Override
	public int registerAddOrdianryUserRole(String id, String userId) {
		// TODO Auto-generated method stub
		return blogUserRoleMapper.registerInsertOrdianryUser(id, userId);
	}

	@Override
	public int addAdminUserRole(String id, String userId, String roleId) {
		// TODO Auto-generated method stub
		return blogUserRoleMapper.addAdminInsertAdminUser(id, userId, roleId);
	}

	@Override
	public List<Map<String, Object>> listAllUserRoleByUserId(String userId) {
		// TODO Auto-generated method stub
		return blogUserRoleMapper.selectUserRole(userId);
	}

}
