package com.trabajopractico.sistema.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trabajopractico.sistema.entities.Aula;
import com.trabajopractico.sistema.entities.Espacio;

public interface EspacioRepository extends JpaRepository<Espacio,Integer>{
	
	@Query("SELECT e FROM Espacio e WHERE e.fecha= :fecha and e.turno= :turno and e.aula.id = :aula")
	public Espacio traer(@Param(value = "fecha")LocalDate fecha,@Param(value = "turno") char turno,@Param(value = "aula") int idAula);
	
	@Query("SELECT e FROM Espacio e WHERE e.aula.id = :aula")
	public List<Espacio> traerEspaciosDeAula(@Param(value = "aula") int idAula);
	
	
}
