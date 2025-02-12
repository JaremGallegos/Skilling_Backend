package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.EstudianteRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EstudianteResponseDTO;
import com.cibertec.skilling.backend.model.entity.Estudiante;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    @Mapping(target = "grado.id", source = "gradoId")
    @Mapping(target = "clase.id", source = "claseId")
    @Mapping(target = "usuarioRef.id", source = "usuarioId")
    Estudiante toEntity(EstudianteRequestDTO requestDTO);

    @Mapping(source = "grado.id", target = "gradoId")
    @Mapping(source = "clase.id", target = "claseId")
    @Mapping(source = "usuarioRef.id", target = "usuarioId")
    EstudianteResponseDTO toResponseDTO(Estudiante estudiante);
}
