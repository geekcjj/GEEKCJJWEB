package com.maike.myblog.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: GEEKCJJWeb
 * @description: 防SQL注入参数校验工具类
 * @author: GarryChan
 * @create: 2020-10-30 16:55
 **/
public class SqlConvertUtil {
    public static Logger logger = LoggerFactory.getLogger(SqlConvertUtil.class);

    public final static String regex = "'|#|%|;|--| and | and|and | or | or|or | not | not|not " +
            "| use | use|use | insert | insert|insert | delete | delete|delete | update | update|update " +
            "| select | select|select | count | count|count | group | group|group | union | union|union " +
            "| create | create|create | drop | drop|drop | truncate | truncate|truncate | alter | alter|alter " +
            "| grant | grant|grant | execute | execute|execute | exec | exec|exec | xp_cmdshell | xp_cmdshell|xp_cmdshell " +
            "| call | call|call | declare | declare|declare | source | source|source | sql | sql|sql ";
    /**
     *
     * @param originStr 原始值
     * @param DBLength 最大长度
     * @param standardStr 标准值(取值范围)
     * @param notEmpty 是否为空，true 不可为空，fasle 可为空
     * by ChenYb date 2019-05-14
     * @return
     */
    public static boolean isVaild(String originStr,int DBLength,String verifyRange,boolean notEmpty){
        int config = 0;
        /*是否允许为空 ture 不允许为空*/
        if (StringUtils.isEmpty(originStr)||StringUtils.isBlank(originStr))
            if (!notEmpty)
                return true;
            else
                return false;
        /*sql安全值,占位*会报错,这里不限制*/
        String newOriginStr = originStr.replaceAll("(?i)" + regex, "");
        logger.debug("analysis before {}",originStr);
        logger.debug("analysis later {}",newOriginStr);
        if (newOriginStr.length() < originStr.length())
            config += 1;
        //json数据跳过
        if (originStr.contains( "{" )
                &&originStr.contains( "}" )
                &&originStr.contains( ":" )
                &&(originStr.contains( "'" )||originStr.contains( "\"" ))
        ){
            logger.debug("analysis JSON ：true --- Length check skip");
            DBLength = 0;
        }
        /*预订长度范围*/
        if (0 != DBLength)
            if (newOriginStr.length() > DBLength)
                config += 1;
        logger.debug("analysis valid length {}",DBLength);
        logger.debug("analysis origin length {}",newOriginStr.length());
        /*预定值范围*/
        if (null != verifyRange && StringUtils.isNotEmpty(verifyRange.trim())) {
            if (!verifyRange.contains(originStr)) {
                config += 1;
            }
            logger.debug("VERIFY RANGE   ==>{}<==",verifyRange);
        }else
            logger.debug("VERIFY RANGE   ==>{}<==","NOT RANGE!");
        logger.info("isVaild - config :{}",config);
        return config==0?true:false;
    }

}
