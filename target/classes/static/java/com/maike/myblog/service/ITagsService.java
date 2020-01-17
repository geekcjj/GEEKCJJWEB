package com.maike.myblog.service;

import com.maike.myblog.entity.Tags;

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
public interface ITagsService extends IService<Tags> {
	List<Map<String,Object>> selectAllTag();
	int insertOneTag(Tags tag);
	int deleteOneTag(int id);
	int deleteMoreTag(String... ids);
	int updateOneTag(Tags tag);
	List<Map<String,Object>> blogAllTag();
}
