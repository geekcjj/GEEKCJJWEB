package com.maike.myblog.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.maike.myblog.entity.LoginLog;
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
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController {
	@RequestMapping(value = "/admin/insertUserLoginLog", method = { RequestMethod.POST, RequestMethod.GET })
	public Result insertUserLoginLog(@RequestBody LoginLog log) {
		if (loginLogService.insertLoginLog(log) > 0) {
			return Result.success(true);
		}
		return Result.error("失败!");
	}

	@RequestMapping(value = "/admin/listUserLoginLog", method = { RequestMethod.POST, RequestMethod.GET })
	public Result listUserLoginLog(@RequestParam("pageNum") String currentPage,
			@RequestParam("pageSize") String pageSize) {
		PageInfo<Map<String, Object>> pageInfo = loginLogService.listLoginLog(Integer.parseInt(currentPage),
				Integer.parseInt(pageSize));

		return Result.success(pageInfo.getList(), String.valueOf(pageInfo.getTotal()));
	}

	@RequestMapping(value = "/admin/deleteUserLoginLog", method = { RequestMethod.POST, RequestMethod.GET })
	public Result deleteUserLoginLog(@RequestParam("logId") String id) {
		if (loginLogService.deleteLoginLog(id) > 0) {
			return Result.success("删除成功!");
		}
		return Result.error("删除失败!");
	}
}
