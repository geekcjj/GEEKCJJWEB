package com.maike.myblog.service.impl;

import com.maike.myblog.entity.BlogUser;
import com.maike.myblog.entity.IndexGallery;
import com.maike.myblog.mapper.BlogUserMapper;
import com.maike.myblog.service.IBlogUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {
	@Resource
	private BlogUserMapper blogUserMapper;

	@Override
	public Map<String, Object> userLoginByUserName(String username, String password) {
		// TODO Auto-generated method stub
		return blogUserMapper.blogUserLoginByUserName(username, password);
	}

	@Override
	public Map<String, Object> userLoginByEmail(String userEmail, String password) {
		// TODO Auto-generated method stub
		return blogUserMapper.blogUserLoginByEmail(userEmail, password);
	}

	@Override
	public Map<String, Object> userLoginByPhone(String phoneNumber, String password) {
		// TODO Auto-generated method stub
		return blogUserMapper.blogUserLoginByPhone(phoneNumber, password);
	}

	@Override
	public int isExistByUserName(String username) {
		// TODO Auto-generated method stub
		return blogUserMapper.isExistUserName(username);
	}

	@Override
	public int isExistByUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return blogUserMapper.isExistUserEmail(userEmail);
	}

	@Override
	public int isExistByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return blogUserMapper.isExistPhoneNumber(phoneNumber);
	}

	@Override
	public Map<String, Object> mapUserBriefByUserName(String userName) {
		// TODO Auto-generated method stub
		return blogUserMapper.selectUserBriefByUserName(userName);
	}

	@Override
	public Map<String, Object> mapUserInfoByUserName(String userName) {
		// TODO Auto-generated method stub
		return blogUserMapper.selectUserInfoByUserName(userName);
	}

	@Override
	public PageInfo<Map<String, Object>> listUserInfo(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		List<Map<String, Object>> docs = blogUserMapper.selectAllUserInfo();
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(docs);
		return pageInfo;
	}

	@Override
	public PageInfo<BlogUser> listAdminUserInfo(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		List<BlogUser> docs = baseMapper
				.selectList(new QueryWrapper<BlogUser>().eq("is_admin", 1).orderByAsc("create_time"));
		PageInfo<BlogUser> pageInfo = new PageInfo<BlogUser>(docs);
		return pageInfo;
	}

	@Override
	public PageInfo<BlogUser> listOrdianryUserInfo(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		List<BlogUser> docs = baseMapper
				.selectList(new QueryWrapper<BlogUser>().eq("is_admin", 0).orderByAsc("create_time"));
		PageInfo<BlogUser> pageInfo = new PageInfo<BlogUser>(docs);
		return pageInfo;
	}

}
