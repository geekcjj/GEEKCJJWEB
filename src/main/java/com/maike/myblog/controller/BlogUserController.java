package com.maike.myblog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.maike.myblog.entity.BlogUser;
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
@RequestMapping("/blogUser")
public class BlogUserController extends BaseController {
	@RequestMapping(value = "/admin/loginByUserName", method = { RequestMethod.GET, RequestMethod.POST })
	public Result adminLoginByUserName(@RequestParam(value = "loginName", required = false) String loginName,
			@RequestParam(value = "password", required = false) String password) {
		if (blogUserService.isExistByUserName(loginName) > 0) {
			Map<String, Object> blogUser = blogUserService.userLoginByUserName(loginName, password);

			if (blogUserService.userLoginByUserName(loginName, password) != null) {
				String userId = (String) blogUser.get("userId");
				List<String> roleList = new ArrayList<String>();
				for (Map<String, Object> userRole : blogUserRoleService.listAllUserRoleByUserId(userId)) {
					roleList.add((String) userRole.get("roleCode"));
				}
				if (roleList.contains("superAdmin") || roleList.contains("ordinaryAdmin")) {
					return Result.success(true);
				} else {
					return Result.error("该用户不是管理员!");
				}
			} else {
				return Result.error("密码错误!");
			}
		}
		return Result.error("用户不存在!");
	}

	@RequestMapping(value = "/admin/loginByUserEmail", method = { RequestMethod.GET, RequestMethod.POST })
	public Result adminLoginByUserEmail(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password) {
		if (blogUserService.isExistByUserEmail(loginName) > 0) {
			Map<String, Object> blogUser = blogUserService.userLoginByEmail(loginName, password);
			if (blogUserService.userLoginByEmail(loginName, password) != null) {
				String userId = (String) blogUser.get("userId");
				List<String> roleList = new ArrayList<String>();
				for (Map<String, Object> userRole : blogUserRoleService.listAllUserRoleByUserId(userId)) {
					roleList.add((String) userRole.get("roleCode"));
				}
				if (roleList.contains("superAdmin") || roleList.contains("ordinaryAdmin")) {
					return Result.success(true);
				} else {
					return Result.error("该用户不是管理员!");
				}
			} else {
				return Result.error("密码错误!");
			}
		}
		return Result.error("用户不存在!");
	}

	@RequestMapping(value = "/admin/loginByPhoneNumber", method = { RequestMethod.GET, RequestMethod.POST })
	public Result adminLoginByPhoneNumber(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password) {
		if (blogUserService.isExistByPhoneNumber(loginName) > 0) {
			Map<String, Object> blogUser = blogUserService.userLoginByPhone(loginName, password);
			if (blogUserService.userLoginByPhone(loginName, password) != null) {
				String userId = (String) blogUser.get("userId");
				List<String> roleList = new ArrayList<String>();
				for (Map<String, Object> userRole : blogUserRoleService.listAllUserRoleByUserId(userId)) {
					roleList.add((String) userRole.get("roleCode"));
				}
				if (roleList.contains("superAdmin") || roleList.contains("ordinaryAdmin")) {
					return Result.success(true);
				} else {
					return Result.error("该用户不是管理员!");
				}
			} else {
				return Result.error("密码错误!");
			}
		}
		return Result.error("用户不存在!");
	}

	@RequestMapping(value = "/blog/loginByUserName", method = { RequestMethod.GET, RequestMethod.POST })
	public Result blogLoginByUserName(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password) {
		if (blogUserService.isExistByUserName(loginName) > 0) {
			Map<String, Object> blogUser = blogUserService.userLoginByUserName(loginName, password);
			if (blogUserService.userLoginByUserName(loginName, password) != null) {
				String userId = (String) blogUser.get("userId");
				List<String> roleList = new ArrayList<String>();
				for (Map<String, Object> userRole : blogUserRoleService.listAllUserRoleByUserId(userId)) {
					roleList.add((String) userRole.get("roleCode"));
				}
				if (roleList.contains("ordinaryUser")) {
					return Result.success(true);
				} else {
					return Result.error("该用户不是管理员!");
				}
			} else {
				return Result.error("密码错误!");
			}
		}
		return Result.error("用户不存在!");
	}

