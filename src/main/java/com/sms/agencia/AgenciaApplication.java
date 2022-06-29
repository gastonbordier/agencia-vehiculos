package com.sms.agencia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sms.agencia.entidades.Camioneta;
import com.sms.agencia.entidades.Motocicleta;
import com.sms.agencia.entidades.Sedan;
import com.sms.agencia.repositories.CamionetaRepository;
import com.sms.agencia.repositories.MotocicletaRepository;
import com.sms.agencia.repositories.SedanRepository;

@SpringBootApplication
//@EntityScan("com.sms.agencia.entidades")
//@EnableJpaRepositories("com.sms.agencia.repository")
public class AgenciaApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AgenciaApplication.class, args);
	}

	@Autowired
	private MotocicletaRepository motocicletaRepository;
	@Autowired
	private SedanRepository sedanRepository;
	@Autowired
	private CamionetaRepository camionetaRepository;

//	@Bean
	public int hardcode() {
		motocicletaRepository.save(new Motocicleta("Benelli", "Tnt 600 I", "Blanco", 5, 2930000, 600));
		motocicletaRepository.save(new Motocicleta("Keller", "Crono Classic", "Rojo", 8, 149990, 110));
		motocicletaRepository.save(new Motocicleta("Zanella", "Hot 90 Shot", "Negro", 10, 214900, 90));
		motocicletaRepository.save(new Motocicleta("Yamaha", "Fz Fi", "Negro", 20, 531800, 150));
		motocicletaRepository.save(new Motocicleta("Benelli", "Leoncino 500", "Verde", 7, 1875000, 500));
		motocicletaRepository.save(new Motocicleta("Benelli", "Leoncino 250", "Gris", 6, 969000, 250));
		motocicletaRepository.save(new Motocicleta("Motomel", "Skua 125", "rojo", 40, 259900, 125));
		motocicletaRepository.save(new Motocicleta("Keeway", "K-light", "Negro", 20, 532900, 200));
		motocicletaRepository.save(new Motocicleta("Zanella", "Styler", "Blanco", 30, 384900, 150));
		motocicletaRepository.save(new Motocicleta("Motomel", "Blitz", "Azul", 12, 157900, 700));
		motocicletaRepository.save(new Motocicleta("Zanella", "Ceccato", "Blanco", 8, 2509990, 700));
		sedanRepository.save(new Sedan("Volkswagen", "Amarok 3.0", "Gris", 0, 11599900, 4, 4, 5, "Diesel", false));
		sedanRepository.save(new Sedan("Volkswagen", "Nivus 1.0", "Blanco", 0, 5990000, 4, 5, 5, "Nafta", false));
		sedanRepository.save(new Sedan("Volkswagen", "Vento 1.4", "Blanco", 0, 7499000, 4, 5, 5, "Nafta", false));
		sedanRepository.save(new Sedan("Citroen", "C3 1.4", "Gris", 0, 1190000, 4, 5, 5, "Nafta", false));
		sedanRepository
				.save(new Sedan("Greely", "Emgrand X7 Sport 2.4", "Blanco", 0, 5900000, 4, 5, 5, "Nafta", false));
		sedanRepository.save(new Sedan("Renault", "Captur 2.0", "Negro", 0, 3590000, 4, 5, 5, "Nafta", false));
		sedanRepository.save(new Sedan("Renault", "Kangoo 1.5", "Gris", 0, 2100000, 4, 5, 5, "Nafta", false));
		sedanRepository.save(new Sedan("Renault", "Kangoo 1.6", "Agua", 0, 3700000, 4, 6, 5, "Nafta", false));
		sedanRepository.save(new Sedan("Chevrolet", "Prisma", "Plateado", 0, 1100000, 4, 4, 5, "GNC", false));
		sedanRepository.save(new Sedan("Peugeot", "207 1.6", "Gris", 0, 2700000, 4, 2, 2, "Nafta", true));
		sedanRepository.save(new Sedan("Ford", "Mustang 4.0", "Rojo", 0, 10400000, 4, 2, 2, "Nafta", true));
		camionetaRepository
				.save(new Camioneta("Iveco", "Eurocargo 160", "Blanco", 3, 4900000, 10, 2, 3, "Diesel", 4200, 30000));
		camionetaRepository.save(new Camioneta("Hino", "816", "Blanco", 4, 9400000, 6, 2, 3, "Diesel", 7500, 4935));
		camionetaRepository.save(new Camioneta("Iveco", "Daily", "Blanco", 1, 8900000, 6, 2, 3, "Diesel", 7200, 4600));
		camionetaRepository
				.save(new Camioneta("Volkswagen", "9-150e", "Blanco", 2, 6300000, 6, 2, 3, "Diesel", 9000, 9000));
		camionetaRepository
				.save(new Camioneta("Iveco", "Eurotech 370", "Blanco", 1, 12000000, 14, 2, 3, "Diesel", 1000, 28000));
		camionetaRepository.save(new Camioneta("Isuzu", "NPR", "Blanco", 1, 16880200, 6, 2, 3, "Diesel", 2500, 5000));
		camionetaRepository
				.save(new Camioneta("Mercedez Benz", "Accelo", "Blanco", 1, 10301600, 6, 2, 3, "Diesel", 3360, 5000));

		return 0;
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
