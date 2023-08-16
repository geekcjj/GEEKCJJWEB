//package com.maike.myblog.utils;
//
//import org.apache.catalina.security.SecurityUtil;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
///**
// * @author geekcjj
// * @version 1.0
// * @description PasswordEncodeUtil
// * @date 2020/2/13 11:27 下午
// */
//@Component
//public class PasswordEncodeUtil implements PasswordEncoder {
//    @Override
//    public String encode(CharSequence charSequence) {
//        return charSequence.toString();
//    }
//
//    @Override
//    public boolean matches(CharSequence charSequence, String s) {
//        return encode(charSequence).equals(s);
//    }
//
//    @Override
//    public boolean upgradeEncoding(String encodedPassword) {
//        return false;
//    }
//}
