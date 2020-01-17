package com.maike.myblog.service;

import com.maike.myblog.entity.IndexGallery;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-01
 */
public interface IIndexGalleryService extends IService<IndexGallery> {
	List<IndexGallery> selectAllGallery();
	int insertOneGallery(IndexGallery gallery);
	int deleteOneGallery(int id);
	int updateOneGallery(IndexGallery gallery);
	List<IndexGallery> blogIndexGallery();
}
