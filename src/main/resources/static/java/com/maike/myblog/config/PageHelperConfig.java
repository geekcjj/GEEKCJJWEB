package com.maike.myblog.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * @projectname GEEKCJJBlog
 * @author GEEKCJJ
 * @date 2019年9月20日 下午3:51:26
 * @description:
 *
 */
@Configuration
public class PageHelperConfig {
	@Bean
	public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        properties.setProperty("pageSizeZero","true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("autoRuntimeDialect","true");
        properties.setProperty("params=count","countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
//	用法在service中使用
//	String current=request.getParameter("currentpage");
//	PageInfo<Entity> pageuser=usersService.selectDocByPage(Integer.parseInt(current), 2);
//	System.out.println("页号："+pageuser.getPages()+"每页数量："+pageuser.getPageNum()+"总数："+pageuser.getSize()+"数据："+JsonUtils.objectToJsonStr(pageuser.getList())+"后面");
}
