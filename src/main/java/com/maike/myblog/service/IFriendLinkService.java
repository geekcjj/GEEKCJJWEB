package com.maike.myblog.service;

import com.maike.myblog.entity.FriendLink;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface IFriendLinkService extends IService<FriendLink> {
	List<FriendLink> blogAllFriendLink();

	PageInfo<FriendLink> getAllFriendLink(int currentPage, int pageSize);

	int insertBlogFriendLink(FriendLink friendLink);

	int updateBlogFriendLink(FriendLink friendLink);

	int deleteBlogFriendLink(String id);
}
