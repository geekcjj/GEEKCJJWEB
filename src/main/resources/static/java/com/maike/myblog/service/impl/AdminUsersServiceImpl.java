package com.maike.myblog.service.impl;

import com.maike.myblog.entity.AdminUsers;
import com.maike.myblog.mapper.AdminUsersMapper;
import com.maike.myblog.service.IAdminUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-22
 */
@Service
public class AdminUsersServiceImpl extends ServiceImpl<AdminUsersMapper, AdminUsers> implements IAdminUsersService {

}
