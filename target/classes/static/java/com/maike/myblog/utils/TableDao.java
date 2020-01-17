package com.maike.myblog.utils;

import java.util.List;

import org.apache.ibatis.annotations.Select;

/** 
 * @ClassName: TableDao 
 * @Description: 
 * @author: geekcjj
 * @date: 2018年7月26日 上午11:07:41  
 */
public interface TableDao {

	 @Select("select TABLE_NAME from information_schema.TABLES where TABLE_SCHEMA=(select database())")
	 List<String> listTable();
	 
	 
}
