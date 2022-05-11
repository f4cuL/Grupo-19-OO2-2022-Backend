package com.trabajopractico.sistema.controllers;

import com.trabajopractico.sistema.entities.pojo.JWTRequest;
import com.trabajopractico.sistema.entities.pojo.JWTResponse;
import com.trabajopractico.sistema.service.CustomUserDetailsService;
import com.trabajopractico.sistema.utilities.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials");
        }
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        return new JWTResponse(token);
    }
}
