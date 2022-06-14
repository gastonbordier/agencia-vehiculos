package com.sms.agencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sms.agencia.dataMotocicletas.Motocicleta;
import com.sms.agencia.dataMotocicletas.MotocicletaRepository;
import com.sms.agencia.dataSedanes.SedanRepository;
import com.sms.agencia.repository.CamionetaRepository;

@SpringBootApplication
//@EntityScan("com.sms.agencia.entidades")
//@EnableJpaRepositories("com.sms.agencia.repository")
public class AgenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaApplication.class, args);
	}

//	@Bean
//	public int hardcode(MotocicletaRepository motocicletaRepository, SedanRepository sedanRepository,
//			CamionetaRepository camionetaRepository) {
//		motocicletaRepository.save(new Motocicleta("Benelli", "Tnt 600 I", "Blanco", 0, 2930000, 600));
//		motocicletaRepository.save(new Motocicleta("Keller", "Crono Classic", "Rojo", 0, 149990, 110));
//		motocicletaRepository.save(new Motocicleta("Zanella", "Hot 90 Shot", "Negro", 0, 214900, 90));
//		motocicletaRepository.save(new Motocicleta("Yamaha", "Fz Fi", "Negro", 0, 531800, 150));
//		motocicletaRepository.save(new Motocicleta("Benelli", "Leoncino 500", "Verde", 0, 1875000, 500));
//		motocicletaRepository.save(new Motocicleta("Benelli", "Leoncino 250", "Gris", 0, 969000, 250));
//		motocicletaRepository.save(new Motocicleta("Motomel", "Skua 125", "rojo", 0, 259900, 125));
//		motocicletaRepository.save(new Motocicleta("Keeway", "K-light", "Negro", 0, 532900, 200));
//		motocicletaRepository.save(new Motocicleta("Zanella", "Styler", "Blanco", 0, 384900, 150));
//		motocicletaRepository.save(new Motocicleta("Motomel", "Blitz", "Azul", 0, 157900, 700));
//		motocicletaRepository.save(new Motocicleta("Zanella", "Ceccato", "Blanco", 0, 2509990, 700));
//		sedanRepository.save(new Sedan("Volkswagen", "Amarok 3.0", "Gris", 0, 11599900, 4, 4, 5, "Diesel", false));
//		sedanRepository.save(new Sedan("Volkswagen", "Nivus 1.0", "Blanco", 0, 5990000, 4, 5, 5, "Nafta", false));
//		sedanRepository.save(new Sedan("Volkswagen", "Vento 1.4", "Blanco", 0, 7499000, 4, 5, 5, "Nafta", false));
//		sedanRepository.save(new Sedan("Citroen", "C3 1.4", "Gris", 0, 1190000, 4, 5, 5, "Nafta", false));
//		sedanRepository.save(new Sedan("Greely", "Emgrand X7 Sport 2.4", "Blanco", 0, 5900000, 4, 5, 5, "Nafta", false));
//		sedanRepository.save(new Sedan("Renault", "Captur 2.0", "Negro", 0, 3590000, 4, 5, 5, "Nafta", false));
//		sedanRepository.save(new Sedan("Renault", "Kangoo 1.5", "Gris", 0, 2100000, 4, 5, 5, "Nafta", false));
//		sedanRepository.save(new Sedan("Renault", "Kangoo 1.6", "Agua", 0, 3700000, 4, 6, 5, "Nafta", false));
//		sedanRepository.save(new Sedan("Chevrolet", "Prisma", "Plateado", 0, 1100000, 4, 4, 5, "GNC", false));
//		sedanRepository.save(new Sedan("Peugeot", "207 1.6", "Gris", 0, 2700000, 4, 2, 2, "Nafta", true));
//		sedanRepository.save(new Sedan("Ford", "Mustang 4.0", "Rojo", 0, 10400000, 4, 2, 2, "Nafta", true));
//		return 0;
//	}

}
