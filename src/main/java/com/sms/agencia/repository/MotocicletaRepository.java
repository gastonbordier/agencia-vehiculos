package com.sms.agencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sms.agencia.entidades.Motocicleta;

@Repository
public interface MotocicletaRepository extends JpaRepository<Motocicleta, Integer>{
	List<Motocicleta> findAll();
	List<Motocicleta> findAllByMarca(String marca);
	Motocicleta findById(int id);
}
