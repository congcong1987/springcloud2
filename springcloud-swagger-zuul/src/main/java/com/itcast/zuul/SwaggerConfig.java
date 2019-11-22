package com.itcast.zuul;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 @Bean
	    public Docket buildDocket() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .apiInfo(buildApiInf()) // .apiInfo(apiInfo())
	        .select()
	        .apis(RequestHandlerSelectors.basePackage(""))// 需要生成文档的包的位置
	        .paths(PathSelectors.any())
	        .build();
	    }

	    private ApiInfo buildApiInf() {
	    return new ApiInfoBuilder()
	        .title("海外智能云平台系统接口详情--皮皮虾")
	        .description("Zuul+Swagger2构建RESTful APIs")
	        .termsOfServiceUrl("http://www.skyworth.com")
	        .contact(new Contact("skyworth", "http://www.skyworth.com", ""))
	        .version("1.0")
	        .build();
	    }
}
