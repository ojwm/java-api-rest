package com.github.ojwm.api.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class RestApplication {

	/**
	 * Start the application
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	/**
	 * Configure the OpenAPI UI
	 * @param appVersion Springdoc version
	 * @return OpenAPI object
	 */
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI().info(new Info()
				.title("Vehicle API")
				.version(appVersion)
				.termsOfService("http://swagger.io/terms/"));
	}
}
