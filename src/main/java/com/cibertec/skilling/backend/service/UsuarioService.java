package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.UsuarioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;

public interface UsuarioService {
    List<UsuarioResponseDTO> findAllUsuarios();
    UsuarioResponseDTO findUsuarioById(String id);
    UsuarioResponseDTO createUsuario(UsuarioRequestDTO requestDTO);
    UsuarioResponseDTO updateUsuario(String id, UsuarioRequestDTO requestDTO);
    void deleteUsuario(String id);
}
