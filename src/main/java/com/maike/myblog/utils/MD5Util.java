package com.maike.myblog.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;

public class MD5Util {

	/**
	 * MD5加密
	 * 
	 * @param b
	 * @return
	 */
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	/**
	 * @Description: 对字符串进行md5加密
	 */
	public static String getMD5Encryption(String text) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		String ciphertext = Base64.encodeBase64String(md5.digest(text.getBytes()));
		return ciphertext;
	}
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	//SHiroMD5加密方法
	public static String shiroMd5Encryption(String originalText,String salt){
		//密文
		String ciphertext=null;
		SimpleHash simpleHash = new SimpleHash("MD5", originalText, ByteSource.Util.bytes(salt), 1024);
		ciphertext=simpleHash+"";
		return ciphertext;
	}
	public static void main(String args[]) {
//		String pwd = "123456";
//		String pwdmd5 = MD5Encode(pwd, "utf-8");
//		System.out.println(pwdmd5);
		System.out.println("输出shiroMD5加密后的密文");
		System.out.println(shiroMd5Encryption("88888888","hanenhao"));
	}
}