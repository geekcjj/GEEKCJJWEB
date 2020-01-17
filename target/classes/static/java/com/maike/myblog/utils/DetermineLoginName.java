package com.maike.myblog.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @projectname GEEKCJJBlog
 * @author GEEKCJJ
 * @date 2019年9月27日 上午11:30:26
 * @description:Java判断字符串是否为手机号或密码
 *
 */
public class DetermineLoginName {
	/**
	 * 判断是否为手机号
	 * @author zp
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles){ 
		String reg = "^((13[0-9])|(14[5-7])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(reg);  
		Matcher m = p.matcher(mobiles);  
		return m.matches();  
	}
	
	/**
	 * 判断是否为邮箱
	 * @author zp
	 * @param mobiles
	 * @return
	 */
	public static boolean isEmailNO(String emails){ 
		String reg = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(reg);  
		Matcher m = p.matcher(emails);  
		return m.matches();  
	}
}
