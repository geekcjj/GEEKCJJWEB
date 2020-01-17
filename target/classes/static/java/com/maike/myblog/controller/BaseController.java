package com.maike.myblog.controller;
/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月15日 下午7:08:58
 * @description:
 *
 */

import org.springframework.beans.factory.annotation.Autowired;

import com.maike.myblog.service.IArticlesBlogService;
import com.maike.myblog.service.IArticlesLifeService;
import com.maike.myblog.service.IArticlesNewService;
import com.maike.myblog.service.IBlogUserPwdService;
import com.maike.myblog.service.IBlogUserRoleService;
import com.maike.myblog.service.IBlogUserService;
import com.maike.myblog.service.ICategoryService;
import com.maike.myblog.service.IFriendLinkService;
import com.maike.myblog.service.IIndexGalleryService;
import com.maike.myblog.service.ILeaveWordsService;
import com.maike.myblog.service.IResourceDownloadService;
import com.maike.myblog.service.ITagsService;
import com.maike.myblog.service.IUserRoleService;

public class BaseController {
	@Autowired
	public IArticlesBlogService articlesBlogService;
	@Autowired
	public IArticlesLifeService articlesLifeService;
	@Autowired
	public IArticlesNewService articlesNewService;
	@Autowired
	public IBlogUserPwdService blogUserPwdService;
	@Autowired
	public IBlogUserRoleService blogUserRoleService;
	@Autowired
	public IBlogUserService blogUserService;
	@Autowired
	public ICategoryService categoryService;
	@Autowired
	public ITagsService tagService;
	@Autowired
	public IUserRoleService userRoleService;
	@Autowired
	public IFriendLinkService friendLinkService;
	@Autowired
	public ILeaveWordsService leaveWordsService;
	@Autowired
	public IResourceDownloadService downloadService;
	@Autowired
	public IIndexGalleryService galleryService;
}
