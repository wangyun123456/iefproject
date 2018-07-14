package com.ief.storeproject.videoplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.ief.storeproject.videoplay")
@ComponentScan(basePackages = {"com.ief.storeproject.videoplay"})
public class VideoPlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoPlayApplication.class, args);
	}
}
