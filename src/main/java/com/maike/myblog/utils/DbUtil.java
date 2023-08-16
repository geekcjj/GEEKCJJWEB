package com.maike.myblog.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 数据库工具类
 */
public class DbUtil {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println("加载mybatis成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载mybatis失败");
        }
    }


    public static SqlSession getSqlSession(boolean autoCommit) {
        return sqlSessionFactory.openSession(autoCommit);
    }


    public static SqlSession getSqlSession() {
//        return sqlSessionFactory.openSession(true);
        return getSqlSession(true);
    }

}
