package com.init.mascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiMascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMascotasApplication.class, args);
	}

}
