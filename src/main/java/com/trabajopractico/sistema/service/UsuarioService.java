package com.trabajopractico.sistema.service;

import com.trabajopractico.sistema.entities.Usuario;
import com.trabajopractico.sistema.interfaces.GenericAbm;

public interface UsuarioService extends GenericAbm<Usuario>{
    public boolean findByNombre(String nombreUsuario);
}
