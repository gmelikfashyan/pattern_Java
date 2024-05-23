package com.example.pr12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Pr12Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Pr12Application.class, args);
		HashClass hashClass = ctx.getBean(HashClass.class);
		SpringApplication.exit(ctx);
	}

}
