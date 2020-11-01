package com.dlt.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket assetsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Assets API")
				.tags(new Tag("Assets API", "Assets API"))
				.select().apis(RequestHandlerSelectors.basePackage("com.dlt.controller"))
				.paths(regex("/v1/assets.*"))
				.build()
				.apiInfo(this.metaData());
	}

	@Bean
	public Docket projectApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Project API")
				.tags(new Tag("Project API", "Project API"))
				.select().apis(RequestHandlerSelectors.basePackage("com.dlt.controller"))
				.paths(regex("/v1/project.*"))
				.build()
				.apiInfo(this.metaData());
	}

	@Bean
	public Docket clientAccountApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.tags(new Tag("Client Account API", "Client Account API"))
				.groupName("Client Account")
				.select().apis(RequestHandlerSelectors.basePackage("com.dlt.controller"))
				.paths(regex("/v1/clientaccount.*"))
				.build()
				.apiInfo(this.metaData());
	}

	@Bean
	public Docket ramdAppConfigApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.tags(new Tag("Ramd App Config API", "Ramd App Config API"))
				.groupName("Ramd App Config API")
				.select().apis(RequestHandlerSelectors.basePackage("com.dlt.controller"))
				.paths(regex("/v1/ramdappconfig.*"))
				.build()
				.apiInfo(this.metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"DLT Service REST API",
				"DLT Service REST API for Assets,Project,Client Account etc.",
				"1.0",
				"Terms of service",
				new Contact("Shivam Mishra", "https://dlt-service.herokuapp.com/", "shvmmishra.158@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}
