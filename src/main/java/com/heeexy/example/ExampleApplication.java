package com.heeexy.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.heeexy.example.dao")
public class ExampleApplication  {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ExampleApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
