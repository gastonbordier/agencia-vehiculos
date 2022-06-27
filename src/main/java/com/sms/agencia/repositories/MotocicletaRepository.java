package com.sms.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.agencia.entidades.Motocicleta;

@Repository
public interface MotocicletaRepository extends JpaRepository<Motocicleta, Integer>{
	
	
}
