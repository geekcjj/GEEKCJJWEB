package com.maike.myblog.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @projectname AllProjectUtils
 * @author GEEKCJJ
 * @date 2019年10月21日 上午12:03:01
 * @description:
 *
 */
public class TestingNumberTypeUtil {
	/**
	 * 校验身份证
	 * 
	 * @param idCard
	 * @return 校验通过返回true，否则返回false
	 */
	public boolean isIDCard(String idCard) {
		String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
		return Pattern.matches(REGEX_ID_CARD, idCard);
	}

	/**
	 * Java 使用
	 */
	String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
	/**
	 * 最新java手机号校验
	 */
	String PHONE_NUMBER_REG_NEW = "^(1[3-9])\\d{9}$";

	/**
	 * JS 使用
	 */
	// "18016381232".match(/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/);
	/**
	 * 判断是否为手机号
	 * 
	 * @author zp
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		// String reg = "^((13[0-9])|(14[5-7])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		String reg = "^(1[3-9])\\d{9}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/**
	 * 判断是否为邮箱
	 * 
	 * @author zp
	 * @param mobiles
	 * @return
	 */
	public static boolean isEmailNO(String emails) {
		String reg = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(emails);
		return m.matches();
	}

	public static void main(String[] args) {
		System.out.println(isMobileNO("17256896549"));
		System.out.println(isEmailNO("17896354893@qq.com"));
	}
}