package com.maike.myblog.service.impl;

import com.maike.myblog.entity.LoginLog;
import com.maike.myblog.mapper.LoginLogMapper;
import com.maike.myblog.service.ILoginLogService;
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
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}
