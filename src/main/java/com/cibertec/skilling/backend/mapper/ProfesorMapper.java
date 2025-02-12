package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.ProfesorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.model.entity.Profesor;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    @Mapping(target = "usuarioRef.id", source = "usuarioId")
    Profesor toEntity(ProfesorRequestDTO requestDTO);

    @Mapping(source = "usuarioRef.id", target = "usuarioId")
    ProfesorResponseDTO toResponseDTO(Profesor profesor);
}
