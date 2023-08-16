package com.maike.myblog.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @Author GeekPlus
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class ValidateCharUtil {
    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
    public static final String DEFAULT_QUERY_REGEX = "[!$^&*+=|{}';'\",<>/?~！#￥%……&*——|{}【】‘；：”“'。，、？]";

    /**
     * 判断查询参数中是否以特殊字符开头，如果以特殊字符开头则返回true，否则返回false
     *
     * @param value
     * @return
     * @see {@link #getQueryRegex()}
     * @see {@link #DEFAULT_QUERY_REGEX}
     */
    public boolean specialSymbols(String value) {
        if (StringUtils.isBlank(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(getQueryRegex());
        Matcher matcher = pattern.matcher(value);

        char[] specialSymbols = getQueryRegex().toCharArray();

        boolean isStartWithSpecialSymbol = false; // 是否以特殊字符开头
        for (int i = 0; i < specialSymbols.length; i++) {
            char c = specialSymbols[i];
            if (value.indexOf(c) == 0) {
                isStartWithSpecialSymbol = true;
                break;
            }
        }

        return matcher.find() && isStartWithSpecialSymbol;
    }


    /**
     * 获取查询过滤的非法字符
     *
     * @return
     */
    protected String getQueryRegex() {
        return DEFAULT_QUERY_REGEX;
    }

    /*
     * @Author GeekPlus
     * @Description //TODO
     * @Date
     * @Param
     * @return
     **/
    public static int String_length(String value) {
        int valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        for (int i = 0; i < value.length(); i++) {
            String temp = value.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }
}
