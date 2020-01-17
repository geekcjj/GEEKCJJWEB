package com.maike.myblog.service.impl;

import com.maike.myblog.entity.FriendLink;
import com.maike.myblog.mapper.FriendLinkMapper;
import com.maike.myblog.service.IFriendLinkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkMapper, FriendLink> implements IFriendLinkService {

	@Override
	public List<FriendLink> blogAllFriendLink() {
		// TODO Auto-generated method stub
		return baseMapper.selectList(new QueryWrapper<FriendLink>().orderByAsc("create_time"));
	}

	@Override
	public PageInfo<FriendLink> getAllFriendLink(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		List<FriendLink> docs = baseMapper.selectList(new QueryWrapper<FriendLink>().orderByAsc("create_time"));
		PageInfo<FriendLink> pageInfo = new PageInfo<FriendLink>(docs);
		return pageInfo;
		// return baseMapper.selectMaps(new
		// QueryWrapper<FriendLink>().orderByDesc("create_time"));
	}

	@Override
	public int insertBlogFriendLink(FriendLink friendLink) {
		// TODO Auto-generated method stub
		return baseMapper.insert(friendLink);
	}

	@Override
	public int updateBlogFriendLink(FriendLink friendLink) {
		// TODO Auto-generated method stub
		return baseMapper.updateById(friendLink);
	}

	@Override
	public int deleteBlogFriendLink(String id) {
		// TODO Auto-generated method stub
		return baseMapper.deleteById(id);
	}

}
