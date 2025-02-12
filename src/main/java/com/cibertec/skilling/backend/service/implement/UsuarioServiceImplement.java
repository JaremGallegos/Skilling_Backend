package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.UsuarioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;
import com.cibertec.skilling.backend.service.UsuarioService;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Override
    public List<UsuarioResponseDTO> findAllUsuarios() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllUsuarios'");
    }

    @Override
    public UsuarioResponseDTO findUsuarioById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findUsuarioById'");
    }

    @Override
    public UsuarioResponseDTO createUsuario(UsuarioRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createUsuario'");
    }

    @Override
    public UsuarioResponseDTO updateUsuario(String id, UsuarioRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUsuario'");
    }

    @Override
    public void deleteUsuario(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteUsuario'");
    }
}
