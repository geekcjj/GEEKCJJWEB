package com.maike.myblog.utils;


import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Random;

public class ShiroMd5 {
    /**
     * 随机生成 salt 需要指定 它的字符串的长度
     *
     * @param len 字符串的长度
     * @return salt
     */
    public static String generateSalt(int len) {
        //一个Byte占两个字节
//        byte[] byteLen=new byte[1];
//        byteLen[0] = (byte)(len >> 1);
//        Random secureRandom = new Random();
//        return secureRandom.nextBytes(byteLen).toHex();
        return null;
    }

    /**
     * 获取加密后的密码，使用默认hash迭代的次数 1 次
     *
     * @param hashAlgorithm hash算法名称 MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512、etc。
     * @param password      需要加密的密码
     * @param salt          盐
     * @return 加密后的密码
     */
    public static String encryptPassword(String hashAlgorithm, String password, String salt) {
        return encryptPassword(hashAlgorithm, password, salt, 1);
    }

    /**
     * 获取加密后的密码，需要指定 hash迭代的次数
     *
     * @param hashAlgorithm  hash算法名称 MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512、etc。
     * @param password       需要加密的密码
     * @param salt           盐
     * @param hashIterations hash迭代的次数
     * @return 加密后的密码
     */
    public static String encryptPassword(String hashAlgorithm, String password, String salt, int hashIterations) {
        SimpleHash hash = new SimpleHash(hashAlgorithm, password, salt, hashIterations);
        return hash.toString();
    }
}
