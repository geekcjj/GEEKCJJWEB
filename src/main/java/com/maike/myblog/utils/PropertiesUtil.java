package com.maike.myblog.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author geekcjj
 * @Description
 * @date 2020/6/4 7:17 下午
 * @Version 1.0
 */
public class PropertiesUtil {
    /**
     * 获取Properties对象
     * @return
     */
    public static Properties getProperties(){
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            //data.properties在resources目录下
            inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("websiteinfo.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("websiteinfo.properties文件未找到!");
        } catch (IOException e) {
            System.out.println("出现IOException");
        } finally {
            try {
                if (null != inputStream){
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("websiteinfo.properties文件流关闭出现异常");
            }
        }
        return properties;
    }

    /**
     * 根据key查询value值
     * @param key key
     * @return
     */
    public static String getValue(String key){
        Properties properties = getProperties();
        String value = properties.getProperty(key);
        return value;
    }

    /**
     * 新增/修改数据
     * @param key
     * @param value
     */
    public static void setValue(String key, String value){
        Properties properties = getProperties();
        properties.setProperty(key, value);
        //此处获取的路径是target下classes

        //这里的path是项目文件的绝对路径
        //先获取项目绝对路径：Thread.currentThread().getContextClassLoader().getResource("").getPath();
        //然后在项目路径后面拼接"properties/sysConfig.properties";
        // 原注释
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        path = path + "data.properties";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            properties.store(fileOutputStream, "注释");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileOutputStream){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("data.properties文件流关闭出现异常");
            }
        }
    }

    /**
     * 删除和修改只有语句不同
     * properties.remove(key);
     */
}
