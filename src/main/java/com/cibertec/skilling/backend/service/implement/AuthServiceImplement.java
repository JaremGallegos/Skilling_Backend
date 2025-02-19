package com.cibertec.skilling.backend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.LoginRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LoginResponseDTO;
import com.cibertec.skilling.backend.model.entity.Usuario;
import com.cibertec.skilling.backend.repository.UsuarioRepository;

@Service
public class AuthServiceImplement {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        Usuario usuario = usuarioRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
          
        if (!passwordEncoder.matches(loginRequest.getClave(), usuario.getClave())) {
            throw new BadCredentialsException("Credenciales incorrectas");
        } else {
            return LoginResponseDTO.builder()
                .message("Login Exitoso")
                .build();
        }
    }
}
