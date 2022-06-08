package com.trabajopractico.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.trabajopractico.sistema.entities.Edificio;


@Repository
public interface EdificioRepository extends JpaRepository<Edificio,Integer> {
	
	
	
	
}
