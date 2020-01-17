package com.maike.myblog.mapper;

import com.maike.myblog.entity.LoginLog;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {
	List<Map<String, Object>> listLoginLog();
}
