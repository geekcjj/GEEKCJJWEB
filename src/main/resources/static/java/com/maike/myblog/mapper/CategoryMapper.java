package com.maike.myblog.mapper;

import com.maike.myblog.entity.Category;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
public interface CategoryMapper extends BaseMapper<Category> {
	List<Map<String,Object>> selectAllCategoryAndCount();
}
