package com.example.sercurity_jwt;

import com.example.sercurity_jwt.configs.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
//@SecuritySem
public class SercurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SercurityJwtApplication.class, args);
	}

}
