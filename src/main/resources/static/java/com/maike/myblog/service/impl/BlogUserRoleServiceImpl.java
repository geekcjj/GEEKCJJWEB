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
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
@Service
public class BlogUserRoleServiceImpl extends ServiceImpl<BlogUserRoleMapper, BlogUserRole> implements IBlogUserRoleService {

	@Resource
	private BlogUserRoleMapper blogUserRoleMapper;
	@Override
	public List<Map<String, Object>> selectUserRole(String userId) {
		// TODO Auto-generated method stub
		return blogUserRoleMapper.selectUserRole(userId);
	}
	@Override
	public Integer registerInsertOrdianryUser(BlogUserRole blogUserRole) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer addAdminInsertAdminUser(BlogUserRole blogUserRole) {
		// TODO Auto-generated method stub
		return null;
	}

}
