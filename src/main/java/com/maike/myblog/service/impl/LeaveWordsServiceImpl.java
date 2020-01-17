package com.maike.myblog.service.impl;

import com.maike.myblog.entity.LeaveWords;
import com.maike.myblog.mapper.LeaveWordsMapper;
import com.maike.myblog.service.ILeaveWordsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@Service
public class LeaveWordsServiceImpl extends ServiceImpl<LeaveWordsMapper, LeaveWords> implements ILeaveWordsService {
	@Resource
	LeaveWordsMapper leaveMapper;
	@Override
	public PageInfo<Map<String,Object>> blogListAllLW(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> docs = leaveMapper.selectLeaveWords();
		PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(docs);
		return pageInfo;
	}

	@Override
	public PageInfo<LeaveWords> blogListAllLWTwo(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<LeaveWords> docs = leaveMapper.selectList(new QueryWrapper<LeaveWords>().orderByAsc("create_time"));
		PageInfo<LeaveWords> pageInfo = new PageInfo<LeaveWords>(docs);
		return pageInfo;
	}
	
	@Override
	public int deleteUserLW(String id) {
		// TODO Auto-generated method stub
		return baseMapper.deleteById(id);
	}

	@Override
	public int updateUserLW(LeaveWords leaveWords) {
		// TODO Auto-generated method stub
		return baseMapper.updateById(leaveWords);
	}

	@Override
	public int insertblogUserLW(LeaveWords leaveWords) {
		// TODO Auto-generated method stub
		return baseMapper.insert(leaveWords);
	}

	@Override
	public Integer getLeaveWordsCount() {
		// TODO Auto-generated method stub
		return leaveMapper.selectLeaveWordsCount();
	}

}
