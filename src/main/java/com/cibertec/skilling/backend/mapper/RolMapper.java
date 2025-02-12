package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;

import com.cibertec.skilling.backend.model.dto.request.RolRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.RolResponseDTO;
import com.cibertec.skilling.backend.model.entity.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {

    Rol toEntity(RolRequestDTO requestDTO);

    RolResponseDTO toResponseDTO(Rol rol);
}
