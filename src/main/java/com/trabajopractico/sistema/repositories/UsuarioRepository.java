package com.trabajopractico.sistema.repositories;

import java.util.List;

import com.trabajopractico.sistema.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.estado = false")
    public List<Usuario> findAll();

    @Modifying
    @Query("Update Usuario u set u.estado = true where id = ?1")
    public void deleteById(int id);
    
    Usuario findByNombreUsuario(String nombreUsuario);

    //select e from aulas where edificion.nombre = aula.edificio
    //select e from edificio where edificio.id = "id" 
    

}
