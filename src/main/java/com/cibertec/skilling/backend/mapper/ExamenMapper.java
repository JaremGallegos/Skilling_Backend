package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.ExamenRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ExamenResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;
import com.cibertec.skilling.backend.model.entity.Examen;

@Mapper(componentModel = "spring")
public interface ExamenMapper {

    @Mapping(target = "leccion.id", source = "leccionId")
    Examen toEntity(ExamenRequestDTO requestDTO);

    @Mapping(source = "leccion.id", target = "leccionId", qualifiedByName = "mapLeccion")
    ExamenResponseDTO toResponseDTO(Examen examen);

    @Named("mapLeccion")
    default LeccionResponseDTO mapLeccion(Integer id) {
        if (id == null) {
            return null;
        }
        return LeccionResponseDTO.builder().id(id).build();
    }
}
