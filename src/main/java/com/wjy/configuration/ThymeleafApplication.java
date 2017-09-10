package com.wjy.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@ComponentScan(basePackages = {"com.wjy"})
@MapperScan(basePackages = {"com.wjy.dao"})
@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}

}
