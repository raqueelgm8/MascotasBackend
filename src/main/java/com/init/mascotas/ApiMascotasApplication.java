package com.init.mascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiMascotasApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	                @Override
	                public void addCorsMappings(CorsRegistry registry) {
	                        registry.addMapping("/api/**")
	                                .allowedOrigins("http://localhost:4200")
	                                .allowedMethods("“GET”, “POST”, “PUT”, “DELETE")
	                                .maxAge(3600);
	                }
	        };
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiMascotasApplication.class, args);
	}
}
