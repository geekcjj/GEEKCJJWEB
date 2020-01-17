package com.maike.myblog.service.impl;

import com.maike.myblog.entity.Tags;
import com.maike.myblog.mapper.TagsMapper;
import com.maike.myblog.service.ITagsService;
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
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements ITagsService {

}
