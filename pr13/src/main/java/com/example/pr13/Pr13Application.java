package com.example.pr13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Pr13Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Pr13Application.class, args);
		Student student = ctx.getBean("student", Student.class);
		SpringApplication.exit(ctx);

	}

}
