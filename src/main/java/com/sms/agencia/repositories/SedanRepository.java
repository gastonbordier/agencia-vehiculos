package com.sms.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sms.agencia.entidades.Sedan;

public interface SedanRepository extends JpaRepository<Sedan, Integer>{
}
