package com.maike.myblog.service;

import com.maike.myblog.entity.LeaveWords;
import com.maike.myblog.entity.ResourceDownload;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-30
 */
public interface ILeaveWordsService extends IService<LeaveWords> {
	List<Map<String,Object>> selectAllLeaveWords();
	int insertOneLeaveWords(LeaveWords leaveWords);
	int deleteOneLeaveWords(int id);
	int deleteMoreLeaveWords(String... ids);
	int updateOneLeaveWords(LeaveWords leaveWords);
	List<Map<String,Object>> blogAllLeaveWords();
	List<Map<String,Object>> blogOneLeaveWords(String lwId);
	List<Map<String,Object>> blogNew10LeaveWords();
}
