package com.maike.myblog.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.maike.myblog.entity.IndexGallery;
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
@RequestMapping("/indexGallery")
public class IndexGalleryController extends BaseController {
	@RequestMapping(value = "/blog/allIndexGallery", method = { RequestMethod.GET, RequestMethod.POST })
	public Result blogAllFriendLink() {
		return Result.success(indexGalleryService.blogAllIndexGallery());
	}

	@RequestMapping(value = "/admin/insertIndexGallery", method = { RequestMethod.GET, RequestMethod.POST })
	public Result insertBlogFriendLink(@RequestBody IndexGallery gallery) {
		return Result.success(indexGalleryService.insertBlogIndexGallery(gallery));
	}

	@RequestMapping(value = "/admin/updateIndexGallery", method = { RequestMethod.GET, RequestMethod.POST })
	public Result updateFriendLink(@RequestBody IndexGallery gallery) {
		return Result.success(indexGalleryService.updateBlogIndexGallery(gallery));
	}

	@RequestMapping(value = "/admin/deleteIndexGallery", method = { RequestMethod.GET, RequestMethod.POST })
	public Result deleteFriendLink(@RequestParam("id") String id) {
		return Result.success(indexGalleryService.deleteBlogIndexGallery(id));
	}

	@RequestMapping(value = "/admin/getAllIndexGallery", method = { RequestMethod.GET, RequestMethod.POST })
	public Result deleteFriendLink(@RequestParam("pageNum") String currentPage,
			@RequestParam("pageSize") String pageSize) {
		PageInfo<IndexGallery> pageInfo = indexGalleryService.getAllIndexGallery(Integer.parseInt(currentPage),
				Integer.parseInt(pageSize));

		return Result.success(pageInfo.getList(), String.valueOf(pageInfo.getTotal()));
	}
}
