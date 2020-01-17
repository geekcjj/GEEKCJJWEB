package com.maike.myblog.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maike.myblog.entity.FriendLink;
import com.maike.myblog.utils.FileNameUtils;
import com.maike.myblog.utils.MyException;
import com.maike.myblog.utils.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-30
 */
@RestController
//@RequestMapping("/friend-link")
public class FriendLinkController extends BaseController{
	@RequestMapping(value="/backManage/friendLink/getAllFriendLink")
	public Result getAllGallery() {
		List<FriendLink> gallery=friendLinkService.selectFriendLink();
		if(gallery!=null) {
			Integer count=friendLinkService.count();
			return Result.success(0,count,gallery);	
		}
		return Result.error("没有数据请添加!");
	}
	@RequestMapping(value="/backManage/friendLink/insertOneFriendLink")
	public Result insertOneGallery(@RequestBody FriendLink friendLink) throws IllegalStateException, IOException {
		int flag=friendLinkService.insertOneFriendLink(friendLink);
		if(flag>0) {
			return Result.success(true);
		}
		return Result.error("添加失败!");
	}
	@RequestMapping(value="/backManage/friendLink/deleteOneFriendLink")
	public Result deleteOneGallery(@RequestParam("id") int id) {
		int flag=friendLinkService.deleteOneFriendLink(id);
		if(flag>0) {
			return Result.success("删除成功!");	
		}
		return Result.error("删除失败!");
	}
	@RequestMapping(value="/backManage/friendLink/updateOneFriendLink")
	public Result updateOneGallery(@RequestBody FriendLink friendLink) {
		int flag=friendLinkService.updateOneFriendLink(friendLink);
		if(flag>0) {
			return Result.success("更新成功!");	
		}
		return Result.error("更新失败!");
	}
	@RequestMapping(value="/blog/friendLink/blogFrienfLink")
	public Result blogIndexGallery() {
		List<FriendLink> list=friendLinkService.blogFriendLink();
		return Result.success(list);
	}
}
