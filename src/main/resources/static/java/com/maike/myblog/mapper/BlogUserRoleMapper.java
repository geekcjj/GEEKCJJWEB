package com.maike.myblog.mapper;

import com.maike.myblog.entity.BlogUserRole;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-23
 */
public interface BlogUserRoleMapper extends BaseMapper<BlogUserRole> {
	Integer registerInsertOrdianryUser(BlogUserRole blogUserRole);
	Integer addAdminInsertAdminUser(BlogUserRole blogUserRole);
	List<Map<String,Object>> selectUserRole(@Param("userId") String userId);
}
