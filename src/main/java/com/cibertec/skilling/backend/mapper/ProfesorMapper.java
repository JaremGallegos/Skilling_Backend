package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.ProfesorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Profesor;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    @Mapping(target = "usuarioRef.id", source = "usuarioId")
    Profesor toEntity(ProfesorRequestDTO requestDTO);

    @Mapping(source = "usuarioRef.id", target = "usuarioId", qualifiedByName = "mapUsuario")
    ProfesorResponseDTO toResponseDTO(Profesor profesor);

    @Named("mapUsuario")
    default UsuarioResponseDTO mapUsuario(String id) {
        if (id == null) {
            return null;
        }
        return UsuarioResponseDTO.builder().id(id).build();
    }
}
