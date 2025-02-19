package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.GradoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GradoResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.model.entity.Grado;
import com.cibertec.skilling.backend.model.entity.Profesor;

@Mapper(componentModel = "spring")
public interface GradoMapper {
    @Mapping(source = "usuarioRef", target = "usuarioId")
    ProfesorResponseDTO toResponseDTO(Profesor profesor);

    Grado toEntity(GradoRequestDTO requestDTO);

    GradoResponseDTO toResponseDTO(Grado grado);

}
