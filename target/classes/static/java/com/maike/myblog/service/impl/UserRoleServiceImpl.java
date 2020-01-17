package com.maike.myblog.service.impl;

import com.maike.myblog.entity.Tags;
import com.maike.myblog.entity.UserRole;
import com.maike.myblog.mapper.UserRoleMapper;
import com.maike.myblog.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-30
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

	@Override
	public List<Map<String, Object>> selectAllUserRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOneUserRole(Tags tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneUserRole(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMoreUserRole(String... ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneUserRole(Tags tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> blogAllUserRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
