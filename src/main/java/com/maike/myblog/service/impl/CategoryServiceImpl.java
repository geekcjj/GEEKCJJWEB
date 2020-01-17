package com.maike.myblog.service.impl;

import com.maike.myblog.entity.Category;
import com.maike.myblog.mapper.CategoryMapper;
import com.maike.myblog.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Map<String, Object>> blogAllCategoryAndCount() {
		// TODO Auto-generated method stub
		return categoryMapper.selectAllCategoryAndCount();
	}

}
