package com.revature.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.revature"))
				.build()
				.enableUrlTemplating(true)
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
			"Tweeter API",
			"This API is a Twitter Clone where users can build and share their music interests.",
			"1.0",
			"Free to use",
			new springfox.documentation.service.Contact("Team Alchemy", "teamalchemy.com", "magic@teamalchemy.com"),
			"API License",
			"http://teamalchemy.com",
			Collections.emptyList()
		);
	} 
}
	

