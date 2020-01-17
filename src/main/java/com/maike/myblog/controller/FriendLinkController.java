package com.maike.myblog.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.maike.myblog.entity.FriendLink;
import com.maike.myblog.utils.Result;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@RestController
@RequestMapping("/friendLink")
public class FriendLinkController extends BaseController {
	@RequestMapping(value = "/blog/blogFrienfLink", method = { RequestMethod.GET, RequestMethod.POST })
	public Result blogAllFriendLink() {
		return Result.success(friendLinkService.blogAllFriendLink());
	}

	@RequestMapping(value = "/admin/insertFrienfLink", method = { RequestMethod.GET, RequestMethod.POST })
	public Result insertBlogFriendLink(@RequestBody FriendLink friendLink) {
		return Result.success(friendLinkService.insertBlogFriendLink(friendLink));
	}

	@RequestMapping(value = "/admin/updateFrienfLink", method = { RequestMethod.GET, RequestMethod.POST })
	public Result updateFriendLink(@RequestBody FriendLink friendLink) {
		return Result.success(friendLinkService.updateBlogFriendLink(friendLink));
	}

	@RequestMapping(value = "/admin/deleteFriendLink", method = { RequestMethod.GET, RequestMethod.POST })
	public Result deleteFriendLink(@RequestParam("id") String id) {
		return Result.success(friendLinkService.deleteBlogFriendLink(id));
	}

	@RequestMapping(value = "/admin/getAllFriendLink", method = { RequestMethod.GET, RequestMethod.POST })
	public Result deleteFriendLink(@RequestParam("pageNum") String currentPage,
			@RequestParam("pageSize") String pageSize) {
		PageInfo<FriendLink> pageInfo = friendLinkService.getAllFriendLink(Integer.parseInt(currentPage),
				Integer.parseInt(pageSize));
		return Result.success(pageInfo.getList(), String.valueOf(pageInfo.getTotal()));
	}
}
