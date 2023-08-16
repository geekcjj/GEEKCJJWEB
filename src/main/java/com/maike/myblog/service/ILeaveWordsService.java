package com.maike.myblog.service;

import com.maike.myblog.entity.LeaveWords;

import java.util.List;
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
public interface ILeaveWordsService extends IService<LeaveWords> {
	PageInfo<Map<String,Object>> blogListAllLW(int pageNum, int pageSize);
	PageInfo<LeaveWords> blogListAllLWTwo(int pageNum, int pageSize);
	int deleteUserLW(String id);
	int updateUserLW(LeaveWords leaveWords);
	int insertblogUserLW(LeaveWords leaveWords);
	Integer getLeaveWordsCount();
}
