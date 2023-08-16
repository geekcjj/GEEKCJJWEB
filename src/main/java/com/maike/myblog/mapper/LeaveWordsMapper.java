package com.maike.myblog.mapper;

import com.maike.myblog.entity.LeaveWords;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@Mapper
public interface LeaveWordsMapper extends BaseMapper<LeaveWords> {
	List<Map<String,Object>> selectLeaveWords();
	Integer selectLeaveWordsCount();
}
