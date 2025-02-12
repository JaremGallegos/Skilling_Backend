package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.TareaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.TareaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Tarea;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    @Mapping(target = "leccion.id", source = "leccionId")
    Tarea toEntity(TareaRequestDTO requestDTO);

    @Mapping(source = "leccion.id", target = "leccionId")
    TareaResponseDTO toResponseDTO(Tarea tarea);
}
