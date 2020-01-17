package com.maike.myblog.service;

import com.maike.myblog.entity.ResourceDownload;
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
 * @since 2019-09-30
 */
public interface IResourceDownloadService extends IService<ResourceDownload> {
	List<Map<String,Object>> selectAllResourceDownload();
	int insertOneResourceDownload(ResourceDownload download);
	int deleteOneResourceDownload(int id);
	int deleteMoreResourceDownload(String... ids);
	int updateOneResourceDownload(ResourceDownload download);
	List<Map<String,Object>> blogAllResourceDownload();
	List<Map<String,Object>> blogTop10ResourceDownload();
	List<Map<String,Object>> blogNew10ResourceDownload();
	List<Map<String,Object>> blogOneResourceDownload(String rdId);
}
