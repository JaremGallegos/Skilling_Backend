package com.cibertec.skilling.backend.service.implement;

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

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImplement(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        Usuario usuario = usuarioRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
          
        if (!passwordEncoder.matches(loginRequest.getClave(), usuario.getClave())) {
            throw new BadCredentialsException("Credenciales incorrectas");
        } else {
            return LoginResponseDTO.builder()
                .message("1")
                .build();
        }
    }
}
