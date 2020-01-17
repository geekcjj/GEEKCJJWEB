package com.maike.myblog.mapper;

import com.maike.myblog.entity.LeaveWords;

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
public interface LeaveWordsMapper extends BaseMapper<LeaveWords> {
	List<Map<String,Object>> selectLeaveWords();
	Integer selectLeaveWordsCount();
}
