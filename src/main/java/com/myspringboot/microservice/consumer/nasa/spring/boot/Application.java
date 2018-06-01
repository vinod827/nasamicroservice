package com.myspringboot.microservice.consumer.nasa.spring.boot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.myspringboot.microservice.consumer.nasa.controller")
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		String[] beans = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for(String bean:beans) {
			System.out.println("Sorted bean: "+bean);
		}
		
	}
}
