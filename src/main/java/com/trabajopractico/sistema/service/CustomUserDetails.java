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
		// TODO Auto-generated method stub
		System.out.println(this.usuario.getClass().toString());
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usuario.getContrasenia();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.getNombreUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
