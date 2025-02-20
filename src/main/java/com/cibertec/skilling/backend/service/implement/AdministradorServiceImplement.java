package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.AdministradorNotFoundException;
import com.cibertec.skilling.backend.mapper.AdministradorMapper;
import com.cibertec.skilling.backend.model.dto.request.AdministradorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AdministradorResponseDTO;
import com.cibertec.skilling.backend.model.entity.Administrador;
import com.cibertec.skilling.backend.repository.AdministradorRepository;
import com.cibertec.skilling.backend.service.AdministradorService;

@Service
public class AdministradorServiceImplement implements AdministradorService {
    
    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;

    public AdministradorServiceImplement(AdministradorRepository administradorRepository, AdministradorMapper administradorMapper) {
        this.administradorRepository = administradorRepository;
        this.administradorMapper = administradorMapper;
    }

    @Override
    public List<AdministradorResponseDTO> findAllAdministradores() {
        return administradorRepository.findAll()
            .stream()
            .map(administradorMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public AdministradorResponseDTO findAdministradorById(String id) {
        return administradorRepository.findById(id)
            .map(administradorMapper::toResponseDTO)
            .orElseThrow(() -> new AdministradorNotFoundException("[Error 404] Adminitrador no encontrador con id: " + id));
    }

    @Override
    public AdministradorResponseDTO createAdministrador(AdministradorRequestDTO requestDTO) {
        Administrador administrador = administradorMapper.toEntity(requestDTO);
        Administrador savedAdministrador = administradorRepository.save(administrador);
        return administradorMapper.toResponseDTO(savedAdministrador);
    }

    @Override
    public AdministradorResponseDTO updateAdministrador(String id, AdministradorRequestDTO requestDTO) {
        Administrador existingAdministrador = administradorRepository.findById(id)
            .orElseThrow(() -> new AdministradorNotFoundException("[Error 404] Administrador no encontrado con id: " + id));
        existingAdministrador.setUsuario(requestDTO.getUsuario());
        Administrador updatedAdministrador = administradorRepository.save(existingAdministrador);
        return administradorMapper.toResponseDTO(updatedAdministrador);
    }

    @Override
    public void deleteAdministrador(String id) {
        Administrador existingAdministrador = administradorRepository.findById(id)
            .orElseThrow(() -> new AdministradorNotFoundException("[Error 404] Administrador no encontrado con id: " + id));
        administradorRepository.delete(existingAdministrador);
    }
}
