package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.ClaseRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.model.entity.Clase;

@Mapper(componentModel = "spring")
public interface ClaseMapper {
    
    @Mapping(target = "grado.id", source = "gradoId")
    @Mapping(target = "profesor.id", source = "profesorId")
    Clase toEntity(ClaseRequestDTO requestDTO);

    @Mapping(source = "grado.id", target = "gradoId")
    @Mapping(source = "profesor.id", target = "profesorId")
    ClaseResponseDTO toResponseDTO(Clase clase);
}
