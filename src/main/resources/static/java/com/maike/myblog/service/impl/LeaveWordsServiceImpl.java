package com.maike.myblog.service.impl;

import com.maike.myblog.entity.LeaveWords;
import com.maike.myblog.mapper.LeaveWordsMapper;
import com.maike.myblog.service.ILeaveWordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-30
 */
@Service
public class LeaveWordsServiceImpl extends ServiceImpl<LeaveWordsMapper, LeaveWords> implements ILeaveWordsService {

	@Override
	public List<Map<String, Object>> selectAllLeaveWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOneLeaveWords(LeaveWords leaveWords) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneLeaveWords(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMoreLeaveWords(String... ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneLeaveWords(LeaveWords leaveWords) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> blogAllLeaveWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> blogNew10LeaveWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> blogOneLeaveWords(String lwId) {
		// TODO Auto-generated method stub
		return null;
	}

}
