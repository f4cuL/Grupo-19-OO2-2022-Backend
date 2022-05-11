package com.trabajopractico.sistema.service;

import java.util.Collection;
import java.util.Collections;

import com.trabajopractico.sistema.entities.Usuario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetails implements  UserDetails{
	
	private Usuario usuario;
	
	public CustomUserDetails() {
	}

	public CustomUserDetails(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println(this.usuario.getClass().toString());
		//TODO LOGICA CON EL GETCLASS PARA LOS ROLES
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return usuario.getContrasenia();
	}

	@Override
	public String getUsername() {
		return usuario.getNombreUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
