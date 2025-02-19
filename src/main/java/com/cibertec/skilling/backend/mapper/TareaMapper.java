package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.TareaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.TareaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Tarea;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    @Mapping(target = "leccion.id", source = "leccionId")
    Tarea toEntity(TareaRequestDTO requestDTO);

    @Mapping(source = "leccion.id", target = "leccionId", qualifiedByName = "mapLeccion")
    TareaResponseDTO toResponseDTO(Tarea tarea);

    @Named("mapLeccion")
    default LeccionResponseDTO mapLeccion(Integer id) {
        if (id == null) {
            return null;
        }
        return LeccionResponseDTO.builder().id(id).build();
    }
}
