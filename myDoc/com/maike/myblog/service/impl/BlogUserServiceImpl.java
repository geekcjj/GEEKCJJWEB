package com.maike.myblog.service.impl;

import com.maike.myblog.entity.BlogUser;
import com.maike.myblog.mapper.BlogUserMapper;
import com.maike.myblog.service.IBlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {

}
