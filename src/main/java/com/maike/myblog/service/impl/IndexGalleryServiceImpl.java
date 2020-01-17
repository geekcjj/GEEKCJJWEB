package com.maike.myblog.service.impl;

import com.maike.myblog.entity.IndexGallery;
import com.maike.myblog.mapper.IndexGalleryMapper;
import com.maike.myblog.service.IIndexGalleryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
public class IndexGalleryServiceImpl extends ServiceImpl<IndexGalleryMapper, IndexGallery>
		implements IIndexGalleryService {

	@Override
	public List<IndexGallery> blogAllIndexGallery() {
		// TODO Auto-generated method stub
		return baseMapper.selectList(new QueryWrapper<IndexGallery>().orderByAsc("create_time"));
	}

	@Override
	public PageInfo<IndexGallery> getAllIndexGallery(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		List<IndexGallery> docs = baseMapper.selectList(new QueryWrapper<IndexGallery>().orderByAsc("create_time"));
		PageInfo<IndexGallery> pageInfo = new PageInfo<IndexGallery>(docs);
		return pageInfo;
		// return baseMapper.selectMaps(new
		// QueryWrapper<IndexGallery>().orderByAsc("create_time"));
	}

	@Override
	public int insertBlogIndexGallery(IndexGallery gallery) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBlogIndexGallery(IndexGallery gallery) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBlogIndexGallery(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
