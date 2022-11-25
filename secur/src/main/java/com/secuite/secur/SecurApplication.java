package com.secuite.secur;

import com.secuite.secur.modele.role;
import com.secuite.secur.modele.utilisateur;
import com.secuite.secur.service.serv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication

public class SecurApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurApplication.class, args);
	}
    @Bean
	PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner start( serv e ) throws Exception {
		return  args -> {

			e.ajouter(("admin"));
			e.ajouter("user");

			e.ajout(new utilisateur(null,"fatoumata","1234",new ArrayList<role>()));
			e.ajout(new utilisateur(null,"Hadi","5678",new ArrayList<role>()));
			e.addroleToUser("fatoumata","admin");
			e.addroleToUser("fatoumata","user");
			e.addroleToUser("Hadi","user");
		};
	}

}
