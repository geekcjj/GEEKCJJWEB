package com.maike.myblog.service.impl;

import com.maike.myblog.entity.IndexGallery;
import com.maike.myblog.mapper.IndexGalleryMapper;
import com.maike.myblog.service.IIndexGalleryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-01
 */
@Service
public class IndexGalleryServiceImpl extends ServiceImpl<IndexGalleryMapper, IndexGallery> implements IIndexGalleryService {

	@Override
	public List<IndexGallery> selectAllGallery() {
		// TODO Auto-generated method stub
		return baseMapper.selectList(new QueryWrapper<IndexGallery>().orderByAsc("create_time"));
	}

	@Override
	public int insertOneGallery(IndexGallery gallery) {
		// TODO Auto-generated method stub
		return baseMapper.insert(gallery);
	}

	@Override
	public int deleteOneGallery(int id) {
		// TODO Auto-generated method stub
		return baseMapper.deleteById(id);
	}

	@Override
	public int updateOneGallery(IndexGallery gallery) {
		// TODO Auto-generated method stub
		return baseMapper.updateById(gallery);
	}

	@Override
	public List<IndexGallery> blogIndexGallery() {
		// TODO Auto-generated method stub
		return baseMapper.selectList(new QueryWrapper<IndexGallery>().orderByDesc("create_time"));
	}

}
