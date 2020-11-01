package com.dlt.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.dlt")
@EnableJpaRepositories(basePackages = "com.dlt.repos")
@EntityScan(basePackages = "com.dlt.model")
@EnableScheduling
public class DltserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DltserviceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods("*");
			}
		};
	}
}

@RestController
class MyController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return "DT Service is live.";
	}
}
