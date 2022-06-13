package com.sms.agencia.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sms.agencia.entidades.Motocicleta;
import com.sms.agencia.entidades.Persona;
import com.sms.agencia.repository.MotocicletaRepository;

@SpringBootApplication
@EntityScan("com.sms.agencia.entidades")
@EnableJpaRepositories("com.sms.agencia.repository")
public class AgenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaApplication.class, args);
	}

	@Bean
	public int hardcodeoMotos(MotocicletaRepository repository) {
		repository.save(new Motocicleta("aaa", "aaaa", 4, 4, 4));
		return 0;
	}
	

}
