package com.maike.myblog.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import freemarker.cache.TemplateCache.MaybeMissingTemplate;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月15日 下午3:54:00
 * @description:
 *
 */
public class CodeGenerator {
	
	//作者
    private static final String author = "geekcjj";
 
    //数据库
    private static final String url = "jdbc:mysql://localhost:3306/geekcjjblog?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "147258cjj";
    private static final String projectPath = System.getProperty("user.dir");
	/**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        //String result=null;
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
            	return ipt;
            }
            scanner.close();
            //return result;
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/myDoc");
//        gc.setAuthor(author);
//        gc.setOpen(false);
//        gc.setIdType(IdType.INPUT);//数据库ID自己输入
//        gc.setBaseResultMap(true);// XML ResultMap
//        gc.setFileOverride(true);//是否覆盖文件
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl(url);
//        // dsc.setSchemaName("public");
//        dsc.setDriverName(driverName);
//        dsc.setUsername(userName);
//        dsc.setPassword(password);
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
////        pc.setModuleName(scanner("模块名"));
//        pc.setParent("com.maike.beauty");
//        mpg.setPackageInfo(pc);
    	//System.out.println(MyBatisUtils.getTableList());
    	generateCode(null);
    	//generateCodeByList(MyBatisUtils.getTableList());
    }
    public static AutoGenerator autoGenerator() {
    	// 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);// 是否打开输出目录,默认true
        //gc.setEnableCache(true); // 是否在xml中添加二级缓存配置,默认false
        gc.setSwagger2(true); // 开启 swagger2 模式,默认false
        gc.setIdType(IdType.INPUT);//数据库ID自己输入
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setFileOverride(true);//是否覆盖文件
        //下面是文件生成的名称
//        gc.setEntityName("%s");
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        gc.setServiceName("I%sService");
//        gc.setServiceImplName("%sServiceImpl");
//        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        return mpg.setDataSource(dsc);

    }
    public static void generateCode(String tablename){//List<String> tblist
    	if(tablename==null||tablename.equals("")) {
    		tablename=scanner("表名");
    	}
    	AutoGenerator mpg=autoGenerator();
    	// 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.maike.myblog");
        //pc.setModuleName(scanner("模块名"));
        //pc.setEntity("pojo");
        mpg.setPackageInfo(pc);
    	// 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
//                return projectPath + "/myDoc/mappers/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                return projectPath + "/myDoc/mappers/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityTableFieldAnnotationEnable(true);//生成实体时，生成字段注解
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(tablename);
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
    public static void generateCodeByList(List<String> tablenamelist) {
    	Long startTime = System.currentTimeMillis();
        for (String tableName : tablenamelist) {
        	//一个一个生成
        	generateCode(tableName);
        }
        System.err.println("批量生成: "+tablenamelist.size()+" 个表，对应的代码文件");
        System.err.println("总共耗时: "+(System.currentTimeMillis()-startTime)+" 毫秒");
    }
}
