package com.maike.myblog.service;

import com.maike.myblog.entity.Category;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
public interface ICategoryService extends IService<Category> {
	List<Category> selectAllCategory();
	int insertOneCategory(Category category);
	int deleteOneCategory(int id);
	int deleteMoreCategory(String... ids);
	int updateOneCategory(Category category);
	List<Map<String,Object>> blogAllCategory();
}
