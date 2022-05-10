package com.trabajopractico.sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.trabajopractico.sistema.entities.Usuario;
import com.trabajopractico.sistema.repositories.UsuarioRepository;

public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario==null) {
			throw new UsernameNotFoundException("usuario no encontrado");
		}
		
		return new CustomUserDetails(usuario);
	}

}
