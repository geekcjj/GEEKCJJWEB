package com.maike.myblog.service.impl;

import com.maike.myblog.entity.ResourceDownload;
import com.maike.myblog.mapper.ResourceDownloadMapper;
import com.maike.myblog.service.IResourceDownloadService;
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
 * @since 2019-09-30
 */
@Service
public class ResourceDownloadServiceImpl extends ServiceImpl<ResourceDownloadMapper, ResourceDownload> implements IResourceDownloadService {

	@Override
	public List<Map<String, Object>> selectAllResourceDownload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOneResourceDownload(ResourceDownload download) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneResourceDownload(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMoreResourceDownload(String... ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOneResourceDownload(ResourceDownload download) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> blogAllResourceDownload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> blogTop10ResourceDownload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> blogNew10ResourceDownload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> blogOneResourceDownload(String rdId) {
		// TODO Auto-generated method stub
		return null;
	}

}
