package com.maike.myblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @projectname spring-boot-demo-02-1
 * @author GEEKCJJ
 * @date 2019年8月5日 上午10:53:56
 * @description:
 *
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig implements WebMvcConfigurer{//WebMvcConfigurationSupport
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.maike.myblog.controller"))
                .paths(PathSelectors.any())
                .build();
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Maike API 接口文档")
                .description("具体项目名称，维护人")
                .termsOfServiceUrl("http://geekcjj.top/")
                //.contact(contact)
                .version("1.0")
                .build();
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html")
        .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/*/*/*")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/webjars/*/*")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
