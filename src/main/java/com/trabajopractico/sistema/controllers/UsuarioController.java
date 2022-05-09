package com.trabajopractico.sistema.controllers;

import java.util.List;

import com.trabajopractico.sistema.entities.Administrador;
import com.trabajopractico.sistema.entities.Usuario;
import com.trabajopractico.sistema.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuService;

    @PostMapping("/usuario")
    public Usuario add(Administrador usuario){
        return usuService.add(usuario);
    }

    @GetMapping("/usuario")
    public List<Usuario> getAllUsers(){
        return usuService.getAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario getUserById(@PathVariable int id){
        return usuService.get(id);
    }

    
}
