package com.maike.myblog.service;

import com.maike.myblog.entity.Category;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface ICategoryService extends IService<Category> {
	List<Map<String, Object>> blogAllCategoryAndCount();
}
