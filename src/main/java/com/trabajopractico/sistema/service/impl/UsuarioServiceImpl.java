package com.trabajopractico.sistema.service.impl;

import java.util.List;

import com.trabajopractico.sistema.entities.Usuario;
import com.trabajopractico.sistema.repositories.UsuarioRepository;
import com.trabajopractico.sistema.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepo;

    public Usuario add(Usuario object) {
        return usuarioRepo.save(object);
    }

    public void remove(int id) {
        usuarioRepo.deleteById(id);
    }

    public Usuario modify(int id, Usuario object) {
        Usuario usuario = get(id);
        usuario = object;
        return usuarioRepo.save(usuario);
    }

    public Usuario get(int id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    public List<Usuario> getAll() {
        return usuarioRepo.findAll();
    }

}
