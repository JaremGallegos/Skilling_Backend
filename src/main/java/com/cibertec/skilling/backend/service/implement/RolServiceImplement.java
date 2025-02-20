package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.RolNotFoundException;
import com.cibertec.skilling.backend.mapper.RolMapper;
import com.cibertec.skilling.backend.model.dto.request.RolRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.RolResponseDTO;
import com.cibertec.skilling.backend.model.entity.Rol;
import com.cibertec.skilling.backend.repository.RolRepository;
import com.cibertec.skilling.backend.service.RolService;

@Service
public class RolServiceImplement implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServiceImplement(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolResponseDTO> findAllRoles() {
        return rolRepository.findAll()
            .stream()
            .map(rolMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public RolResponseDTO findRolById(Integer id) {
        return rolRepository.findById(id)
            .map(rolMapper::toResponseDTO)
            .orElseThrow(() -> new RolNotFoundException("[Error 404] Rol no encontrado con id: " + id));
    }

    @Override
    public RolResponseDTO createRol(RolRequestDTO requestDTO) {
        Rol rol = rolMapper.toEntity(requestDTO);
        Rol savedRol = rolRepository.save(rol);
        return rolMapper.toResponseDTO(savedRol);
    }

    @Override
    public RolResponseDTO updateRol(Integer id, RolRequestDTO requestDTO) {
        Rol existingRol = rolRepository.findById(id)
            .orElseThrow(() -> new RolNotFoundException("[Error 404] Rol no encontrado con id: " + id));
        existingRol.setTipo(requestDTO.getTipo());
        Rol updatedRol = rolRepository.save(existingRol);
        return rolMapper.toResponseDTO(updatedRol);
    }

    @Override
    public void deleteRol(Integer id) {
        Rol existingRol = rolRepository.findById(id)
            .orElseThrow(() -> new RolNotFoundException("[Error 404] Rol no encontrado con id: " + id));
        rolRepository.delete(existingRol);
    }
}
