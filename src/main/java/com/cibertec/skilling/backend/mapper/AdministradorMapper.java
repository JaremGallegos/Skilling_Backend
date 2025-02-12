package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.AdministradorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AdministradorResponseDTO;
import com.cibertec.skilling.backend.model.entity.Administrador;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {

    @Mapping(target = "usuarioRef.id", source = "usuarioId")
    Administrador toEntity(AdministradorRequestDTO requestDTO);

    @Mapping(source = "usuarioRef.id", target = "usuarioId")
    AdministradorResponseDTO toResponseDTO(Administrador administrador);
}
