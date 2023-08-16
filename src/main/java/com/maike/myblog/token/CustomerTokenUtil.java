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
 * @ClassName: CustomerTokenUtil 
 * @Description: 客户令牌授权工具类
 * @author: WeiZheng
 * @date: 2018年9月18日 上午11:24:05  
 */
public class CustomerTokenUtil {

	/**
	 * token --> CustomerToken 
	 */
	private static  Map<String,CustomerToken> customerMap = new HashMap<>();
	private static Map<String,String> tmpTokenMap = new HashMap<>();
	/**
	 * 获得令牌 时效默认一天
	* @Title: getToken 
	* @Description:  
	* @param customerToken
	* @return String
	* @author WeiZheng
	* @date 2018年9月18日上午11:34:26
	 */
	public static String getToken(CustomerToken customerToken){
		String token = null;
		if(null == customerToken){
			return token;
		}
		token = SHAUtil.getMD5(customerToken.hashCode()+"&*@"+customerToken.getCustomerId()+"!*$"+customerToken.getCustomerName());
		customerMap.put(token, customerToken);
		return token;
	}
	/**
	 * 验证令牌合法性
	* @Title: validateToken 
	* @Description:  
	* @param token 令牌
	* @return Integer -1 参数不合法 -2 令牌非法 -3 令牌失效 1 令牌有效
	* @author WeiZheng
	* @date 2018年9月18日上午11:44:12
	 */
	public static Integer validateToken(String token){
		Integer index = 0;
		if(null == token || "".equals(token.trim())){
			index = -1;
			return index ;
		}
		CustomerToken customerToken = customerMap.get(token);
		if(null == customerToken){
			/**
			 * 令牌实体不存在
			 */
			index = -2;
		}else{
			if(null == customerToken.getExpiredTime()){
				customerToken.setExpiredTime(DateUtil.getExpiredTime(customerToken.getCreateTime(), 1));
			}
			if(new Date().after(customerToken.getExpiredTime())){
				/**
				 * 令牌失效
				 */
				index = -3;
			}else{
				index = 1;
			}
		}
		return index;
	}
	/**
	 * 登出操作
	* @Title: loginOut 
	* @Description:  
	* @param token 令牌字符
	* @return Boolean
	* @author WeiZheng
	* @date 2018年9月18日下午1:57:06
	 */
	public static Boolean loginOut(String token){
		Boolean isSuccess = false;
		if(null != token){
			isSuccess = customerMap.remove(token) != null;
		}
		return isSuccess;
	}
	/**
	 * 获取客户信息实体 根据令牌
	* @Title: getCustomerByToken 
	* @Description:  
	* @param token
	* @return CustomerToken
	* @author WeiZheng
	* @date 2018年9月18日下午2:14:55
	 */
	private static CustomerToken getCustomerByToken(String token){
		if(null == token || "".equals(token.trim())){
			return null;
		}
		return customerMap.get(token);
	}
	private CustomerTokenUtil(){
	}
	/**
     * 验证时限授权令牌  客户权限验证
    * @Title: basicValidateTimeToken 
    * @Description:  
    * @param request
    * @return Map<String,Object> code(200 401 400) message(SUCCESS FAIL) result 
    * if return code = 200  will back result TimeTokenEntity else if return code = 401 则返回相应的信息 message  result  是返回的controller的结果集
    * @author WeiZheng
    * @date 2018年9月7日上午11:56:44
     */
    public static Map<String,Object> basicValidateCustomerTimeToken(HttpServletRequest request){
    	Map<String,Object> backMap = new HashMap<>();
    	/**
    	 * 确定请求该API的身份
    	 * 首先根据获取token 根据token 查询对应的用户信息
    	 * 获取对应请求用户的编号 分销商编号 进行操作下单 
    	 */
    	CustomerToken entity = null;
    	String token = request.getParameter("timeToken");
    	if(null == token){
    		backMap.put(ConstValue.TIME_TOKEN_CODE, 400);
    		backMap.put(ConstValue.TIME_TOKEN_MESSAGE, "token参数异常");
    		backMap.put(ConstValue.TIME_TOKEN_RESULT, Result.error(ResultEnum.SERVER_ERROR.getCode(), "token参数异常"));
    	}else{
    		entity = CustomerTokenUtil.getCustomerByToken(token);
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
    /**
     * 获取临时授权
    * @Title: getTmpToken 
    * @Description:  
    * @param value
    * @return String
    * @author WeiZheng
    * @date 2018年9月19日下午5:10:09
     */
    public static String getTmpToken(String value){
    	String tmpToken = SHAUtil.getMD5StrBySaltAndNewMethod(value+System.currentTimeMillis());
    	tmpTokenMap.put(tmpToken, value);
    	return tmpToken;
    }
    /**
     * 验证临时授权合法性
    * @Title: validateTmpToken 
    * @Description:  
    * @param tmpToken
    * @param value
    * @return Boolean
    * @author WeiZheng
    * @date 2018年9月19日下午5:10:21
     */
    public static Boolean validateTmpToken(String tmpToken,String value){
    	Boolean isValidate = false;
    	String originalValue = tmpTokenMap.remove(tmpToken);
    	if(null != originalValue && null != value && originalValue.equals(value)){
    		isValidate = true; 
    	}
    	return isValidate;
    }
}
