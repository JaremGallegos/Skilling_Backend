package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.ResultadoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EstudianteResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.ExamenResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.ResultadoResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.TareaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Resultado;

@Mapper(componentModel = "spring")
public interface ResultadoMapper {

    @Mapping(target = "examen.id", source = "examenId")
    @Mapping(target = "tarea.id", source = "tareaId")
    @Mapping(target = "estudiante.id", source = "estudianteId")
    Resultado toEntity(ResultadoRequestDTO requestDTO);

    @Mapping(source = "examen.id", target = "examenId", qualifiedByName = "mapExamen")
    @Mapping(source = "tarea.id", target = "tareaId", qualifiedByName = "mapTarea")
    @Mapping(source = "estudiante.id", target = "estudianteId", qualifiedByName = "mapEstudiante")
    ResultadoResponseDTO toResponseDTO(Resultado resultado);

    @Named("mapExamen")
    default ExamenResponseDTO mapExamen(Integer id) {
        if (id == null) {
            return null;
        }
        return ExamenResponseDTO.builder().id(id).build();
    }

    @Named("mapTarea")
    default TareaResponseDTO mapTarea(Integer id) {
        if (id == null){
            return null;
        } 
        return TareaResponseDTO.builder().id(id).build();
    }

    @Named("mapEstudiante")
    default EstudianteResponseDTO mapEstudiante(String id) {
        if (id == null) {
            return null;
        }
        return EstudianteResponseDTO.builder().id(id).build();
    }
}
