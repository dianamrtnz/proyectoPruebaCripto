package com.pruebacriptocurrency.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ProyectoPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPruebaApplication.class, args);
	}

}
