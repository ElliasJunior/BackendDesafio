package com.elias;

import com.elias.Repository.UserRepository;
import com.elias.model.Users;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class CrudSpringApplication {


	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository){
		return args -> {
			userRepository.deleteAll();

			Users u = new Users();
			u.setName("SuperAdmin");
			u.setEmail("admin@hotmail.com");
			u.setSenha("adminadmin");
			u.setPerfil("Administrador");
			u.setValidado("Sim");

			userRepository.save(u);

		};


	}

}
