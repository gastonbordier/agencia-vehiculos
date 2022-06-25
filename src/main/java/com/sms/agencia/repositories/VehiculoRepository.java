package com.sms.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.agencia.entidades.Camioneta;
import com.sms.agencia.entidades.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{
}
