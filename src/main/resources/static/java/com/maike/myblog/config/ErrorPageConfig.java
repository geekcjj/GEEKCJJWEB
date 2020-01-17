package com.maike.myblog.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @projectname GEEKCJJBlog
 * @author GEEKCJJ
 * @date 2019年9月23日 上午2:04:39
 * @description:
 *
 */
@Component
public class ErrorPageConfig implements ErrorPageRegistrar{

	public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error400Page");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error401Page");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500Page");
        registry.addErrorPages(error400Page,error401Page,error404Page,error500Page);
        //WebMvcConfigurer.super.addViewControllers(registry);
    }
//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401");
//                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
//                ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
//                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
//
//                container.addErrorPages(error401Page,error404Page,error403Page,error500Page);
//            }
//        };
//	}

}
