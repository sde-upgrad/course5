package org.upgrad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JeetApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeetApplication.class, args);
	}
}