	@RequestMapping(value = "/blog/loginByUserEmail", method = { RequestMethod.GET, RequestMethod.POST })
	public Result blogLoginByUserEmail(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password) {
		if (blogUserService.isExistByUserEmail(loginName) > 0) {
			Map<String, Object> blogUser = blogUserService.userLoginByEmail(loginName, password);
			if (blogUserService.userLoginByEmail(loginName, password) != null) {
				String userId = (String) blogUser.get("userId");
				List<String> roleList = new ArrayList<String>();
				for (Map<String, Object> userRole : blogUserRoleService.listAllUserRoleByUserId(userId)) {
					roleList.add((String) userRole.get("roleCode"));
				}
				if (roleList.contains("ordinaryUser")) {
					return Result.success(true);
				} else {
					return Result.error("该用户不是管理员!");
				}
			} else {
				return Result.error("密码错误!");
			}
		}
		return Result.error("用户不存在!");
	}

	@RequestMapping(value = "/blog/loginByPhoneNumber", method = { RequestMethod.GET, RequestMethod.POST })
	public Result blogLoginByPhoneNumber(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password) {
		if (blogUserService.isExistByPhoneNumber(loginName) > 0) {
			Map<String, Object> blogUser = blogUserService.userLoginByPhone(loginName, password);
			if (blogUserService.userLoginByPhone(loginName, password) != null) {
				String userId = (String) blogUser.get("userId");
				List<String> roleList = new ArrayList<String>();
				for (Map<String, Object> userRole : blogUserRoleService.listAllUserRoleByUserId(userId)) {
					roleList.add((String) userRole.get("roleCode"));
				}
				if (roleList.contains("ordinaryUser")) {
					return Result.success(true);
				} else {
					return Result.error("该用户不是管理员!");
				}
			} else {
				return Result.error("密码错误!");
			}
		}
		return Result.error("用户不存在!");
	}

	@RequestMapping(value = "/blog/userBriefInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public Result blogUserBriefInfo(@RequestParam("userName") String userName) {
		Map<String, Object> userMap = blogUserService.mapUserBriefByUserName(userName);
		return Result.success(userMap);
	}

	@RequestMapping(value = "/blog/userInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public Result blogUserInfo(@RequestParam("userName") String userName) {
		Map<String, Object> userMap = blogUserService.mapUserInfoByUserName(userName);
		return Result.success(userMap);
	}

	@RequestMapping(value = "/admin/allUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public Result allUserInfo(@RequestParam("pageNum") String pageNum, @RequestParam("pageSize") String pageSize) {
		PageInfo<Map<String, Object>> pageInfo = blogUserService.listUserInfo(Integer.parseInt(pageNum),
				Integer.parseInt(pageSize));
		return Result.success(pageInfo.getList(), String.valueOf(pageInfo.getTotal()));
	}

	@RequestMapping(value = "/admin/allAdminUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public Result allAdminUserInfo(@RequestParam("pageNum") String pageNum, @RequestParam("pageSize") String pageSize) {
		PageInfo<BlogUser> pageInfo = blogUserService.listAdminUserInfo(Integer.parseInt(pageNum),
				Integer.parseInt(pageSize));
		return Result.success(pageInfo.getList(), String.valueOf(pageInfo.getTotal()));
	}

	@RequestMapping(value = "/admin/allOrdianryUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public Result allOrdianryUserInfo(@RequestParam("pageNum") String pageNum,
			@RequestParam("pageSize") String pageSize) {
		PageInfo<BlogUser> pageInfo = blogUserService.listOrdianryUserInfo(Integer.parseInt(pageNum),
				Integer.parseInt(pageSize));
		return Result.success(pageInfo.getList(), String.valueOf(pageInfo.getTotal()));
	}
}
