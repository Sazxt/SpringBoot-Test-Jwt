package com.kitabisa.kitabisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableJpaRepositories(basePackages = "com.kitabisa.kitabisa.repository")
public class KitabisaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitabisaApplication.class, args);
	}

}
