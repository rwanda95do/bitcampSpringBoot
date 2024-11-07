package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("user.dao")
@ComponentScan(basePackages = {"user.controller", "user.service.impl", "user.dao"})
@SpringBootApplication
//@SpringBootApplication (exclude = DataSourceAutoConfiguration.class)
public class Chapter02MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter02MySqlApplication.class, args);
	}

}
