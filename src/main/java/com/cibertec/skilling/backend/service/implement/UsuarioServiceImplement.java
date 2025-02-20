package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.UsuarioNotFoundException;
import com.cibertec.skilling.backend.mapper.UsuarioMapper;
import com.cibertec.skilling.backend.model.dto.request.UsuarioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Usuario;
import com.cibertec.skilling.backend.repository.UsuarioRepository;
import com.cibertec.skilling.backend.service.UsuarioService;
import com.cibertec.skilling.backend.utils.AppConfig;

@Service
public class UsuarioServiceImplement implements UsuarioService {
    
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final AppConfig passwordEncoder;

    public UsuarioServiceImplement(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, AppConfig passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UsuarioResponseDTO> findAllUsuarios() {
        return usuarioRepository.findAll()
            .stream()
            .map(usuarioMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findUsuarioById(String id) {
        return usuarioRepository.findById(id)
            .map(usuarioMapper::toResponseDTO)
            .orElseThrow(() -> new UsuarioNotFoundException("[Error 404] Usuario no encontrado con id: " + id));
    }

    @Override
    public UsuarioResponseDTO createUsuario(UsuarioRequestDTO requestDTO) {
        Usuario usuario = usuarioMapper.toEntity(requestDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(savedUsuario);
    }

    @Override
    public UsuarioResponseDTO updateUsuario(String id, UsuarioRequestDTO requestDTO) {
        Usuario existingUsuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new UsuarioNotFoundException("[Error 404] Usuario no encontrado con id: " + id));
        existingUsuario.setEmail(requestDTO.getEmail());
        existingUsuario.setClave(passwordEncoder.passwordEncoder().encode(requestDTO.getClave()));
        Usuario updatedUsuario = usuarioRepository.save(existingUsuario);
        return usuarioMapper.toResponseDTO(updatedUsuario);
    }

    @Override
    public void deleteUsuario(String id) {
        Usuario existingUsuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new UsuarioNotFoundException("[Error 404] Usuario no encontrado con id: " + id));
        usuarioRepository.delete(existingUsuario);
    }
}
