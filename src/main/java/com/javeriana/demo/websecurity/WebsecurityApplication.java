package com.javeriana.demo.websecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsecurityApplication.class, args);
		
//		System.out.print(new BCryptPasswordEncoder().encode("12345"));
	}

}
