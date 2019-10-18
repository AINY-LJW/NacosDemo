package com.comment.consumer.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 拦截器配置类
 * 拦截器配置类是为了配置拦截器的使用,可以配置多个拦截器注入即可
 * <p>TODO 类描述</p>
 *
 * <p><br>
 *
 * @author lijiawen
 * @version 2019年2月20日
 */
@SuppressWarnings("deprecation")

@SpringBootConfiguration
public class WebMvnConfigurer extends WebMvcConfigurerAdapter{
	@Autowired
    private WebInterceptor webInterceptor;
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	final String[] notLoginInterceptPaths = {"/login/**","/error/**","/login"};
    	//拦截器的拦截路径，（最初使用”/**”，然后使用excludePathPatterns方法排除路径，但是排除不成功,可以查看打印出来的requestURI，
    	//最终使用单独配置的方式，有待改善）
//        registry.addInterceptor(webInterceptor).excludePathPatterns("/jw-crz/token");
//        registry.addInterceptor(webInterceptor).addPathPatterns("/**").excludePathPatterns("/jw-crz/login").excludePathPatterns("/error");
    	 registry.addInterceptor(new WebInterceptor()).addPathPatterns("/homePage").excludePathPatterns(notLoginInterceptPaths);
//        registry.addInterceptor(webInterceptor).excludePathPatterns("/error");
        registry.addInterceptor(webInterceptor).addPathPatterns("/**/ryclxx");
        registry.addInterceptor(webInterceptor).addPathPatterns("/**/xzyh");
        registry.addInterceptor(webInterceptor).addPathPatterns("/**/news");
        super.addInterceptors(registry);
    }

}
