package com.trabajopractico.sistema.repositories;

import java.util.Optional;

import com.trabajopractico.sistema.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
