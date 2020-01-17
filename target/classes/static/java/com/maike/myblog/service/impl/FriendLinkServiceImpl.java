package com.maike.myblog.service.impl;

import com.maike.myblog.entity.FriendLink;
import com.maike.myblog.mapper.FriendLinkMapper;
import com.maike.myblog.service.IFriendLinkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

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
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkMapper, FriendLink> implements IFriendLinkService {

	@Override
	public List<FriendLink> selectFriendLink() {
		// TODO Auto-generated method stub
		return baseMapper.selectList(new QueryWrapper<FriendLink>().orderByAsc("create_time"));
	}

	@Override
	public int insertOneFriendLink(FriendLink friendLink) {
		// TODO Auto-generated method stub
		return baseMapper.insert(friendLink);
	}

	@Override
	public int deleteOneFriendLink(int id) {
		// TODO Auto-generated method stub
		return baseMapper.deleteById(id);
	}

	@Override
	public int updateOneFriendLink(FriendLink friendLink) {
		// TODO Auto-generated method stub
		return baseMapper.updateById(friendLink);
	}

	@Override
	public List<FriendLink> blogFriendLink() {
		// TODO Auto-generated method stub
		return baseMapper.selectList(new QueryWrapper<FriendLink>().orderByDesc("create_time"));
	}

}
