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

    public boolean findByNombre(String nombreUsuario) {
        return (usuarioRepo.findByNombreUsuario(nombreUsuario)==null);
    }

    public void remove(int id) {
        usuarioRepo.deleteById(id);
    }

    public Usuario modify(int id, Usuario object) {
        Usuario usuario = get(id);
        usuario.setNombreUsuario(object.getNombreUsuario());
        usuario.setApellido(object.getApellido());
        usuario.setNombre(object.getNombre());
        usuario.setContrasenia(object.getContrasenia());
        usuario.setCorreo(object.getCorreo());
        usuario.setDocumento(object.getDocumento());
        return usuarioRepo.save(usuario);
    }

    public Usuario get(int id) {
        return usuarioRepo.findById(id).orElse(new Usuario());
    }

    public List<Usuario> getAll() {
        return usuarioRepo.findAll();
    }

}
