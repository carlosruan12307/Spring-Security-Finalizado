package com.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.security.security.enums.RoleEnum;
import com.security.security.repository.RoleRepository;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SecurityApplication.class, args);
	}

}
