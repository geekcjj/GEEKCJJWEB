package com.maike.myblog.service.impl;

import com.maike.myblog.entity.Category;
import com.maike.myblog.mapper.CategoryMapper;
import com.maike.myblog.service.ICategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

	@Resource
	private CategoryMapper categoryMapper;
	@Override
	public List<Category> selectAllCategory() {
		// TODO Auto-generated method stub
		return baseMapper.selectList(new QueryWrapper<Category>().orderByAsc(""));
	}
	@Override
	public int insertOneCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneCategory(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMoreCategory(String... ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> blogAllCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.selectAllCategoryAndCount();
	}

}
