package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.AsistenciaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AsistenciaResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.EstudianteResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;
import com.cibertec.skilling.backend.model.entity.Asistencia;

@Mapper(componentModel = "spring")
public interface AsistenciaMapper {

    @Mapping(target = "estudiante.id", source = "estudianteId")
    @Mapping(target = "leccion.id", source = "leccionId")
    Asistencia toEntity(AsistenciaRequestDTO requestDTO);

    @Mapping(source = "estudiante.id", target = "estudianteId", qualifiedByName = "mapEstudiante")
    @Mapping(source = "leccion.id", target = "leccionId", qualifiedByName = "mapLeccion")
    AsistenciaResponseDTO toResponseDTO(Asistencia asistencia);

    @Named("mapLeccion")
    default LeccionResponseDTO mapLeccion(Integer id) {
        if (id == null) {
            return null;
        }
        return LeccionResponseDTO.builder().id(id).build();
    }

    @Named("mapEstudiante")
    default EstudianteResponseDTO mapEstudiante(String id) {
        if (id == null) {
            return null;
        }
        return EstudianteResponseDTO.builder().id(id).build();
    }
}
