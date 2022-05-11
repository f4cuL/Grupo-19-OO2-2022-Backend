// package com.trabajopractico.sistema.service;

// import java.util.Collection;
// import java.util.Collections;

// import com.trabajopractico.sistema.entities.Administrador;
// import com.trabajopractico.sistema.entities.Usuario;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// @Component
// public class CustomUserDetails implements  UserDetails{
	
// 	private Usuario usuario;
	
// 	public CustomUserDetails() {
// 	}

// 	public CustomUserDetails(Usuario usuario) {
// 		super();
// 		this.usuario = usuario;
// 	}

// 	@Override
// 	public Collection<? extends GrantedAuthority> getAuthorities() {
// 		if (this.usuario.getClass().equals(Usuario.class)) {
// 			return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
// 		} else if (this.usuario.getClass().equals(Administrador.class)) {
// 			return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
// 		} else {
// 			return Collections.singleton(new SimpleGrantedAuthority("ROLE_AUDITOR"));
// 		}
// 	}

// 	@Override
// 	public String getPassword() {
// 		return usuario.getContrasenia();
// 	}

// 	@Override
// 	public String getUsername() {
// 		return usuario.getNombreUsuario();
// 	}

// 	@Override
// 	public boolean isAccountNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isAccountNonLocked() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isCredentialsNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isEnabled() {
// 		return (this.usuario.getEstado() ? false : true);
// 	}

// }
