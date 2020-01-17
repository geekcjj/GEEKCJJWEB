package com.maike.myblog.mapper;

import com.maike.myblog.entity.BlogUserPwd;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-27
 */
public interface BlogUserPwdMapper extends BaseMapper<BlogUserPwd> {
	Integer registerIncertPwd(BlogUserPwd blogUserPwd);
	Integer modifyUserPwd(BlogUserPwd blogUserPwd);
}
