package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;

import com.cibertec.skilling.backend.model.dto.request.GradoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GradoResponseDTO;
import com.cibertec.skilling.backend.model.entity.Grado;

@Mapper(componentModel = "spring")
public interface GradoMapper {

    Grado toEntity(GradoRequestDTO requestDTO);

    GradoResponseDTO toResponseDTO(Grado grado);
}
