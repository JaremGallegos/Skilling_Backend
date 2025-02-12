package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.AsistenciaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AsistenciaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Asistencia;

@Mapper(componentModel = "spring")
public interface AsistenciaMapper {

    @Mapping(target = "estudiante.id", source = "estudianteId")
    @Mapping(target = "leccion.id", source = "leccionId")
    Asistencia toEntity(AsistenciaRequestDTO requestDTO);

    @Mapping(source = "estudiante.id", target = "estudianteId")
    @Mapping(source = "leccion.id", target = "leccionId")
    AsistenciaResponseDTO toResponseDTO(Asistencia asistencia);
}
