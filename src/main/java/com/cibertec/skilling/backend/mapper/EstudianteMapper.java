package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.EstudianteRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.EstudianteResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.GradoResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Estudiante;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    @Mapping(target = "grado.id", source = "gradoId")
    @Mapping(target = "clase.id", source = "claseId")
    @Mapping(target = "usuarioRef.id", source = "usuarioId")
    Estudiante toEntity(EstudianteRequestDTO requestDTO);

    @Mapping(source = "grado.id", target = "gradoId", qualifiedByName = "mapGrado")
    @Mapping(source = "clase.id", target = "claseId", qualifiedByName = "mapClase")
    @Mapping(source = "usuarioRef.id", target = "usuarioId", qualifiedByName = "mapUsuario")
    EstudianteResponseDTO toResponseDTO(Estudiante estudiante);

    @Named("mapGrado")
    default GradoResponseDTO mapGrado(Integer id) {
        if (id == null) {
            return null;
        }
        return GradoResponseDTO.builder().id(id).build();
    }

    @Named("mapUsuario")
    default UsuarioResponseDTO mapUsuario(String id) {
        if (id == null) {
            return null;
        }
        return UsuarioResponseDTO.builder().id(id).build();
    }

    @Named("mapClase")
    default ClaseResponseDTO mapClase(Integer id) {
        if (id == null) {
            return null;
        }
        return ClaseResponseDTO.builder().id(id).build();
    }
}
