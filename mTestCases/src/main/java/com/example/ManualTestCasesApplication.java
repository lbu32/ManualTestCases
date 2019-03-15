package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ManualTestCasesApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ManualTestCasesApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<ManualTestCasesApplication> applicationClass = ManualTestCasesApplication.class;

}
