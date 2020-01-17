package com.maike.myblog.utils;

import java.util.UUID;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月25日 下午6:24:38
 * @description:
 *
 */
public class FileNameUtils {
	private static String uuid=UUID.randomUUID().toString().replace("-", "");
	private static String timestamp=System.currentTimeMillis()+"";
	/**
	 * 获取文件后缀
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName){
	  return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/**
	 * 生成新的文件名
	 * @param fileOriginName 源文件名
	 * @return
	 */
	public static String getFileName(String fileOriginName){
	  return timestamp + FileNameUtils.getSuffix(fileOriginName);
	}
}
