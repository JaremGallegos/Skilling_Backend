package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.LeccionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;
import com.cibertec.skilling.backend.model.entity.Leccion;

@Mapper(componentModel = "spring")
public interface LeccionMapper {

    @Mapping(target = "materia.id", source = "materiaId")
    @Mapping(target = "clase.id", source = "claseId")
    @Mapping(target = "profesor.id", source = "profesorId")
    Leccion toEntity(LeccionRequestDTO requestDTO); 

    @Mapping(source = "materia.id", target = "materiaId")
    @Mapping(source = "clase.id", target = "claseId")
    @Mapping(source = "profesor.id", target = "profesorId")
    LeccionResponseDTO toResponseDTO(Leccion leccion);
}
