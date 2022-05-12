package com.trabajopractico.sistema.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.trabajopractico.sistema.entities.Administrador;
import com.trabajopractico.sistema.entities.Auditoria;
import com.trabajopractico.sistema.entities.Usuario;
import com.trabajopractico.sistema.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public Usuario add(@Valid @RequestBody Usuario usuario) throws Exception{
       if(usuarioService.findByNombre(usuario.getNombreUsuario())){
        return usuarioService.add(usuario);
       } else{
           throw new Exception("Ya existe ese usuario");
       } 
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuario/admin")
    public Usuario add(@Valid @RequestBody Administrador usuario) throws Exception{
        if(usuarioService.findByNombre(usuario.getNombreUsuario())){
            return usuarioService.add(usuario);
           } else{
               throw new Exception("Ya existe ese usuario");
           }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuario/auditoria")
    public Usuario add(@Valid @RequestBody Auditoria usuario) throws Exception {
        if (usuarioService.findByNombre(usuario.getNombreUsuario())) {
            return usuarioService.add(usuario);
        } else {
            throw new Exception("Ya existe ese usuario");
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('AUDITORIA')")
    @GetMapping("/usuario")
    public List<Usuario> getAllUsers(HttpServletRequest request){
        return usuarioService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('AUDITORIA')")
    @GetMapping("/usuario/{id}")
    public Usuario getUserById(@PathVariable int id){
        return usuarioService.get(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/usuario/{id}")
    public Usuario modifyUserById(@PathVariable int id, @Valid @RequestBody Usuario usuario){
        return usuarioService.modify(id,usuario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuario/{id}")
    public void deleteUserById(@PathVariable int id){
        usuarioService.remove(id);
    }
    
    @GetMapping("/home")
    public String home() {
    	return "home";
    }
    
    @GetMapping("/admin")
    public String admin() {
    	return "admin";
    }

    @GetMapping("/logout")
    public String logout() {
    	return "admin";
    }
     
}
