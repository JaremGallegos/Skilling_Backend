package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.LeccionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.MateriaResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.model.entity.Leccion;

@Mapper(componentModel = "spring")
public interface LeccionMapper {

    @Mapping(target = "materia.id", source = "materiaId")
    @Mapping(target = "clase.id", source = "claseId")
    @Mapping(target = "profesor.id", source = "profesorId")
    Leccion toEntity(LeccionRequestDTO requestDTO); 

    @Mapping(source = "materia.id", target = "materiaId", qualifiedByName = "mapMateria")
    @Mapping(source = "clase.id", target = "claseId", qualifiedByName = "mapClase")
    @Mapping(source = "profesor.id", target = "profesorId", qualifiedByName = "mapProfesor")
    LeccionResponseDTO toResponseDTO(Leccion leccion);

    @Named("mapMateria")
    default MateriaResponseDTO mapMateria(Integer id) {
        if (id == null) {
            return null;
        }
        return MateriaResponseDTO.builder().id(id).build();
    }

    @Named("mapClase")
    default ClaseResponseDTO mapClase(Integer id) {
        if (id == null) {
            return null;
        }
        return ClaseResponseDTO.builder().id(id).build();
    }

    @Named("mapProfesor")
    default ProfesorResponseDTO mapProfesor(String id) {
        if (id == null) {
            return null;
        }
        return ProfesorResponseDTO.builder().id(id).build();
    }
}
