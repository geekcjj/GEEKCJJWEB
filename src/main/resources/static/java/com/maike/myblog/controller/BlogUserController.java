package com.maike.myblog.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maike.myblog.entity.BlogUser;
import com.maike.myblog.enums.ResultEnum;
import com.maike.myblog.utils.DetermineLoginName;
import com.maike.myblog.utils.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
@RestController
@RequestMapping("/blogUser")
public class BlogUserController extends BaseController{
	@RequestMapping(value="/userLogin",method={RequestMethod.POST,RequestMethod.GET})
	public Result blogUserLogin(@RequestParam(value="loginName",required=false) String loginName,@RequestParam(value="password",required=false) String password,
			HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		//Map<String,Object> bloUser= blogUserService.blogUserLogin(loginName,password);
//		if(bloUser!=null) {
//			return Result.success(bloUser);
//		}
		/**
		 * 在用户登录是判断用户登录名的类型,以启用不同的登录方式
		 */
		//Map<String,Object> userMap;
		/**
		 * 判断登录名是否为手机
		 */
		if(DetermineLoginName.isMobileNO(loginName)) {
			//再判断成功后,再查询手机号是否存在
			if(blogUserService.count(new QueryWrapper<BlogUser>().eq("phone", loginName))>0) {
				Map<String,Object> userMap= blogUserService.blogUserLoginByPhone(loginName, password);
				if(userMap!=null) {
					userMap.put("loginUserIdType", "phone");
					String userId=(String) userMap.get("userId");
					System.out.println("用户ID:"+userId);
					List<Map<String,Object>> rolelist= blogUserRoleService.selectUserRole(userId);
					for (Map<String,Object> roleMap:rolelist) {
						if(roleMap.containsValue("ordinaryUser")) {
							userMap.put("userType", roleMap.get("roleCode"));
						}
					}
					if(userMap.get("userType")!=null) {
						return Result.success(userMap);
					}else {
						return Result.error("该用户不是普通用户!");
					}
				}else {
					return Result.error("密码错误!");
				}
			}else {
				return Result.error(ResultEnum.PHONE_NOT_EXIST.getCode(),ResultEnum.PHONE_NOT_EXIST.getMsg());
			}
		}
		/**
		 * 判断登录名是否为邮箱
		 */
		else if(DetermineLoginName.isEmailNO(loginName)) {
			//再判断成功后,再查询邮箱是否存在
			if(blogUserService.count(new QueryWrapper<BlogUser>().eq("email", loginName))>0) {
				Map<String,Object> userMap= blogUserService.blogUserLoginByEmail(loginName, password);
				if(userMap!=null) {
					userMap.put("loginUserIdType", "email");
					String userId=(String) userMap.get("userId");
					System.out.println("用户ID:"+userId);
					List<Map<String,Object>> rolelist= blogUserRoleService.selectUserRole(userId);
					for (Map<String,Object> roleMap:rolelist) {
						if(roleMap.containsValue("ordinaryUser")) {
							userMap.put("userType", roleMap.get("roleCode"));
						}
					}
					if(userMap.get("userType")!=null) {
						return Result.success(userMap);
					}else {
						return Result.error("该用户不是普通用户!");
					}
				}else {
					return Result.error("密码错误!");
				}
			}else {
				return Result.error(ResultEnum.EMAIL_NOT_EXIST.getCode(),ResultEnum.EMAIL_NOT_EXIST.getMsg());
			}
		}else {
			//再判断成功后,再查询用户名是否存在
			if(blogUserService.isExistUsername(loginName)>0) {
				Map<String,Object> userMap= blogUserService.blogUserLoginByUserName(loginName, password);
				System.out.println(userMap);
				if(userMap!=null) {
					userMap.put("loginUserIdType", "username");
					String userId=(String) userMap.get("userId");
					System.out.println("用户ID:"+userId);
					List<Map<String,Object>> rolelist= blogUserRoleService.selectUserRole(userId);
					for (Map<String,Object> roleMap:rolelist) {
						if(roleMap.containsValue("ordinaryUser")) {
							userMap.put("userType", roleMap.get("roleCode"));
						}
					}
					if(userMap.get("userType")!=null) {
						return Result.success(userMap);
					}else {
						return Result.error("该用户不是普通用户!");
					}
				}
				return Result.error("密码错误!");
			}else {
				return Result.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
			}
		}
		//return Result.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
	}
	@RequestMapping(value="/adminUserLogin",method={RequestMethod.POST,RequestMethod.GET})
	public Result blogAdminUserLogin(@RequestParam("loginName") String loginName,@RequestParam("password") String password,
			HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		/**
		 * 在用户登录是判断用户登录名的类型,以启用不同的登录方式
		 */
		//Map<String,Object> userMap;
		/**
		 * 判断登录名是否为手机
		 */
		if(DetermineLoginName.isMobileNO(loginName)) {
			//再判断成功后,再查询手机号是否存在
			if(blogUserService.count(new QueryWrapper<BlogUser>().eq("phone", loginName))>0) {
				Map<String,Object> userMap= blogUserService.blogUserLoginByPhone(loginName, password);
				if(userMap!=null) {
					userMap.put("loginUserIdType", "phone");
					String userId=(String) userMap.get("userId");
					System.out.println("用户ID:"+userId);
					List<Map<String,Object>> rolelist= blogUserRoleService.selectUserRole(userId);
					for (Map<String,Object> roleMap:rolelist) {
						if(roleMap.containsValue("superAdmin")) {
							userMap.put("adminUserType", roleMap.get("roleCode"));
						}
						if(roleMap.containsValue("ordinaryAdmin")) {
							userMap.put("adminUserType1", roleMap.get("roleCode"));
						}
					}
					System.out.println(userMap.get("adminUserType"));
					if(userMap.get("adminUserType")!=null||userMap.get("adminUserType1")!=null) {
						return Result.success(userMap);
					}else {
						return Result.error("该用户不是管理员!");
					}
				}else {
					return Result.error("密码错误!");
				}
			}else {
				return Result.error(ResultEnum.PHONE_NOT_EXIST.getCode(),ResultEnum.PHONE_NOT_EXIST.getMsg());
			}
		}
		/**
		 * 判断登录名是否为邮箱
		 */
		else if(DetermineLoginName.isEmailNO(loginName)) {
			//再判断成功后,再查询邮箱是否存在
			if(blogUserService.count(new QueryWrapper<BlogUser>().eq("email", loginName))>0) {
				Map<String,Object> userMap= blogUserService.blogUserLoginByEmail(loginName, password);
				if(userMap!=null) {
					userMap.put("loginUserIdType", "email");
					String userId=(String) userMap.get("userId");
					System.out.println("用户ID:"+userId);
					List<Map<String,Object>> rolelist= blogUserRoleService.selectUserRole(userId);
					for (Map<String,Object> roleMap:rolelist) {
						if(roleMap.containsValue("superAdmin")) {
							userMap.put("adminUserType", roleMap.get("roleCode"));
						}else if(roleMap.containsValue("ordinaryAdmin")) {
							userMap.put("adminUserType1", roleMap.get("roleCode"));
						}
					}
					System.out.println(userMap.get("adminUserType"));
					if(userMap.get("adminUserType")!=null||userMap.get("adminUserType1")!=null) {
						return Result.success(userMap);
					}else {
						return Result.error("该用户不是管理员!");
					}
				}else {
					return Result.error("密码错误!");
				}
			}else {
				return Result.error(ResultEnum.EMAIL_NOT_EXIST.getCode(),ResultEnum.EMAIL_NOT_EXIST.getMsg());
			}
		}else {
			//再判断成功后,再查询用户名是否存在
			if(blogUserService.isExistUsername(loginName)>0) {
				Map<String,Object> userMap= blogUserService.blogUserLoginByUserName(loginName, password);
				System.out.println(userMap);
				if(userMap!=null) {
					userMap.put("loginUserIdType", "username");
					String userId=(String) userMap.get("userId");
					System.out.println("用户ID:"+userId);
					List<Map<String,Object>> rolelist= blogUserRoleService.selectUserRole(userId);
					for (Map<String,Object> roleMap:rolelist) {
						if(roleMap.containsValue("superAdmin")) {
							userMap.put("adminUserType", roleMap.get("roleCode"));
						}
						if(roleMap.containsValue("ordinaryAdmin")) {
							userMap.put("adminUserType1", roleMap.get("roleCode"));
						}
					}
					System.out.println(userMap.get("adminUserType"));
					if(userMap.get("adminUserType")!=null||userMap.get("adminUserType1")!=null) {
						System.out.println(userId+"{}}}{{}"+(String)userMap.get("username"));
						// 在客户端存储用户个性化信息，方便用户下次再访问网站时使用
//						try {
//							Cookie cookie = new Cookie("usersId", URLEncoder.encode(userId, "utf-8"));
//							// cookie.setPath("/");
//							cookie.setMaxAge(60 * 60 * 24);
//							response.addCookie(cookie);
//			 
//							Cookie cookie2 = new Cookie("userName", URLEncoder.encode((String)userMap.get("username"), "utf-8"));
//							// cookie.setPath("/");
//							cookie2.setMaxAge(60 * 60 * 24);
//							response.addCookie(cookie2);
//						}catch(UnsupportedEncodingException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						return Result.success(userMap);
					}else {
						return Result.error("该用户不是管理员!");
					}
				}
				return Result.error("密码错误!");
			}else {
				return Result.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
			}
		}
	}
}
