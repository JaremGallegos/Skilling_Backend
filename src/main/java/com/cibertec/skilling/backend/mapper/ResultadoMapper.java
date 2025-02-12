package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.ResultadoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ResultadoResponseDTO;
import com.cibertec.skilling.backend.model.entity.Resultado;

@Mapper(componentModel = "spring")
public interface ResultadoMapper {

    @Mapping(target = "examen.id", source = "examenId")
    @Mapping(target = "tarea.id", source = "tareaId")
    @Mapping(target = "estudiante.id", source = "estudianteId")
    Resultado toEntity(ResultadoRequestDTO requestDTO);

    @Mapping(source = "examen.id", target = "examenId")
    @Mapping(source = "tarea.id", target = "tareaId")
    @Mapping(source = "estudiante.id", target = "estudianteId")
    ResultadoResponseDTO toResponseDTO(Resultado resultado);
}
