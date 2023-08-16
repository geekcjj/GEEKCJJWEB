package com.maike.myblog.test;

import com.maike.myblog.utils.PropertiesOption;
import com.maike.myblog.utils.PropertiesUtil;

/**
 * @author geekcjj
 * @Description
 * @date 2020/6/4 4:04 下午
 * @Version 1.0
 */
public class TestWebSiteInfo {
    public static void main(String[] args){
        String wsn= PropertiesUtil.getValue("website-name");
        System.out.println(wsn);
//        try{
//            po.updatePropertiesOne("website-name","池塘网");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        PropertiesUtil.setValue("website-info","池塘网");
        System.out.println(PropertiesOption.getValue("website-info"));
    }
}
