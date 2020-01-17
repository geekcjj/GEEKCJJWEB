package com.maike.myblog.service.impl;

import com.maike.myblog.entity.BlogUser;
import com.maike.myblog.mapper.BlogUserMapper;
import com.maike.myblog.mapper.BlogUserPwdMapper;
import com.maike.myblog.mapper.BlogUserRoleMapper;
import com.maike.myblog.service.IBlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {
	@Resource
	private BlogUserMapper blogUserMapper;
	@Resource
	private BlogUserPwdMapper blogUserPwdMapper;
	@Resource
	private BlogUserRoleMapper blogUserRoleMapper;
//	@Override
//	public Map<String, Object> blogUserLogin(String loginName, String password) {
//		// TODO Auto-generated method stub
//		/**
//		 * 在用户登录是判断用户登录名的类型,以启用不同的登录方式
//		 */
//		Map<String,Object> userMap=new HashMap<String, Object>();
//		/**
//		 * 判断登录名是否为手机
//		 */
//		if(DetermineLoginName.isMobileNO(loginName)) {
//			//再判断成功后,再查询手机号是否存在
//			if(baseMapper.selectCount(new QueryWrapper<BlogUser>().eq("phone", loginName))>0) {
//				userMap= blogUserMapper.blogUserLoginByPhone(loginName, password);
//				String userId=(String) userMap.get("userId");
//				System.out.println("用户ID:"+userId);
//				List<Map<String,Object>> rolelist= blogUserRoleMapper.selectUserRole(userId);
//				for (Map<String,Object> roleMap:rolelist) {
//					if(roleMap.containsValue("ordinaryUser")) {
//						userMap.put("userType", roleMap.get("roleCode"));
//					}
//				}
//				return userMap;
//			}else {
//				userMap.put("loginMsg", "手机号不存在");
//				return userMap;
//			}
//		}
//		/**
//		 * 判断登录名是否为邮箱
//		 */
//		else if(DetermineLoginName.isEmailNO(loginName)) {
//			//再判断成功后,再查询邮箱是否存在
//			if(baseMapper.selectCount(new QueryWrapper<BlogUser>().eq("email", loginName))>0) {
//				userMap= blogUserMapper.blogUserLoginByEmail(loginName, password);
//				String userId=(String) userMap.get("userId");
//				System.out.println("用户ID:"+userId);
//				List<Map<String,Object>> rolelist= blogUserRoleMapper.selectUserRole(userId);
//				for (Map<String,Object> roleMap:rolelist) {
//					if(roleMap.containsValue("ordinaryUser")) {
//						userMap.put("userType", roleMap.get("roleCode"));
//					}
//				}
//				return userMap;
//			}else {
//				userMap.put("loginMsg", "邮箱不存在");
//				return userMap;
//			}
//		}else {
//			//再判断成功后,再查询用户名是否存在
//			if(blogUserMapper.isExistUserName(loginName)>0) {
//				userMap= blogUserMapper.blogUserLoginByUserName(loginName, password);
//				if(userMap!=null) {
//					String userId=(String) userMap.get("userId");
//					System.out.println("用户ID:"+userId);
//					List<Map<String,Object>> rolelist= blogUserRoleMapper.selectUserRole(userId);
//					for (Map<String,Object> roleMap:rolelist) {
//						if(roleMap.containsValue("ordinaryUser")) {
//							userMap.put("userType", roleMap.get("roleCode"));
//						}
//					}
//				}else {
//					userMap=new HashMap<String, Object>();
//					userMap.put("loginMsg", "密码错误");
//				}
//				return userMap;
//			}else {
//				userMap.put("loginMsg", "用户不存在");
//				return userMap;
//			}
//		}
//	}
	@Override
	public Map<String, Object> blogUserLoginByUserName(String loginName, String password) {
		return blogUserMapper.blogUserLoginByUserName(loginName, password);
	}
	@Override
	public Map<String, Object> blogUserLoginByPhone(String loginName, String password) {
		return blogUserMapper.blogUserLoginByPhone(loginName, password);
	}
	@Override
	public Map<String, Object> blogUserLoginByEmail(String loginName, String password) {
		return blogUserMapper.blogUserLoginByEmail(loginName, password);
	}
//	@Override
//	public Map<String, Object> blogAdminUserLogin(String loginName, String password) {
//		// TODO Auto-generated method stub
//		/**
//		 * 在用户登录是判断用户登录名的类型,以启用不同的登录方式
//		 */
//		if(DetermineLoginName.isMobileNO(loginName)) {
//			Map<String,Object> userMap= blogUserMapper.blogUserLoginByPhone(loginName, password);
//			String userId=(String) userMap.get("userId");
//			System.out.println("用户ID:"+userId);
//			List<Map<String,Object>> rolelist= blogUserRoleMapper.selectUserRole(userId);
//			for (Map<String,Object> roleMap:rolelist) {
//				if(roleMap.containsValue("superAdmin")) {
//					userMap.put("userType", roleMap.get("roleCode"));
//				}
//				if(roleMap.containsValue("ordinaryAdmin")) {
//					userMap.put("userType", roleMap.get("roleCode"));
//				}
//			}
//			return userMap;
//		}
//		else if(DetermineLoginName.isEmailNO(loginName)) {
//			Map<String,Object> userMap= blogUserMapper.blogUserLoginByEmail(loginName, password);
//			String userId=(String) userMap.get("userId");
//			System.out.println("用户ID:"+userId);
//			List<Map<String,Object>> rolelist= blogUserRoleMapper.selectUserRole(userId);
//			for (Map<String,Object> roleMap:rolelist) {
//				if(roleMap.containsValue("superAdmin")) {
//					userMap.put("userType", roleMap.get("roleCode"));
//				}
//				if(roleMap.containsValue("ordinaryAdmin")) {
//					userMap.put("userType", roleMap.get("roleCode"));
//				}
//			}
//			return userMap;
//		}else {
//			Map<String,Object> userMap= blogUserMapper.blogUserLoginByUserName(loginName, password);
//			String userId=(String) userMap.get("userId");
//			System.out.println("用户ID:"+userId);
//			List<Map<String,Object>> rolelist= blogUserRoleMapper.selectUserRole(userId);
//			for (Map<String,Object> roleMap:rolelist) {
//				if(roleMap.containsValue("superAdmin")) {
//					userMap.put("userType", roleMap.get("roleCode"));
//				}
//				if(roleMap.containsValue("ordinaryAdmin")) {
//					userMap.put("userType", roleMap.get("roleCode"));
//				}
//			}
//			return userMap;
//		}
//	}
	
	@Override
	public Integer blogUserRegister(BlogUser blogUser) {
		// TODO Auto-generated method stub
//		if(blogUserMapper.isExistUserName(blogUser.getUsername())>0) {
//		}
		return baseMapper.insert(blogUser);
	}

	@Override
	public Integer blogUserUpdate(BlogUser blogUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogUser> blogUserInfomationDisplay(BlogUser blogUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String,Object>> selectUserRole(BlogUser blogUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer isExistUsername(String username) {
		// TODO Auto-generated method stub
		return blogUserMapper.isExistUserName(username);
	}
	@Override
	public Map<String, Object> selectUserBriefByUserName(String userName) {
		// TODO Auto-generated method stub
		return blogUserMapper.selectUserBriefByUserName(userName);
	}
	@Override
	public Map<String, Object> selectUserInfoByUserName(String userName) {
		// TODO Auto-generated method stub
		return blogUserMapper.selectUserInfoByUserName(userName);
	}

}
