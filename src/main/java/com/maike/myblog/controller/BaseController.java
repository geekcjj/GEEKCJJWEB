package com.maike.myblog.controller;
/**
 * @projectname GEEKCJJWeb
 * @author GEEKCJJ
 * @date 2019年10月18日 下午7:32:14
 * @description:
 *
 */

import org.springframework.beans.factory.annotation.Autowired;

import com.maike.myblog.service.IArticleCommentService;
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
import com.maike.myblog.service.ILoginLogService;
import com.maike.myblog.service.IResourceDownloadService;
import com.maike.myblog.service.IRolePermissionService;
import com.maike.myblog.service.ITagsService;
import com.maike.myblog.service.IUserRolePermissionService;
import com.maike.myblog.service.IUserRoleService;

public class BaseController {
	@Autowired
	public IBlogUserService blogUserService;
	@Autowired
	public IArticleCommentService articleCommentService;
	@Autowired
	public IArticlesBlogService articlesBlogService;
	@Autowired
	public IArticlesLifeService articlesLifeService;
	@Autowired
	public IArticlesNewService articlesNewService;
	@Autowired
	public IBlogUserRoleService blogUserRoleService;
	@Autowired
	public IBlogUserPwdService blogUserPwdService;
	@Autowired
	public ICategoryService categoryService;
	@Autowired
	public IFriendLinkService friendLinkService;
	@Autowired
	public IIndexGalleryService indexGalleryService;
	@Autowired
	public ILeaveWordsService leaveWordsService;
	@Autowired
	public ILoginLogService loginLogService;
	@Autowired
	public IResourceDownloadService downloadService;
	@Autowired
	public IRolePermissionService rolePermissionService;
	@Autowired
	public ITagsService tagsService;
	@Autowired
	public IUserRolePermissionService userRolePermissionService;
	@Autowired
	public IUserRoleService userRoleService;
}
