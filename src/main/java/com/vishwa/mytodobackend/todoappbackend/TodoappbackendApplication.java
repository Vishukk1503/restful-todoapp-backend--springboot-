package com.vishwa.mytodobackend.todoappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication


public class TodoappbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappbackendApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings ( @NonNull CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("*")
				.allowedHeaders("*") // Allow all headers
				.allowCredentials(true) // Allow credentials if necessary
				.allowedOrigins("http://localhost:3000", "http://localhost:8080");
				
			}
		};
	}	

}
