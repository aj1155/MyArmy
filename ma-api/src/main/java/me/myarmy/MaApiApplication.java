package me.myarmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MaApiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MaApiApplication.class);
	}
}
