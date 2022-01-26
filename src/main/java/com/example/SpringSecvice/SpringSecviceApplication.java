package com.example.SpringSecvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringSecviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecviceApplication.class, args);
	}
}
