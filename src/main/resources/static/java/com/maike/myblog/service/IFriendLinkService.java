package com.maike.myblog.service;

import com.maike.myblog.entity.FriendLink;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-30
 */
public interface IFriendLinkService extends IService<FriendLink> {
	List<FriendLink> selectFriendLink();
	int insertOneFriendLink(FriendLink friendLink);
	int deleteOneFriendLink(int id);
	int updateOneFriendLink(FriendLink friendLink);
	List<FriendLink> blogFriendLink();
}
