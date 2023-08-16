//package com.maike.myblog.service;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.maike.myblog.entity.BlogUser;
//import com.maike.myblog.entity.MyUserDetails;
//import com.maike.myblog.mapper.BlogUserMapper;
//import com.maike.myblog.utils.TestingNumberTypeUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Map;
//
///**
// * @author geekcjj
// * @version 1.0
// * @description MyCustomUserService
// * @date 2020/2/14 10:54 下午
// */
//@Component
//public class MyCustomUserService implements UserDetailsService {
//
//    @Resource
//    private BlogUserMapper blogUserMapper;
//
//    /**
//     * 登陆验证时，通过username获取用户的所有权限信息
//     * 并返回UserDetails放到spring的全局缓存SecurityContextHolder中，以供授权器使用
//     */
//    @Override
//    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
//        MyUserDetails myUserDetails = new MyUserDetails();
//        myUserDetails.setUsername(loginName);
//        Map<String,Object> userMap;
//        /**
//         * 判断登录名是否为手机
//         */
//        if (TestingNumberTypeUtil.isMobileNO(loginName)) {
//            userMap = blogUserMapper.selectPwdByPhoneNumber(loginName);
//        } else if (TestingNumberTypeUtil.isEmailNO(loginName)) {
//            // loginUserIdType.equals("email")||loginUserIdType=="email"
//            userMap = blogUserMapper.selectPwdByEmail(loginName);
//        } else {
//            userMap = blogUserMapper.selectPwdByUsername(loginName);
//        }
//        myUserDetails.setPassword((String) userMap.get("password"));
//        return myUserDetails;
//    }
//}
