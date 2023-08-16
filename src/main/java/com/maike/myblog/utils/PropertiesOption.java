package com.maike.myblog.utils;

import java.io.*;
import java.util.Properties;

/**
 * @author geekcjj
 * @Description
 * @date 2020/5/30 8:28 下午
 * @Version 1.0
 */
public class PropertiesOption {
    //private static final String FILE_PATH=Thread.currentThread().getContextClassLoader().getResource("websiteinfo.properties").getPath();
    private static final String FILE_PATH="websiteinfo.properties";
    private static Properties properties =new Properties();
    /**
     * 修改properties文件中属性值对应的值
     * 修改其样式且顺序改变
     * @param propertity 属性名称
     * @param value 属性值
     */
    public void updatePropertiesOne(String propertity, String value){
        Properties prop = new Properties();
        try {
            prop.load(this.getClass().getResourceAsStream("/"+FILE_PATH));
            prop.setProperty(propertity, value);
        } catch (IOException e) {
            //加载配置文件出错
            e.printStackTrace();
        }

        String basePath = this.getClass().getResource("/").getPath() + FILE_PATH;
        OutputStream out;
        try {
            out = new FileOutputStream(basePath);
            prop.store(out, null);
        } catch (FileNotFoundException e) {
            //配置文件未发现
            e.printStackTrace();
        } catch (IOException e) {
            //配置文件内容写入出错
            e.printStackTrace();
        }
    }

    /**
     * 修改properties文件中属性值对应的值
     * 不修改其样式
     * @param propertiesName properties文件名称
     * @param propertity 属性名称
     * @param value 属性值
     */
    public void updatePropertiesTwo(String propertiesName, String propertity, String value){

        String basePath = this.getClass().getResource("/").getPath() + propertiesName;
        FileReader fr = null;
        BufferedReader bf = null;
        StringBuffer buf = new StringBuffer();
        try {
            fr = new FileReader(basePath);
            bf = new BufferedReader(fr);

            String line = null;
            while( (line = bf.readLine()) != null){
                String cloneLine = line;
                if(line.trim().indexOf("#", 0) == 0){
                    buf.append(cloneLine);
                }else{
                    String property = cloneLine.trim().split("=")[0];
                    if(propertity.equals(property.trim())){
                        buf.append(property.trim() + " = " + value);
                    }else{
                        buf.append(cloneLine);
                    }
                }
                buf.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            //文件读取失败
            e.printStackTrace();
        } finally{
            if(bf != null){
                try {
                    bf.close();
                } catch (IOException e) {
                    //带缓冲的字符输入流关闭失败
                    e.printStackTrace();
                }
            }
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(basePath);
            bw = new BufferedWriter(fw);
            bw.write(buf.toString());
        } catch (IOException e) {
            //字符输出流类创建失败
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    //带缓冲的字符输出流关闭失败
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     *
     */
    public static void load() throws IOException{
        properties=new Properties();
        InputStream inputStream = PropertiesOption.class.getClassLoader().getResourceAsStream(FILE_PATH);
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
        try{
            properties.load(bf);
        }catch(IOException e) {
            e.printStackTrace();
        }
        //        try(FileInputStream fis = new FileInputStream(FILE_PATH)){
//            properties.load(fis);
//        }
    }
    /**
     * 操作文件
     * @param key
     * @param value
     * @return
     */
    public static Boolean optionProperty(String key,String value){
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)){
            if(properties == null){
                load();
            }
            properties.setProperty(key, value);
            // 将Properties集合保存到流中
            properties.store(fos, "");
        } catch (IOException e) {
            //log.error(propertiesName+" load failed",e);
            return false;
        }
        return true;
    }
    /**
     * 修改
     * @param key
     * @param value
     * @return
     */
    public static Boolean updateProperty(String key,String value) {
        if(getValue(key) == null) {
            //log.info(propertiesName+" does not have this key");
            return false;
        }
        return optionProperty(key,value);
    }
    /**
     * 新增
     * @param key
     * @param value
     * @return
     */
    public static Boolean addProperty(String key,String value) {
        if(getValue(key)!= null) {
        //System.out.println(propertiesName+" already has this key");
        return false;
        }
        return optionProperty(key, value);
    }
    /**
     * 修改或者新增key
     * @param key
     * @param value
     */
    public static void update(String key, String value) {
        FileOutputStream oFile = null;
        try {
            properties.load(new FileInputStream(FILE_PATH));
            properties.setProperty(key, value);
            oFile = new FileOutputStream(FILE_PATH);
            //将Properties中的属性列表（键和元素对）写入输出流
            properties.store(oFile, "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
                //fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 通过key删除value
     * @param key
     */
    public static void delete(String key) {
        properties.remove(key);
        FileOutputStream oFile = null;
        try {
            oFile = new FileOutputStream(FILE_PATH);
            properties.store(oFile, "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 通过传入的路径及key，获得对应的值
     */
    public static String getValue(String path, String key)
    {
        Properties properties;
        try
        {
            properties = new Properties();
            //这种方式读取中文会出现乱码，因为字节流是无法读取中文的，所以采取reader把inputStream转换成reader用字符流来读取中文。
            //properties.load(PropertiesOption.class.getClassLoader().getResourceAsStream(FILE_PATH));
            //所以采取下面这种方式不会乱码
            InputStream inputStream = PropertiesOption.class.getClassLoader().getResourceAsStream(path);
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            properties.load(bf);
        }
        catch (IOException e)
        {
            throw new RuntimeException("File Read Failed...", e);
        }
        return properties.getProperty(key);
    }
    /**
     * 通过key直接获取对应的值
     */
    public static String getValue(String key)
    {
        Properties properties = new Properties();
        try
        {
            //这种方式读取中文会出现乱码，因为字节流是无法读取中文的，所以采取reader把inputStream转换成reader用字符流来读取中文。
            //properties.load(PropertiesOption.class.getClassLoader().getResourceAsStream(FILE_PATH));
            //所以采取下面这种方式不会乱码
            InputStream inputStream = PropertiesOption.class.getClassLoader().getResourceAsStream(FILE_PATH);
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            properties.load(bf);
        }
        catch (IOException e)
        {
            throw new RuntimeException("File Read Failed...", e);
        }
        return properties.getProperty(key);
    }
}
