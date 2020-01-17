package com.maike.myblog.service;

import com.maike.myblog.entity.LoginLog;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface ILoginLogService extends IService<LoginLog> {
	/**
	 * 插入登录日志
	 * 
	 * @param log
	 * @return
	 */
	int insertLoginLog(LoginLog log);

	/**
	 * 查询登录日志
	 * 
	 * @return
	 */
	PageInfo<Map<String, Object>> listLoginLog(int currentPage, int pageSize);

	/**
	 * 删除登录日志
	 * 
	 * @param id
	 * @return
	 */
	int deleteLoginLog(String id);
}
