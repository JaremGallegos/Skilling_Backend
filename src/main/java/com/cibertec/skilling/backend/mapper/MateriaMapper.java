package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;

import com.cibertec.skilling.backend.model.dto.request.MateriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.MateriaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Materia;

@Mapper(componentModel = "spring")
public interface MateriaMapper {

    Materia toEntity(MateriaRequestDTO requestDTO);

    MateriaResponseDTO toResponseDTO(Materia materia);
}
