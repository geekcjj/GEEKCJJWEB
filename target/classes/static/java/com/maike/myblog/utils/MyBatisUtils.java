package com.maike.myblog.utils;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/** 
 * @ClassName: MyBatisUtils 
 * @Description: 工具类
 * @author: geekcjj
 * @date: 2018年7月26日 上午11:01:40  
 */
public class MyBatisUtils {

	private static final String CONFIG_PATH = "mybatis/mybatis.xml";

    /*
     * 获取数据库访问链接
     */
    public static SqlSession getSqlSession() {
        SqlSession session = null;
        try {
            InputStream stream = Resources.getResourceAsStream(CONFIG_PATH);
            // 可以根据配置的相应环境读取相应的数据库环境
            // SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
            // stream, "development");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
    static StringBuilder sb = new StringBuilder();;
    /*
     * 获取数据库访问链接
     */
    public static void closeSession(SqlSession session) {
        session.close();
    }    
    /**
    * @Title: getTableList 
    * @Description:  获取数据库的全部数据表集合
    * @return List<String>
    * @author WeiZheng
    * @date 2018年7月26日上午11:10:53
     */
    public static List<String> getTableList(){
    	List<String> tableList = null;
    	SqlSession sqlSession = MyBatisUtils.getSqlSession();
    	TableDao tableDao = sqlSession.getMapper(TableDao.class);
    	tableList = tableDao.listTable();
    	MyBatisUtils.closeSession(sqlSession);
        return tableList;
    }
    public static String mapUnderscoreToCamelCase(String tableName){
    	// 清除sb缓存
    	sb.setLength(0);
    	String tableNameNew = tableName.replaceFirst("tb_", "");
    	String [] tableNameArray =  tableNameNew.split("_");
    	Integer length = tableNameArray.length;
    	// 重新赋值
    	for(int i=0;i<length;i++){
    		sb.append((tableNameArray[i].charAt(0)+"").toUpperCase());
    		sb.append(tableNameArray[i].substring(1));
    	}
    	return sb.toString();
    }
    public static void main(String[] args) {
    	
    	System.out.println(getTableList());
//    	String tableName = "tb_product_to_param";
//    	System.out.println(mapUnderscoreToCamelCase(tableName));
//    	String tableName1 = "message2";
//    	System.out.println(mapUnderscoreToCamelCase(tableName1));
    	//batchInsertSucaiList();
    	//batchInsertCollegeList();
    	//batchInsertLshList();
	}
}
