package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.ClaseRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.GradoResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.model.entity.Clase;

@Mapper(componentModel = "spring")
public interface ClaseMapper {
    
    @Mapping(target = "grado.id", source = "gradoId")
    @Mapping(target = "profesor.id", source = "profesorId")
    Clase toEntity(ClaseRequestDTO requestDTO);

    @Mapping(source = "grado.id", target = "gradoId", qualifiedByName = "mapGrado")
    @Mapping(source = "profesor.id", target = "profesorId", qualifiedByName = "mapProfesor")
    ClaseResponseDTO toResponseDTO(Clase clase);

    @Named("mapGrado")
    default GradoResponseDTO mapGrado(Integer id) {
        if (id == null) {
            return null;
        }
        return GradoResponseDTO.builder().id(id).build();
    }

    @Named("mapProfesor")
    default ProfesorResponseDTO mapProfesor(String id) {
        if (id == null) {
            return null;
        }
        return ProfesorResponseDTO.builder().id(id).build();
    }
}
