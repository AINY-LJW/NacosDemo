/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.comment.user.config
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年10月16日       lijiawen        
 * ============================================================*/

package com.comment.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * TODO Swagger2配置类
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其
 * </p>
 *
 * @author lijiawen
 * @version 2019年10月16日
 */

@Configuration
//启用Swagger2。
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket createRestfulApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				//select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
				.select()
				//扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
				.apis(RequestHandlerSelectors.basePackage("com.comment.user")).paths(PathSelectors.any()).build();
	}

	/**
	 * api信息
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("亚马逊评论分析系统").description("亚马逊评论分析系统")
				.termsOfServiceUrl("http://localhost:8802/homePage").version("1.0").build();
	}

}
