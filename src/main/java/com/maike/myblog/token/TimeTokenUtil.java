package com.maike.myblog.token;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.maike.myblog.consts.ConstValue;
import com.maike.myblog.enums.ResultEnum;
import com.maike.myblog.utils.DateUtil;
import com.maike.myblog.utils.Result;
import com.maike.myblog.utils.SHAUtil;

/** 
 * @ClassName: TimeTokenUtil 
 * @Description: 时效令牌工具
 * @author: WeiZheng
 * @date: 2018年8月22日 上午11:22:43  
 */
public class TimeTokenUtil {
	/**
	 * token --> timeTokenEntity 用户信息 集合信息
	 */
    private static Map<String,TimeTokenEntity> userMap = new HashMap<>();
    /**
     * account --> token 账户名称 映射令牌 信息
     */
    private static Map<String,String> tokenMap = new HashMap<>();
    
    /**
     * 更具传入的部分实体信息 生成令牌
    * @Title: getToken 
    * @Description:  
    * @param userEntity 账户 编号 分销商编号 ip地址 客户端需要封装好
    * @return String 令牌字符
    * @author WeiZheng
    * @date 2018年8月22日上午11:44:22
     */
    public static String getToken(TimeTokenEntity userEntity){
    	String token = null;
    	/**
    	 * 补充信息
    	 * 创建时间更新时间 过期时间 令牌
    	 */
    	if(null == userEntity){
    		return token;
    	}
    	Date now = new Date();
    	userEntity.setCreateTime(now);
    	userEntity.setUpdateTime(now);
    	userEntity.setExpiredTime(DateUtil.getExpiredTime(now, 1));
    	token = SHAUtil.getMD5(userEntity.toString());
    	userEntity.setToken(token);
    	/**
    	 * 放入集合中
    	 */
    	userMap.put(token, userEntity);
    	tokenMap.put(userEntity.getAccount(), token);
    	return token;
    }
    /**
     * 验证授权是否合法
    * @Title: validateToken 
    * @Description:  
    * @param token
    * @return String
    * @author WeiZheng
    * @date 2018年8月22日上午11:52:34
     */
    public static String validateToken(String token){
    	String back = "error:不合法令牌";
    	if(null == token || "".equals(token.trim())){
    		return back;
    	}
    	TimeTokenEntity entity = userMap.get(token);
    	if(null == entity){
    		back = "error:未授权";
    	}else{
    		/**
    		 * FIXBUG: 偶尔会出现 过时时间null 异常
    		 * 添加空指针判断 进行重新赋值
    		 */
    		if(null == entity.getExpiredTime()){
    			entity.setExpiredTime(DateUtil.getExpiredTime(entity.getUpdateTime(), 1));
    		}
    		if(entity.getExpiredTime().before(new Date())){
    			back = "error:授权过时";
    		}else{
    			back = "success";
    		}
    	}
    	return back;
    }
    /**
     * 根据token获取登录账户的信息
    * @Title: getEntityByToken 
    * @Description:  
    * @param token 令牌
    * @return TimeTokenEntity
    * @author WeiZheng
    * @date 2018年8月22日上午11:54:09
     */
    public static TimeTokenEntity getEntityByToken(String token){
    	return userMap.get(token);
    }
    /**
     * 
     * 登出 根据令牌
    * @Title: loginOutByToken 
    * @Description:  
    * @param token
    * @return Boolean 登出成功则返回true 若失败 或者不存在则返回false
    * @author WeiZheng
    * @date 2018年8月22日上午11:59:01
     */
    public static Boolean loginOutByToken(String token){
    	Boolean isSuccess = false;
    	/**
    	 * 移除userMap
    	 * 移除account
    	 */
    	TimeTokenEntity  entity = userMap.get(token);
    	if(null == entity){
    	}else{
    		tokenMap.remove(entity.getAccount());
    		userMap.remove(token);
    		isSuccess = true;
    	}
    	return isSuccess;
    }
    /**
     * 根据账户名称进行登出
    * @Title: loginOutByAccount 
    * @Description:  
    * @param account 账户名称 
    * @return Boolean 若登出成功返回成功 反之则返回false
    * @author WeiZheng
    * @date 2018年8月22日下午12:02:28
     */
    public static Boolean loginOutByAccount(String account){
    	Boolean isSuccess = false;
    	String token = tokenMap.remove(account);
    	if(null != token){
    		userMap.remove(token);
    		isSuccess = true;
    	}
    	return isSuccess;
    }
    /**
     *  更新时效令牌信息 该方法先暂时 编写 具体是用或者不用待定
    * @Title: updateTimeToken 
    * @Description:  
    * @param userEntity 账户名称不能为空 最好传入的时候就包含全部必要信息
    * @return String 时效令牌
    * @author WeiZheng
    * @date 2018年8月22日下午12:05:36
     */
    public static String updateTimeToken(TimeTokenEntity userEntity){
    	String token = null;
    	if(null == userEntity){
    		return token;
    	}
    	String oldToken = tokenMap.get(userEntity.getAccount());
    	/**
    	 * 不为空
    	 */
    	if(null != oldToken){
    		TimeTokenEntity entity = userMap.get(oldToken);
    		if(null == entity){
    			/**
    			 * 实体的信息的不对称
    			 * 重新创建
    			 */
    			token = getToken(userEntity);
    		}else{
    			/**
    			 * 更新对应的信息
    			 */
    			token = SHAUtil.getMD5(userEntity.toString());
    			Date now = new Date();
    			entity.setUpdateTime(now);
    			entity.setExpiredTime(DateUtil.getExpiredTime(now, 1));
    			entity.setToken(token);
    			userMap.put(token, userEntity);
    			tokenMap.put(userEntity.getAccount(), token);
    		}
    	}else{
    		/**
    		 * 需要进行添加 新的令牌信息
    		 */
    		token = getToken(userEntity);
    	}
    	return token;
    }
    /**
     * 验证时限授权令牌
    * @Title: basicValidateTimeToken 
    * @Description:  
    * @param request
    * @return Map<String,Object> code(200 401 400) message(SUCCESS FAIL) result 
    * if return code = 200  will back result TimeTokenEntity else if return code = 401 则返回相应的信息 message  result  是返回的controller的结果集
    * @author WeiZheng
    * @date 2018年9月7日上午11:56:44
     */
    public static Map<String,Object> basicValidateTimeToken(HttpServletRequest request){
    	Map<String,Object> backMap = new HashMap<>();
    	/**
    	 * 确定请求该API的身份
    	 * 首先根据获取token 根据token 查询对应的用户信息
    	 * 获取对应请求用户的编号 分销商编号 进行操作下单 
    	 */
    	TimeTokenEntity entity = null;
    	String token = request.getParameter("token");
    	if(null == token){
    		backMap.put(ConstValue.TIME_TOKEN_CODE, 400);
    		backMap.put(ConstValue.TIME_TOKEN_MESSAGE, "token参数异常");
    		backMap.put(ConstValue.TIME_TOKEN_RESULT, Result.error(ResultEnum.SERVER_ERROR.getCode(), "token参数异常"));
    	}else{
    		entity = TimeTokenUtil.getEntityByToken(token);
    	}
    	if(null == entity){
    		backMap.put(ConstValue.TIME_TOKEN_CODE, 401);
    		backMap.put(ConstValue.TIME_TOKEN_MESSAGE, "权限验证异常");
    		backMap.put(ConstValue.TIME_TOKEN_RESULT, Result.error(ResultEnum.AUTH_ERROR.getCode(), "权限验证异常"));
    	}else{
    		backMap.put(ConstValue.TIME_TOKEN_CODE, 200);
    		backMap.put(ConstValue.TIME_TOKEN_MESSAGE, "验证成功");
    		backMap.put(ConstValue.TIME_TOKEN_RESULT, entity);
    	}
    	return backMap;
    } 
}
