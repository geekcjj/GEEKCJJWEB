package com.maike.myblog.service.impl;

import com.maike.myblog.entity.LoginLog;
import com.maike.myblog.mapper.LoginLogMapper;
import com.maike.myblog.service.ILoginLogService;
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
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {
	@Resource
	private LoginLogMapper loginLogMapper;

	@Override
	public int insertLoginLog(LoginLog log) {
		// TODO Auto-generated method stub
		return baseMapper.insert(log);
	}

	@Override
	public PageInfo<Map<String, Object>> listLoginLog(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		List<Map<String, Object>> docs = loginLogMapper.listLoginLog();
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(docs);
		return pageInfo;
	}

	@Override
	public int deleteLoginLog(String id) {
		// TODO Auto-generated method stub
		return baseMapper.deleteById(id);
	}

}
