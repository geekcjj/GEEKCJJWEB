package com.maike.myblog.service.impl;

import com.maike.myblog.entity.Tags;
import com.maike.myblog.mapper.TagsMapper;
import com.maike.myblog.service.ITagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

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
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements ITagsService {

	@Override
	public List<Map<String, Object>> selectAllTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOneTag(Tags tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneTag(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMoreTag(String... ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneTag(Tags tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> blogAllTag() {
		// TODO Auto-generated method stub
		return null;
	}

}
