package com.maike.myblog.service;

import com.maike.myblog.entity.IndexGallery;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
public interface IIndexGalleryService extends IService<IndexGallery> {
	List<IndexGallery> blogAllIndexGallery();

	PageInfo<IndexGallery> getAllIndexGallery(int currentPage, int pageSize);

	int insertBlogIndexGallery(IndexGallery gallery);

	int updateBlogIndexGallery(IndexGallery gallery);

	int deleteBlogIndexGallery(String id);
}
